package com.edu.edupath.controller;


import com.edu.edupath.model.Course;
import com.edu.edupath.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/course/list";
    }

    // Danh sách và filter
    @GetMapping("/list")
    public String listCourses(
            @RequestParam(value = "level", required = false) String level,
            @RequestParam(value = "maxFee", required = false) Double maxFee,
            Model model) {

        List<Course> courses = courseService.searchCourses(level, maxFee);

        model.addAttribute("courses", courses);
        model.addAttribute("level", level);
        model.addAttribute("maxFee", maxFee);

        return "course/list";
    }


    // Chi tiết course
    @GetMapping("/detail/{code}")
    public String detailCourse(@PathVariable("code") String code, Model model) {
        Optional<Course> course = courseService.findByCode(code);
        if(course.isEmpty()) {
            return "redirect:/course/list";
        }
        model.addAttribute("course", course.get());
        return "course/detail";
    }

    // Form edit course
    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable("code") String code, Model model){
        Optional<Course> course = courseService.findByCode(code);

        if (course.isEmpty()) {
            return "redirect:/course/list";
        }

        model.addAttribute("course", course.get());
        return "course/form";
    }

    // Cập nhật
    @PostMapping("/update")
    public String updateCourse(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "fee", required = false) double fee,
            @RequestParam(value = "startDate", required = false) String startDate,
            RedirectAttributes redirect) {

        LocalDate date = LocalDate.parse(startDate);

        String result = courseService.updateById(code, fee, date);

        if (result.contains("thành công")) {
            redirect.addFlashAttribute("message", result);
        } else {
            redirect.addFlashAttribute("error", result);
        }

        return "redirect:/course/list";
    }

    // Xóa
    @PostMapping("/delete/{code}")
    public String deleteCourse(
            @PathVariable("code") String code,
            RedirectAttributes redirect) {

        String result = courseService.deleteById(code);

        if (result.contains("thành công")) {
            redirect.addFlashAttribute("message", result);
        } else {
            redirect.addFlashAttribute("error", result);
        }

        return "redirect:/course/list";
    }
}
