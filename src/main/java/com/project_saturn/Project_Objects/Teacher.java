package com.project_saturn.Project_Objects;
public class Teacher {
    private String firstName;
    private String lastName;
    private int teacherId;
    
    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTeacherId() {
        return teacherId;
    }
    
    @Override
    public String toString() {
        return "INSERT INTO Teachers (first_name, last_name) VALUES (" + firstName + ", " + lastName + ")";
    }
}