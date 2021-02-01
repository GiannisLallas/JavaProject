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
public class TrainersPerCourse {
     private Course courses;
    private List<Trainer> trainers;

    public TrainersPerCourse() {
    }

    public TrainersPerCourse(Course courses, List<Trainer> trainers) {
        this.courses = courses;
        this.trainers = trainers;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentPerCourse{" + "courses=" + courses + ", trainers=" + trainers + '}' + "\n";
    }
}
