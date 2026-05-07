package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Teacher;
import com.project_saturn.Utils.Parsers.LineParser;

public class TeacherTable {
    private static HashMap<Teacher, ArrayList<Integer>> teacherPeriods = new HashMap<>();
    private static HashMap<Integer, Teacher> teachers = new HashMap<>();
    private static File firstNameFile, lastNameFile;

    public static void createTable() {
        firstNameFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Teachers", "First_Name").toFile();
        lastNameFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Teachers", "Last_Name").toFile();
        ArrayList<String> firstNameList = new LineParser(firstNameFile).parse();
        ArrayList<String> lastNameList = new LineParser(lastNameFile).parse();

        for (int i = 0; i < firstNameList.size(); i++){
            Teacher teacher = new Teacher(firstNameList.get(i), lastNameList.get(i));
            int teacherId = teachers.size() + 1;
            teacherPeriods.put(teacher, new ArrayList<>());
            teachers.put(teacherId, teacher);
            teacher.setTeacherId(teacherId);
        }
    }

    public static Teacher assignRandomTeacher(int period) {
        ArrayList<Teacher> openTeachers = new ArrayList<>();
        ArrayList<Integer> assignedTeacherPeriods;
        Teacher assignedTeacher;
        int randomIndex;

        for (Teacher teacher : teacherPeriods.keySet()) {
            ArrayList<Integer> teachingPeriods = teacherPeriods.get(teacher);
            if (teachingPeriods.contains(period)) { continue; }
            openTeachers.add(teacher);
        }
        //System.out.println(openTeachers.size());
        randomIndex = (int) (Math.random() * openTeachers.size());
        assignedTeacher = openTeachers.get(randomIndex);
        assignedTeacherPeriods = teacherPeriods.get(assignedTeacher);
        assignedTeacherPeriods.add(period);
        
        return assignedTeacher;
    }

    public static String getInsertStatements() {
        String result = "";
        for (Teacher teacher : teachers.values()) {
            result += teacher.toString() + "\n";
        }
        return result;
    }
}
