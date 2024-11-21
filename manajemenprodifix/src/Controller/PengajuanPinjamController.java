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
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class PengajuanPinjamController {

    public void loadData(DefaultTableModel model) throws SQLException {
        model.setRowCount(0);
        String query = "SELECT id_peminjaman, tipe_peminjaman, tanggal_peminjaman FROM peminjaman WHERE status = 'Pending'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_peminjaman"),
                    rs.getString("tipe_peminjaman"),
                    rs.getDate("tanggal_peminjaman")
                });
            }
        }
    }
    
    public void filterTable(DefaultTableModel model, String keyword) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword)); 
    }
    
    public void setujuiPeminjaman(int idPeminjaman) throws SQLException {
        String query = "UPDATE peminjaman SET status = 'Disetujui' WHERE id_peminjaman = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPeminjaman);
            stmt.executeUpdate();
        }
    }

    public void tolakPeminjaman(int idPeminjaman) throws SQLException {
        String query = "UPDATE peminjaman SET status = 'Ditolak' WHERE id_peminjaman = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPeminjaman);
            stmt.executeUpdate();
        }
    }
}
