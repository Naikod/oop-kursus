package id.ac.polinema.uts.kursus;

import java.io.PrintStream;
import java.util.Scanner;

public class AcademyApp {
    private Academy academy;
    private Scanner in;
    private PrintStream out;

    public AcademyApp(Academy academy, Scanner in, PrintStream out) {
        this.academy = academy;
        this.in = in;
        this.out = out;
    }

    public void run(){
        while (true) {
            printMenu();
            out.print("Select: ");
            String choice = in.hasNextLine() ? in.nextLine().trim(): "0";
            switch (Integer.parseInt(choice)) {
                case 0:
                    out.println("Bye");
                    break;
                    
                case 1:
                    listCourses();
                    break;
                case 2:
                    addOnlineCourse();
                    break;
                case 3:
                    addOfflineCourse();
                    break;
                case 4:
                    addWorkshop();
                    break;
                case 5:
                    registerStudent();
                    break;
                case 6:
                    enrollStudent();
                    break;
                case 7:
                    dropCourse();
                    break;
                case 8:
                    searchCourses();
                    break;
                case 9:
                    listStudents();
                    break;
                default:
                    out.println("Invalid option");
                    break;
            }
        }
    }

    private void printMenu() {
        out.println(academy.getName());
        out.println("1. List courses");
        out.println("2. Add online course");
        out.println("3. Add offline courses");
        out.println("4. Add workshop");
        out.println("5. Register student");
        out.println("6. Enroll student");
        out.println("7. Drop course");
        out.println("8. Search courses");
        out.println("9. List students");
        out.println("0. Exit");
    }

    private void listCourses() {
        Course[] courses = academy.getCourses();
        if (courses.length == 0) {
            out.println("No courses");
            return;
        }
        for (Course c : courses) {
            printCourseLine(c);
        }
    }

    private void printCourseLine(Course c) {
        String status = c.isAvailable() ? "Open" : "Full";
        out.println(c.describe() + " | " + status + " | " + c.durationWeeks() + " weeks");
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private void addOnlineCourse() {
        out.print("Code: ");
        String code = in.nextLine();
        out.print("Title: ");
        String title = in.nextLine();
        out.print("Year: ");
        String yearStr = in.nextLine();
        if (isBlank(code) || isBlank(title)) {
            out.println("Invalid input");
            return;
        }
        int year;
        try {
            year = Integer.parseInt(yearStr.trim());
            if (year < 2015) {
                out.println("Invalid number");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("Invalid number");
            return;
        }
        out.print("Instructor name (blank for none): ");
        String instrName = in.nextLine();
        Instructor instructor = null;
        if (!isBlank(instrName)) {
            out.print("Instructor expertise: ");
            String expertise = in.nextLine();
            instructor = new Instructor(instrName.trim(), expertise);
        }
        OnlineCourse course;
        try {
            if (instructor != null) {
                course = new OnlineCourse(code, title, year, instructor);
            } else {
                course = new OnlineCourse(code, title, year);
            }
        } catch (IllegalArgumentException e) {
            out.println("Invalid input");
            return;
        }
        if (academy.addCourse(course)) {
            out.println("Course added");
        } else {
            out.println("Academy is full");
        }
    }

    private void addOfflineCourse() {
        out.print("Title: ");
        String title = in.nextLine();
        out.print("Year: ");
        String yearStr = in.nextLine();
        int year;
        try {
            year = Integer.parseInt(yearStr.trim());
            if (year < 2015) {
                out.println("Invalid number");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("Invalid number");
            return;
        }
        out.print("Room: ");
        String room = in.nextLine();
        if (isBlank(title) || isBlank(room)) {
            out.println("Invalid input");
            return;
        }
        OfflineCourse course;
        try {
            course = new OfflineCourse(title, year, room);
        } catch (IllegalArgumentException e) {
            out.println("Invalid input");
            return;
        }
        if (academy.addCourse(course)) {
            out.println("Course added");
        } else {
            out.println("Academy is full");
        }
    }

    private void addWorkshop() {
        out.print("Title: ");
        String title = in.nextLine();
        out.print("Year: ");
        String yearStr = in.nextLine();
        int year;
        try {
            year = Integer.parseInt(yearStr.trim());
            if (year < 2015) {
                out.println("Invalid number");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("Invalid number");
            return;
        }
        out.print("Seats: ");
        String seatsStr = in.nextLine();
        int seats;
        try {
            seats = Integer.parseInt(seatsStr.trim());
            if (seats <= 0) {
                out.println("Invalid number");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("Invalid number");
            return;
        }
        if (isBlank(title)) {
            out.println("Invalid input");
            return;
        }
        Workshop course;
        try {
            course = new Workshop(title, year, seats);
        } catch (IllegalArgumentException e) {
            out.println("Invalid input");
            return;
        }
        if (academy.addCourse(course)) {
            out.println("Course added");
        } else {
            out.println("Academy is full");
        }
    }

    private void registerStudent() {
        out.print("Student ID: ");
        String id = in.nextLine();
        out.print("Name: ");
        String name = in.nextLine();
        try {
            Student student = new Student(id, name);
            if (academy.addStudent(student)) {
                out.println("Student registered");
            } else {
                out.println("Student ID already exists");
            }
        } catch (IllegalArgumentException e) {
            out.println("Student ID already exists");
        }
    }

    private void enrollStudent() {
        out.print("Student ID: ");
        String id = in.nextLine();
        out.print("Course title: ");
        String title = in.nextLine();
        if (academy.enroll(id, title)) {
            out.println("Enrollment successful");
        } else {
            out.println("Enrollment failed");
        }
    }

    private void dropCourse() {
        out.print("Student ID: ");
        String id = in.nextLine();
        out.print("Course title: ");
        String title = in.nextLine();
        if (academy.drop(id, title)) {
            out.println("Drop successful");
        } else {
            out.println("Drop failed");
        }
    }

    private void searchCourses() {
        out.print("Keyword: ");
        String keyword = in.nextLine();
        Course[] found = academy.searchByKeyword(keyword);
        if (found.length == 0) {
            out.println("No courses found");
            return;
        }
        for (Course c : found) {
            printCourseLine(c);
        }
    }

    private void listStudents() {
        Student[] students = academy.getStudents();
        if (students.length == 0) {
            out.println("No students");
            return;
        }
        for (Student s : students) {
            out.println(s.getStudentId() + " - " + s.getName() + " (" + s.getCourseCount() + " of 3 courses)");
        }
    }
}
