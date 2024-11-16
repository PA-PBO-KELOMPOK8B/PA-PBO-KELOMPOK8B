/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author HP
 */
public class PinjamRuangan extends javax.swing.JFrame {
    int xx, xy;

    /**
     * Creates new form PinjamRuangan
     */
    public PinjamRuangan() {
        initComponents();
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
        tabel_ruang = new javax.swing.JTable();
        t_tanggal = new javax.swing.JTextField();
        t_searching = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t_jam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_koderuang = new javax.swing.JTextField();
        b_ajukan = new javax.swing.JButton();
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

        tabel_ruang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Ruangan", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabel_ruang);

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
        t_searching.setText("Cari Ruangan");
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
        jLabel5.setText("Kode Ruangan");

        t_jam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_jam.setBorder(null);
        t_jam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_jamFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_jamFocusLost(evt);
            }
        });
        t_jam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_jamActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 51, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jam Pemakaian");

        t_koderuang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_koderuang.setBorder(null);
        t_koderuang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_koderuangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_koderuangFocusLost(evt);
            }
        });
        t_koderuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_koderuangActionPerformed(evt);
            }
        });

        b_ajukan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b_ajukan.setForeground(new java.awt.Color(0, 51, 255));
        b_ajukan.setText("Ajukan Peminjaman");
        b_ajukan.setAlignmentY(0.0F);
        b_ajukan.setBorder(null);
        b_ajukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ajukanActionPerformed(evt);
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
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t_tanggal)
                                    .addComponent(t_jam, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(t_koderuang, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(b_ajukan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(90, 90, 90))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(t_searching, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_koderuang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_ajukan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_searching, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
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
    }//GEN-LAST:event_t_searchingActionPerformed

    private void t_jamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_jamFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_jamFocusGained

    private void t_jamFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_jamFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_jamFocusLost

    private void t_jamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_jamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_jamActionPerformed

    private void t_koderuangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_koderuangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_t_koderuangFocusGained

    private void t_koderuangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_koderuangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_koderuangFocusLost

    private void t_koderuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_koderuangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_koderuangActionPerformed

    private void b_ajukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ajukanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_ajukanActionPerformed

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
            java.util.logging.Logger.getLogger(PinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PinjamRuangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_ajukan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_jam;
    private javax.swing.JTextField t_koderuang;
    private javax.swing.JTextField t_searching;
    private javax.swing.JTextField t_tanggal;
    private javax.swing.JTable tabel_ruang;
    // End of variables declaration//GEN-END:variables
}