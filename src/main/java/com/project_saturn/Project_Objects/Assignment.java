package com.project_saturn.Project_Objects;

public class Assignment {
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
        return "INSERT INTO Assignments(student_id, offering_id, assignment_type, assignment_name, grade) VALUES "
<<<<<<< HEAD:src/main/java/com/project_saturn/Project_Objects/Assignments.java
                + "(" + studentId + ", " + offeringId + ", '" + assignmentType + "', " + assignmentType + ", " + grade + ")"; // returns insert statements
=======
<<<<<<< HEAD:src/main/java/com/project_saturn/Project_Objects/Assignments.java
<<<<<<< HEAD
                + "(" + studentId + ", " + offeringId + ", '" + assignmentType + "', " + assignmentType + ", " + grade + ")"; // returns insert statements
=======
                + "(" + studentId + ", " + offeringId + ", '" + assignmentType + "', " + assignmentName + ", " + grade + ")"; // returns insert statements
>>>>>>> 0633e4d (Created the Assignments Creator Class)
=======
                + "(" + studentId + ", " + offeringId + ", '" + assignmentType + "', " + assignmentName + ", " + grade + ");"; // returns insert statements
>>>>>>> deccf88 (Completed Java Side For Project):src/main/java/com/project_saturn/Project_Objects/Assignment.java
>>>>>>> 4f29cc0 (Completed Java Side For Project):src/main/java/com/project_saturn/Project_Objects/Assignment.java
    }
}
