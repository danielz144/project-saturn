package com.project_saturn.Project_Objects;

public class Course {
    private int courseId;
    private String courseName;
    private String courseType;

    public Course(int courseId, String courseName, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_type() {
        return course_type;
    }

    @Override
    public String toString() {
        return "INSERT INTO Courses(course_id, course_name, course_type) VALUES " + "(" + courseId + ", '" + courseName + "', '" + courseType + "')"; // returns insert statements
    }
}