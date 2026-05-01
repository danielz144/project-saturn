package com.project_saturn.Project_Objects;

public class Course_Offering {
    private String location;
    private int offering_id; //PK
    private int teacher_id, course_id, period;

    public Course_Offering(int offering_id, int teacher_id, int course_id, String location, int period) {
        this.teacher_id = teacher_id;
        this.course_id = course_id;
        this.location = location;
        this.period = period;
        this.offering_id = offering_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getOffering_id() {
        return offering_id;
    }

    public String getLocation() {
        return location;
    }

    public int getPeriod() {
        return period;
    }

    public int getTeacher_id() {
        return teacher_id;
    }
}
