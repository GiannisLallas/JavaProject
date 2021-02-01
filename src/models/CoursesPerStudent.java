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
public class CoursesPerStudent {

    private Student student;
    private List<Course> courses;

    public CoursesPerStudent(Student student, List<Course> courses) {
        this.student = student;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void appendCourses(Course course) {
        this.courses.add(course);
    }
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "CoursesPerStudent{" + "student=" + student + ", courses=" + courses + '}';
    }

}
