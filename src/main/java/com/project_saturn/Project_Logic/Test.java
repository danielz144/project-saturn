package com.project_saturn.Project_Logic;

import com.project_saturn.Project_Tables.CourseOfferingTable;
import com.project_saturn.Project_Tables.CourseTable;

public class Test {
    public static void main(String[] args) {
        CourseTable.createTables();
        System.out.println(CourseTable.getInsertStatements());
        CourseOfferingTable.createCourseOfferings();
        System.out.println(CourseOfferingTable.getInsertStatements());
        System.out.println(CourseOfferingTable.getCourseOfferings().size());
    }
}
