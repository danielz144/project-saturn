package com.project_saturn.Project_Objects;

public class Assignments {
    private int student_id;
    private int offering_id;
    private String assignment_type;
    private int assignment_name;
    private int grade;

    public Assignments(int student_id, int offering_id, String assignment_type, int assignment_name, int grade) {
        this.student_id = student_id;
        this.offering_id = offering_id;
        this.assignment_type = assignment_type;
        this.assignment_name = assignment_name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "INSERT INTO Assignments(student_id, offering_id, assignment_type, assignment_name, grade) VALUES "
                + "(" + student_id + ", " + offering_id + ", '" + assignment_type + "', " + assignment_name + ", " + grade + ")"; // returns insert statements
    }
}
