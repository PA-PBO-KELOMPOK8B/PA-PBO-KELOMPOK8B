/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program;
import java.util.Map;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author ACER
 */ 
public class Manajemensumberdayaprodi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseUtil dbUtil = new DatabaseUtil();
        ResourceManager resourceManager = new ResourceManager(dbUtil);
        List<Request> requests = new ArrayList<>();

        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        System.out.print("Login sebagai (1: Akademik, 2: Mahasiswa): ");
        int role = scanner.nextInt();

        String roleName = (role == 1) ? "akademik" : "mahasiswa";

        if (validateUserRole(username, password, roleName, dbUtil)) {
            if (role == 1) {
                Akademik akademik = new Akademik("1", username, password, requests, dbUtil);
                showAkademikMenu(akademik, resourceManager);
            } else if (role == 2) {
                Mahasiswa mahasiswa = new Mahasiswa("2", username, password, dbUtil);
                showMahasiswaMenu(mahasiswa, resourceManager);
            }
        } else {
            System.out.println("Data anda tidak sesuai role, silahkan lapor ke akademik.");
        }

        dbUtil.closeConnection();
        scanner.close();
    }

    public static void showAkademikMenu(Akademik akademik, ResourceManager resourceManager) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\nMenu Akademik:");
        System.out.println("1. Tambah Ruangan");
        System.out.println("2. Tambah Barang");
        System.out.println("3. Lihat Semua Ruangan (Ascending)");
        System.out.println("4. Lihat Semua Barang");
        System.out.println("5. Update Status Ruangan");
        System.out.println("6. Update Status Barang");
        System.out.println("7. Hapus Ruangan");
        System.out.println("8. Hapus Barang");
        System.out.println("9. Lihat Pengajuan Peminjaman");
        System.out.println("10. Keluar");

        System.out.print("Pilih opsi: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Masukkan nama ruangan: ");
                String roomName = scanner.nextLine();
                System.out.print("Masukkan gedung ruangan: ");
                String roomBuilding = scanner.nextLine();
                System.out.print("Status (true untuk tersedia, false untuk tidak tersedia): ");
                boolean roomStatus = scanner.nextBoolean();
                resourceManager.addRoom(roomName, roomBuilding, roomStatus);
                break;

            case 2:
                System.out.print("Masukkan nama barang: ");
                String itemName = scanner.nextLine();
                System.out.print("Jumlah barang: ");
                int quantity = scanner.nextInt();
                System.out.print("Status (true untuk tersedia, false untuk tidak tersedia): ");
                boolean itemStatus = scanner.nextBoolean();
                resourceManager.addItem(itemName, quantity, itemStatus);
                break;

            case 3:
                System.out.println("Menampilkan semua ruangan (Ascending):");
                resourceManager.showRooms();
                break;

            case 4:
                System.out.println("Menampilkan semua barang:");
                resourceManager.showItems();
                break;

            case 5:
                System.out.print("Masukkan nama ruangan untuk update status: ");
                String roomToUpdate = scanner.nextLine();
                System.out.print("Status baru (true untuk tersedia, false untuk tidak tersedia): ");
                boolean newRoomStatus = scanner.nextBoolean();
                resourceManager.updateRoomStatus(roomToUpdate, newRoomStatus);
                break;

            case 6:
                System.out.print("Masukkan nama barang untuk update status: ");
                String itemToUpdate = scanner.nextLine();
                System.out.print("Status baru (true untuk tersedia, false untuk tidak tersedia): ");
                boolean newItemStatus = scanner.nextBoolean();
                resourceManager.updateItemStatus(itemToUpdate, newItemStatus);
                break;

            case 7:
                System.out.print("Masukkan nama ruangan untuk dihapus: ");
                String roomToDelete = scanner.nextLine();
                resourceManager.deleteRoom(roomToDelete);
                break;

            case 8:
                System.out.print("Masukkan nama barang untuk dihapus: ");
                String itemToDelete = scanner.nextLine();
                resourceManager.deleteItem(itemToDelete);
                break;

            case 9:
                System.out.println("Daftar Pengajuan Peminjaman:");
                resourceManager.showPeminjamanRequests();
                break;

            case 10:
                System.out.println("Keluar dari menu Akademik.");
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    } while (choice != 10);
}


    public static void showMahasiswaMenu(Mahasiswa mahasiswa, ResourceManager resourceManager) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\nMenu Mahasiswa:");
        System.out.println("1. Ajukan Peminjaman Ruangan");
        System.out.println("2. Ajukan Peminjaman Barang");
        System.out.println("3. Keluar");

        System.out.print("Pilih opsi: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                mahasiswa.requestRoomLoan(resourceManager);
                break;

            case 2:
                mahasiswa.requestItemLoan(resourceManager);
                break;

            case 3:
                System.out.println("Keluar dari menu Mahasiswa.");
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    } while (choice != 3);
}



    private static boolean validateUserRole(String username, String password, String expectedRole, DatabaseUtil dbUtil) {
        String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String actualRole = resultSet.getString("role");
                return actualRole.equals(expectedRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
