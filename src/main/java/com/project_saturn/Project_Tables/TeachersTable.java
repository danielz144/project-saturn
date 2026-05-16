package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Teacher;
import com.project_saturn.Utils.Parsers.LineParser;

class DepartmentTracker {
    private static HashMap<Integer, Integer> departmentCounts = new HashMap<>();

    public static void init() {
        if (DepartmentsTable.getDepartments().size() == 0) { System.err.println("Department Table Must Be Created First!"); return; }
        for (int departmentId : DepartmentsTable.getDepartments().keySet()) {
            departmentCounts.put(departmentId, 0);
        }
    }

    public static int assignRandomDepartmentId() {
        ArrayList<Integer> lowestDepartmentCount = new ArrayList<>();
        int lowestCount = Integer.MAX_VALUE, randomIndex, assignedDepartmentId;

        for (int departmentId : departmentCounts.keySet()) {
            int count = departmentCounts.get(departmentId);
            if (count > lowestCount) { continue; }
            if (count < lowestCount) { lowestDepartmentCount.clear(); }
            lowestCount = count;
            lowestDepartmentCount.add(departmentId);
        }
        randomIndex = (int) (Math.random()*lowestDepartmentCount.size());
        assignedDepartmentId = lowestDepartmentCount.get(randomIndex);
        departmentCounts.replace(assignedDepartmentId, lowestCount + 1);

        return assignedDepartmentId;
    }
}

public class TeachersTable {
    private static HashMap<Integer, ArrayList<Teacher>> assignedTeachers = new HashMap<>();
    private static HashMap<Integer, Teacher> teachers = new HashMap<>();

    public static void createTable() {
        File firstNameFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Teachers", "First_Name").toFile();
        File lastNameFile = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Teachers", "Last_Name").toFile();
        ArrayList<String> firstNameList = new LineParser(firstNameFile).parse();
        ArrayList<String> lastNameList = new LineParser(lastNameFile).parse();
        DepartmentTracker.init();

        for (int i = 0; i < firstNameList.size(); i++){
            Teacher teacher = new Teacher(firstNameList.get(i), lastNameList.get(i));
            int teacherId = teachers.size() + 1;
            teachers.put(teacherId, teacher);
            teacher.setTeacherId(teacherId);
            teacher.setDepartmentId(DepartmentTracker.assignRandomDepartmentId());
        }
    }

    public static Teacher assignRandomTeacher(int period) {
        //Gets already assigned teachers
        if (!assignedTeachers.containsKey(period)){ assignedTeachers.put(period, new ArrayList<>()); }
        ArrayList<Teacher> periodAssignedTeachers = assignedTeachers.get(period);
        ArrayList<Teacher> availableTeachers = new ArrayList<>();
        Teacher assignedTeacher;
        int randomIndex;

        //Only adds available teachers to the list
        for (Teacher teacher : teachers.values()) {
            if (periodAssignedTeachers.contains(teacher)){ continue; }
            availableTeachers.add(teacher);
        }

        randomIndex = (int) (Math.random() * availableTeachers.size());
        assignedTeacher = availableTeachers.get(randomIndex);
        periodAssignedTeachers.add(assignedTeacher);

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
