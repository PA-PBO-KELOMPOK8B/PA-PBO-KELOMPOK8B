/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */

public class RuangController {

    public void insertRuang(String idRuang, String nama, String status) throws SQLException {
        String gedung = nama.substring(0, 1); 
        String defaultFasilitas = "AC, Whiteboard, TV";

        String queryGetFasilitas = "SELECT fasilitas FROM ruangan WHERE gedung = ? LIMIT 1";
        String fasilitas = defaultFasilitas;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryGetFasilitas)) {
            stmt.setString(1, gedung);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    fasilitas = rs.getString("fasilitas");
                }
            }
        }

        String queryInsert = "INSERT INTO ruangan (id_ruangan, nama_ruangan, gedung, fasilitas, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryInsert)) {
            stmt.setString(1, idRuang);
            stmt.setString(2, nama);
            stmt.setString(3, gedung);
            stmt.setString(4, fasilitas);
            stmt.setString(5, status);
            stmt.executeUpdate();
        }
    }

    public void updateRuang(String idRuang, String nama, String status) throws SQLException {
        String query = "UPDATE ruangan SET nama_ruangan = ?, status = ? WHERE id_ruangan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, status);
            stmt.setString(3, idRuang);
            stmt.executeUpdate();
        }
    }

    public void deleteRuang(String idRuang) throws SQLException {
        String query = "DELETE FROM ruangan WHERE id_ruangan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idRuang);
            stmt.executeUpdate();
        }
    }

    public void loadData(DefaultTableModel model) throws SQLException {
    model.setRowCount(0);
    String query = "SELECT id_ruangan, nama_ruangan, status FROM ruangan";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String idRuangan = rs.getString("id_ruangan");
            String namaRuangan = rs.getString("nama_ruangan");
            String status = rs.getString("status");

            System.out.println("ID: " + idRuangan + ", Nama: " + namaRuangan + ", Status: " + status);

            model.addRow(new Object[]{idRuangan, namaRuangan, status});
            }
        }
    }
}
