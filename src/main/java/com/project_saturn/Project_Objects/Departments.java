package com.project_saturn.Project_Objects;

public class Departments {
    private String name;
    private int department_id;

    public Departments(String name, int department_id) {
        this.name = name;
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "INSERT INTO Departments(name, department_id) VALUES " + "('" + name + "', " + department_id + ")"; // returns insert statements
    }


}
