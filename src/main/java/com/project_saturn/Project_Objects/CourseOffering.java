package com.project_saturn.Project_Objects;
import java.util.ArrayList;
import java.util.HashMap;

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
            lowestCount = count;
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

class LocationTracker {
    private static HashMap<String, Integer> locationCounts = new HashMap<>();

    public static void init() {
        for (String location : Rooms.getLocations()){
            locationCounts.put(location, 0);
        }
    }

    public static int assignRandomLocationId() {
        ArrayList<String> lowestCountLocations = new ArrayList<>();
        int lowestCount = Integer.MAX_VALUE, randomIndex;
        String assignedLocation;

        // Find the lowest count of offerings for any period
        for (String location : locationCounts.keySet()) {
            int count = locationCounts.get(location);
            if (count > lowestCount) { continue; }
            if (count < lowestCount) { lowestCountLocations.clear(); }
            lowestCount = count;
            lowestCountLocations.add(location);
        }
        randomIndex = (int) (Math.random() * lowestCountLocations.size()); //Randomizes the index of the lowest count periods
        assignedLocation = lowestCountLocations.get(randomIndex);
        locationCounts.replace(assignedLocation, lowestCount + 1); // Increment the count for the assigned period

        return Rooms.getLocations().indexOf(assignedLocation);
    }

    public static HashMap<String, Integer> getLocationCounts() {
        return locationCounts;
    }
}

public class CourseOffering {
    private static HashMap<Integer, CourseOffering> courseOfferings = new HashMap<>();
    private static ArrayList<RegisterTracker> registerTracker = new ArrayList<>();
    private static int totalOfferings;
    
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
        return "(" + courseId + ",  " + teacherId + ", " + (locationId+1) + ", " + period + ")";
    }

    public static HashMap<Integer, CourseOffering> getCourseOfferings() {
        return courseOfferings;
    }
    
    private static void initRegisterTracker() {
        for (Integer courseId : Course.getCourses().keySet()) {
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
    public static void populateTable() {
        int amountOfCourses, amountOfOfferings;
        if (Rooms.getLocations().size() == 0){ System.err.println("Initialize Room Table First!"); return; }
        if (courseOfferings.size() > 0) { System.err.println("Course offerings already exist."); return; }
        
        initRegisterTracker();
        PeriodTracker.init();
        LocationTracker.init();

        amountOfCourses = Course.getCourses().size();
        amountOfOfferings = (int) (Math.random()*(4*amountOfCourses + 1)) + amountOfCourses; //Gets a random number of offerings between the amount of courses and 5 times the amount of courses
        
        for (int i = 1; i <= amountOfOfferings; i++){
            int locationId = LocationTracker.assignRandomLocationId();
            int period = PeriodTracker.assignRandomPeriod();
            RegisterTracker tracker = getRandomTracker();
            Teacher assignedTeacher;

            assignedTeacher = Teacher.assignRandomTeacher(period);
            courseOfferings.put(i, new CourseOffering(i, assignedTeacher.getTeacherId(), tracker.getCourseId(), locationId, period));

            //Removes open slots to ensure 
            tracker.registeredOffering();
            totalOfferings--;
        }
    }

    public static String getInsertStatements() {
        StringBuilder result = new StringBuilder();
        result.append("INSERT INTO Course_Offerings (course_id, teacher_id, location_id, period) VALUES");
        for (CourseOffering offering : courseOfferings.values()) {
            result.append(offering.toString()).append(",\n");
        }
        result.delete(result.length() - 2, result.length()); // Remove the last comma and newline
        result.append(";");
        return result.toString();
    }
}
