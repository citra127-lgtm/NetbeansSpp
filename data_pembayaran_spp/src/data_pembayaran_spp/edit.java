/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_pembayaran_spp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Scaramouce
 */
public class edit extends javax.swing.JFrame {
    private int idToEdit = -1;

    /**
     * Creates new form edit
     */
    public edit() {
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
            String query = "SELECT NISN, NAMA_SISWA, KELAS_JURUSAN FROM spp WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idToEdit);

            // Menjalankan query SELECT
            ResultSet rs = ps.executeQuery();

            // Mengisi formulir dengan data yang akan diedit
            if (rs.next()) {
                txtid.setText(String.valueOf(idToEdit));
                v_nisn.setText(rs.getString("NISN"));
                v_siswa.setText(rs.getString("NAMA_SISWA"));
                v_kelas.setText(rs.getString("KELAS_JURUSAN"));
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
        v_nisn = new javax.swing.JTextField();
        v_siswa = new javax.swing.JTextField();
        v_kelas = new javax.swing.JTextField();
        v_edit = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        mrgn1.setBackground(new java.awt.Color(0, 51, 102));
        mrgn1.setRoundBottomLeft(30);
        mrgn1.setRoundBottomRight(30);
        mrgn1.setRoundTopLeft(30);
        mrgn1.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EDIT DATA SISWA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/was.png"))); // NOI18N

        mrgn2.setBackground(new java.awt.Color(0, 51, 153));
        mrgn2.setForeground(new java.awt.Color(255, 255, 255));
        mrgn2.setRoundBottomLeft(30);
        mrgn2.setRoundBottomRight(30);
        mrgn2.setRoundTopLeft(30);
        mrgn2.setRoundTopRight(30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NISN");

        javax.swing.GroupLayout mrgn2Layout = new javax.swing.GroupLayout(mrgn2);
        mrgn2.setLayout(mrgn2Layout);
        mrgn2Layout.setHorizontalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        mrgn2Layout.setVerticalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        mrgn3.setBackground(new java.awt.Color(0, 51, 153));
        mrgn3.setRoundBottomLeft(30);
        mrgn3.setRoundBottomRight(30);
        mrgn3.setRoundTopLeft(30);
        mrgn3.setRoundTopRight(30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NAMA_SISWA");

        javax.swing.GroupLayout mrgn3Layout = new javax.swing.GroupLayout(mrgn3);
        mrgn3.setLayout(mrgn3Layout);
        mrgn3Layout.setHorizontalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        mrgn3Layout.setVerticalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        mrgn4.setBackground(new java.awt.Color(0, 51, 153));
        mrgn4.setForeground(new java.awt.Color(255, 255, 255));
        mrgn4.setRoundBottomLeft(30);
        mrgn4.setRoundBottomRight(30);
        mrgn4.setRoundTopLeft(30);
        mrgn4.setRoundTopRight(30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KELAS_JURUSAN");

        javax.swing.GroupLayout mrgn4Layout = new javax.swing.GroupLayout(mrgn4);
        mrgn4.setLayout(mrgn4Layout);
        mrgn4Layout.setHorizontalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(24, 24, 24))
        );
        mrgn4Layout.setVerticalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        v_edit.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        v_edit.setText("SAVE");
        v_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_editActionPerformed(evt);
            }
        });

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mrgn1Layout = new javax.swing.GroupLayout(mrgn1);
        mrgn1.setLayout(mrgn1Layout);
        mrgn1Layout.setHorizontalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                                .addComponent(mrgn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                                .addComponent(mrgn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(v_nisn, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(v_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(v_edit)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mrgn1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(mrgn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(v_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        mrgn1Layout.setVerticalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mrgn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(v_nisn))
                .addGap(18, 18, 18)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(v_siswa)
                    .addComponent(mrgn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mrgn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(v_kelas))
                .addGap(18, 18, 18)
                .addComponent(v_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(mrgn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(mrgn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
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

    private void v_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_editActionPerformed
        String NISN = v_nisn.getText();
        String NAMA_SISWA = v_siswa.getText();
        String KELAS_JURUSAN = v_kelas.getText();

        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Menyusun query UPDATE untuk mengedit data
            String query = "UPDATE spp SET NISN = ?, NAMA_SISWA = ?, KELAS_JURUSAN = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, NISN);
            ps.setString(2, NAMA_SISWA);
            ps.setString(3, KELAS_JURUSAN);
            ps.setInt(4, idToEdit);

            // Menjalankan query UPDATE
            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diedit");
                
                data_siswa siswaFrame = new data_siswa();
                siswaFrame.table();  // Memanggil method untuk me-refresh tabel
                siswaFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengedit data");
            }

            // Menutup PreparedStatement dan koneksi
            //ps.close();
            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
        }
    
    }//GEN-LAST:event_v_editActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

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
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private custom.mrgn mrgn1;
    private custom.mrgn mrgn2;
    private custom.mrgn mrgn3;
    private custom.mrgn mrgn4;
    private javax.swing.JTextField txtid;
    private javax.swing.JButton v_edit;
    private javax.swing.JTextField v_kelas;
    private javax.swing.JTextField v_nisn;
    private javax.swing.JTextField v_siswa;
    // End of variables declaration//GEN-END:variables
}
