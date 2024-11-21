/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ACER
 */
import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public boolean loginMahasiswa(String idMahasiswa, String password) {
        String query = "SELECT * FROM mahasiswa WHERE id_mahasiswa = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idMahasiswa);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // True jika ID Mahasiswa dan Password cocok
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginStaff(String idStaff, String noTelp) {
        String query = "SELECT * FROM staff WHERE id_staff = ? AND no_telp = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idStaff);
            stmt.setString(2, noTelp);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // True jika ID Staff dan No Telp cocok
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}