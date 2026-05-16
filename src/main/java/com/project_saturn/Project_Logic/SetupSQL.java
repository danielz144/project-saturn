package com.project_saturn.Project_Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.project_saturn.Project_Tables.AssignmentsTable;
import com.project_saturn.Project_Tables.CourseOfferingsTable;
import com.project_saturn.Project_Tables.CoursesTable;
import com.project_saturn.Project_Tables.DepartmentsTable;
import com.project_saturn.Project_Tables.RoomsTable;
import com.project_saturn.Project_Tables.RosterTable;
import com.project_saturn.Project_Tables.StudentsTable;
import com.project_saturn.Project_Tables.TeachersTable;

public class SetupSQL {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("InsertStatements.sql", true);
        PrintWriter printWriter = new PrintWriter("InsertStatements.sql");
        printWriter.close();

        StudentsTable.createTable();
        DepartmentsTable.createTable();
        RoomsTable.createTable();
        TeachersTable.createTable();
        CoursesTable.createTable();
        CourseOfferingsTable.createTable();
        AssignmentsTable.createTable();
        RosterTable.createTable();

        fileWriter.write(StudentsTable.getInsertStatements());
        fileWriter.write(DepartmentsTable.getInsertStatements());
        fileWriter.write(RoomsTable.getInsertStatements());
        fileWriter.write(TeachersTable.getInsertStatements());
        fileWriter.write(CoursesTable.getInsertStatements());
        fileWriter.write(CourseOfferingsTable.getInsertStatements());
        fileWriter.write(AssignmentsTable.getInsertStatements());
        fileWriter.write(RosterTable.getInsertStatements());

        fileWriter.close();
    }
}
