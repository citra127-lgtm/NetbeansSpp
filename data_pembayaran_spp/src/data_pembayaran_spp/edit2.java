/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_pembayaran_spp;

   import java.sql.Connection;
   import java.sql.PreparedStatement;
   import javax.swing.JOptionPane;
   import java.sql.ResultSet;
   

/**
 *
 * @author Scaramouce
 */
public class edit2 extends javax.swing.JFrame {
    private int idToEdit = -1;
    /**
     * Creates new form edit2
     */
    public edit2() {
        initComponents();
        setResizable(false);
        
    }
    public void setIdToEdit(int idToEdit) {
        this.idToEdit = idToEdit;
        fillForm();
    }
    private void fillForm() {
        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Menyusun query SELECT untuk mendapatkan data yang akan diedit
            String query = "SELECT NISN, ID_STAF_ATAU_GURU, TANGGAL_PEMBAYARAN,NOMINAL FROM bayar WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idToEdit);

            // Menjalankan query SELECT
            ResultSet rs = ps.executeQuery();

            // Mengisi formulir dengan data yang akan diedit
            if (rs.next()) {
                vid.setText(String.valueOf(idToEdit));
                txtnisn.setText(rs.getString("NISN"));
                txtstaf.setText(rs.getString("ID_STAF_ATAU_GURU"));
                tbyar.setText(rs.getString("TANGGAL_PEMBAYARAN"));
                txtnom.setText(rs.getString("NOMINAL"));
            }

            // Menutup PreparedStatement dan koneksi
            //ps.close();
            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
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
        mrgn1 = new custom.mrgn();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mrgn2 = new custom.mrgn();
        jLabel3 = new javax.swing.JLabel();
        mrgn3 = new custom.mrgn();
        jLabel4 = new javax.swing.JLabel();
        mrgn4 = new custom.mrgn();
        jLabel5 = new javax.swing.JLabel();
        mrgn5 = new custom.mrgn();
        jLabel6 = new javax.swing.JLabel();
        txtnisn = new javax.swing.JTextField();
        txtstaf = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        bsv = new javax.swing.JButton();
        tbyar = new javax.swing.JTextField();
        vid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        mrgn1.setBackground(new java.awt.Color(0, 51, 102));
        mrgn1.setRoundBottomLeft(30);
        mrgn1.setRoundBottomRight(30);
        mrgn1.setRoundTopLeft(30);
        mrgn1.setRoundTopRight(30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/hain.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EDIT DATA PEMBAYARAN");

        mrgn2.setBackground(new java.awt.Color(0, 51, 153));
        mrgn2.setRoundBottomLeft(30);
        mrgn2.setRoundBottomRight(30);
        mrgn2.setRoundTopLeft(30);
        mrgn2.setRoundTopRight(30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NISN");

        javax.swing.GroupLayout mrgn2Layout = new javax.swing.GroupLayout(mrgn2);
        mrgn2.setLayout(mrgn2Layout);
        mrgn2Layout.setHorizontalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        mrgn2Layout.setVerticalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        mrgn3.setBackground(new java.awt.Color(0, 51, 153));
        mrgn3.setRoundBottomLeft(30);
        mrgn3.setRoundBottomRight(30);
        mrgn3.setRoundTopLeft(30);
        mrgn3.setRoundTopRight(30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID_STAF_ATAU_GURU");

        javax.swing.GroupLayout mrgn3Layout = new javax.swing.GroupLayout(mrgn3);
        mrgn3.setLayout(mrgn3Layout);
        mrgn3Layout.setHorizontalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        mrgn3Layout.setVerticalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        mrgn4.setBackground(new java.awt.Color(0, 51, 153));
        mrgn4.setRoundBottomLeft(30);
        mrgn4.setRoundBottomRight(30);
        mrgn4.setRoundTopLeft(30);
        mrgn4.setRoundTopRight(30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TANGGAL_PEMBAYARAN");

        javax.swing.GroupLayout mrgn4Layout = new javax.swing.GroupLayout(mrgn4);
        mrgn4.setLayout(mrgn4Layout);
        mrgn4Layout.setHorizontalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        mrgn4Layout.setVerticalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        mrgn5.setBackground(new java.awt.Color(0, 51, 153));
        mrgn5.setRoundBottomLeft(30);
        mrgn5.setRoundBottomRight(30);
        mrgn5.setRoundTopLeft(30);
        mrgn5.setRoundTopRight(30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMINAL");

        javax.swing.GroupLayout mrgn5Layout = new javax.swing.GroupLayout(mrgn5);
        mrgn5.setLayout(mrgn5Layout);
        mrgn5Layout.setHorizontalGroup(
            mrgn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        mrgn5Layout.setVerticalGroup(
            mrgn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        bsv.setText("SAVE");
        bsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsvMouseClicked(evt);
            }
        });
        bsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mrgn1Layout = new javax.swing.GroupLayout(mrgn1);
        mrgn1.setLayout(mrgn1Layout);
        mrgn1Layout.setHorizontalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(vid, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(mrgn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mrgn1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(mrgn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                                        .addComponent(mrgn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                                        .addComponent(mrgn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)))))
                        .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstaf, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnisn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbyar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        mrgn1Layout.setVerticalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(10, 10, 10)
                .addComponent(vid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addComponent(txtnisn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtstaf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addComponent(mrgn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mrgn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbyar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mrgn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mrgn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bsv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(mrgn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(mrgn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsvMouseClicked
        
    
                                           

    }//GEN-LAST:event_bsvMouseClicked

    private void bsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsvActionPerformed
        String NISN = txtnisn.getText();
        String ID_STAF_ATAU_GURU = txtstaf.getText();
        String TANGGAL_PEMBAYARAN = tbyar.getText();
        String NOMINAL = txtnom.getText();

        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Menyusun query UPDATE untuk mengedit data
            String query = "UPDATE bayar SET NISN = ?, ID_STAF_ATAU_GURU = ?, TANGGAL_PEMBAYARAN = ?, NOMINAL = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, NISN);
            ps.setString(2, ID_STAF_ATAU_GURU);
            ps.setString(3, TANGGAL_PEMBAYARAN);
            ps.setString(4, NOMINAL);
            ps.setInt(5, idToEdit);

            // Menjalankan query UPDATE
            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diedit");
                
                bayar bayarFrame = new bayar();
                bayarFrame.table();  // Memanggil method untuk me-refresh tabel
                bayarFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengedit data");
            }

            // Menutup PreparedStatement dan koneksi
            //ps.close();
            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
        }
    
    }//GEN-LAST:event_bsvActionPerformed

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
            java.util.logging.Logger.getLogger(edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private custom.mrgn mrgn1;
    private custom.mrgn mrgn2;
    private custom.mrgn mrgn3;
    private custom.mrgn mrgn4;
    private custom.mrgn mrgn5;
    private javax.swing.JTextField tbyar;
    private javax.swing.JTextField txtnisn;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtstaf;
    private javax.swing.JTextField vid;
    // End of variables declaration//GEN-END:variables
}