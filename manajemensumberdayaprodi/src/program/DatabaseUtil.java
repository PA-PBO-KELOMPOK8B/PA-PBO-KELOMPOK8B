/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/manajemen_sumberdaya_prodi";
    private static final String USERNAME = "root"; // Sesuaikan dengan username database
    private static final String PASSWORD = "";     // Sesuaikan dengan password database

    private Connection connection;

    public DatabaseUtil() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi ke database berhasil.");
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Menutup koneksi
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tambahkan metode getItems() untuk mendapatkan daftar barang dari tabel barang
    public List<Resource> getItems() {
        List<Resource> items = new ArrayList<>();
        String sql = "SELECT name, quantity FROM barang";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                items.add(new Resource(name, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return items;
    }
}
