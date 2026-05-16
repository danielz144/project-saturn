package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Department;
import com.project_saturn.Utils.Parsers.LineParser;

public class DepartmentsTable {
     private static HashMap<Integer, Department> departments = new HashMap<>();

     public static void createTable() {
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
          String result = "";
          for (Department department : departments.values()) {
               result += department.toString() + "\n";
          }
          return result;
     }
}
