package id.ac.polinema.uts.kursus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Academy");
        Academy academy = new Academy("Polinema Academy");
        Instructor dewi = new Instructor("Dewi Lestari", "Software Engineering");
        OnlineCourse java = new OnlineCourse("OOP-101", "Java Basics", 2023, dewi);
        OfflineCourse db = new OfflineCourse("Database Systems", 2021, "R-204");
        Workshop git = new Workshop("Git Bootcamp", 2024, 30);
        Student rina = new Student("S101", "Rina");

        academy.addCourse(java);
        academy.addCourse(db);
        academy.addCourse(git);
        academy.addStudent(rina);

        AcademyApp app = new AcademyApp(academy, new Scanner(System.in), System.out);
        app.run();
    }
}