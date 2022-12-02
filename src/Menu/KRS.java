
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
import static jdk.nashorn.internal.objects.NativeString.search;
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
public class KRS extends javax.swing.JFrame {
    String ambilkodeMK;
    /**
     * Creates new form dataMobil
     */
    public KRS() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    KRS(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        txtNIM.setEnabled(kondisi);
        txtKodeMK.setEnabled(kondisi);
        txtMK.setEnabled(kondisi);
        txtSMS.setEnabled(kondisi);
        txtProdi.setEnabled(kondisi);
        txtSKS.setEnabled(kondisi);
        txtWP.setEnabled(kondisi);
        txtPrasyarat.setEnabled(kondisi);
        txtKDS.setEnabled(kondisi);
        txtDosen.setEnabled(kondisi);
        txtHari.setEnabled(kondisi);
        txtRuang.setEnabled(kondisi);
    }

    void enabledBtn(boolean aktifTambah, boolean aktifSimpan, boolean aktifBatal,boolean aktifBack){
        btnTambah.setEnabled(aktifTambah);
        btnSimpan.setEnabled(aktifSimpan);
        btnBatal.setEnabled(aktifBatal);
        bBack.setEnabled(aktifBack);
    }

    public void browseData(){
        koneksiDB.konekDB();
        ResultSet hasil = null;
        hasil = koneksiDB.retrieveData("SELECT * FROM mk INNER JOIN dosen ON mk.kodeDosen=dosen.kodeDosen");
        String[] header = {"KDMK","Mata Kuliah","Semester","KDS","Dosen Pengampu","Prodi","SKS","W/P","Prasyarat","Waktu","Ruang"};
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
                    isiData[urutanKolom][1] = hasil.getString("nmMK");
                    isiData[urutanKolom][2] = hasil.getString("Semester");
                    isiData[urutanKolom][3] = hasil.getString("kodeDosen");
                    isiData[urutanKolom][4] = hasil.getString("nmDosen");
                    isiData[urutanKolom][5] = hasil.getString("Prodi");
                    isiData[urutanKolom][6] = hasil.getString("SKS");
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

    public void browseData2(){
        
        ResultSet hasil2 = null;
        hasil2 = koneksiDB.retrieveData("SELECT * FROM jadwal");
        String[] header = {"NIM","Kode MK","Mata Kuliah"};
        Object[][] isiData;

        try{
            hasil2.beforeFirst();
            int jmlBaris = 0;
            while(hasil2.next()){
                jmlBaris = hasil2.getRow();
            }
            isiData = new Object[jmlBaris][3];
            hasil2.beforeFirst();
            int urutanKolom = 0;
    
        while(hasil2.next()){
                    isiData[urutanKolom][0] = hasil2.getString("NIM");
                    isiData[urutanKolom][1] = hasil2.getString("kodeMKtp");
                    isiData[urutanKolom][2] = hasil2.getString("nmMKtp");

                    urutanKolom++;
                }
                tbljadwal.setModel(new DefaultTableModel(isiData,header));
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
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbljadwal = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmk = new javax.swing.JTable();
        bBack = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        txtNIM = new javax.swing.JTextField();
        FProdi = new javax.swing.JComboBox<>();
        FSms = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtRuang = new javax.swing.JTextField();
        txtHari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        txtKodeMK = new javax.swing.JTextField();
        txtDosen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSMS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSKS = new javax.swing.JTextField();
        txtWP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPrasyarat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtProdi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtKDS = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

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
        btnTambah.setBounds(930, 800, 270, 40);

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(null);
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(930, 860, 270, 40);

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
        btnBatal.setBounds(930, 920, 270, 40);

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbljadwal.setAutoCreateRowSorter(true);
        tbljadwal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbljadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIM", "Kode", "Mata Kuliah"
            }
        ));
        tbljadwal.setRowHeight(50);
        tbljadwal.setSelectionBackground(new java.awt.Color(155, 131, 165));
        jScrollPane2.setViewportView(tbljadwal);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(100, 690, 660, 290);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblmk.setAutoCreateRowSorter(true);
        tblmk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblmk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode MK", "Mata Kuliah", "Kode Dosen", "Dosen Pengampu", "Semester", "SKS", "W/P", "Prasyarat", "Waktu", "Ruang"
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
        jScrollPane1.setBounds(100, 180, 1420, 290);

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
        bBack.setBounds(1670, 100, 70, 70);

        tSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSearchKeyReleased(evt);
            }
        });
        getContentPane().add(tSearch);
        tSearch.setBounds(820, 130, 240, 30);
        getContentPane().add(txtNIM);
        txtNIM.setBounds(1300, 600, 330, 30);

        FProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH PRODI--", "Sistem Informasi(S1)", "Teknik Industri(S1)", "Teknik Informatika(S1)", "Arsitektur(S1)", "Manajemen(S1)", "Akuntansi(S1)", " " }));
        FProdi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FProdiItemStateChanged(evt);
            }
        });
        getContentPane().add(FProdi);
        FProdi.setBounds(260, 130, 160, 30);

        FSms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH SEMESTER--", "Show All", "Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8" }));
        FSms.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FSmsItemStateChanged(evt);
            }
        });
        getContentPane().add(FSms);
        FSms.setBounds(440, 130, 160, 30);

        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("NIM");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1240, 600, 50, 30);

        txtRuang.setEnabled(false);
        getContentPane().add(txtRuang);
        txtRuang.setBounds(1660, 700, 170, 30);

        txtHari.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtHari.setEnabled(false);
        getContentPane().add(txtHari);
        txtHari.setBounds(1580, 940, 260, 30);

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Ruang");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1660, 660, 80, 30);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mata Kuliah");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1360, 660, 270, 33);

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Dosen Pengampu");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1240, 820, 230, 33);

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Waktu");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1580, 910, 80, 20);

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Kode MK");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1240, 660, 150, 33);

        txtMK.setEnabled(false);
        getContentPane().add(txtMK);
        txtMK.setBounds(1360, 700, 270, 30);

        txtKodeMK.setEnabled(false);
        getContentPane().add(txtKodeMK);
        txtKodeMK.setBounds(1240, 700, 110, 30);

        txtDosen.setEnabled(false);
        getContentPane().add(txtDosen);
        txtDosen.setBounds(1240, 860, 280, 30);

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Semester");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1240, 740, 150, 33);

        txtSMS.setEnabled(false);
        getContentPane().add(txtSMS);
        txtSMS.setBounds(1240, 780, 150, 30);

        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("SKS");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1660, 740, 70, 40);

        txtSKS.setEnabled(false);
        getContentPane().add(txtSKS);
        txtSKS.setBounds(1660, 780, 70, 30);

        txtWP.setEnabled(false);
        getContentPane().add(txtWP);
        txtWP.setBounds(1760, 780, 70, 30);

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("W/P");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1760, 740, 70, 40);

        txtPrasyarat.setEnabled(false);
        getContentPane().add(txtPrasyarat);
        txtPrasyarat.setBounds(1240, 940, 320, 30);

        jLabel12.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Prasyarat");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1240, 900, 100, 30);

        jLabel13.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Prodi");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1400, 740, 150, 33);

        txtProdi.setEnabled(false);
        getContentPane().add(txtProdi);
        txtProdi.setBounds(1400, 780, 230, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Search :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(750, 130, 70, 30);

        jLabel14.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Kode Dosen");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(1530, 820, 100, 33);

        txtKDS.setEnabled(false);
        getContentPane().add(txtKDS);
        txtKDS.setBounds(1530, 860, 100, 30);

        jButton1.setText("Show All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(620, 130, 100, 30);

        BG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/KRS.jpg"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(-2, -2, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// first load
        this.browseData();
        this.browseData2();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        kosong();
        enabledTxt(true);
        enabledBtn(false, true, true, true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosong();
        enabledTxt(false);
        //tambah-ubah-hapus-simpan-batal-keluar
        enabledBtn(true, false, false, true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String ambilNIM = txtNIM.getText();
        String ambilkodeMK = txtKodeMK.getText();
        String ambilnmMK = txtMK.getText();
        String ambilSMS = txtSMS.getText();
        String ambilProdi = txtProdi.getText();
        String ambilSKS = txtSKS.getText();
        String ambilWP = txtWP.getText();
        String ambilPrasyarat = txtPrasyarat.getText();
        String ambilkodeDosen = txtKDS.getText();
        String ambildosenMK = txtDosen.getText();
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
                    if (jml < 1000){
                        int hasil = koneksiDB.manipulation("INSERT INTO jadwal(NIM,kodeDosen,kodeMKtp,nmMKtp,SKStp,SMStp,waktutp,ruangtp)VALUES('"+ambilNIM+"','"+ambilkodeDosen+"','"+ambilkodeMK+
                            "','"+ambilnmMK+"','"+ambilSKS+"','"+ambilSMS+"','"+ambilwaktu+"','"+ambilruang+"')");
                        if (hasil < 0){
                            JOptionPane.showMessageDialog(rootPane, "Penyimpanan gagal");
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Penyimpanan Sukses !");
                            browseData2();
                            kosong();
                            enabledTxt(false);
                            enabledBtn(true,false,false,true);

                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Kode MK Sudah Terdaftar !");
                    }
                    //  }catch(HeadlessException | SQLException ex){
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }    
            }       
        }
        DB2Refresh();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void DB2Refresh(){
            //Untuk refresh tabel KRS terpilih
            koneksiDB.konekDB();
            DefaultTableModel model = (DefaultTableModel)tbljadwal.getModel();
            model.setRowCount(0);
            browseData2();
    }
    private void tblmkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmkMouseClicked
        try {
            int row = tblmk.rowAtPoint(evt.getPoint());
            String kodeMK = tblmk.getValueAt(row, 0).toString();
            String nmMK = tblmk.getValueAt(row, 1).toString();
            String Semester = tblmk.getValueAt(row, 2).toString();
            String kodeDosen = tblmk.getValueAt(row, 3).toString();
            String nmDosen = tblmk.getValueAt(row, 4).toString();
            String Prodi = tblmk.getValueAt(row, 5).toString();
            String SKS = tblmk.getValueAt(row, 6).toString();
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
            txtDosen.setText(String.valueOf(nmDosen));
            txtHari.setText(String.valueOf(waktu));
            txtRuang.setText(String.valueOf(ruang));
        } catch (Exception e) {
        }
        //tambah-simpan-batal-keluar
        enabledBtn(false, true, true, true);              // TODO add your handling code here:
    }//GEN-LAST:event_tblmkMouseClicked

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
    this.dispose();
    }//GEN-LAST:event_bBackActionPerformed

    private void tSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyReleased
     DefaultTableModel table = (DefaultTableModel)tblmk.getModel();
     String search = tSearch.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tblmk.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tSearchKeyReleased

    private void FSmsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FSmsItemStateChanged
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)tblmk.getModel();
        String query=FSms.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tblmk.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
        
    }//GEN-LAST:event_FSmsItemStateChanged

    private void FProdiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FProdiItemStateChanged
        DefaultTableModel table = (DefaultTableModel)tblmk.getModel();
        String query=FProdi.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tblmk.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }//GEN-LAST:event_FProdiItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    DefaultTableModel table = (DefaultTableModel)tblmk.getModel();
    String search = tSearch.getText().toString();
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
    tblmk.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(KRS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KRS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KRS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KRS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KRS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JComboBox<String> FProdi;
    private javax.swing.JComboBox<String> FSms;
    private javax.swing.JButton bBack;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tbljadwal;
    private javax.swing.JTable tblmk;
    private javax.swing.JTextField txtDosen;
    private javax.swing.JTextField txtHari;
    private javax.swing.JTextField txtKDS;
    private javax.swing.JTextField txtKodeMK;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtPrasyarat;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextField txtRuang;
    private javax.swing.JTextField txtSKS;
    private javax.swing.JTextField txtSMS;
    private javax.swing.JTextField txtWP;
    // End of variables declaration//GEN-END:variables
}
