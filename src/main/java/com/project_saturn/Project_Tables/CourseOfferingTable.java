package com.project_saturn.Project_Tables;

import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.Course_Offering;

class RegisterTracker {
    private int openSlots = 5; // Max is 5
    private int courseId;

    public RegisterTracker(int courseId) {
        this.courseId = courseId;
    }

    public void registeredOffering() {
        openSlots--;
    }

    public int getOpenSlots() {
        return openSlots;
    }

    public int getCourseId() {
        return courseId;
    }
}

public class CourseOfferingTable {
    public static HashMap<Integer, Course_Offering> courseOfferings = new HashMap<>();
    private static ArrayList<RegisterTracker> registerTracker = new ArrayList<>(); 
    
    private static void initRegisterTracker() {
        for (Integer courseId : CourseTable.getCourses().keySet()) {
            registerTracker.add(new RegisterTracker(courseId));
        }
    }

    public static void createCourseOfferings() {
        int amountOfCourses = CourseTable.getCourses().size();
        if (courseOfferings.size() > 0) { System.err.println("Course offerings already exist."); return; }
        initRegisterTracker();

        int amountOfOfferings = (int) (Math.random()*(4*amountOfCourses + 1)) + amountOfCourses;

        
    }
}
