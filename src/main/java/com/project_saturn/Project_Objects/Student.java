package com.project_saturn.Project_Objects;
public class Student {
    private String firstName;
    private String lastName;
    private int studentId;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "INSERT INTO Students (first_name, last_name) VALUES (" + firstName + ", " + lastName + ")";
=======
<<<<<<< HEAD
        return "INSERT INTO Students (first_name, last_name) VALUES ('" + firstName + "', '" + lastName + "')";
=======
        return "INSERT INTO Students (first_name, last_name) VALUES ('" + firstName.replaceAll("'", "''") + "', '" + lastName.replaceAll("'", "''") + "');";
>>>>>>> deccf88 (Completed Java Side For Project)
>>>>>>> 4f29cc0 (Completed Java Side For Project)
    }
}