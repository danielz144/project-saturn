package com.project_saturn.Project_Logic;

import com.project_saturn.Project_Tables.CourseOfferingTable;
import com.project_saturn.Project_Tables.CourseTable;
import com.project_saturn.Project_Tables.TeacherTable;

public class Test {
    public static void main(String[] args) {
        TeacherTable.createTable();
        System.out.println(TeacherTable.assignRandomTeacher(0).toString());
    }
}
