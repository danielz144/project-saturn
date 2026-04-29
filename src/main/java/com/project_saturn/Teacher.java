package com.project_saturn;
public class Teacher {
    private String firstName;
    private String lastName;
    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "INSERT INTO Teachers (first_name, last_name) VALUES (" + firstName + ", " + lastName + ")";
    }
}