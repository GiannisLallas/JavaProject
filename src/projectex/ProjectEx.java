/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectex;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Assignment;
import models.AssignmentsPerCourse;
import models.AssignmentsPerStudent;

import models.Course;
import models.CoursesPerStudent;
import models.Student;
import models.StudentsPerCourse;
import models.Trainer;
import models.TrainersPerCourse;

/**
 *
 * @author admin
 */
public class ProjectEx {

    /**
     * @param args the command line arguments
     */
    public static Boolean isScannerData = false;
    public static List<Student> allStudents = new ArrayList();
    public static List<Course> allCourses = new ArrayList();
    public static List<Trainer> allTrainers = new ArrayList();
    public static List<Assignment> allAssignments = new ArrayList();
    public static List<AssignmentsPerCourse> allAssignmentsPerCourse = new ArrayList();
    public static List<StudentsPerCourse> allStudentsPerCourse = new ArrayList();
    public static List<TrainersPerCourse> allTrainersPerCourse = new ArrayList();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to put your own data ? ");
        String data = input.next();

        if (data.equals("y") || data.equals("Y")) {
            isScannerData = true;
            generateDataFromScanner();
        }

        printAllStudents();
        printAllTrainers();
        printAllAssignments();
        PrintAllCourses();
        printStudentsPerCourse();
        printTrainersPercourse();
        printAssignmentsPerCourse();
        printAssignmentsPerStudent();
        printStudentsWithMultipleCourses();

        System.out.println("\nPlease enter date(dd/MM/yyyy) :");
        String date = input.next();
        returnStudentsWhoNeedToSubmitAssignments(date);

    }
    
    public static void generateDataFromScanner() {
        List<Course> courses = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("\nHow many courses do you want to add ? ");
        int data = input.nextInt();
        for (int i = 0; i < data; i++) {
            System.out.println("\nGive the name of the course : ");
            String name = input.next();
            System.out.println("\nGive the type of the course : ");
            String type = input.next();
            System.out.println("\nGive the stream of the course : ");
            String stream = input.next();
            System.out.println("\nGive the start date of the course (yyyy-MM-dd)  : ");
            String startDate = input.next();
            LocalDate startLocalDate = LocalDate.parse(startDate);
            System.out.println("\nGive the end date of the course (yyyy-MM-dd) : ");
            String endDate = input.next();
            LocalDate endLocalDate = LocalDate.parse(endDate);

            allCourses.add(new Course(name, type, stream, startLocalDate, endLocalDate));

            //generate the assignments for this course
            AssignmentsPerCourse assignmentsPerCourse = new AssignmentsPerCourse(new Course(name, type, stream, startLocalDate, endLocalDate), generateAllAssignmentsFromScannerPerCourse());
            allAssignmentsPerCourse.add(assignmentsPerCourse);
            
            //generate the trainers for this course
            TrainersPerCourse trainersPerCourse = new TrainersPerCourse(new Course(name, type, stream, startLocalDate, endLocalDate), generateAllTrainersFromScanner());
            allTrainersPerCourse.add(trainersPerCourse);
            
            //generate the students for this course
            StudentsPerCourse studentsPerCourse = new StudentsPerCourse(new Course(name, type, stream, startLocalDate, endLocalDate), generateFromScannerAllStudentsPerCourse());
            allStudentsPerCourse.add(studentsPerCourse);
            
        }

    }
    
    public static List<Student> generateFromScannerAllStudentsPerCourse() {
        List<Student> students = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("\nHow many students do you want to add to this course ? ");
        int data = input.nextInt();
        for (int i = 0; i < data; i++) {
            System.out.println("\nGive the name of the student : ");
            String name = input.next();
            System.out.println("\nGive the last name of the student : ");
            String lastName = input.next();
            System.out.println("\nGive the birth date of the student (yyyy-MM-dd): ");
            String date = input.next();
            LocalDate birthDate = LocalDate.parse(date);
            System.out.println("\nGive the tuition fees of the student : ");
            int fee = input.nextInt();

            students.add(new Student(name, lastName, birthDate, fee));
        }
        allStudents.addAll(students);
        return students;
    }
    
    public static List<Trainer> generateAllTrainersFromScanner() {
        List<Trainer> trainers = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("\nHow many trainers do you want to add for this course ? ");
        int data = input.nextInt();
        for (int i = 0; i < data; i++) {
            System.out.println("\nGive the name of the trainer : ");
            String name = input.next();
            System.out.println("\nGive the last name of the trainer : ");
            String lastName = input.next();
            
            trainers.add(new Trainer(name, lastName));
        }
        allTrainers.addAll(trainers);
        return trainers;
    }
    
    public static List<Assignment> generateAllAssignmentsFromScannerPerCourse() {
        List<Assignment> assignments = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("\nHow many assignments do you want to add for this course ? ");
        int data = input.nextInt();
        for (int i = 0; i < data; i++) {
            System.out.println("\nGive the name of the assignment : ");
            String name = input.next();
            System.out.println("\nGive the description of the assignment : ");
            String description = input.next();
            System.out.println("\nGive the submission date of the assignment : ");
            String submissionDate = input.next();
            LocalDate submissionLocalDate = LocalDate.parse(submissionDate);
            System.out.println("\nGive the total mark of the assignment : ");
            double totalMark = input.nextDouble();

            //add new assignment to return list for each course
            assignments.add(new Assignment(name, description, submissionLocalDate, totalMark));
            //add new assignment in all Assignment list
            allAssignments.add(new Assignment(name, description, submissionLocalDate, totalMark));
        }

        return assignments;
    }
    //end methods with data from scanner
    

    public static List<Student> generateAllStudents() {
        List<Student> students = new ArrayList();

        students.add(new Student("Giannis", "Lallas", LocalDate.of(1993, 1, 31), 1800));
        students.add(new Student("Nikos", "Souliotis", LocalDate.of(1989, 1, 24), 1800));
        students.add(new Student("Anna", "Lalla", LocalDate.of(1990, 10, 26), 1800));
        students.add(new Student("Giorgos", "Papanikolaou", LocalDate.of(1995, 8, 15), 1800));
        students.add(new Student("Maria", "Alexiou", LocalDate.of(1994, 10, 25), 1800));
        students.add(new Student("Giannis", "Welteke", LocalDate.of(1994, 10, 25), 1800));
        students.add(new Student("Eirini", "Welteke", LocalDate.of(1994, 10, 25), 1800));
        
        return students;
    }

    

    public static void printAllStudents() {
        if (!isScannerData) {
            allStudents = generateAllStudents();
        }     
        for (Student student : allStudents) {
            System.out.println("List of  students  = " + student);

        }
    }

    public static List<Trainer> generateAllTrainers() {
        List<Trainer> trainers = new ArrayList();
        
        trainers.add(new Trainer("Giorgos", "Papadopoulos"));
        trainers.add(new Trainer("Alex", "Argiropoulos"));
        trainers.add(new Trainer("Stefan", "Welteke"));
        trainers.add(new Trainer("Nikos", "Delatolas"));
        trainers.add(new Trainer("Niki", "Tsiouri"));
        
        return trainers;
    }

    

    public static void printAllTrainers() {
        if (!isScannerData) {
            allTrainers = generateAllTrainers();
        }
        for (Trainer trainer : allTrainers) {
            System.out.println("List of trainers = " + trainer);
        }
    }

    public static List<Course> generateAllCourses() {
        List<Course> courses = new ArrayList();
        
        courses.add(new Course("Cb11", "Java", "Full Time", LocalDate.of(2020, 6, 15), LocalDate.of(2021, 1, 24)));
        courses.add(new Course("Cb11", "Java", "Part Time", LocalDate.of(2020, 6, 15), LocalDate.of(2020, 9, 13)));
        courses.add(new Course("Cb11", "C#", "Part Time", LocalDate.of(2020, 6, 15), LocalDate.of(2020, 9, 13)));
        courses.add(new Course("Cb11", "C#", "Full Time", LocalDate.of(2020, 6, 15), LocalDate.of(2021, 1, 24)));
        
        return courses;
    }

    

    public static void PrintAllCourses() {
        if (!isScannerData) {
            allCourses = generateAllCourses();
        }
        for (Course courses : allCourses) {
            System.out.println("List of all Courses " + courses);
        }

    }

    

    public static void generateAllAssignments() {
        List<Assignment> assignments = new ArrayList();

        //JavaFullTimeAss&Projects
        assignments.add(new Assignment("Ftjv1", "First assignement full time Java", LocalDate.of(2020, 7, 15), 100));
        assignments.add(new Assignment("Ftjv2", "Second assignement full time Java", LocalDate.of(2020, 7, 25), 100));
        assignments.add(new Assignment("Ftjv3", "Third assignement full time Java ", LocalDate.of(2020, 8, 10), 100));
        assignments.add(new Assignment("Ftjv4", "Fourth assignement full time Java", LocalDate.of(2020, 8, 14), 100));
        assignments.add(new Assignment("Ftjv5", "Fifth assignement full time Java", LocalDate.of(2020, 9, 20), 100));
        assignments.add(new Assignment("Project 1", "First Project full time Java", LocalDate.of(2020, 8, 7), 100));
        assignments.add(new Assignment("Project 2", "Fifth Project full time Java", LocalDate.of(2020, 11, 8), 100));

        //JavaPartTimeAss&Projects
        assignments.add(new Assignment("Ptjv1", "First assignement part time Java", LocalDate.of(2020, 7, 10), 100));
        assignments.add(new Assignment("Ptjv2", "Second assignement part time Java", LocalDate.of(2020, 7, 15), 100));
        assignments.add(new Assignment("Ptjv3", "Third assignement  part time Java", LocalDate.of(2020, 8, 10), 100));
        assignments.add(new Assignment("Ptjv4", "Fourth assignement  part time Java", LocalDate.of(2020, 8, 26), 100));
        assignments.add(new Assignment("Ptjv5", "Fifth assignement  part time Java", LocalDate.of(2020, 8, 29), 100));
        assignments.add(new Assignment("Project 1", "First Project  part time Java", LocalDate.of(2020, 7, 10), 100));
        assignments.add(new Assignment("Project 2", "Fifth Project  part time Java", LocalDate.of(2020, 8, 12), 100));

        //C#FullTimeAss&Projects
        assignments.add(new Assignment("C#ft1", "First assignement full time C#", LocalDate.of(2020, 7, 15), 100));
        assignments.add(new Assignment("C#ft1", "Second assignement full time C#", LocalDate.of(2020, 7, 25), 100));
        assignments.add(new Assignment("C#ft1", "Third assignement full time C#", LocalDate.of(2020, 8, 10), 100));
        assignments.add(new Assignment("C#ft1", "Fourth assignement full time C#", LocalDate.of(2020, 8, 14), 100));
        assignments.add(new Assignment("C#ft1", "Fifth assignement full time C#", LocalDate.of(2020, 9, 20), 100));
        assignments.add(new Assignment("Project 1", "First Project full time C#", LocalDate.of(2020, 8, 7), 100));
        assignments.add(new Assignment("Project 2", "Fifth Project full time C#", LocalDate.of(2020, 11, 8), 100));

        //C#PartTimeAss&Projects
        assignments.add(new Assignment("C#Pt1", "First assignement part time  C#", LocalDate.of(2020, 7, 10), 100));
        assignments.add(new Assignment("C#Pt1", "Second assignement part time  C#", LocalDate.of(2020, 7, 15), 100));
        assignments.add(new Assignment("C#Pt1", "Third assignement  part time  C#", LocalDate.of(2020, 8, 10), 100));
        assignments.add(new Assignment("C#Pt1", "Fourth assignement  part time  C#", LocalDate.of(2020, 8, 26), 100));
        assignments.add(new Assignment("C#Pt1", "Fifth assignement  part time  C#", LocalDate.of(2020, 8, 29), 100));
        assignments.add(new Assignment("Project 1", "First Project  part time  C#", LocalDate.of(2020, 7, 10), 100));
        assignments.add(new Assignment("Project 2", "Fifth Project  part time  C#", LocalDate.of(2020, 8, 12), 100));

        allAssignments.addAll(assignments);

    }

    public static void printAllAssignments() {
        if (!isScannerData) {
            generateAllAssignments();
        }
        for (Assignment as : allAssignments) {
            System.out.println("List of All assignments : " + as);
        }
    }

    public static List<StudentsPerCourse> generateStudentsPerCourse() {

        List<Student> students = allStudents;
        List<Course> courses = allCourses;
        List<StudentsPerCourse> studentsPerCourse = new ArrayList();
        //Full TimeJava
        List<Student> studentsForCourseFullTimeJava = new ArrayList();
        studentsForCourseFullTimeJava.add(students.get(0));
        studentsForCourseFullTimeJava.add(students.get(1));
        studentsPerCourse.add(new StudentsPerCourse(courses.get(0), studentsForCourseFullTimeJava));
        //Part TimeJava
        List<Student> studentsForCoursePartTimeJava = new ArrayList();
        studentsForCoursePartTimeJava.add(students.get(1));
        studentsForCoursePartTimeJava.add(students.get(2));
        studentsPerCourse.add(new StudentsPerCourse(courses.get(1), studentsForCoursePartTimeJava));
        //Full Time C#
        List<Student> studentsForCourseFullTimeCS = new ArrayList();
        studentsForCourseFullTimeCS.add(students.get(3));
        studentsForCourseFullTimeCS.add(students.get(4));
        studentsPerCourse.add(new StudentsPerCourse(courses.get(3), studentsForCourseFullTimeCS));
        //Part Time C#
        List<Student> studentsForCoursePartTimeCS = new ArrayList();
        studentsForCoursePartTimeCS.add(students.get(5));
        studentsForCoursePartTimeCS.add(students.get(6));
        studentsPerCourse.add(new StudentsPerCourse(courses.get(2), studentsForCoursePartTimeCS));

        return studentsPerCourse;

    }

    public static void printStudentsPerCourse() {
        if(!isScannerData){
            allStudentsPerCourse = generateStudentsPerCourse();
        }
        for (StudentsPerCourse s : allStudentsPerCourse) {

            System.out.println("For lesson " + s.getCourses().getTitle() + ". " + " The stream of the lessson is " + s.getCourses().getStream() + ". Type is " + s.getCourses().getType() + ". The students are = " + s.getStudents().toString());
        }
    }

    public static List<TrainersPerCourse> generateTrainersPerCourse() {
        List<Trainer> trainers = allTrainers;
        List<Course> courses = allCourses;
        List<TrainersPerCourse> trainersPerCourse = new ArrayList();
        //TrainersFullTimeJava
        List<Trainer> trainersForCourseFullTimeJava = new ArrayList();
        trainersForCourseFullTimeJava.add(trainers.get(0));
        trainersPerCourse.add(new TrainersPerCourse(courses.get(0), trainersForCourseFullTimeJava));

        //TrainersPartTimeJava
        List<Trainer> trainersForCoursePartTimeJava = new ArrayList();
        trainersForCoursePartTimeJava.add(trainers.get(0));
        trainersForCoursePartTimeJava.add(trainers.get(1));
        trainersPerCourse.add(new TrainersPerCourse(courses.get(1), trainersForCoursePartTimeJava));

        //TrainersFullTimeC#
        List<Trainer> trainersForCourseFullTimeCS = new ArrayList();
        trainersForCourseFullTimeCS.add(trainers.get(2));
        trainersPerCourse.add(new TrainersPerCourse(courses.get(3), trainersForCourseFullTimeCS));

        //TrainersPartTimeC#
        List<Trainer> trainersForCoursePartTimeCS = new ArrayList();
        trainersForCoursePartTimeCS.add(trainers.get(3));
        trainersForCoursePartTimeCS.add(trainers.get(4));
        trainersPerCourse.add(new TrainersPerCourse(courses.get(2), trainersForCoursePartTimeCS));

        return trainersPerCourse;
    }

    public static void printTrainersPercourse() {
        if(!isScannerData){
            allTrainersPerCourse = generateTrainersPerCourse();
        }
        for (TrainersPerCourse t : allTrainersPerCourse) {
            System.out.println("For lesson " + t.getCourses().getTitle() + ". " + " The stream of the lessson is " + t.getCourses().getStream() + ". Type is " + t.getCourses().getType() + ". " + " The trainers are =  " + t.getTrainers());
        }
    }

    public static List<AssignmentsPerCourse> generateAssignmentsPerCourse() {
        List<AssignmentsPerCourse> assignmentsPerCourse = new ArrayList();
        List<Course> courses = allCourses;
        List<Assignment> assignments = allAssignments;

        //Assignements Full Time Java
        List<Assignment> assignmentsForCourseFullTimeJava = new ArrayList();
        assignmentsForCourseFullTimeJava.add(assignments.get(0));
        assignmentsForCourseFullTimeJava.add(assignments.get(1));
        assignmentsForCourseFullTimeJava.add(assignments.get(2));
        assignmentsForCourseFullTimeJava.add(assignments.get(3));
        assignmentsForCourseFullTimeJava.add(assignments.get(4));
        assignmentsForCourseFullTimeJava.add(assignments.get(5));
        assignmentsForCourseFullTimeJava.add(assignments.get(6));
        assignmentsPerCourse.add(new AssignmentsPerCourse(courses.get(0), assignmentsForCourseFullTimeJava));

        //Assignements Part Time Java
        List<Assignment> assignmentsForCoursePartTimeJava = new ArrayList();
        assignmentsForCoursePartTimeJava.add(assignments.get(7));
        assignmentsForCoursePartTimeJava.add(assignments.get(8));
        assignmentsForCoursePartTimeJava.add(assignments.get(9));
        assignmentsForCoursePartTimeJava.add(assignments.get(10));
        assignmentsForCoursePartTimeJava.add(assignments.get(11));
        assignmentsForCoursePartTimeJava.add(assignments.get(12));
        assignmentsForCoursePartTimeJava.add(assignments.get(13));
        assignmentsPerCourse.add(new AssignmentsPerCourse(courses.get(1), assignmentsForCoursePartTimeJava));

        //Assignements Full Time C#
        List<Assignment> assignmentsForCourseFullTimeCS = new ArrayList();
        assignmentsForCourseFullTimeCS.add(assignments.get(14));
        assignmentsForCourseFullTimeCS.add(assignments.get(15));
        assignmentsForCourseFullTimeCS.add(assignments.get(16));
        assignmentsForCourseFullTimeCS.add(assignments.get(17));
        assignmentsForCourseFullTimeCS.add(assignments.get(18));
        assignmentsForCourseFullTimeCS.add(assignments.get(19));
        assignmentsForCourseFullTimeCS.add(assignments.get(20));
        assignmentsPerCourse.add(new AssignmentsPerCourse(courses.get(3), assignmentsForCourseFullTimeCS));

        //Assignements Part Time C#
        List<Assignment> assignmentsForCoursePartTimeCS = new ArrayList();
        assignmentsForCoursePartTimeCS.add(assignments.get(14));
        assignmentsForCoursePartTimeCS.add(assignments.get(15));
        assignmentsForCoursePartTimeCS.add(assignments.get(16));
        assignmentsForCoursePartTimeCS.add(assignments.get(17));
        assignmentsForCoursePartTimeCS.add(assignments.get(18));
        assignmentsForCoursePartTimeCS.add(assignments.get(19));
        assignmentsForCoursePartTimeCS.add(assignments.get(20));
        assignmentsPerCourse.add(new AssignmentsPerCourse(courses.get(2), assignmentsForCoursePartTimeCS));

        return assignmentsPerCourse;

    }

    public static void printAssignmentsPerCourse() {
        if (!isScannerData) {
           allAssignmentsPerCourse = generateAssignmentsPerCourse(); 
        }
        for (AssignmentsPerCourse a : allAssignmentsPerCourse) {
            System.out.println("For lesson " + a.getCourses().getTitle() + ". " + " The stream of the lessson is " + a.getCourses().getStream() + "." + " Type is " + a.getCourses().getType() + ". "
                    + " The assignments per Course are = " + a.getAssignmentsPerCourse());

        }
    }

    public static List<AssignmentsPerStudent> generateAssignmentsPerStudent(List<StudentsPerCourse> studentsPerCourse, List<AssignmentsPerCourse> assignmentsPerCourse, List<Student> studentList) {

        List<AssignmentsPerStudent> assignmentsPerStudents = new ArrayList();
        for (Student student : studentList) {
            assignmentsPerStudents.add(new AssignmentsPerStudent(student, new ArrayList<Assignment>()));
        }

        for (StudentsPerCourse s : studentsPerCourse) {
            for (AssignmentsPerCourse a : assignmentsPerCourse) {
                if (s.getCourses().equals(a.getCourses())) {
                    for (AssignmentsPerStudent assignmentsPerStudent : assignmentsPerStudents) {
                        for (Student student : s.getStudents()) {
                            if (assignmentsPerStudent.getStudent().equals(student)) {
                                assignmentsPerStudent.setAssignmentsPerCourse(a.getAssignmentsPerCourse());
                            }
                        }
                    }
                }
            }

        }

        return assignmentsPerStudents;
    }

    public static void printAssignmentsPerStudent() {
        for (AssignmentsPerStudent a : generateAssignmentsPerStudent(allStudentsPerCourse, allAssignmentsPerCourse, allStudents)) {
            System.out.println("The assignments for student " + a.getStudent().getName() + " " + a.getStudent().getLastName() + " are = "
                    + a.getAssignmentsPerCourse());
        }
    }

    public static List<CoursesPerStudent> findCoursesPerStudent() {
        List<CoursesPerStudent> coursesPerStudents = new ArrayList();
        for (Student student : allStudents) {
            coursesPerStudents.add(new CoursesPerStudent(student, new ArrayList<Course>()));
        }
        for (StudentsPerCourse s : allStudentsPerCourse) {
            for (CoursesPerStudent c : coursesPerStudents) {
                for (Student student : s.getStudents()) {
                    if (student.equals(c.getStudent())) {
                        c.appendCourses(s.getCourses());
                    }
                }
            }

        }
        return coursesPerStudents;
    }

    public static void printStudentsWithMultipleCourses() {
        for (CoursesPerStudent c : findCoursesPerStudent()) {
            if (c.getCourses().size() > 1) {
                System.out.println("The students with multiple Courses are = " + c.toString());
            }
        }
    }

    public static void returnStudentsWhoNeedToSubmitAssignments(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        LocalDate dateFromString = LocalDate.parse(date, formatter);//yyyy-MM-dd
        DateTimeFormatter printingFormatter = DateTimeFormatter.ofPattern("EEE dd MMMM yyyy");

        //find first mera of week
        DayOfWeek hmera = dateFromString.getDayOfWeek();
        System.out.println("hmera = " + hmera);
        while (hmera != DayOfWeek.MONDAY) {
            dateFromString = dateFromString.minusDays(1);
            hmera = dateFromString.getDayOfWeek();
        }
        String firstDayOfWeek = dateFromString.format(printingFormatter);
        LocalDate firstDay = LocalDate.parse(firstDayOfWeek, printingFormatter);
        //find last day of week
        while (hmera != DayOfWeek.FRIDAY) {
            dateFromString = dateFromString.plusDays(1);
            hmera = dateFromString.getDayOfWeek();
        }
        String lastDayOfWeek = dateFromString.format(printingFormatter);
        LocalDate lastDay = LocalDate.parse(lastDayOfWeek, printingFormatter);
        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        System.out.println("lastDayOfWeek = " + lastDayOfWeek);
        List<Student> studentsWhoNeedToSubmitAssignments = new ArrayList();
        for (AssignmentsPerStudent a : generateAssignmentsPerStudent(allStudentsPerCourse, allAssignmentsPerCourse, allStudents)) {
            for (Assignment as : a.getAssignmentsPerCourse()) {
                if (as.getSubDateTime().isAfter(firstDay) && as.getSubDateTime().isBefore(lastDay)) {
                    studentsWhoNeedToSubmitAssignments.add(a.getStudent());
                    break;
                }

            }

        }

        for (Student studentsWhoNeedToSubmitAssignment : studentsWhoNeedToSubmitAssignments) {
            System.out.println("The students are = " + studentsWhoNeedToSubmitAssignment);

        }

    }

}
