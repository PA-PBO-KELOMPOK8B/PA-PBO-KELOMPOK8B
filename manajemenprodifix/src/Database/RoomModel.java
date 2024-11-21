/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import Database.ItemModel;

/**
 *
 * @author ACER
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomModel {
    private String idRuangan;
    private String nama;
    private String gedung;
    private String fasilitas;

    // Constructor
    public RoomModel(String idRuangan, String nama, String gedung, String fasilitas) {
        this.idRuangan = idRuangan;
        this.nama = nama;
        this.gedung = gedung;
        this.fasilitas = fasilitas;
    }

    // Getter dan Setter
    public String getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(String idRuangan) {
        this.idRuangan = idRuangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGedung() {
        return gedung;
    }

    public void setGedung(String gedung) {
        this.gedung = gedung;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    // CRUD
    public static List<RoomModel> ambilSemuaRuangan() {
        List<RoomModel> rooms = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM ruangan";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                rooms.add(new RoomModel(
                    rs.getString("id_ruangan"),
                    rs.getString("nama"),
                    rs.getString("gedung"),
                    rs.getString("fasilitas")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static RoomModel ambilRuanganBerdasarkanId(String id) {
        RoomModel room = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM ruangan WHERE id_ruangan = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                room = new RoomModel(
                    rs.getString("id_ruangan"),
                    rs.getString("nama"),
                    rs.getString("gedung"),
                    rs.getString("fasilitas")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public static boolean tambahRuangan(RoomModel room) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO ruangan (id_ruangan, nama, gedung, fasilitas) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, room.getIdRuangan());
            stmt.setString(2, room.getNama());
            stmt.setString(3, room.getGedung());
            stmt.setString(4, room.getFasilitas());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean perbaruiRuangan(RoomModel room) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE ruangan SET nama = ?, gedung = ?, fasilitas = ? WHERE id_ruangan = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, room.getNama());
            stmt.setString(2, room.getGedung());
            stmt.setString(3, room.getFasilitas());
            stmt.setString(4, room.getIdRuangan());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hapusRuangan(String id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM ruangan WHERE id_ruangan = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
