/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */

public class Mahasiswa extends User {
    private DatabaseUtil dbUtil;

    public Mahasiswa(String id, String username, String password, DatabaseUtil dbUtil) {
        super(id, username, password);
        this.dbUtil = dbUtil;
    }

    @Override
    public void login() {
        System.out.println("Login berhasil sebagai Mahasiswa!");
    }

    // Metode untuk mengajukan peminjaman ruangan
    public void requestRoomLoan(ResourceManager resourceManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Daftar Ruangan yang Tersedia:");
        resourceManager.showRooms(); // Menampilkan daftar ruangan yang tersedia

        System.out.print("Pilih nama ruangan yang ingin dipinjam: ");
        String roomName = scanner.nextLine();

        System.out.println("Pilih kelas:");
        System.out.println("1. A 2021\n2. B 2021\n3. C 2021\n4. A 2022\n5. B 2022\n6. A 2023\n7. B 2023\n8. A 2024\n9. B 2024\n10. C 2024");
        int kelasChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] kelasOptions = {"A 2021", "B 2021", "C 2021", "A 2022", "B 2022", "A 2023", "B 2023", "A 2024", "B 2024", "C 2024"};
        String kelas = kelasOptions[kelasChoice - 1];

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan No Telepon: ");
        String noTelepon = scanner.nextLine();

        System.out.print("Masukkan Mata Kuliah: ");
        String mataKuliah = scanner.nextLine();

        System.out.print("Masukkan Jam: ");
        String jam = scanner.nextLine();

        // Membuat objek Peminjaman untuk ruangan
        Peminjaman peminjaman = new Peminjaman(roomName, kelas, nama, noTelepon, mataKuliah, jam);
        resourceManager.addPeminjamanRequest(peminjaman);

        System.out.println("Data peminjaman ruangan telah diajukan.");
    }

    // Metode untuk mengajukan peminjaman barang
    public void requestItemLoan(ResourceManager resourceManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama barang yang ingin dipinjam: ");
        String itemName = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan No Telepon: ");
        String noTelepon = scanner.nextLine();

        System.out.print("Masukkan Mata Kuliah: ");
        String mataKuliah = scanner.nextLine();

        System.out.print("Masukkan Jam: ");
        String jam = scanner.nextLine();

        // Membuat objek Peminjaman untuk barang
        Peminjaman peminjaman = new Peminjaman(itemName, "Barang", nama, noTelepon, mataKuliah, jam);
        resourceManager.addPeminjamanRequest(peminjaman);

        System.out.println("Data peminjaman barang telah diajukan.");
    }
}