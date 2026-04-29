package com.project_saturn.Project_Objects;

public class Course_Offerings {
    static private int offerings = 0;
    private String location;
    private int teacher_id, course_id, period;

    public Course_Offerings(int teacher_id, int course_id, String location, int period) {
        this.teacher_id = teacher_id;
        this.course_id = course_id;
        this.location = location;
        this.period = period;
        offerings++;
    }

    static public int getOfferings() {
        return offerings;
    }

    public int getCourse_id() {
        return course_id;
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
