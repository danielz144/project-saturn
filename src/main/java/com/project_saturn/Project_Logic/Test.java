package com.project_saturn.Project_Logic;

import com.project_saturn.Project_Tables.CourseOfferingTable;
import com.project_saturn.Project_Tables.CourseTable;
import com.project_saturn.Project_Tables.TeacherTable;

public class Test {
    public static void main(String[] args) {
        TeacherTable.createTable();
        CourseTable.createTable();
        CourseOfferingTable.createTable();

        System.out.println(CourseOfferingTable.getInsertStatements());
    }
}
