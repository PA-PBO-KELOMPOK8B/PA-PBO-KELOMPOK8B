/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DatabaseConnection;
import Database.RuangModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author ACER
 */

public class PinjamRuanganController {

    public List<RuangModel> loadAvailableRooms() throws SQLException {
        List<RuangModel> rooms = new ArrayList<>();
        String query = "SELECT nama_ruangan, status FROM ruangan WHERE status = 'Tersedia'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                rooms.add(new RuangModel(rs.getString("nama_ruangan"), rs.getString("status")));
            }
        }
        return rooms;
    }

    public void populateTable(DefaultTableModel model) throws SQLException {
        List<RuangModel> rooms = loadAvailableRooms();
        model.setRowCount(0); // Bersihkan tabel

        for (RuangModel room : rooms) {
            model.addRow(new Object[]{room.getKodeRuangan(), room.getStatus()});
        }
    }

    public void ajukanPeminjaman(String namaRuangan, String tanggalPinjam, String jamPemakaian, String mahasiswaId) throws SQLException {
    String query = "INSERT INTO peminjaman (nama_ruangan, tanggal_peminjaman, jam_pemakaian, mahasiswa_id_mahasiswa, status, tipe_peminjaman) VALUES (?, ?, ?, ?, 'Pending', 'Ruangan')";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, namaRuangan);
        stmt.setString(2, tanggalPinjam);
        stmt.setString(3, jamPemakaian);
        stmt.setString(4, mahasiswaId);
        stmt.executeUpdate();
    }
}

    
    

    public void filterTable(DefaultTableModel model, String keyword) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        model.fireTableDataChanged();
    }
}