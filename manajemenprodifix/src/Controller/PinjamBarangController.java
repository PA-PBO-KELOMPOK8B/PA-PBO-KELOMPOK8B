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

public class PinjamBarangController {

    public void loadData(DefaultTableModel model) throws SQLException {
        model.setRowCount(0);
        String query = "SELECT id_barang, nama, jumlah FROM barang";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String idBarang = rs.getString("id_barang");
                String nama = rs.getString("nama");
                int stok = rs.getInt("jumlah");
                model.addRow(new Object[]{idBarang, nama, stok});
            }
        }
    }

    public void ajukanPeminjaman(String idBarang, String tanggal, int kuantitas) throws SQLException {
        String query = "INSERT INTO peminjaman (id_barang, tanggal_peminjaman, kuantitas, tipe_peminjaman) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idBarang);
            stmt.setString(2, tanggal);
            stmt.setInt(3, kuantitas);
            stmt.setString(4, "Barang");
            stmt.executeUpdate();
        }
    }

}
