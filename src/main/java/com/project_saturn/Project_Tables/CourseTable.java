package com.project_saturn.Project_Tables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.sound.sampled.Line;

import com.project_saturn.Project_Objects.Course;
import com.project_saturn.Utils.Parsers.LineParser;

public class CourseTable {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static File regentCoursesFile, nonRegentCoursesFile;

    private static boolean createAP(String courseName) {
        if (!courseName.contains("AP")) { return false; }
        courses.add(new Course(courses.size() + 1, courseName, "AP"));
        return true;
    }

    private static void createNonRegents() throws FileNotFoundException{
        LineParser parser = new LineParser(nonRegentCoursesFile);
        ArrayList<String> lines = parser.parse();

        for (String courseName : lines) {
            if (createAP(courseName)){ continue; }
            courses.add(new Course(courses.size() + 1, courseName, "Non-Regent"));
        }
    }

    private static void createRegents() throws FileNotFoundException {
        LineParser parser = new LineParser(regentCoursesFile);
        ArrayList<String> lines = parser.parse();

        for (String couseName : lines){
            courses.add(new Course(courses.size() + 1, couseName, "Regent"));
        }
    }

    public static void createTables() throws FileNotFoundException {
        regentCoursesFile = new File("src\\main\\java\\com\\project_saturn\\Infos\\Regents_Courses");
        nonRegentCoursesFile = new File("src\\main\\java\\com\\project_saturn\\Infos\\Non_Regents_Courses");
        createRegents();
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }
}
