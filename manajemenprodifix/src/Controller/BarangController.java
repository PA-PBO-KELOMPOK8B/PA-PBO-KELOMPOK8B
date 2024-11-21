/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseConnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class BarangController {

    public void loadData(DefaultTableModel model) {
        model.setRowCount(0);
        String query = "SELECT id_barang, nama, jumlah FROM barang";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String idBarang = rs.getString("id_barang");
                String nama = rs.getString("nama");
                int jumlah = rs.getInt("jumlah");
                model.addRow(new Object[]{idBarang, nama, jumlah});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBarang(String idBarang, String nama, int jumlah) throws SQLException {
        String query = "INSERT INTO barang (id_barang, nama, jumlah) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idBarang);
            stmt.setString(2, nama);
            stmt.setInt(3, jumlah);
            stmt.executeUpdate();
        }
    }

    public void updateBarang(String idBarang, String nama, int jumlah) throws SQLException {
        String query = "UPDATE barang SET nama = ?, jumlah = ? WHERE id_barang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setInt(2, jumlah);
            stmt.setString(3, idBarang);
            stmt.executeUpdate();
        }
    }

    public void deleteBarang(String idBarang) throws SQLException {
        String query = "DELETE FROM barang WHERE id_barang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idBarang);
            stmt.executeUpdate();
        }
    }
    public boolean isIdExist(String idBarang) throws SQLException {
        String query = "SELECT COUNT(*) FROM barang WHERE id_barang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idBarang);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}
