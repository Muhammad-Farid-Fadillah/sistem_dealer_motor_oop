/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BAB10.DatabaseConected;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


//masukkan import dibawah sini

/**
 *
 * @author icornermalang
 */
public class Gui_Pembayaran extends javax.swing.JFrame {
    /**
     * Creates new form Gui_Penilaian
     */
    String merk, kode_pelanggan, kode_pembayaran, jumlah, diskon, total_pembayaran;
    public Gui_Pembayaran() {
        initComponents();
        tampil();
        tampil_motor();
        tampil_pembeli();
        //masuukan source code (txtKeaktifan.setEnabled(false);tampil();tampil_mhs();tampil_mk(); txtKeaktifan.setText(Integer.toString(0));)
    }
    Connection conn;
    public void refresh() {
        new Gui_Pembayaran().setVisible(true);
        this.setVisible(false);
    }
    


    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/dealermotor?serverTimezone=UTC",
        "root",
        "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Pembeli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_Pembeli.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_Pembeli.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("merk");
        tabelhead.addColumn("kode_pelanggan");
        tabelhead.addColumn("kode_pembayaran");
        tabelhead.addColumn("jumlah");
        tabelhead.addColumn("total_prmbayaran");
        try {
            koneksi();
            String sql = "SELECT * FROM pembayaran";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
            table_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }


    public void tampil_motor() {
        try {
            koneksi();
            String sql = "SELECT merk FROM motor order by merk asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbMerk.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_pembeli() {
        try {
            koneksi();
            String sql = "SELECT nama FROM biodata_pembeli order by nama asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbNamaPelanggan.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert() {
        String merk = (String) cmbMerk.getSelectedItem();
        String nama = (String) cmbNamaPelanggan.getSelectedItem();
        String kode_pembayaran = txtKodePembayran.getText();
        String jumlah = txtJumlah.getText();
        String total = txtTotal.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO pembayaran(merk, nama, id_pembayaran, jumlah, total_pembayaran)"
                    + "VALUES('" + merk + "','" + nama + "','" + kode_pembayaran + "','" + jumlah + "','" + total + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Nilai!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
        
    }
    public void close() {
    int konfirmasi = JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (konfirmasi == JOptionPane.YES_OPTION) {
        dispose(); // Menutup jendela saat ini
    }
}


public void update() {
    String merk = (String) cmbMerk.getSelectedItem();
    String nama = (String) cmbNamaPelanggan.getSelectedItem();
    String kode_pembayaran = txtKodePembayran.getText();
    String jumlah = txtJumlah.getText();
    String total = txtTotal.getText();

    try {
        koneksi(); // pastikan method koneksi() sudah menginisialisasi conn
        String sql = "UPDATE pembayaran SET merk=?, nama=?, jumlah=?, total_pembayaran=? WHERE id_pembayaran=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, merk);
        ps.setString(2, nama);
        ps.setString(3, jumlah);
        ps.setString(4, total);
        ps.setString(5, kode_pembayaran); // gunakan kode pembayaran sebagai kunci update

        int rowsUpdated = ps.executeUpdate();
        ps.close();
        conn.close();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Berhasil Mengupdate Data Pembayaran!");
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk diupdate.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan saat Update: " + e.getMessage());
    }

    refresh(); // perbarui tampilan tabel/input
}

public void delete() {
    String kodePembayaran = txtKodePembayran.getText().trim();

    if (kodePembayaran.isEmpty()) {
        JOptionPane.showMessageDialog(null, "⚠️ Masukkan Kode Pembayaran terlebih dahulu!");
        return;
    }

    int konfirmasi = JOptionPane.showConfirmDialog(
        null,
        "Apakah Anda yakin ingin menghapus data dengan Kode Pembayaran: " + kodePembayaran + "?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION
    );

    if (konfirmasi == JOptionPane.YES_OPTION) {
        try {
            koneksi(); // pastikan conn terkoneksi
            String sql = "DELETE FROM pembayaran WHERE id_pembayaran = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kodePembayaran);

            int hasil = stmt.executeUpdate();
            stmt.close();

            if (hasil > 0) {
                JOptionPane.showMessageDialog(null, "✅ Data berhasil dihapus.");
                batal(); // reset input field setelah hapus
            } else {
                JOptionPane.showMessageDialog(null, "❌ Data dengan Kode Pembayaran tersebut tidak ditemukan.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Gagal menghapus data:\n" + e.getMessage());
        }

        refresh(); // update tampilan tabel atau data setelah hapus
    }
}



public void cari() {
    try {
        koneksi(); // pastikan conn sudah dikoneksikan di method ini
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM pembayaran WHERE id_pembayaran LIKE '%" + txtCari.getText() + "%'";
        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            cmbMerk.setSelectedItem(rs.getString("merk"));
            cmbNamaPelanggan.setSelectedItem(rs.getString("nama"));
            txtKodePembayran.setText(rs.getString("id_pembayaran"));
            txtJumlah.setText(rs.getString("jumlah"));
            txtTotal.setText(rs.getString("total_pembayaran"));
        } else {
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ditemukan.");
        }

        rs.close();
        statement.close();
        conn.close();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat pencarian: " + ex.getMessage());
    }
}



public void batal() {
    txtKodePembayran.setText("");
    txtJumlah.setText("");
    txtTotal.setText("");
    cmbMerk.setSelectedIndex(0); // reset ke pilihan pertama
    cmbNamaPelanggan.setSelectedIndex(0); // reset ke pilihan pertama
    txtCari.setText(""); // reset pencarian kalau ada
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKodePembayran = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        cmbMerk = new javax.swing.JComboBox<>();
        cmbNamaPelanggan = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnNim = new javax.swing.JButton();
        btnKdMk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Program Penilaian");

        jLabel5.setText("Kode Pembayaran");

        jLabel6.setText("Jumlah");

        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Merk", "Nama Pelanggan", "Kode_Pembayaran", "Jumlah", "Total"
            }
        ));
        table_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_data);

        cmbMerk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Merk" }));
        cmbMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMerkActionPerformed(evt);
            }
        });

        cmbNamaPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Pelanggan" }));

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnUbah.setText("Update");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Delete");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Pembayaran");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnNim.setText("Merk");
        btnNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNimActionPerformed(evt);
            }
        });

        btnKdMk.setText("Nama Pelanggan");
        btnKdMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKdMkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(36, 36, 36)
                                    .addComponent(txtKodePembayran, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNim)
                                    .addComponent(btnKdMk))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMerk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbNamaPelanggan, 0, 272, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(143, 143, 143)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnSimpan)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(32, 36, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUbah)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addGap(18, 18, 18)
                .addComponent(btnBatal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(btnNim))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKdMk))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtKodePembayran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSimpan))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        //masukkan method batal();
        batal();
        
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        //masukkan method insert();
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        //masukkan method update();
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void table_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataMouseClicked
        // TODO add your handling code here:
        int tabel = table_data.getSelectedRow(); //0
        merk = table_data.getValueAt(tabel, 0).toString();
        kode_pelanggan = table_data.getValueAt(tabel, 1).toString();
        kode_pembayaran = table_data.getValueAt(tabel, 2).toString();
        jumlah = table_data.getValueAt(tabel, 3).toString();
        diskon = table_data.getValueAt(tabel, 4).toString();
        total_pembayaran = table_data.getValueAt(tabel, 5).toString();

        //masukkan source code onclick pada tabel
        
    }//GEN-LAST:event_table_dataMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        //masukkan method delete();
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        //masukkan method cari();
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNimActionPerformed
        // TODO add your handling code here:
        new GUI_Motor().setVisible(true);
        
    }//GEN-LAST:event_btnNimActionPerformed

    private void btnKdMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKdMkActionPerformed
        // TODO add your handling code here:
        new GUI_Pembeli().setVisible(true);
    }//GEN-LAST:event_btnKdMkActionPerformed

    private void cmbMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMerkActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbMerkActionPerformed

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
            java.util.logging.Logger.getLogger(Gui_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKdMk;
    private javax.swing.JButton btnNim;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbMerk;
    private javax.swing.JComboBox<String> cmbNamaPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_data;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKodePembayran;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
