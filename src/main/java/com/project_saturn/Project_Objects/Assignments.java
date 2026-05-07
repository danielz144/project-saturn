package com.project_saturn.Project_Objects;

public class Assignments {
    private int studentId;
    private int offeringId;
    private String assignmentType;
    private int assignmentName;
    private int grade;

    public Assignments(int studentId, int offeringId, String assignmentType, int assignmentName, int grade) {
        this.studentId = studentId;
        this.offeringId = offeringId;
        this.assignmentType = assignmentType;
        this.assignmentName = assignmentName;
        this.grade = grade;
    }

<<<<<<< HEAD
=======
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

>>>>>>> 80d882b (Merged From Tyson, fixed some naming conventions)
    @Override
    public String toString() {
        return "INSERT INTO Assignments(student_id, offering_id, assignment_type, assignment_name, grade) VALUES "
                + "(" + studentId + ", " + offeringId + ", '" + assignmentType + "', " + assignmentName + ", " + grade + ")"; // returns insert statements
    }
}
