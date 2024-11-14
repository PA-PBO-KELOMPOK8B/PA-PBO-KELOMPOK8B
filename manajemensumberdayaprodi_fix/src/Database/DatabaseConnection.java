package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/manajemen_prodi"; 
            String user = "root"; // Sesuaikan dengan user database Anda
            String password = ""; // Sesuaikan dengan password database Anda
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Koneksi ke database gagal: " + e.getMessage());
        }
    }
}

