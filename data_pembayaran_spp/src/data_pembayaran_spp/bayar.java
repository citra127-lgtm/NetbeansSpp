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
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Scaramouce
 */
class ColorRenderer extends DefaultTableCellRenderer {
        private static final Color TABLE_COLOR = new Color(204, 204, 255);
        private static final Color COLUMN_COLOR = new Color(0, 102, 153);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Mengatur warna latar belakang tabel
        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
        } else {
            c.setBackground(TABLE_COLOR);
        }

        // Mengatur warna latar belakang kolom
        if (column == 0) {  // Mengatur warna kolom ke-0
            c.setBackground(COLUMN_COLOR);
        }

        return c;
    }
}





public class bayar extends javax.swing.JFrame {
    private int idToDelete = -1;
    
    
    
    private void deleteData(int idToDelete) {
        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Menyusun query DELETE untuk menghapus data
            String query = "DELETE FROM bayar WHERE id = ?";
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
        tbl.addColumn("ID_STAF_ATAU_JURUSAN");
        tbl.addColumn("TANGGAL_PEMBAYARAN");
        tbl.addColumn("NOMINAL");

        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Mengeksekusi kueri SQL untuk memilih semua data dari tabel "spp"
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM bayar");

            // Mengisi DefaultTableModel dengan data dari ResultSet
            while (res.next()) {
                tbl.addRow(new Object[] {
                    res.getString("id"),
                    res.getString("NISN"),
                    res.getString("ID_STAF_ATAU_GURU"),
                    res.getString("TANGGAL_PEMBAYARAN"),
                    res.getString("NOMINAL")
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
    
    }
    
    /**
     * Creates new form bayar
     */
    public bayar() {
        initComponents();
        table();
        setResizable(false);
        
         ColorRenderer colorRenderer = new ColorRenderer();

          // Mengatur renderer untuk seluruh kolom
          for (int i = 0; i < jTable1.getColumnCount(); i++) {
         jTable1.getColumnModel().getColumn(i).setCellRenderer(colorRenderer);
         }
        
        
        
        
        
        
        edd.addMouseListener(new MouseAdapter() {
        @Override
    public void mouseClicked(MouseEvent e) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            int idToEdit = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            edit2 edit2Frame = new edit2();
            edit2Frame.setIdToEdit(idToEdit);
            edit2Frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diedit.");
        }
    }
});
        has.addMouseListener(new MouseAdapter() {
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
        tbl.addColumn("ID_STAF_ATAU_GURU");
        tbl.addColumn("TANGGAL_PEMBAYARAN");
        tbl.addColumn("NOMINAL");
        
        String search = mask.getText();

        try {
            // Membuat koneksi ke database menggunakan metode getConnection dari kelas koneksi
            Connection con = koneksi.getConnection();

            // Mengeksekusi kueri SQL untuk memilih semua data dari tabel "siswa"
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM bayar where TANGGAL_PEMBAYARAN LIKE '%"+search+"%'" 
                    + "OR NISN LIKE'%"+search+"%'" + "OR NOMINAL LIKE'%"+search+"%'" + "OR ID_STAF_ATAU_GURU LIKE '%"+search+"%'");

            // Mengisi DefaultTableModel dengan data dari ResultSet
            while (res.next()) {
                tbl.addRow(new Object[] {
                    res.getString("id"),
                    res.getString("NISN"),
                    res.getString("ID_STAF_ATAU_GURU"),
                    res.getString("TANGGAL_PEMBAYARAN"),
                    res.getString("NOMINAL")
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mrgn1 = new custom.mrgn();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mrgn2 = new custom.mrgn();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mask = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mrgn3 = new custom.mrgn();
        bahy = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mrgn4 = new custom.mrgn();
        edd = new javax.swing.JLabel();
        mrgn5 = new custom.mrgn();
        has = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/logosy2.png"))); // NOI18N

        mrgn1.setBackground(new java.awt.Color(0, 51, 153));
        mrgn1.setRoundBottomLeft(30);
        mrgn1.setRoundBottomRight(30);
        mrgn1.setRoundTopLeft(30);
        mrgn1.setRoundTopRight(30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/topi2.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dashboard");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mrgn1Layout = new javax.swing.GroupLayout(mrgn1);
        mrgn1.setLayout(mrgn1Layout);
        mrgn1Layout.setHorizontalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mrgn1Layout.setVerticalGroup(
            mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mrgn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mrgn2.setBackground(new java.awt.Color(0, 51, 153));
        mrgn2.setRoundBottomLeft(30);
        mrgn2.setRoundBottomRight(30);
        mrgn2.setRoundTopLeft(30);
        mrgn2.setRoundTopRight(30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/invo.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Invoice");

        javax.swing.GroupLayout mrgn2Layout = new javax.swing.GroupLayout(mrgn2);
        mrgn2.setLayout(mrgn2Layout);
        mrgn2Layout.setHorizontalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mrgn2Layout.setVerticalGroup(
            mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mrgn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/out.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LOG OUT");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mrgn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mrgn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addComponent(mrgn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(mrgn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Primary");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dashboard");

        search.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 506, Short.MAX_VALUE)
                .addComponent(mask, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mask, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "NISN", "ID_STAF_ATAU_GURU", "TANGGAL_PEMBAYARAN", "NOMINAL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        mrgn3.setBackground(new java.awt.Color(0, 51, 102));
        mrgn3.setRoundBottomLeft(30);
        mrgn3.setRoundBottomRight(30);
        mrgn3.setRoundTopLeft(30);
        mrgn3.setRoundTopRight(30);

        bahy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/hain.png"))); // NOI18N
        bahy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bahyMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("+");

        javax.swing.GroupLayout mrgn3Layout = new javax.swing.GroupLayout(mrgn3);
        mrgn3.setLayout(mrgn3Layout);
        mrgn3Layout.setHorizontalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bahy, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mrgn3Layout.setVerticalGroup(
            mrgn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bahy)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mrgn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap())
        );

        mrgn4.setBackground(new java.awt.Color(0, 51, 102));
        mrgn4.setRoundBottomLeft(30);
        mrgn4.setRoundBottomRight(30);
        mrgn4.setRoundTopLeft(30);
        mrgn4.setRoundTopRight(30);

        edd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/ecc.png"))); // NOI18N

        javax.swing.GroupLayout mrgn4Layout = new javax.swing.GroupLayout(mrgn4);
        mrgn4.setLayout(mrgn4Layout);
        mrgn4Layout.setHorizontalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(edd)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        mrgn4Layout.setVerticalGroup(
            mrgn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(edd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mrgn5.setBackground(new java.awt.Color(0, 51, 102));
        mrgn5.setRoundBottomLeft(30);
        mrgn5.setRoundBottomRight(30);
        mrgn5.setRoundTopLeft(30);
        mrgn5.setRoundTopRight(30);

        has.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data_pembayaran_spp/yel.png"))); // NOI18N

        javax.swing.GroupLayout mrgn5Layout = new javax.swing.GroupLayout(mrgn5);
        mrgn5.setLayout(mrgn5Layout);
        mrgn5Layout.setHorizontalGroup(
            mrgn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(has)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        mrgn5Layout.setVerticalGroup(
            mrgn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mrgn5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(has, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data Pembayaran Siswa");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Payment amout");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(mrgn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(mrgn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(mrgn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel14))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mrgn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mrgn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mrgn5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bahyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bahyMouseClicked
        this.setVisible(false);
        input2 input2 = new input2();
        input2.setVisible(true);
    }//GEN-LAST:event_bahyMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        data_siswa siswaFrame = new data_siswa();
        siswaFrame.table();  // Memanggil method untuk me-refresh tabel
        siswaFrame.setVisible(true);
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       this.setVisible(false);
       login login = new login();
       login.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
       table();
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bayar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bahy;
    private javax.swing.JLabel edd;
    private javax.swing.JLabel has;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mask;
    private custom.mrgn mrgn1;
    private custom.mrgn mrgn2;
    private custom.mrgn mrgn3;
    private custom.mrgn mrgn4;
    private custom.mrgn mrgn5;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
