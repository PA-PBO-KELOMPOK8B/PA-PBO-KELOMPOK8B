/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.PinjamBarangController;
import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author HP
 */
public class PinjamBarang extends javax.swing.JFrame {
    DefaultTableModel model;
    int xx, xy;
    private PinjamBarangController controller;

    public PinjamBarang() {
        initComponents();
        controller = new PinjamBarangController();
        
        // Inisialisasi model tabel dengan tipe data kolom yang benar
        String[] kolom = {"Kode Barang", "Nama Barang", "Stok"};
        model = new DefaultTableModel(kolom, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // Kolom stok (integer)
                    return Integer.class;
                }
                return String.class; // Kolom lainnya string
            }
        };
        
        tabel_barang.setModel(model);
        loadData();
        
        // Setup sorting untuk tabel
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        sorter.setComparator(2, (o1, o2) -> {
            if (o1 instanceof Integer && o2 instanceof Integer) {
                return ((Integer) o1).compareTo((Integer) o2);
            }
            return 0; // Default jika bukan Integer
        });
        tabel_barang.setRowSorter(sorter);

    }

    private void loadData() {
        try {
            controller.loadData(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data barang: " + e.getMessage());
        }
    }
    
    private void filterTable(String keyword) {
        DefaultTableModel model = (DefaultTableModel) tabel_barang.getModel(); // Pastikan tabel_barang
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabel_barang.setRowSorter(sorter);

        if (keyword.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword)); // Case-insensitive filtering
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
        tabel_barang = new javax.swing.JTable();
        t_tanggal = new javax.swing.JTextField();
        t_searching = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_kuantitas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_kodebarang = new javax.swing.JTextField();
        t_ajukan = new javax.swing.JButton();
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

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Stok"
            }
        ));
        jScrollPane1.setViewportView(tabel_barang);

        t_tanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_tanggal.setBorder(null);
        t_tanggal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_tanggalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_tanggalFocusLost(evt);
            }
        });
        t_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tanggalActionPerformed(evt);
            }
        });

        t_searching.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_searching.setText("Cari Barang");
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

        jLabel4.setBackground(new java.awt.Color(0, 51, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal Pinjam");

        jLabel5.setBackground(new java.awt.Color(0, 51, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Barang");

        t_kuantitas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_kuantitas.setBorder(null);
        t_kuantitas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_kuantitasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_kuantitasFocusLost(evt);
            }
        });
        t_kuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kuantitasActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 51, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kuantitas");

        t_kodebarang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_kodebarang.setBorder(null);
        t_kodebarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_kodebarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_kodebarangFocusLost(evt);
            }
        });
        t_kodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kodebarangActionPerformed(evt);
            }
        });

        t_ajukan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        t_ajukan.setForeground(new java.awt.Color(0, 51, 255));
        t_ajukan.setText("Ajukan Peminjaman");
        t_ajukan.setAlignmentY(0.0F);
        t_ajukan.setBorder(null);
        t_ajukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ajukanActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_ajukan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(t_searching, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_kodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(t_ajukan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(t_searching, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void t_tanggalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_tanggalFocusGained
        String username = t_tanggal.getText();
        if(username.equals("Username")) {
            t_tanggal.setText("");
        }
    }//GEN-LAST:event_t_tanggalFocusGained

    private void t_tanggalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_tanggalFocusLost
        String username = t_tanggal.getText();
        if(username.equals("")||username.equals("Username")) {
            t_tanggal.setText("Username");
        }
    }//GEN-LAST:event_t_tanggalFocusLost

    private void t_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tanggalActionPerformed

    private void t_searchingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_searchingFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchingFocusGained

    private void t_searchingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_searchingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchingFocusLost

    private void t_searchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_searchingActionPerformed
        // TODO add your handling code here:
        String keyword = t_searching.getText().trim();
        filterTable(keyword);
    }//GEN-LAST:event_t_searchingActionPerformed

    private void t_kuantitasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_kuantitasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kuantitasFocusGained

    private void t_kuantitasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_kuantitasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kuantitasFocusLost

    private void t_kuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kuantitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kuantitasActionPerformed

    private void t_kodebarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_kodebarangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kodebarangFocusGained

    private void t_kodebarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_kodebarangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kodebarangFocusLost

    private void t_kodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kodebarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kodebarangActionPerformed

    private void t_ajukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ajukanActionPerformed
        // TODO add your handling code here:
        String idBarang = t_kodebarang.getText().trim();
        String tanggal = t_tanggal.getText().trim();
        String kuantitasText = t_kuantitas.getText().trim();

        if (idBarang.isEmpty() || tanggal.isEmpty() || kuantitasText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        int kuantitas;
        try {
            kuantitas = Integer.parseInt(kuantitasText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kuantitas harus berupa angka!");
            return;
        }

        try {
            controller.ajukanPeminjaman(idBarang, tanggal, kuantitas);
            JOptionPane.showMessageDialog(this, "Peminjaman berhasil diajukan!");
            loadData(); // Refresh tabel
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengajukan peminjaman: " + e.getMessage());
        }
    }//GEN-LAST:event_t_ajukanActionPerformed

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
            java.util.logging.Logger.getLogger(PinjamBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PinjamBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PinjamBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PinjamBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PinjamBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton t_ajukan;
    private javax.swing.JTextField t_kodebarang;
    private javax.swing.JTextField t_kuantitas;
    private javax.swing.JTextField t_searching;
    private javax.swing.JTextField t_tanggal;
    private javax.swing.JTable tabel_barang;
    // End of variables declaration//GEN-END:variables
}
