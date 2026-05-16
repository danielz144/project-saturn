package com.project_saturn.Project_Objects;
public class Teacher {
    private String firstName;
    private String lastName;
    private int teacherId, departmentId;
    
    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setDepartmentId(int departmentId) {
         this.departmentId = departmentId;
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

    public int getDepartmentId() {
         return departmentId;
    }
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "INSERT INTO Teachers (first_name, last_name) VALUES (" + firstName + ", " + lastName + ")";
=======
<<<<<<< HEAD
        return "INSERT INTO Teachers (first_name, last_name) VALUES ('" + firstName + "', '" + lastName + "')";
=======
        return "INSERT INTO Teachers (first_name, last_name) VALUES ('" + firstName.replaceAll("'", "''") + "', '" + lastName.replaceAll("'", "''") + "');";
>>>>>>> deccf88 (Completed Java Side For Project)
>>>>>>> 4f29cc0 (Completed Java Side For Project)
    }
}