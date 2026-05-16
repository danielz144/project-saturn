package com.project_saturn.Project_Tables;

import java.util.ArrayList;
import java.util.HashMap;

import com.project_saturn.Project_Objects.CourseOffering;

class CourseOfferingTracker {
     private static HashMap<Integer, HashMap<CourseOffering, Integer>> periodCounts = new HashMap<>();

     public static void init() {
          for (int i = 1; i <= 10; i++){
               periodCounts.put(i, new HashMap<>());
          }

          for (CourseOffering courseOffering : CourseOfferingsTable.getCourseOfferings().values()) {
               HashMap<CourseOffering, Integer> periodOfferings = periodCounts.get(courseOffering.getPeriod());
               periodOfferings.put(courseOffering, 0);
          }
     }

     public static CourseOffering assignRandomOffering(int period) {
          ArrayList<CourseOffering> lowestOfferingList = new ArrayList<>();
          HashMap<CourseOffering, Integer> periodOfferings = periodCounts.get(period);
          int lowestOfferingCount = Integer.MAX_VALUE, randomOfferingIndex;

          // Check for offerings that are less assigned in the period
          for (CourseOffering courseOffering : periodOfferings.keySet()) {
               int count = periodOfferings.get(courseOffering);
               if (count > lowestOfferingCount) { continue; }
               if (count < lowestOfferingCount) { lowestOfferingList.clear(); }
               lowestOfferingCount = count;
               lowestOfferingList.add(courseOffering);
          }
          randomOfferingIndex = (int) (Math.random() * lowestOfferingList.size());

          return lowestOfferingList.get(randomOfferingIndex);
     }
}

public class RosterTable {
     private static HashMap<Integer, ArrayList<Integer>> roster = new HashMap<>(); // (studentId -> [offeringIds])

     public static void createTable() {
          CourseOfferingTracker.init();

          for (int studentId : StudentsTable.getStudents().keySet()) {
               ArrayList<Integer> studentOfferings = new ArrayList<>();
               for (int i = 1; i <= 10; i++){
                    studentOfferings.add(CourseOfferingTracker.assignRandomOffering(i).getOfferingId());
               }
               roster.put(studentId, studentOfferings);
          }
     }

     public static HashMap<Integer, ArrayList<Integer>> getRoster() {
          return roster;
     }

     public static String getInsertStatements() {
          String result = "";
          for (int studentId : roster.keySet()) {
               for (int offeringId : roster.get(studentId)) {
                    result += "INSERT INTO Roster(student_id, offering_id) VALUES (" + studentId + ", " + offeringId + ");\n";
               }
          }
          return result;
     }
}
