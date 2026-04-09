package com.edu.edupath.service;

import com.edu.edupath.model.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    List<Course> searchCourses(String level, Double maxPrice);
    Optional<Course> findByCode(String code);// trả về một đối tượng hoặc trả về rỗng
    String deleteById(String id); // Trả về thông báo không tìm thấy hoặc thành công
    String updateById(String id, double price, LocalDate date);
}
