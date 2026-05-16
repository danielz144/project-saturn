package com.project_saturn.Project_Tables;

import com.project_saturn.Project_Objects.Assignment;
import java.util.ArrayList;

public class AssignmentsTable {
    private static ArrayList<Assignment> assignments = new ArrayList<>();

    public static void createTable() {
        for (int i = 0; i < CoursesTable.getCourses().size(); i++) {
            for (int j = 1; j <= 15; j++) {
                if (j <= 12) {
                    assignments.add(new Assignment(1, i, "Minor", j, (int) (Math.random() * 26) + 75)); // Replace student id with one from CourseTable
                } else {
                    assignments.add(new Assignment(1, i, "Major", j, (int) (Math.random() * 26) + 75)); // Replace student id with one from CourseTable
                }
            }
        }
    }

    public static ArrayList<Assignment> getAssignments() {
        return assignments; // Returns the list of Assignments
    }

    public static String getInsertStatements() {
        String result = "";
        for (Assignment assignment : assignments) {
            result += assignment.toString() + "\n";
        }
        return result;
    }
}
