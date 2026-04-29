package com.project_saturn;

public class Roster {
    private int student_id; //References "Students" class student_id
    private int offering_id; //References "Course_Offerings" class offering_id

    public Roster(int student_id, int offering_id) {
        this.student_id = student_id;
        this.offering_id = offering_id;
    }

    // Returns the SQL statement to insert this roster entry into the database
    @Override
    public String toString() {
        return "INSERT INTO Roster (student_id, offering_id)" +
                " VALUES (" + student_id + ", " + offering_id + ")";
    }
}
