package id.ac.polinema.uts.kursus;

import java.util.Scanner;
/**
 * Titik awal program (satu-satunya method main di proyek ini).
 *
 * Bagian 1: baris PERTAMA output harus persis "Welcome to Polinema Academy".
 * Setelah itu kamu bebas menambah baris lain untuk bereksperimen.
 *
 * Bagian 7: di bawah baris sapaan, kamu akan membuat Academy, mengisi data
 * contoh, lalu menjalankan AcademyApp. Kerangkanya ada di README.
 */
public class Main {

    public static void main(String[] args) {
        // TODO: Tampilkan sebuah teks ke layar.
        // Di Java, perintahnya berbentuk: System.out.println("teks kamu");
        // Ganti teks di dalam tanda kutip dengan teks dari soal. Huruf besar-kecil dan
        System.out.println("Welcome to Polinema Academy");
        Academy academy = new Academy("Poltek Academy");
        Instructor dewi = new Instructor("Dewi Lestari", "Software Engineering");
        OnlineCourse java = new OnlineCourse("OOP-101", "Java Basics", 2023, dewi);
        OfflineCourse db = new OfflineCourse("Database", 2021, "R-204");
        Workshop git = new Workshop("Git Bootcamp", 2024, 30);
        Student rina = new Student("S101", "Rina");

        academy.addCourse(java);
        academy.addCourse(db);
        academy.addCourse(git);
        academy.addStudent(rina);

        AcademyApp app = new AcademyApp(academy, new Scanner(System.in), System.out);
        app.run();
        // Bagian 7: lanjutkan di sini (buat Academy, isi data contoh, jalankan AcademyApp).

    }
}
