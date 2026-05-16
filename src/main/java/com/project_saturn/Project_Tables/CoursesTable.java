package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Course;
import com.project_saturn.Utils.Parsers.LineParser;

public class CoursesTable {
    private static HashMap<Integer, Course> courses = new HashMap<>();
    private static File regentCoursesFile, nonRegentCoursesFile;

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
            courses.put(courseId, new Course(courseId, courseName, "Non-Regent"));
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

    public static void createTable() {
        regentCoursesFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Regents_Courses").toFile();
        nonRegentCoursesFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Non_Regents_Courses").toFile();
        createNonRegents();
        createRegents();
    }

    public static HashMap<Integer, Course> getCourses() {
        return courses;
    }

   public static String getInsertStatements() {
    String result = "";
    for (Course course : courses.values()) {
        result += course.toString() + "\n";
    }
    return result;
   }
}
