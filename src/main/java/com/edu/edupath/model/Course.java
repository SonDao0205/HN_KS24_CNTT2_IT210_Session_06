package com.edu.edupath.model;

import java.sql.Date;

public class Course {
    private String courseCode;
    private String courseName;
    private String description;
    private String instructor;
    private int duration;
    private double fee;
    private Level level;
    private Date startDate;
    private int studentCount;
    private int maxStudents;
    private boolean isFull;

    public Course() {
    }

    public Course(String courseCode, String courseName, String description, String instructor, int duration, double fee, Level level, Date startDate, int studentCount, int maxStudents, boolean isFull) {
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
        this.isFull = isFull;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
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

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
