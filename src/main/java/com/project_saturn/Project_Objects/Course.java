package com.project_saturn.Project_Objects;

public class Course {
    private int course_id;
    private String course_name;
    private String course_type;

    public Course(int course_id, String course_name, String course_type) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_type = course_type;
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
        return "INSERT INTO Courses(course_id, course_name, course_type) VALUES " + "(" + course_id + ", '" + course_name + "', '" + course_type + "')"; // returns insert statements
    }
}