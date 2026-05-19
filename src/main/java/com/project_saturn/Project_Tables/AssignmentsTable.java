package com.project_saturn.Project_Tables;

import com.project_saturn.Project_Objects.Assignment;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentsTable {
    private static ArrayList<Assignment> assignments = new ArrayList<>();

    public static void createTable() {
        for (int offeringId : CourseOfferingsTable.getCourseOfferings().keySet()) {
            HashMap<Integer, ArrayList<Integer>> roster = RosterTable.getRoster();

            for (int studentId : roster.keySet()) {
                ArrayList<Integer> studentOfferingIds = roster.get(studentId);
                if (!studentOfferingIds.contains(offeringId)) { continue; }
                assignStudentsAsisgnment(studentId, offeringId);
            }
        }
    }

    private static void assignStudentsAsisgnment(int studentId, int offeringId) {
        for (int j = 1; j <= 15; j++) {
            if (j <= 12) {
                assignments.add(new Assignment(studentId, offeringId, "Minor", j, (int) (Math.random() * 26) + 75)); // Replace student id with one from CourseTable
            } else {
                assignments.add(new Assignment(studentId, offeringId, "Major", j, (int) (Math.random() * 26) + 75)); // Replace student id with one from CourseTable
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
