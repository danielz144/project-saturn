package com.project_saturn.Project_Objects;
public class Roster {
    private int studentId; //References "Students" class student_id
    private int offeringId; //References "Course_Offerings" class offering_id

    public Roster(int student_id, int offering_id) {
        this.studentId = student_id;
        this.offeringId = offering_id;
    }

    // Returns the SQL statement to insert this roster entry into the database
    @Override
    public String toString() {
        return "INSERT INTO Roster (student_id, offering_id)" +
                " VALUES (" + studentId + ", " + offeringId + ")";
    }
}
