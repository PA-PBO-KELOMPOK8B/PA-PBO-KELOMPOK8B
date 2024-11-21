package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    private String idBarang;
    private String nama;
    private int jumlah;
    private String peminjamanIdPeminjaman;

    // Constructor
    public ItemModel(String idBarang, String nama, int jumlah, String peminjamanIdPeminjaman) {
        this.idBarang = idBarang;
        this.nama = nama;
        this.jumlah = jumlah;
        this.peminjamanIdPeminjaman = peminjamanIdPeminjaman;
    }

    // Getter dan Setter
    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getPeminjamanIdPeminjaman() {
        return peminjamanIdPeminjaman;
    }

    public void setPeminjamanIdPeminjaman(String peminjamanIdPeminjaman) {
        this.peminjamanIdPeminjaman = peminjamanIdPeminjaman;
    }

    // Ambil semua data barang
    public static List<ItemModel> ambilSemuaBarang() {
        List<ItemModel> items = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM barang";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.add(new ItemModel(
                    rs.getString("id_barang"),
                    rs.getString("nama"),
                    rs.getInt("jumlah"),
                    rs.getString("peminjaman_id_peminjaman")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Ambil barang berdasarkan ID
    public static ItemModel ambilBarangBerdasarkanId(String idBarang) {
        ItemModel item = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM barang WHERE id_barang = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, idBarang);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                item = new ItemModel(
                    rs.getString("id_barang"),
                    rs.getString("nama"),
                    rs.getInt("jumlah"),
                    rs.getString("peminjaman_id_peminjaman")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    // Tambah barang baru
    public static boolean tambahBarang(ItemModel item) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO barang (id_barang, nama, jumlah, peminjaman_id_peminjaman) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getIdBarang());
            stmt.setString(2, item.getNama());
            stmt.setInt(3, item.getJumlah());
            stmt.setString(4, item.getPeminjamanIdPeminjaman());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Perbarui data barang
    public static boolean perbaruiBarang(ItemModel item) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE barang SET nama = ?, jumlah = ?, peminjaman_id_peminjaman = ? WHERE id_barang = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getNama());
            stmt.setInt(2, item.getJumlah());
            stmt.setString(3, item.getPeminjamanIdPeminjaman());
            stmt.setString(4, item.getIdBarang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Hapus barang berdasarkan ID
    public static boolean hapusBarang(String idBarang) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM barang WHERE id_barang = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, idBarang);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
