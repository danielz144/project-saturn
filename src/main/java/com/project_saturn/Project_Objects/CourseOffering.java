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

    public int getCourseId() {
        return courseId;
    }

    public int getOfferingId() {
        return offeringId;
    }

    public String getLocation() {
        return location;
    } 

    public int getPeriod() {
        return period;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return "INSERT INTO Course_Offering (course_id, teacher_id, location, period) VALUES" + 
        "(" + courseId + ",  " + teacherId + ", '" + location + "', " + period + ");";
    }
}
