package com.project_saturn.Project_Tables;

import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.CourseOffering;
import com.project_saturn.Project_Objects.Teacher;

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

class PeriodTracker {
    private static HashMap<Integer, Integer> periodCounts = new HashMap<>();

    public static void init() {
        for (int i = 1; i <= 10; i++){
            periodCounts.put(i, 0);
        }
    }

    public static int assignRandomPeriod() {
        ArrayList<Integer> lowestCountPeriods = new ArrayList<>();
        int lowestCount = Integer.MAX_VALUE, randomIndex, assignedPeriod;

        // Find the lowest count of offerings for any period
        for (Integer period : periodCounts.keySet()) {
            int count = periodCounts.get(period);
            if (count > lowestCount) { continue; }
            if (count < lowestCount) { lowestCountPeriods.clear(); }
            lowestCountPeriods.add(period);
        }
        randomIndex = (int) (Math.random() * lowestCountPeriods.size()); //Randomizes the index of the lowest count periods
        assignedPeriod = lowestCountPeriods.get(randomIndex);
        periodCounts.replace(assignedPeriod, lowestCount + 1); // Increment the count for the assigned period

        return assignedPeriod;
    }

    public static HashMap<Integer, Integer> getPeriodCounts() {
        return periodCounts;
    }
}

public class CourseOfferingTable {
    private static HashMap<Integer, CourseOffering> courseOfferings = new HashMap<>();
    private static ArrayList<RegisterTracker> registerTracker = new ArrayList<>();
    private static int totalOfferings;

    public static HashMap<Integer, CourseOffering> getCourseOfferings() {
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
            if (randomIndex <= tracker.getOpenSlots()) {
                return tracker;
            } else {
                randomIndex -= tracker.getOpenSlots();
            }
        }
        return null;
    }

    //NOTE: Update teacher_id, location, and period for random values
    //Runs 1 Time!
    public static void createTable() {
        int amountOfCourses, amountOfOfferings;
        if (courseOfferings.size() > 0) { System.err.println("Course offerings already exist."); return; }
        initRegisterTracker();
        PeriodTracker.init();
        amountOfCourses = CourseTable.getCourses().size();
        amountOfOfferings = (int) (Math.random()*(4*amountOfCourses + 1)) + amountOfCourses; //Gets a random number of offerings between the amount of courses and 5 times the amount of courses

        for (int i = 1; i <= amountOfOfferings; i++){
            RegisterTracker tracker = getRandomTracker();
            Teacher assignedTeacher;
            int period = PeriodTracker.assignRandomPeriod();

            assignedTeacher = TeacherTable.assignRandomTeacher(period);
            courseOfferings.put(i, new CourseOffering(i, assignedTeacher.getTeacherId(), tracker.getCourseId(), "", period));

            //Removes open slots to ensure 
            tracker.registeredOffering();
            totalOfferings--;
        }
    }

    public static String getInsertStatements() {
        String result = "";
        for (CourseOffering offering : courseOfferings.values()) {
            result += offering.toString() + "\n";
        }
        return result;
    }
}
