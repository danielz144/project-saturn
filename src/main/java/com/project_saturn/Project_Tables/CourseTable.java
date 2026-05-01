package com.project_saturn.Project_Tables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Course;
import com.project_saturn.Utils.Parsers.LineParser;

public class CourseTable {
    private static HashMap<Integer, Course> courses = new HashMap<>();
    private static File regentCoursesFile, nonRegentCoursesFile;

    private static boolean createAP(String courseName) {
        if (!courseName.contains("AP")) { return false; }
        int courseId = courses.size() + 1;
        courses.put(courseId, new Course(courseId, courseName, "AP"));
        return true;
    }

    private static void createNonRegents() throws FileNotFoundException{
        LineParser parser = new LineParser(nonRegentCoursesFile);
        ArrayList<String> lines = parser.parse();

        for (String courseName : lines) {
            if (createAP(courseName)){ continue; }
            int courseId = courses.size() + 1;
            courses.put(courseId, new Course(courseId, courseName, "Non-Regent"));
        }
    }

    private static void createRegents() throws FileNotFoundException {
        LineParser parser = new LineParser(regentCoursesFile);
        ArrayList<String> lines = parser.parse();

        for (String couseName : lines){
            int courseId = courses.size() + 1;
            courses.put(courseId, new Course(courseId, couseName, "Regent"));
        }
    }

    public static void createTables() throws FileNotFoundException {
        regentCoursesFile = new File("src\\main\\java\\com\\project_saturn\\Infos\\Regents_Courses");
        nonRegentCoursesFile = new File("src\\main\\java\\com\\project_saturn\\Infos\\Non_Regents_Courses");
        createNonRegents();
        createRegents();
    }

    public static HashMap<Integer, Course> getCourses() {
        return courses;
    }
}
