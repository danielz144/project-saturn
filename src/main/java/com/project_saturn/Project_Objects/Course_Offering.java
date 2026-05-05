package com.project_saturn.Project_Objects;

public class Course_Offering {
    private String location;
    private int offeringId; //PK
    private int teacherId, courseId, period;

    public Course_Offering(int offering_id, int teacher_id, int course_id, String location, int period) {
        this.teacherId = teacher_id;
        this.courseId = course_id;
        this.location = location;
        this.period = period;
        this.offeringId = offering_id;
    }

    public int getCourse_id() {
        return courseId;
    }

    public int getOffering_id() {
        return offeringId;
    }

    public String getLocation() {
        return location;
    } 

    public int getPeriod() {
        return period;
    }

    public int getTeacher_id() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "INSERT INTO Course_Offering (course_id, teacher_id, location) VALUES" + 
        "(" + courseId + ",  " + teacherId + ", " + location + ", " + period + ")";
    }
}
