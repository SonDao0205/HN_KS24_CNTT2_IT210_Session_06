package com.edu.edupath.repository;

import com.edu.edupath.model.Course;
import com.edu.edupath.model.Level;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private List<Course> courses;
    public CourseRepository() {
        init();
    }

    // tạo dữ liệu mẫu
    public void init() {
        courses = new ArrayList<>();
        courses.add(new Course(
                "IELTS-6.5",
                "IELTS 6.5",
                "Lộ trình luyện IELTS từ 5.0 lên 6.5",
                "Mr. A",
                "3 tháng",
                5000000,
                Level.INTERMEDIATE,
                LocalDate.of(2026, 5, 1),
                10,
                20
        ));

        courses.add(new Course(
                "TOEIC-800",
                "TOEIC 800+",
                "Luyện đề TOEIC nâng cao",
                "Ms. B",
                "2 tháng",
                4000000,
                Level.ADVANCED,
                LocalDate.of(2026, 6, 1),
                0,
                25
        ));

        courses.add(new Course(
                "ENG-BASIC",
                "English Basic",
                "Khóa học tiếng Anh cơ bản cho người mới",
                "Mr. C",
                "4 tháng",
                2000000,
                Level.BEGINNER,
                LocalDate.of(2026, 4, 20),
                20,
                20
        ));

        courses.add(new Course(
                "IELTS-7.0",
                "IELTS 7.0+",
                "Luyện đề chuyên sâu IELTS",
                "Mr. D",
                "3 tháng",
                7000000,
                Level.ADVANCED,
                LocalDate.of(2026, 7, 10),
                5,
                15
        ));

        courses.add(new Course(
                "COMM-ENG",
                "Communication English",
                "Giao tiếp tiếng Anh thực tế",
                "Ms. E",
                "2 tháng",
                3000000,
                Level.INTERMEDIATE,
                LocalDate.of(2026, 5, 15),
                0,
                20
        ));
    }

    // lấy danh sách
    public List<Course> findAll() {
        return courses;
    }

    // tìm theo courseCode
    public Course findByCode(String courseCode) {
        return courses.stream()
                .filter(c -> c.getCourseCode().equalsIgnoreCase(courseCode))
                .findFirst()
                .orElse(null);
    }

    // update fee và startDate
    public void update(Course updatedCourse) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(updatedCourse.getCourseCode())) {
                c.setFee(updatedCourse.getFee());
                c.setStartDate(updatedCourse.getStartDate());
                break;
            }
        }
    }

    // xoá theo courseCode
    public void deleteByCode(String courseCode) {
        courses.removeIf(c -> c.getCourseCode().equalsIgnoreCase(courseCode));
    }
}
