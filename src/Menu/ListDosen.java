
package Menu;

import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author IDEAPAD FLEX 5i
 */
public class ListDosen extends javax.swing.JFrame {
    String ambilkodeDosen;
    /**
     * Creates new form dataMobil
     */
    public ListDosen() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    void kosong(){
        txtKDS.setText("");         
        txtDosen.setText("");
        txtEmail.setText("");
        txtntDosen.setText("");
        txtFakultas.setText("");
        txtKDS.requestFocus();    
    }

//Aktifkan Komponen Text Box
    void enabledTxt(boolean kondisi){
        txtKDS.setEnabled(kondisi);
        txtDosen.setEnabled(kondisi);
        txtEmail.setEnabled(kondisi);
        txtntDosen.setEnabled(kondisi);
        txtFakultas.setEnabled(kondisi);
    }

    void enabledBtn(boolean aktifTambah, boolean aktifSimpan, boolean aktifBatal,boolean aktifKeluar,boolean aktifHapus,boolean aktifUbah,boolean aktifBack){
        btnTambah.setEnabled(aktifTambah);
        btnSimpan.setEnabled(aktifSimpan);
        btnBatal.setEnabled(aktifBatal);
        btnHapus.setEnabled(aktifHapus);
        btnUbah.setEnabled(aktifUbah);
        bBack.setEnabled(aktifBack);
    }

    public void browseData(){
        koneksiDB.konekDB();
        ResultSet hasil = null;
        hasil = koneksiDB.retrieveData("SELECT * FROM dosen");
        String[] header = {"Fakultas","Kode Dosen","Nama","No Telp","Email"};
        Object[][] isiData;

        try{
            hasil.beforeFirst();
            int jmlBaris = 0;
            while(hasil.next()){
                jmlBaris = hasil.getRow();
            }
            isiData = new Object[jmlBaris][5];
            hasil.beforeFirst();
            int urutanKolom = 0;
    
        while(hasil.next()){
                    isiData[urutanKolom][0] = hasil.getString("fakultas");
                    isiData[urutanKolom][1] = hasil.getString("kodeDosen");
                    isiData[urutanKolom][2] = hasil.getString("nmDosen");
                    isiData[urutanKolom][3] = hasil.getString("ntDosen");
                    isiData[urutanKolom][4] = hasil.getString("emailDosen");
                    urutanKolom++;
                }
                tbldosen.setModel(new DefaultTableModel(isiData,header));
            }catch(Exception ex){
                System.err.println(ex.getMessage());
            }

        }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog3 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog4 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog5 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog6 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog7 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog8 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog9 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog10 = new datechooser.beans.DateChooserDialog();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtKDS = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtDosen = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldosen = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        bBack = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtntDosen = new javax.swing.JTextField();
        txtFakultas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txtEmail.setEnabled(false);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(1020, 450, 230, 30);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nama Dosen");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1020, 250, 230, 33);

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email Dosen");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1020, 420, 230, 20);

        btnTambah.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setBorder(null);
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(1010, 570, 250, 40);

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Kode Dosen");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1030, 170, 220, 33);

        btnUbah.setBackground(new java.awt.Color(255, 255, 255));
        btnUbah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setBorder(null);
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });
        getContentPane().add(btnUbah);
        btnUbah.setBounds(1010, 630, 250, 40);

        btnHapus.setBackground(new java.awt.Color(255, 255, 255));
        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setBorder(null);
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(1010, 690, 250, 40);

        txtKDS.setEnabled(false);
        txtKDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKDSActionPerformed(evt);
            }
        });
        getContentPane().add(txtKDS);
        txtKDS.setBounds(1020, 210, 230, 30);

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(null);
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(1010, 750, 250, 40);

        txtDosen.setEnabled(false);
        txtDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDosenActionPerformed(evt);
            }
        });
        getContentPane().add(txtDosen);
        txtDosen.setBounds(1020, 290, 230, 30);

        btnBatal.setBackground(new java.awt.Color(255, 255, 255));
        btnBatal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.setBorder(null);
        btnBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal);
        btnBatal.setBounds(1010, 810, 250, 40);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbldosen.setAutoCreateRowSorter(true);
        tbldosen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbldosen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fakultas", "Kode Dosen", "Nama Dosen", "No. Telp", "Email"
            }
        ));
        tbldosen.setRowHeight(50);
        tbldosen.setSelectionBackground(new java.awt.Color(155, 131, 165));
        tbldosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldosenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldosen);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 210, 820, 760);

        btnCetak.setBackground(new java.awt.Color(255, 255, 255));
        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.setBorder(null);
        btnCetak.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCetakMouseClicked(evt);
            }
        });
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        getContentPane().add(btnCetak);
        btnCetak.setBounds(1010, 870, 250, 40);

        bBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back.png"))); // NOI18N
        bBack.setToolTipText("");
        bBack.setBorder(null);
        bBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBack.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        bBack.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back-pressed.png"))); // NOI18N
        bBack.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back-pressed.png"))); // NOI18N
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });
        getContentPane().add(bBack);
        bBack.setBounds(1490, 170, 70, 70);

        tSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSearchActionPerformed(evt);
            }
        });
        tSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSearchKeyReleased(evt);
            }
        });
        getContentPane().add(tSearch);
        tSearch.setBounds(500, 150, 420, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(1010, 520, 250, 30);

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("No Telp");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1020, 330, 230, 33);

        txtntDosen.setEnabled(false);
        txtntDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtntDosenActionPerformed(evt);
            }
        });
        getContentPane().add(txtntDosen);
        txtntDosen.setBounds(1020, 370, 230, 30);

        txtFakultas.setEnabled(false);
        txtFakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFakultasActionPerformed(evt);
            }
        });
        getContentPane().add(txtFakultas);
        txtFakultas.setBounds(1020, 130, 230, 30);

        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fakultas");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1020, 90, 230, 33);

        jLabel2.setText("*Search juga dapat digunakan untuk custom print berdasarkan Fakultas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 100, 420, 16);

        BG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin-dosen.jpg"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(-2, -2, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// first load
        this.browseData();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        kosong();
        enabledTxt(true);
        enabledBtn(false,true,true,false,false,false,true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosong();
        enabledTxt(false);
        //tambah-ubah-hapus-simpan-batal-keluar
        enabledBtn(true, false, false, true,false,false,true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDosenActionPerformed
    txtDosen.requestFocus();   
    }//GEN-LAST:event_txtDosenActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String ambilkodeDosen = txtKDS.getText();
        String ambilnmDosen = txtDosen.getText();
        String ambilntDosen = txtntDosen.getText();
        String ambilemailDosen= txtEmail.getText();
        String ambilFakultas= txtFakultas.getText();
        if(btnSimpan.getText().compareTo("Simpan")==0){
            int jml = 0;
            ResultSet ketemu;
            koneksiDB.konekDB();
            if(!ambilkodeDosen.isEmpty()){
                try{
                    ketemu = koneksiDB.retrieveData("SELECT * FROM dosen WHERE kodeDosen='"+ambilkodeDosen+"'");
                    ketemu.beforeFirst();
                    while(ketemu.next()){
                        jml++;
                    }
                    if (jml < 1){
                        int hasil = koneksiDB.manipulation("INSERT INTO dosen(fakultas,kodeDosen,nmDosen,ntDosen,emailDosen)VALUES('"+ambilFakultas+"','"+ambilkodeDosen+
                            "','"+ambilnmDosen+"','"+ambilntDosen+"','"+ambilemailDosen+"')");
                        if (hasil < 1){
                            JOptionPane.showMessageDialog(rootPane, "Penyimpanan gagal");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Penyimpanan Sukses !");
                            browseData();
                            kosong();
                            enabledTxt(false);
                            enabledBtn(true,false,false,true,false,false,true);

                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Kode Dosen Sudah Terdaftar !");
                    }
                    //  }catch(HeadlessException | SQLException ex){
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Kode Dosen tidak boleh kosong !");
            }
        }else{
            int hasil = koneksiDB.manipulation("UPDATE dosen SET fakultas='"+ambilFakultas+"',kodeDosen='"+ambilkodeDosen+"',nmDosen='"+ambilnmDosen+"',ntDosen='"+ambilntDosen
                    +"',emailDosen='"+ambilemailDosen+"' WHERE kodeDosen='"+ambilkodeDosen+"'");
            if (hasil < 1){
                JOptionPane.showMessageDialog(rootPane, "Update gagal !");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Update Sukses !");
                browseData();
                kosong();
                enabledTxt(false);
                enabledBtn(true,false,false,true,false,false,true);

                btnSimpan.setText("Simpan");
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtKDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKDSActionPerformed
        txtDosen.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKDSActionPerformed

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        String ambilkodeDosen = txtKDS.getText();
        int tanya = JOptionPane.showConfirmDialog(rootPane, "Yakin data akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (tanya == JOptionPane.YES_OPTION){
            int hasil = koneksiDB.manipulation("DELETE FROM dosen WHERE kodeMK='"+ambilkodeDosen+"'");
            if (hasil < 1){
                JOptionPane.showMessageDialog(rootPane, "Hapus data gagal !");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Hapus Data Sukses !");
                browseData();
                kosong();
                enabledTxt(false);
                enabledBtn(true,false,false,true,false,false,true);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        koneksiDB.konekDB();
        InputStream reportSource = this.getClass().getResourceAsStream("ListDosen.jrxml");
        Map<String, Object> params = new HashMap<>();
        params.put("tSearch",tSearch.getText());
        try{
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,koneksiDB.conn);
            JasperViewer.viewReport(jasperPrint,false);

            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("List Dosen");
            jv.setVisible(true);

        }catch(JRException ex){
            System.out.println(ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        enabledBtn(false, true, true, false,false ,false,true);
        enabledTxt(true);
        btnSimpan.setText("Update");
        String ambilkodeDosen = txtKDS.getText();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void tbldosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldosenMouseClicked
        try {
            int row = tbldosen.rowAtPoint(evt.getPoint());
            String Fakultas = tbldosen.getValueAt(row, 0).toString();
            String kodeDosen = tbldosen.getValueAt(row, 1).toString();
            String nmDosen = tbldosen.getValueAt(row, 2).toString();
            String ntDosen = tbldosen.getValueAt(row, 3).toString();
            String emailDosen = tbldosen.getValueAt(row, 4).toString();
            txtKDS.setText(String.valueOf(kodeDosen));
            txtEmail.setText(String.valueOf(emailDosen));
            txtntDosen.setText(String.valueOf(ntDosen));
            txtDosen.setText(String.valueOf(nmDosen));;
            txtFakultas.setText(String.valueOf(Fakultas));;
        } catch (Exception e) {
        }
        //tambah-ubah-hapus-simpan-batal-keluar
        enabledBtn(false, true, false, false,true,true,true);              // TODO add your handling code here:
    }//GEN-LAST:event_tbldosenMouseClicked

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
    this.dispose();
    }//GEN-LAST:event_bBackActionPerformed

    private void tSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSearchActionPerformed

    private void tSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyReleased
     DefaultTableModel table = (DefaultTableModel)tbldosen.getModel();
     String search = tSearch.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tbldosen.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tSearchKeyReleased

    private void txtntDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtntDosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtntDosenActionPerformed

    private void txtFakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFakultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFakultasActionPerformed

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
            java.util.logging.Logger.getLogger(ListDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListDosen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton bBack;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog10;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserDialog dateChooserDialog3;
    private datechooser.beans.DateChooserDialog dateChooserDialog4;
    private datechooser.beans.DateChooserDialog dateChooserDialog5;
    private datechooser.beans.DateChooserDialog dateChooserDialog6;
    private datechooser.beans.DateChooserDialog dateChooserDialog7;
    private datechooser.beans.DateChooserDialog dateChooserDialog8;
    private datechooser.beans.DateChooserDialog dateChooserDialog9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tbldosen;
    private javax.swing.JTextField txtDosen;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFakultas;
    private javax.swing.JTextField txtKDS;
    private javax.swing.JTextField txtntDosen;
    // End of variables declaration//GEN-END:variables
}
