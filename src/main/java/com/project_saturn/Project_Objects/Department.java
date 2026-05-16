package com.project_saturn.Project_Objects;

public class Department {
    private String name;
    private int departmentId;

    public Department(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "INSERT INTO Departments(name) VALUES " + "('" + name + "');"; // returns insert statements
    }


}
