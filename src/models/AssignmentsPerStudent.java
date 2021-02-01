/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author admin
 */
public class AssignmentsPerStudent {
    private Student student;
     private List<Assignment> AssignmentsPerCourse ;

    public AssignmentsPerStudent() {
    }

    

    public AssignmentsPerStudent(Student student, List<Assignment> AssignmentsPerCourse) {
        this.student = student;
        this.AssignmentsPerCourse = AssignmentsPerCourse;
    }
    

    
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Assignment> getAssignmentsPerCourse() {
        return AssignmentsPerCourse;
    }

    public void setAssignmentsPerCourse(List<Assignment> AssignmentsPerCourse) {
            this.AssignmentsPerCourse.addAll(AssignmentsPerCourse);
       
        
    }

    @Override
    public String toString() {
        return "AssignmentsPerStudent{" + "student=" + student + ", AssignmentsPerCourse=" + AssignmentsPerCourse + '}' + "\t";
    }
     
     
    
    
}
