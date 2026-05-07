package com.project_saturn.Project_Objects;

public class Course {
    private int courseId;
    private String courseName;
    private String courseType;

    public Course(int courseId, String courseName, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
<<<<<<< HEAD
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
<<<<<<< HEAD
=======
>>>>>>> 0633e4d (Created the Assignments Creator Class)
=======
>>>>>>> 80d882b (Merged From Tyson, fixed some naming conventions)
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "INSERT INTO Courses(course_id, course_name, course_type) VALUES (" + courseId + ", '" + courseName + "', '" + courseType + "');"; // returns insert statements
=======
        return "INSERT INTO Courses(course_id, course_name, course_type) VALUES " + "(" + courseId + ", '" + courseName + "', '" + courseType + "')"; // returns insert statements
>>>>>>> 0633e4d (Created the Assignments Creator Class)
    }
}