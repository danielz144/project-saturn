package com.project_saturn.Project_Objects;

public class CourseOffering {
    private int locationId;
    private int offeringId; //PK
    private int teacherId, courseId, period;

    public CourseOffering(int offeringId, int teacherId, int courseId, int locationId, int period) {
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.locationId = locationId;
        this.period = period;
        this.offeringId = offeringId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getOfferingId() {
        return offeringId;
    }

    public int getLocationId() {
        return locationId;
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
        "(" + courseId + ",  " + teacherId + ", '" + locationId+1 + "', " + period + ");";
    }
}
