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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */

public class RiwayatPinjamController {
    
    public void loadRiwayat(DefaultTableModel model) throws SQLException {
        String query = "SELECT id_peminjaman, tipe_peminjaman, tanggal_peminjaman, status FROM peminjaman";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            model.setRowCount(0); // Clear the table before adding data
            while (rs.next()) {
                int idPeminjaman = rs.getInt("id_peminjaman");
                String tipePeminjaman = rs.getString("tipe_peminjaman");
                String tanggalPinjam = rs.getString("tanggal_peminjaman");
                String status = rs.getString("status");
                
                model.addRow(new Object[]{idPeminjaman, tipePeminjaman, tanggalPinjam, status});
            }
        }
    }

    public void batalkanPeminjaman(int idPeminjaman) throws SQLException {
        String query = "UPDATE peminjaman SET status = 'Dibatalkan' WHERE id_peminjaman = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPeminjaman);
            stmt.executeUpdate();
        }
    }
}
