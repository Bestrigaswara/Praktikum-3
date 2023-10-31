package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Aplikasi Pengelola Kata Sandi sederhana yang memungkinkan pengguna menyimpan dan mengambil kata sandi untuk situs web.
 */
public class PasswordManager {
    /**
     * passwordDatabase adalah Map yang menyimpan nama situs web sebagai kunci dan kata sandi yang sesuai sebagai nilainya.
     */
    private static final Map<String, String> passwordDatabase = new HashMap<>();

    /**
     * Metode utama adalah titik masuk program, di mana pengguna dapat berinteraksi dengan Pengelola Kata Sandi.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selamat datang di Pengelola Kata Sandi!");
            System.out.println("1. Tambah kata sandi");
            System.out.println("2. Lihat kata sandi");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Membersihkan karakter newline

            switch (choice) {
                case 1:
                    addPassword(scanner);
                    break;
                case 2:
                    viewPassword(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih! Sampai jumpa lagi.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    /**
     * Metode ini memungkinkan pengguna untuk menambahkan kata sandi untuk situs web.
     *
     * @param scanner Objek Scanner untuk masukan pengguna.
     */
    private static void addPassword(Scanner scanner) {
        System.out.print("Masukkan nama situs/web: ");
        String website = scanner.nextLine();
        System.out.print("Masukkan kata sandi: ");
        String password = scanner.nextLine();

        passwordDatabase.put(website, password);
        System.out.println("Kata sandi berhasil disimpan.");
    }

    /**
     * Metode ini memungkinkan pengguna untuk melihat kata sandi untuk situs web tertentu.
     *
     * @param scanner Objek Scanner untuk masukan pengguna.
     */
    private static void viewPassword(Scanner scanner) {
        System.out.print("Masukkan nama situs/web: ");
        String website = scanner.nextLine();

        if (passwordDatabase.containsKey(website)) {
            String password = passwordDatabase.get(website);
            System.out.println("Kata sandi untuk " + website + ": " + password);
        } else {
            System.out.println("Situs/web tidak ditemukan.");
        }
    }
}
