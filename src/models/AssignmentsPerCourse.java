/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class AssignmentsPerCourse {
    private Course courses;
    private List<Assignment> AssignmentsPerCourse ;

    public AssignmentsPerCourse() {
    }

    public AssignmentsPerCourse(Course courses, List<Assignment> AssignmentsPerCourse) {
        this.courses = courses;
        this.AssignmentsPerCourse = AssignmentsPerCourse;
    }

    public List<Assignment> getAssignmentsPerCourse() {
        return AssignmentsPerCourse;
    }

    public void setAssignmentsPerCourse(List<Assignment> AssignmentsPerCourse) {
        this.AssignmentsPerCourse = AssignmentsPerCourse;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "AssignmentsPerCourse{" + "courses=" + courses + ", AssignmentsPerCourse=" + AssignmentsPerCourse + '}' + "\n";
    }

   
    
    
}
