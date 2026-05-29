package com.project_saturn.Project_Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Assignment {
    private static ArrayList<Assignment> assignments = new ArrayList<>();
    private int studentId;
    private int offeringId;
    private String assignmentType;
    private int assignmentName;
    private int grade;

    public Assignment(int studentId, int offeringId, String assignmentType, int assignmentName, int grade) {
        this.studentId = studentId;
        this.offeringId = offeringId;
        this.assignmentType = assignmentType;
        this.assignmentName = assignmentName;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getOfferingId() {
        return offeringId;
    }

    public int getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    @Override
    public String toString() {
        return "(" + studentId + ", " + offeringId + ", '" + assignmentType + "', " + assignmentName + ", " + grade + ")"; // returns insert statements
    }

    public static void populateTable() {
        for (int offeringId : CourseOffering.getCourseOfferings().keySet()) {
            HashMap<Integer, ArrayList<Integer>> roster = Roster.getRoster();

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

    public static String getInsert1() {
        StringBuilder result = new StringBuilder();
        result.append("INSERT INTO Assignments(student_id, offering_id, assignment_type, assignment_name, grade) VALUES");
        for (int i = 0; i < assignments.size() / 2; i++) {
            Assignment assignment = assignments.get(i);
            result.append(assignment.toString()).append(",\n");
        }
        result.delete(result.length() - 2, result.length()); // Remove the last comma and space
        result.append(";\n");
        return result.toString();
    }

    public static String getInsert2() {
        StringBuilder result = new StringBuilder();
        result.append("INSERT INTO Assignments(student_id, offering_id, assignment_type, assignment_name, grade) VALUES");
        for (int i = assignments.size()/2; i >= 0; i--) {
            Assignment assignment = assignments.get(i);
            result.append(assignment.toString()).append(",\n");
        }
        result.delete(result.length() - 2, result.length()); // Remove the last comma and space
        result.append(";\n");
        return result.toString();
    }
}
