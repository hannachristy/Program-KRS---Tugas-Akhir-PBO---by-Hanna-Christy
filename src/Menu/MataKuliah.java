
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
public class MataKuliah extends javax.swing.JFrame {
    String ambilkodeMK;
    /**
     * Creates new form dataMobil
     */
    public MataKuliah() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    void kosong(){
        txtKodeMK.setText("");    
        txtMK.setText("");     
        txtSMS.setText("");   
        txtProdi.setText("");   
        txtSKS.setText("");   
        txtWP.setText("");   
        txtPrasyarat.setText("");
        txtKDS.setText("");
        txtDosen.setText("");
        txtHari.setText("");
        txtRuang.setText("");
        txtKodeMK.requestFocus();    
    }

//Aktifkan Komponen Text Box
    void enabledTxt(boolean kondisi){
        txtKodeMK.setEnabled(kondisi);
        txtMK.setEnabled(kondisi);
        txtSMS.setEnabled(kondisi);
        txtProdi.setEnabled(kondisi);
        txtSKS.setEnabled(kondisi);
        txtWP.setEnabled(kondisi);
        txtPrasyarat.setEnabled(kondisi);
        txtKDS.setEnabled(kondisi);
        txtHari.setEnabled(kondisi);
        txtRuang.setEnabled(kondisi);
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
        hasil = koneksiDB.retrieveData("SELECT * FROM mk INNER JOIN dosen ON mk.kodeDosen=dosen.kodeDosen");
        String[] header = {"Kode","Prodi","namaMK","Semester","SKS","KDS","Dosen Pengampu","W/P","Prasyarat","Waktu","Ruang"};
        Object[][] isiData;

        try{
            hasil.beforeFirst();
            int jmlBaris = 0;
            while(hasil.next()){
                jmlBaris = hasil.getRow();
            }
            isiData = new Object[jmlBaris][11];
            hasil.beforeFirst();
            int urutanKolom = 0;
    
        while(hasil.next()){
                    isiData[urutanKolom][0] = hasil.getString("kodeMK");
                    isiData[urutanKolom][1] = hasil.getString("Prodi");
                    isiData[urutanKolom][2] = hasil.getString("nmMK");
                    isiData[urutanKolom][3] = hasil.getString("Semester");
                    isiData[urutanKolom][4] = hasil.getString("SKS");
                    isiData[urutanKolom][5] = hasil.getString("kodeDosen");
                    isiData[urutanKolom][6] = hasil.getString("nmDosen");
                    isiData[urutanKolom][7] = hasil.getString("wop");
                    isiData[urutanKolom][8] = hasil.getString("Prasyarat");
                    isiData[urutanKolom][9] = hasil.getString("waktu");
                    isiData[urutanKolom][10] = hasil.getString("ruang");
                    urutanKolom++;
                }
                tblmk.setModel(new DefaultTableModel(isiData,header));
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
        txtRuang = new javax.swing.JTextField();
        txtHari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        txtMK = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        txtKodeMK = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtDosen = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmk = new javax.swing.JTable();
        bBack = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtSMS = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSKS = new javax.swing.JTextField();
        txtWP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrasyarat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProdi = new javax.swing.JTextField();
        txtKDS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txtRuang.setEnabled(false);
        getContentPane().add(txtRuang);
        txtRuang.setBounds(1710, 690, 160, 30);

        txtHari.setEnabled(false);
        getContentPane().add(txtHari);
        txtHari.setBounds(1610, 620, 260, 30);

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Ruang");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1610, 690, 80, 30);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mata Kuliah");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1600, 250, 270, 33);

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Dosen Pengampu");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1480, 410, 230, 33);

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Waktu");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1610, 590, 80, 20);

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
        btnTambah.setBounds(1480, 780, 180, 50);

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Kode MK");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1480, 250, 150, 33);

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
        btnUbah.setBounds(1480, 840, 180, 50);

        txtMK.setEnabled(false);
        getContentPane().add(txtMK);
        txtMK.setBounds(1600, 290, 270, 30);

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
        btnHapus.setBounds(1690, 780, 180, 50);

        txtKodeMK.setEnabled(false);
        getContentPane().add(txtKodeMK);
        txtKodeMK.setBounds(1480, 290, 110, 30);

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
        btnSimpan.setBounds(1580, 910, 180, 50);

        txtDosen.setEnabled(false);
        getContentPane().add(txtDosen);
        txtDosen.setBounds(1480, 450, 280, 30);

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
        btnBatal.setBounds(1690, 840, 180, 50);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblmk.setAutoCreateRowSorter(true);
        tblmk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblmk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "KDMK", "Mata Kuliah", "Prodi", "Semester", "SKS", "W/P", "Prasyarat", "KDS", "Dosen Pengampu", "Waktu", "Ruang"
            }
        ));
        tblmk.setRowHeight(50);
        tblmk.setSelectionBackground(new java.awt.Color(155, 131, 165));
        tblmk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmk);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 210, 1350, 760);

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
        bBack.setBounds(1670, 70, 80, 70);

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
        tSearch.setBounds(430, 150, 360, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(1480, 740, 390, 30);

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Semester");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1480, 330, 150, 33);

        txtSMS.setEnabled(false);
        getContentPane().add(txtSMS);
        txtSMS.setBounds(1480, 370, 150, 30);

        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("SKS");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1480, 590, 50, 50);

        txtSKS.setEnabled(false);
        getContentPane().add(txtSKS);
        txtSKS.setBounds(1530, 590, 50, 50);

        txtWP.setEnabled(false);
        getContentPane().add(txtWP);
        txtWP.setBounds(1530, 670, 50, 50);

        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("W/P");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1480, 670, 50, 50);

        txtPrasyarat.setEnabled(false);
        getContentPane().add(txtPrasyarat);
        txtPrasyarat.setBounds(1480, 530, 390, 30);

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Prasyarat");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1480, 490, 100, 30);

        jLabel12.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Prodi");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1640, 330, 150, 33);

        txtProdi.setEnabled(false);
        getContentPane().add(txtProdi);
        txtProdi.setBounds(1640, 370, 230, 30);

        txtKDS.setEnabled(false);
        getContentPane().add(txtKDS);
        txtKDS.setBounds(1770, 450, 100, 30);

        jLabel14.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Kode Dosen");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(1770, 410, 100, 33);

        BG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin-mk.jpg"))); // NOI18N
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

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String ambilkodeMK = txtKodeMK.getText();
        String ambilnmMK = txtMK.getText();
        String ambilSMS = txtSMS.getText();
        String ambilProdi = txtProdi.getText();
        String ambilSKS = txtSKS.getText();
        String ambilWP = txtWP.getText();
        String ambilPrasyarat = txtPrasyarat.getText();
        String ambilkodeDosen = txtKDS.getText();
        String ambilnmDosen = txtDosen.getText();
        String ambilwaktu = txtHari.getText();
        String ambilruang = txtRuang.getText();
        
         if(btnSimpan.getText().compareTo("Simpan")==0){
            int jml = 0;
            ResultSet ketemu;
            koneksiDB.konekDB();
            if(!ambilkodeMK.isEmpty()){
                try{
                    ketemu = koneksiDB.retrieveData("SELECT * FROM mk WHERE kodeMK='"+ambilkodeMK+"'");
                    ketemu.beforeFirst();
                    while(ketemu.next()){
                        jml++;
                    }
                    if (jml < 1){
                        int hasil = koneksiDB.manipulation("INSERT INTO mk(kodeMK,nmMK,Prodi,Semester,SKS,wop,Prasyarat,kodeDosen,waktu,ruang) VALUES('"+ambilkodeMK+
                                "','"+ambilnmMK+"','"+ambilProdi+"','"+ambilSMS+"','"+ambilSKS+"','"+ambilWP+"','"+ambilPrasyarat+"','"+ambilkodeDosen+"','"+ambilwaktu+"','"+ambilruang+"')");
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
                        JOptionPane.showMessageDialog(rootPane, "Peminjaman Sudah Terdaftar !");
                    }
              //  }catch(HeadlessException | SQLException ex){
                      }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "ID Pinjam tidak boleh kosong !");
            }
        }else{
            int hasil = koneksiDB.manipulation("UPDATE mk SET kodeMK='"+ambilkodeMK+"',nmMK='"+ambilnmMK
                    + "',Semester='"+ambilSMS+"',Prodi='"+ambilProdi+"',SKS='"+ambilSKS+"',wop='"+ambilWP+"',Prasyarat='"+ambilPrasyarat
                    + "',waktu='"+ambilwaktu+"',ruang='"+ambilruang+"',kodeDosen='"+ambilkodeDosen
                    + "' WHERE kodeMK='"+ambilkodeMK+"'");
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

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        String ambilkodeMK = txtKodeMK.getText();
        int tanya = JOptionPane.showConfirmDialog(rootPane, "Yakin data akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (tanya == JOptionPane.YES_OPTION){
            int hasil = koneksiDB.manipulation("DELETE FROM mk WHERE kodeMK='"+ambilkodeMK+"'");
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

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        enabledBtn(false, true, true, false, false ,false, true);
        enabledTxt(true);
        btnSimpan.setText("Update");
        String ambilkodeMK = txtKodeMK.getText();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void tblmkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmkMouseClicked
        try {
            int row = tblmk.rowAtPoint(evt.getPoint());
            String kodeMK = tblmk.getValueAt(row, 0).toString();
            String Prodi = tblmk.getValueAt(row, 1).toString();
            String nmMK = tblmk.getValueAt(row, 2).toString();
            String Semester = tblmk.getValueAt(row,3).toString();
            String SKS = tblmk.getValueAt(row, 4).toString();
            String kodeDosen = tblmk.getValueAt(row, 5).toString();
            String dosenMK = tblmk.getValueAt(row, 6).toString();
            String wop = tblmk.getValueAt(row, 7).toString();
            String Prasyarat = tblmk.getValueAt(row, 8).toString();
            String waktu = tblmk.getValueAt(row, 9).toString();
            String ruang = tblmk.getValueAt(row, 10).toString();
            txtKodeMK.setText(String.valueOf(kodeMK));
            txtMK.setText(String.valueOf(nmMK));
            txtSMS.setText(String.valueOf(Semester));
            txtSKS.setText(String.valueOf(SKS));
            txtProdi.setText(String.valueOf(Prodi));
            txtWP.setText(String.valueOf(wop));
            txtPrasyarat.setText(String.valueOf(Prasyarat));
            txtKDS.setText(String.valueOf(kodeDosen));
            txtDosen.setText(String.valueOf(dosenMK));
            txtHari.setText(String.valueOf(waktu));
            txtRuang.setText(String.valueOf(ruang));
        } catch (Exception e) {
        }
        //tambah-ubah-hapus-simpan-batal-keluar
        enabledBtn(false, true, true, true , true, true, true);              // TODO add your handling code here:
    }//GEN-LAST:event_tblmkMouseClicked

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
    this.dispose();
    }//GEN-LAST:event_bBackActionPerformed

    private void tSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchActionPerformed

    }//GEN-LAST:event_tSearchActionPerformed

    private void tSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyReleased
     DefaultTableModel table = (DefaultTableModel)tblmk.getModel();
     String search = tSearch.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tblmk.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tSearchKeyReleased

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
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MataKuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton bBack;
    private javax.swing.JButton btnBatal;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tblmk;
    private javax.swing.JTextField txtDosen;
    private javax.swing.JTextField txtHari;
    private javax.swing.JTextField txtKDS;
    private javax.swing.JTextField txtKodeMK;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtPrasyarat;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextField txtRuang;
    private javax.swing.JTextField txtSKS;
    private javax.swing.JTextField txtSMS;
    private javax.swing.JTextField txtWP;
    // End of variables declaration//GEN-END:variables
}
