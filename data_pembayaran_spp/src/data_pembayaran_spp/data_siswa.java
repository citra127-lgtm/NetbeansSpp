/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_pembayaran_spp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;


public class data_siswa extends javax.swing.JFrame {
    private int idToDelete = -1;
    
    private void deleteData(int idToDelete) {
        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Menyusun query DELETE untuk menghapus data
            String query = "DELETE FROM spp WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idToDelete);

            // Menjalankan query DELETE
            int result = ps.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                // Refresh tabel setelah penghapusan
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data");
            }

            // Menutup PreparedStatement dan koneksi
            ps.close();
            con.close();
        } catch (Exception e) {
            // Menampilkan pesan kesalahan jika terjadi exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
        }
    }

    private void refreshTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id");
        tbl.addColumn("NISN");
        tbl.addColumn("NAMA_SISWA");
        tbl.addColumn("KELAS_JURUSAN");

        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Mengeksekusi kueri SQL untuk memilih semua data dari tabel "spp"
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM spp");

            // Mengisi DefaultTableModel dengan data dari ResultSet
            while (res.next()) {
                tbl.addRow(new Object[] {
                    res.getString("id"),
                    res.getString("NISN"),
                    res.getString("NAMA_SISWA"),
                    res.getString("KELAS_JURUSAN")
                });
            }

            // Setelah loop, menetapkan DefaultTableModel sebagai model untuk jTable1
            jTable1.setModel(tbl);

            // Menutup koneksi
            st.close();
            con.close();
        } catch (Exception e) {
            // Menampilkan pesan kesalahan jika koneksi ke database gagal
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
        }
        this.dispose();
    

    
    }

   
    public data_siswa() {
       
        initComponents();
        table();
        
        ecc.addMouseListener(new MouseAdapter() {
        @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            int idToEdit = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            edit editFrame = new edit();
            editFrame.setIdToEdit(idToEdit);
            editFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diedit.");
        }
    }
});
        
        
        hap.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            int idToDelete = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            deleteData(idToDelete);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Ganti warna atau ubah properti lainnya saat mouse masuk ke label
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Ganti warna atau ubah properti lainnya saat mouse keluar dari label
    }
});
    }
    
    
    
    
    
   public void table() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id");
        tbl.addColumn("NISN");
        tbl.addColumn("NAMA_SISWA");
        tbl.addColumn("KELAS_JURUSAN");
        
        String cari = tul.getText();

        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Mengeksekusi kueri SQL untuk memilih semua data dari tabel "siswa"
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM spp where NAMA_SISWA LIKE '%"+cari+"%'" + "OR NISN LIKE '%"+cari+"%'" + "OR KELAS_JURUSAN LIKE'%"+cari+"%'");

            // Mengisi DefaultTableModel dengan data dari ResultSet
            while (res.next()) {
                tbl.addRow(new Object[] {
                    res.getString("id"),
                    res.getString("NISN"),
                    res.getString("NAMA_SISWA"),
                    res.getString("KELAS_JURUSAN")
                });
            }

            // Setelah loop, menetapkan DefaultTableModel sebagai model untuk jTable1
            jTable1.setModel(tbl);

            // Menampilkan pesan konfirmasi jika koneksi ke database berhasil
            JOptionPane.showMessageDialog(null, "Koneksi database berhasil");

            // Menutup koneksi
            //st.close();
            //con.close();
        } catch (Exception e) {
            // Menampilkan pesan kesalahan jika koneksi ke database gagal
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

        bg = new javax.swing.JPanel();
        side = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        log = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mrgn2 = new custom.mrgn();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mrgn3 = new custom.mrgn();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        tul = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mrgn1 = new custom.mrgn();
        tamb = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mrgn4 = new custom.mrgn();
        ecc = new javax.swing.JLabel();
        mrgn5 = new custom.mrgn();
        hap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(204, 204, 255));

        side.setBackground(new java.awt.Color(0, 51, 102));

        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/logosy2.png"))); // NOI18N

        log.setBackground(new java.awt.Color(0, 51, 102));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/out.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LOG OUT");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logLayout = new javax.swing.GroupLayout(log);
        log.setLayout(logLayout);
        logLayout.setHorizontalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logLayout.setVerticalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logLayout.createSequentialGroup()
                .addGroup(logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        mrgn2.setBackground(new java.awt.Color(0, 51, 153));
        mrgn2.setRoundBottomLeft(30);
        mrgn2.setRoundBottomRight(30);
        mrgn2.setRoundTopLeft(30);
        mrgn2.setRoundTopRight(30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/invo.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Invoice");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mrgn2Layout = new javax.swing.GroupLayout(mrgn2);
        mrgn2.setLayout(mrgn2Layout);
        mrgn2Layout.setHorizontalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mrgn2Layout.setVerticalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mrgn3.setBackground(new java.awt.Color(0, 51, 153));
        mrgn3.setRoundBottomLeft(30);
        mrgn3.setRoundBottomRight(30);
        mrgn3.setRoundTopLeft(30);
        mrgn3.setRoundTopRight(30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dashboard");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/topi2.png"))); // NOI18N

        javax.swing.GroupLayout mrgn3Layout = new javax.swing.GroupLayout(mrgn3);
        mrgn3.setLayout(mrgn3Layout);
        mrgn3Layout.setHorizontalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        mrgn3Layout.setVerticalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout sideLayout = new javax.swing.GroupLayout(side);
        side.setLayout(sideLayout);
        sideLayout.setHorizontalGroup(
            sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
            .addGroup(sideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mrgn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mrgn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(log, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideLayout.setVerticalGroup(
            sideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(mrgn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(mrgn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Primary ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dashboard");

        cari.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        cari.setText("Search");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        tul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                .addComponent(tul, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cari)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tul, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data siswa");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Payment amout");

        mrgn1.setBackground(new java.awt.Color(0, 51, 102));
        mrgn1.setRoundBottomLeft(30);
        mrgn1.setRoundBottomRight(30);
        mrgn1.setRoundTopLeft(30);
        mrgn1.setRoundTopRight(30);
        mrgn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mrgn1MouseClicked(evt);
            }
        });

        tamb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tamb.setForeground(new java.awt.Color(255, 255, 255));
        tamb.setText("+");
        tamb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambMouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/was.png"))); // NOI18N

        javax.swing.GroupLayout mrgn1Layout = new javax.swing.GroupLayout(mrgn1);
        mrgn1.setLayout(mrgn1Layout);
        mrgn1Layout.setHorizontalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamb, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        mrgn1Layout.setVerticalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tamb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "NISN", "NAMA_SISWA", "KELAS_JURUSAN"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        mrgn4.setBackground(new java.awt.Color(0, 51, 102));
        mrgn4.setRoundBottomLeft(30);
        mrgn4.setRoundBottomRight(30);
        mrgn4.setRoundTopLeft(30);
        mrgn4.setRoundTopRight(30);

        ecc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/ecc.png"))); // NOI18N
        ecc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mrgn4Layout = new javax.swing.GroupLayout(mrgn4);
        mrgn4.setLayout(mrgn4Layout);
        mrgn4Layout.setHorizontalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(ecc)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        mrgn4Layout.setVerticalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ecc, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        mrgn5.setBackground(new java.awt.Color(0, 51, 102));
        mrgn5.setRoundBottomLeft(30);
        mrgn5.setRoundBottomRight(30);
        mrgn5.setRoundTopLeft(30);
        mrgn5.setRoundTopRight(30);

        hap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/yel.png"))); // NOI18N

        javax.swing.GroupLayout mrgn5Layout = new javax.swing.GroupLayout(mrgn5);
        mrgn5.setLayout(mrgn5Layout);
        mrgn5Layout.setHorizontalGroup(
            mrgn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(hap)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        mrgn5Layout.setVerticalGroup(
            mrgn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(mrgn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(mrgn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(mrgn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mrgn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mrgn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mrgn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(side, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addComponent(side, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        table();
    }//GEN-LAST:event_cariActionPerformed

    private void tulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tulActionPerformed

    private void mrgn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mrgn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mrgn1MouseClicked

    private void tambMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambMouseClicked
       this.setVisible(false);
        input input = new input();
        input.setVisible(true);
       
    }//GEN-LAST:event_tambMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setVisible(false);
        bayar bayar= new bayar();
        bayar.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       this.setVisible(false);
        login login = new login();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void eccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eccMouseClicked
        //this.setVisible(false);
        //edit edit = new edit();
        //edit.setVisible(true);
    }//GEN-LAST:event_eccMouseClicked

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
            java.util.logging.Logger.getLogger(data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton cari;
    private javax.swing.JLabel ecc;
    private javax.swing.JLabel hap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel log;
    private javax.swing.JLabel logo;
    private custom.mrgn mrgn1;
    private custom.mrgn mrgn2;
    private custom.mrgn mrgn3;
    private custom.mrgn mrgn4;
    private custom.mrgn mrgn5;
    private javax.swing.JPanel side;
    private javax.swing.JLabel tamb;
    private javax.swing.JTextField tul;
    // End of variables declaration//GEN-END:variables
}
