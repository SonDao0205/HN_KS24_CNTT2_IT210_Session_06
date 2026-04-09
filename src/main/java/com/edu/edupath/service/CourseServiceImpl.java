package com.edu.edupath.service;

import com.edu.edupath.model.Course;
import com.edu.edupath.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        // Chỉ nên trả về các khóa học chưa bị xóa
        List<Course> activeCourses = new ArrayList<>();
        for (Course c : courseRepository.findAll()) {
            if (!c.isDelete()) activeCourses.add(c);
        }
        return activeCourses;
    }

    @Override
    public List<Course> searchCourses(String level, Double maxPrice) {
        // lấy tất cả
        List<Course> allCourses = courseRepository.findAll();

        List<Course> filteredCourses = new ArrayList<>();

        for (Course course : allCourses) {

            boolean matchLevel = (level == null || level.isEmpty() || level.equals("ALL"))
                    || course.getLevel().name().equalsIgnoreCase(level); // lấy tất cả khóa trong level đó

            boolean matchPrice = (maxPrice == null) || (course.getFee() <= maxPrice);// kiểm tra giá

            boolean isNotDeleted = !course.isDelete();

            if (matchLevel && matchPrice && isNotDeleted) {
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }

    @Override
    public Optional<Course> findByCode(String id) {
        // lấy tất cả
        List<Course> allCourses = courseRepository.findAll();

        for (Course course : allCourses) {
            if (course.getCourseCode().equals(id) && !course.isDelete()) {
                return Optional.of(course);// nếu có trả về một đối tượng khóa học
            }
        }

        return Optional.empty();// không thì trả về rỗng
    }


    @Override
    public String deleteById(String id) {
        // lấy tất cả
        List<Course> allCourses = courseRepository.findAll();

        for (Course course : allCourses) {
            // Kiểm tra xem có đúng mã khóa học cần xóa không
            if (course.getCourseCode().equals(id)) {

                //  Nếu có học viên > 0 thì không được xóa
                if (course.getStudentCount() > 0) {
                    return "Không thể xóa khi còn học viên";
                }


               if (!course.isDelete()){
                   // xóa mềm
                   course.setDelete(true);

                   return "Xóa thành công";// bao thanh cong
               }else {
                   return "Khóa học này đã xóa";
               }
            }
        }

        return "Không tìm thấy khóa học nào với ID đó";
    }

    @Override
    public String updateById(String id, double price, LocalDate date) {

        List<Course> allCourses = courseRepository.findAll();

        if (allCourses.isEmpty()) {
            return "Danh sách rỗng";
        }

        if (price <= 0) {
            return "Giá không được nhỏ hơn bằng 0";
        }

        if (date.isBefore(LocalDate.now())) {
            return "Ngày khai giảng mới không được là quá khứ!";
        }

        for (Course course : allCourses) {
            if (course.getCourseCode().equals(id) &&  !course.isDelete()) {
                course.setFee(price);
                course.setStartDate(date);

                return "Cập nhật thành công";
            }
        }
        return "Không tìm thấy khóa học cần cập nhật";
    }
}
