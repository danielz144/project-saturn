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
    private static HashMap<Integer, Course_Offering> courseOfferings = new HashMap<>();
    private static ArrayList<RegisterTracker> registerTracker = new ArrayList<>();
    private static int totalOfferings;

    public static HashMap<Integer, Course_Offering> getCourseOfferings() {
        return courseOfferings;
    }
    
    private static void initRegisterTracker() {
        for (Integer courseId : CourseTable.getCourses().keySet()) {
            registerTracker.add(new RegisterTracker(courseId));
        }

        totalOfferings = registerTracker.size() * 5; // Each course can have up to 5 offerings
    }

    private static RegisterTracker getRandomTracker() {
        int randomIndex = (int) (Math.random() * totalOfferings);
        for (RegisterTracker tracker : registerTracker) {
            if (tracker.getOpenSlots() < 1) { continue; }
            if (randomIndex < tracker.getOpenSlots()) {
                return tracker;
            } else {
                randomIndex -= tracker.getOpenSlots();
            }
        }
        return null;
    }

    //NOTE: Update teacher_id, location, and period for random values
    //Runs 1 Time!
    public static void createCourseOfferings() {
        int amountOfCourses, amountOfOfferings;
        if (courseOfferings.size() > 0) { System.err.println("Course offerings already exist."); return; }
        initRegisterTracker();
        amountOfCourses = CourseTable.getCourses().size();
        amountOfOfferings = (int) (Math.random()*(4*amountOfCourses + 1)) + amountOfCourses; //Gets a random number of offerings between the amount of courses and 5 times the amount of courses

        for (int i = 1; i <= amountOfOfferings; i++){
            RegisterTracker tracker = getRandomTracker();
            courseOfferings.put(i, new Course_Offering(i, 0, tracker.getCourseId(), "", 0));

            //Removes open slots to ensure 
            tracker.registeredOffering();
            totalOfferings--;
        }
    }

    public static String getInsertStatements() {
        String result = "";
        for (Course_Offering offering : courseOfferings.values()) {
            result += offering.toString() + "\n";
        }
        return result;
    }
}
