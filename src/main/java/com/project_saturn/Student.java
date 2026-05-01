package com.project_saturn;
public class Student {
    private String firstName;
    private String lastName;
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "INSERT INTO Students (first_name, last_name) VALUES (" + firstName + ", " + lastName + ")";
    }
}