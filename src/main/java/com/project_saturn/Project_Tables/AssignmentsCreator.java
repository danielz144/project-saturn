package com.project_saturn.Project_Tables;

import com.project_saturn.Project_Objects.Assignments;

import java.util.ArrayList;

public class AssignmentsCreator {

    private ArrayList<Assignments> assignments;

    public AssignmentsCreator() {
        assignments = new ArrayList<>();
    }

    public void makeAssignments() {
        for (int i = 0; i < CoursesTable.getCourses().size(); i++) {
            for (int j = 1; j <= 15; j++) {
                if (j <= 12) {
                    assignments.add(new Assignments(1, i, "Minor", j, (int) (Math.random() * 26) + 75));
                } else {
                    assignments.add(new Assignments(1, i, "Major", j, (int) (Math.random() * 26) + 75));
                }
            }
        }
    }

    public ArrayList<Assignments> getAssignments() {
        return assignments;
    }
}
