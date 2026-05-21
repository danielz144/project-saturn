package com.project_saturn.Project_Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.project_saturn.Project_Objects.Assignment;
import com.project_saturn.Project_Objects.CourseOffering;
import com.project_saturn.Project_Objects.Course;
import com.project_saturn.Project_Objects.Department;
import com.project_saturn.Project_Objects.Rooms;
import com.project_saturn.Project_Objects.Roster;
import com.project_saturn.Project_Objects.Student;
import com.project_saturn.Project_Objects.Teacher;

public class SetupSQL {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("InsertStatements.sql", true);
        PrintWriter printWriter = new PrintWriter("InsertStatements.sql");
        printWriter.close();

        Student.populateTable();
        Department.populateTable();
        Rooms.populateTable();
        Teacher.populateTable();
        Course.populateTable();
        CourseOffering.populateTable();
        Assignment.populateTable();
        Roster.populateTable();

        fileWriter.write(Student.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Student Tables Values!';\n");
        System.out.println("Registered Student Table Values!");

        fileWriter.write(Department.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Department Tables Values!';\n");
        System.out.println("Registered Department Table Values!");

        fileWriter.write(Rooms.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Room Tables Values!';\n");
        System.out.println("Registered Room Table Values!");

        fileWriter.write(Teacher.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Teacher Tables Values!';\n");
        System.out.println("Registered Teacher Table Values!");

        fileWriter.write(Course.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Course Tables Values!';\n");
        System.out.println("Registered Course Table Values!");

        fileWriter.write(CourseOffering.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Course Offering Tables Values!';\n");
        System.out.println("Registered Course Offering Table Values!");

        fileWriter.write(Assignment.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Assignment Tables Values!';\n");
        System.out.println("Registered Assignment Table Values!");

        fileWriter.write(Roster.getInsertStatements());
        fileWriter.write("system echo 'Finished Inserting Roster Tables Values!';\n");
        System.out.println("Registered Roster Table Values!");
        System.out.println("Finished Registering All Table Values!");

        fileWriter.close();
    }
}
