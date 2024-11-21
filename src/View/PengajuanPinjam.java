/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.PengajuanPinjamController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author HP
 */
public class PengajuanPinjam extends javax.swing.JFrame {
    int xx, xy;
    private PengajuanPinjamController pengajuanPinjamController;
    private DefaultTableModel model;

    /**
     * Creates new form PinjamRuangan
     */
    

    public PengajuanPinjam() {
        initComponents();
        String[] kolom = {"ID Peminjaman", "Tipe Peminjaman", "Tanggal Pinjam"};
        model = new DefaultTableModel(kolom, 0); // Inisialisasi model
        tabel_pengajuan.setModel(model);
        pengajuanPinjamController = new PengajuanPinjamController();

        try {
            pengajuanPinjamController.loadData(model); // Load data ke tabel
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ex.getMessage());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pengajuan = new javax.swing.JTable();
        t_searching = new javax.swing.JTextField();
        b_setuju = new javax.swing.JButton();
        b_hapus = new javax.swing.JButton();
        b_tolak = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        tabel_pengajuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Peminjaman", "Tipe Peminjaman", "Tanggal Pinjam"
            }
        ));
        jScrollPane1.setViewportView(tabel_pengajuan);

        t_searching.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_searching.setText("Cari....");
        t_searching.setBorder(null);
        t_searching.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_searchingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_searchingFocusLost(evt);
            }
        });
        t_searching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_searchingActionPerformed(evt);
            }
        });

        b_setuju.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_setuju.setForeground(new java.awt.Color(0, 51, 255));
        b_setuju.setText("Setujui Peminjaman");
        b_setuju.setAlignmentY(0.0F);
        b_setuju.setBorder(null);
        b_setuju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setujuActionPerformed(evt);
            }
        });

        b_hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_hapus.setForeground(new java.awt.Color(0, 51, 255));
        b_hapus.setText("Hapus List");
        b_hapus.setAlignmentY(0.0F);
        b_hapus.setBorder(null);
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });

        b_tolak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_tolak.setForeground(new java.awt.Color(0, 51, 255));
        b_tolak.setText("Tolak Peminjaman");
        b_tolak.setAlignmentY(0.0F);
        b_tolak.setBorder(null);
        b_tolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_tolakActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 51, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EXIT");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_setuju, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_tolak, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(b_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(t_searching, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_searching, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_setuju, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_tolak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_searchingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_searchingFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchingFocusGained

    private void t_searchingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_searchingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchingFocusLost

    private void t_searchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_searchingActionPerformed
        // TODO add your handling code here:
        String keyword = t_searching.getText().trim(); 
        pengajuanPinjamController.filterTable((DefaultTableModel) tabel_pengajuan.getModel(), keyword);
    }//GEN-LAST:event_t_searchingActionPerformed

    private void b_setujuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setujuActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabel_pengajuan.getSelectedRow();
        if (selectedRow != -1) {
            int idPeminjaman = (int) tabel_pengajuan.getValueAt(selectedRow, 0); // Ambil id_peminjaman
            try {
                pengajuanPinjamController.setujuiPeminjaman(idPeminjaman); // Panggil melalui instance
                JOptionPane.showMessageDialog(this, "Peminjaman Disetujui!");
                pengajuanPinjamController.loadData(model); // Refresh tabel
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menyetujui peminjaman: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih peminjaman yang ingin disetujui!");
        }
    }//GEN-LAST:event_b_setujuActionPerformed

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabel_pengajuan.getSelectedRow(); // Mengambil baris yang dipilih
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tabel_pengajuan.getModel();
            model.removeRow(selectedRow); // Menghapus baris yang dipilih
            JOptionPane.showMessageDialog(this, "Baris berhasil dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void b_tolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_tolakActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabel_pengajuan.getSelectedRow();
        if (selectedRow != -1) {
            int idPeminjaman = (int) tabel_pengajuan.getValueAt(selectedRow, 0); // Ambil id_peminjaman
            try {
                pengajuanPinjamController.tolakPeminjaman(idPeminjaman); // Panggil melalui instance
                JOptionPane.showMessageDialog(this, "Peminjaman Ditolak!");
                pengajuanPinjamController.loadData(model); // Refresh tabel
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menolak peminjaman: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih peminjaman yang ingin ditolak!");
        }
    }//GEN-LAST:event_b_tolakActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PengajuanPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengajuanPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengajuanPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengajuanPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengajuanPinjam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_setuju;
    private javax.swing.JButton b_tolak;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_searching;
    private javax.swing.JTable tabel_pengajuan;
    // End of variables declaration//GEN-END:variables
}
