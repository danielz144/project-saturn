package com.project_saturn.Project_Objects;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Utils.Person;
import com.project_saturn.Utils.Parsers.PersonParser;

public class Student {
    private static HashMap<Integer, Student> students = new HashMap<>();
    private String firstName;
    private String lastName;
    private int studentId;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "INSERT INTO Students (first_name, last_name) VALUES ('" + firstName.replaceAll("'", "''") + "', '" + lastName.replaceAll("'", "''") + "');";
    }
     
     public static void populateTable() {
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
          StringBuilder result = new StringBuilder();
          for (Student student : students.values()) {
               result.append(student.toString()).append("\n");
          }
          return result.toString();
     }
}