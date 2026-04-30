package com.project_saturn.Project_Tables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.project_saturn.Utils.Parsers.LineParser;

public class create_courses {
    private static ArrayList<String> courses = new ArrayList<>();

    public static void create_aps(File non_regents) throws FileNotFoundException{
        LineParser parser = new LineParser(non_regents);
        ArrayList<String> lines = parser.parse();

        for (String line : lines) {
            if (!line.contains("AP")) { continue; }
            courses.add(line);
        }
    }
    
    public static void create(File non_regents, File regents) throws FileNotFoundException {
        
    }

    public static ArrayList<String> getCourses() {
        return courses;
    }
}
