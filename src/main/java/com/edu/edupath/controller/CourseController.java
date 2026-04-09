package com.edu.edupath.controller;


import com.edu.edupath.model.Course;
import com.edu.edupath.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Danh sách và filter
    @GetMapping("/list")
    public String listCourses(@RequestParam(required = false) String level,
                              @RequestParam(required = false) Double maxFee,
                              Model model) {

        List<Course> courses = courseService.searchCourses(level, maxFee);

        model.addAttribute("courses", courses);
        model.addAttribute("level", level);
        model.addAttribute("maxFee", maxFee);

        return "course/list";
    }

    // Chi tiết course
    @GetMapping("/detail/{code}")
    public String detailCourse(@PathVariable String code, Model model) {
        Optional<Course> course = courseService.findByCode(code);
        if(course.isEmpty()) {
            return "redirect:/course/list";
        }
        model.addAttribute("course", course);
        return "course/detail";
    }

    // Form edit course
    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable("code") String code, Model model){
        Optional<Course> course = courseService.findByCode(code);

        if (course.isEmpty()) {
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course/form";
    }

    // Cập nhật
    @PostMapping("/update")
    public String updateCourse(
            @ModelAttribute Course course,
            RedirectAttributes redirect) {

        courseService.updateCourse(course);

        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/course/list";
    }

    // Xóa
    @PostMapping("/delete/{id}")
    public String deleteCourse(
            @PathVariable String code,
            RedirectAttributes redirect) {


        String result = courseService.deleteById(code);

        if (result.contains("Không thể")) {
            redirect.addFlashAttribute("error", result);
        } else {
            redirect.addFlashAttribute("message", result);
        }

        return "redirect:/course/list";
    }
}
