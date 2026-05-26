package com.project_saturn.Project_Objects;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Utils.Parsers.LineParser;

public class Course {
    private static HashMap<Integer, Course> courses = new HashMap<>();
    private static File regentCoursesFile, nonRegentCoursesFile;
    private int courseId;
    private String courseName;
    private String courseType;

    public Course(int courseId, String courseName, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "INSERT INTO Courses (course_name, course_type) VALUES " + "('"+courseName + "', '" + courseType + "');"; // returns insert statements
    }

    private static boolean createAP(String courseName) {
        if (!courseName.contains("AP")) { return false; }
        int courseId = courses.size() + 1;
        courses.put(courseId, new Course(courseId, courseName, "AP"));
        return true;
    }

    private static void createNonRegents(){
        LineParser parser = new LineParser(nonRegentCoursesFile);
        ArrayList<String> lines = parser.parse();

        for (String courseName : lines) {
            if (createAP(courseName)){ continue; }
            int courseId = courses.size() + 1;
            courses.put(courseId, new Course(courseId, courseName, "Elective"));
        }
    }

    private static void createRegents() {
        LineParser parser = new LineParser(regentCoursesFile);
        ArrayList<String> lines = parser.parse();

        for (String couseName : lines){
            int courseId = courses.size() + 1;
            courses.put(courseId, new Course(courseId, couseName, "Regent"));
        }
    }

    public static void populateTable() {
        regentCoursesFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Regents_Courses").toFile();
        nonRegentCoursesFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Non_Regents_Courses").toFile();
        createNonRegents();
        createRegents();
    }

    public static HashMap<Integer, Course> getCourses() {
        return courses;
    }

   public static String getInsertStatements() {
    StringBuilder result = new StringBuilder();
    for (Course course : courses.values()) {
        result.append(course.toString()).append("\n");
    }
    return result.toString();
   }
}