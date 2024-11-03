/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Akademik extends User {
    private List<Request> requests;
    private DatabaseUtil dbUtil;

    public Akademik(String id, String username, String password, List<Request> requests, DatabaseUtil dbUtil) {
        super(id, username, password);
        this.requests = requests;
        this.dbUtil = dbUtil;
    }

    @Override
    public void login() {
        System.out.println("Login sebagai Akademik berhasil!");
    }

    public void approveLoanRequests() {
        for (Request request : requests) {
            if (request.getStatus().equals("pending")) {
                request.approve();
                System.out.println("Permintaan peminjaman dari " + request.getRequesterName() + " disetujui.");
                // Tambahkan pembaruan status ke database jika diperlukan
            }
        }
    }
}
