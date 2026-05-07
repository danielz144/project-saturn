package com.project_saturn.Project_Objects;

public class Department {
    private String name;
    private int departmentId;

<<<<<<< HEAD:src/main/java/com/project_saturn/Project_Objects/Department.java
    public Department(String name, int departmentId) {
=======
    public Departments(String name, int departmentId) {
>>>>>>> 80d882b (Merged From Tyson, fixed some naming conventions):src/main/java/com/project_saturn/Project_Objects/Departments.java
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
