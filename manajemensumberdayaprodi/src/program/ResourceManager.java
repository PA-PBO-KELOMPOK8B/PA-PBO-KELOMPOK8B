/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class ResourceManager {
    private DatabaseUtil dbUtil;
    private List<Peminjaman> peminjamanRequests = new ArrayList<>();

    public ResourceManager(DatabaseUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public void addPeminjamanRequest(Peminjaman peminjaman) {
        peminjamanRequests.add(peminjaman);
        System.out.println("Pengajuan peminjaman disimpan untuk ditinjau oleh Akademik.");
    }

    public void showPeminjamanRequests() {
        System.out.println("Daftar Pengajuan Peminjaman:");
        for (Peminjaman peminjaman : peminjamanRequests) {
            System.out.println(peminjaman);
        }
    }

    // CREATE: Menambah ruangan
    public void addRoom(String name, String gedung, boolean status) {
        String sql = "INSERT INTO ruangan (name, gedung, status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, gedung);
            statement.setBoolean(3, status);
            statement.executeUpdate();
            System.out.println("Ruangan berhasil ditambahkan: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CREATE: Menambah barang
    public void addItem(String name, int quantity, boolean status) {
        String sql = "INSERT INTO barang (name, quantity, status) VALUES (?, ?, ?)";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setBoolean(3, status);
            statement.executeUpdate();
            System.out.println("Barang berhasil ditambahkan: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Mengembalikan daftar nama ruangan yang tersedia
    public List<String> getAvailableRooms() {
        List<String> availableRooms = new ArrayList<>();
        String sql = "SELECT name FROM ruangan WHERE status = TRUE";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                availableRooms.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableRooms;
    }

    // READ: Menampilkan semua ruangan dengan pengelompokan gedung
    public void showRooms() {
        Map<String, List<String>> roomsByBuilding = new HashMap<>();
        String sql = "SELECT name, gedung, status FROM ruangan ORDER BY gedung ASC, name ASC";

        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String building = resultSet.getString("gedung");
                boolean status = resultSet.getBoolean("status");
                String statusString = status ? "Ada" : "Sedang dipakai";

                // Jika gedung belum ada di map, tambahkan gedung baru
                roomsByBuilding.putIfAbsent(building, new ArrayList<>());
                
                // Tambahkan ruangan dengan statusnya ke daftar gedung
                roomsByBuilding.get(building).add(name + " (" + statusString + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Menampilkan hasil
        for (String building : roomsByBuilding.keySet()) {
            System.out.println("\nGedung " + building + ":");
            for (String room : roomsByBuilding.get(building)) {
                System.out.println(room);
            }
        }
    }

    // Method untuk mendapatkan ruangan yang diurutkan berdasarkan gedung
    public Map<String, List<String>> getSortedRoomsByBuilding() {
        Map<String, List<String>> roomsByBuilding = new HashMap<>();
        String sql = "SELECT name, gedung, status FROM ruangan ORDER BY gedung ASC, name ASC";

        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String building = resultSet.getString("gedung");
                boolean status = resultSet.getBoolean("status");
                String statusString = status ? "Ada" : "Sedang dipakai";

                // Jika gedung belum ada di map, tambahkan gedung baru
                roomsByBuilding.putIfAbsent(building, new ArrayList<>());
                
                // Tambahkan ruangan dengan statusnya ke daftar gedung
                roomsByBuilding.get(building).add(name + " (" + statusString + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomsByBuilding;
    }

    // READ: Menampilkan semua barang
    public void showItems() {
        String sql = "SELECT name, quantity, status FROM barang ORDER BY name ASC";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Daftar Barang:");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                boolean status = resultSet.getBoolean("status");
                String statusString = status ? "Tersedia" : "Tidak tersedia";

                System.out.println(name + " - Jumlah: " + quantity + " - Status: " + statusString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Memperbarui status ruangan
    public void updateRoomStatus(String name, boolean status) {
        String sql = "UPDATE ruangan SET status = ? WHERE name = ?";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setBoolean(1, status);
            statement.setString(2, name);
            statement.executeUpdate();
            System.out.println("Status ruangan " + name + " berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Memperbarui status barang
    public void updateItemStatus(String name, boolean status) {
        String sql = "UPDATE barang SET status = ? WHERE name = ?";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setBoolean(1, status);
            statement.setString(2, name);
            statement.executeUpdate();
            System.out.println("Status barang " + name + " berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Menghapus ruangan
    public void deleteRoom(String name) {
        String sql = "DELETE FROM ruangan WHERE name = ?";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Ruangan " + name + " berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Menghapus barang
    public void deleteItem(String name) {
        String sql = "DELETE FROM barang WHERE name = ?";
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Barang " + name + " berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
