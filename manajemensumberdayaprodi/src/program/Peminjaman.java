/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

/**
 *
 * @author ACER
 */
public class Peminjaman {
    private String roomName;
    private String kelas;
    private String nama;
    private String noTelepon;
    private String mataKuliah;
    private String jam;

    public Peminjaman(String roomName, String kelas, String nama, String noTelepon, String mataKuliah, String jam) {
        this.roomName = roomName;
        this.kelas = kelas;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.mataKuliah = mataKuliah;
        this.jam = jam;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getKelas() {
        return kelas;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getJam() {
        return jam;
    }

    @Override
    public String toString() {
        return "Peminjaman{" +
                "Ruangan='" + roomName + '\'' +
                ", Kelas='" + kelas + '\'' +
                ", Nama='" + nama + '\'' +
                ", NoTelepon='" + noTelepon + '\'' +
                ", MataKuliah='" + mataKuliah + '\'' +
                ", Jam='" + jam + '\'' +
                '}';
    }
}
