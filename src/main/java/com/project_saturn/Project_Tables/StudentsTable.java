package com.project_saturn.Project_Tables;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Student;
import com.project_saturn.Utils.Person;
import com.project_saturn.Utils.Parsers.PersonParser;

public class StudentsTable {
     private static HashMap<Integer, Student> students = new HashMap<>();
     
     public static void createTable() {
          File studentNames = Paths.get("src", "main", "java", "com", "project_saturn", "Infos", "Mock_Students").toFile();
          ArrayList<Person> studentsList = new PersonParser(studentNames).parse();

          for (Person studentPerson : studentsList) {
               Student student = new Student(studentPerson.getFirstName(), studentPerson.getLastName());
               int studentId = students.size() + 1;

               students.put(studentId, student);
               student.setStudentId(studentId);
          }
     }

     public static HashMap<Integer, Student> getStudents() {
          return students;
     }

     public static String getInsertStatements() {
          String result = "";
          for (Student student : students.values()) {
               result += student.toString() + "\n";
          }
          return result;
     }
}
