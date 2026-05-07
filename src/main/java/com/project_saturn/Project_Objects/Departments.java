package com.project_saturn.Project_Objects;

public class Departments {
    private String name;
    private int departmentId;

    public Departments(String name, int departmentId) {
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
        return "INSERT INTO Departments(name, department_id) VALUES " + "('" + name + "', " + departmentId + ")"; // returns insert statements
    }


}
