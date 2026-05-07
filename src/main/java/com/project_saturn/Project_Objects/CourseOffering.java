package com.project_saturn.Project_Objects;

public class CourseOffering {
    private String location;
    private int offeringId; //PK
    private int teacherId, courseId, period;

    public CourseOffering(int offeringId, int teacherId, int courseId, String location, int period) {
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.location = location;
        this.period = period;
        this.offeringId = offeringId;
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
