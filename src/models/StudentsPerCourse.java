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
public class StudentsPerCourse {

    private Course courses;
    private List<Student> students;

    public StudentsPerCourse() {
    }

    public StudentsPerCourse(Course courses, List<Student> students) {
        this.courses = courses;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentPerCourse{" + "courses=" + courses + ", students=" + students + '}';
    }

  
   

    
    }



