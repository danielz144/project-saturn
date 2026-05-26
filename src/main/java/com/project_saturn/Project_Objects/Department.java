package com.project_saturn.Project_Objects;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Utils.Parsers.LineParser;

public class Department {
    private static HashMap<Integer, Department> departments = new HashMap<>();
    private String name;
    private int departmentId;

    public Department(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "INSERT INTO Departments(name) VALUES " + "('" + name + "');"; // returns insert statements
    }

     public static void populateTable() {
          File departmentNames = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Departments").toFile();
          ArrayList<String> departmentsList = new LineParser(departmentNames).parse();

          for (String departmentName : departmentsList) {
               int departmentId = departments.size() + 1;
               Department department = new Department(departmentName, departmentId);
               departments.put(departmentId, department);
          }
     }

     public static HashMap<Integer, Department> getDepartments() {
          return departments;
     }

     public static String getInsertStatements() {
          StringBuilder result = new StringBuilder();
          for (Department department : departments.values()) {
               result.append(department.toString()).append("\n");
          }
          return result.toString();
     }
}
