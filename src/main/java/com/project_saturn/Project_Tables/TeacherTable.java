package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Teacher;
import com.project_saturn.Utils.Parsers.LineParser;

public class TeacherTable {
    private static HashMap<Integer, Teacher> teachers = new HashMap<>();
    private static File firstNameFile, lastNameFile;

    public static void createTable() {
        firstNameFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Teachers", "First_Name").toFile();
        lastNameFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Teachers", "Last_Name").toFile();
        ArrayList<String> firstNameList = new LineParser(firstNameFile).parse();
        ArrayList<String> lastNameList = new LineParser(lastNameFile).parse();

        for (int i = 0; i < firstNameList.size(); i++){
            Teacher teacher = new Teacher(firstNameList.get(i), lastNameList.get(i));
            teachers.put(teachers.size() + 1, teacher);
        }
    }
}
