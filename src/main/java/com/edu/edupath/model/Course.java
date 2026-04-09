package com.edu.edupath.model;

import java.time.LocalDate;

public class Course {
    private String courseCode; // mã khóa học
    private String courseName; // tên khóa học
    private String description; // mô tả cho khóa học
    private String instructor; // giảng viên
    private String duration; // thời lượng ( ví dụ 12 tuần )
    private double fee; // học phí
    private Level level; // trình độ ( bên enum Level )
    private LocalDate startDate; // ngày khai giảng
    private int studentCount; // Số học viên hiện tại của khóa
    private int maxStudents; // Sĩ số tối đa

    public Course() {
    }

    public Course(String courseCode, String courseName, String description, String instructor, String duration, double fee, Level level, LocalDate startDate, int studentCount, int maxStudents) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.fee = fee;
        this.level = level;
        this.startDate = startDate;
        this.studentCount = studentCount;
        this.maxStudents = maxStudents;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    // method này trả về có khóa học đã full chưa
    public boolean isFull() {
        return this.studentCount >= this.maxStudents;
    }

    // method kiểm tra có được xóa không
    public boolean isDeletable() {
        return this.studentCount == 0;
    }
}
