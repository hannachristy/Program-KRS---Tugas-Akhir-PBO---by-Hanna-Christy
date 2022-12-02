
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
public class ListMhs extends javax.swing.JFrame {
    String ambilNIM;
    /**
     * Creates new form dataMobil
     */
    public ListMhs() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    void kosong(){
        txtNIM.setText("");    
        txtMhs.setText(""); 
        txtJK.setText("");
        txtTTL.setText("");
        txtAlamat.setText("");
        txtntMhs.setText("");
        txtFakultas.setText("");
        txtProdi.setText("");
        txtSMS.setText("");
        txtNIM.requestFocus();    
    }

//Aktifkan Komponen Text Box
    void enabledTxt(boolean kondisi){
        txtNIM.setEnabled(kondisi);
        txtMhs.setEnabled(kondisi);
        txtJK.setEnabled(kondisi);
        txtTTL.setEnabled(kondisi);
        txtAlamat.setEnabled(kondisi);
        txtntMhs.setEnabled(kondisi);
        txtFakultas.setEnabled(kondisi);
        txtProdi.setEnabled(kondisi);
        txtSMS.setEnabled(kondisi);
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
        hasil = koneksiDB.retrieveData("SELECT * FROM mhs");
        String[] header = {"NIM","Nama","Jenis Kelamin","TTL","Alamat","No Telp","Fakultas","Prodi","Semester"};
        Object[][] isiData;

        try{
            hasil.beforeFirst();
            int jmlBaris = 0;
            while(hasil.next()){
                jmlBaris = hasil.getRow();
            }
            isiData = new Object[jmlBaris][9];
            hasil.beforeFirst();
            int urutanKolom = 0;
    
        while(hasil.next()){
                    isiData[urutanKolom][0] = hasil.getString("NIM");
                    isiData[urutanKolom][1] = hasil.getString("nmMhs");
                    isiData[urutanKolom][2] = hasil.getString("jk");
                    isiData[urutanKolom][3] = hasil.getString("ttl");
                    isiData[urutanKolom][4] = hasil.getString("alamat");
                    isiData[urutanKolom][5] = hasil.getString("ntMhs");
                    isiData[urutanKolom][6] = hasil.getString("fakultas");
                    isiData[urutanKolom][7] = hasil.getString("prodi");
                    isiData[urutanKolom][8] = hasil.getString("sms");
                    urutanKolom++;
                }
                tblmhs.setModel(new DefaultTableModel(isiData,header));
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
        txtFakultas = new javax.swing.JTextField();
        txtntMhs = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        txtMhs = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        txtNIM = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtTTL = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmhs = new javax.swing.JTable();
        btnCetakP = new javax.swing.JButton();
        bBack = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtJK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSMS = new javax.swing.JTextField();
        txtProdi = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnCetakF = new javax.swing.JButton();
        tSearchF = new javax.swing.JTextField();
        tSearchP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txtFakultas.setEnabled(false);
        getContentPane().add(txtFakultas);
        txtFakultas.setBounds(1440, 700, 230, 30);

        txtntMhs.setEnabled(false);
        getContentPane().add(txtntMhs);
        txtntMhs.setBounds(1440, 610, 230, 30);

        txtAlamat.setEnabled(false);
        getContentPane().add(txtAlamat);
        txtAlamat.setBounds(1440, 520, 230, 30);

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Fakultas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1440, 660, 230, 30);

        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("No. Telp");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1440, 580, 230, 20);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nama Mahasiswa/i");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1440, 200, 230, 33);

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tempat, Tanggal Lahir");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1440, 390, 230, 33);

        jLabel5.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Alamat");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1440, 490, 230, 20);

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
        btnTambah.setBounds(1740, 290, 150, 40);

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("NIM");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1440, 110, 230, 33);

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
        btnUbah.setBounds(1740, 350, 150, 40);

        txtMhs.setEnabled(false);
        txtMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMhsActionPerformed(evt);
            }
        });
        getContentPane().add(txtMhs);
        txtMhs.setBounds(1440, 240, 230, 30);

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
        btnHapus.setBounds(1740, 410, 150, 40);

        txtNIM.setEnabled(false);
        txtNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIMActionPerformed(evt);
            }
        });
        getContentPane().add(txtNIM);
        txtNIM.setBounds(1440, 150, 230, 30);

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
        btnSimpan.setBounds(1740, 470, 150, 40);

        txtTTL.setEnabled(false);
        txtTTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTTLActionPerformed(evt);
            }
        });
        getContentPane().add(txtTTL);
        txtTTL.setBounds(1440, 430, 230, 30);

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
        btnBatal.setBounds(1740, 530, 150, 40);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblmhs.setAutoCreateRowSorter(true);
        tblmhs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblmhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Jenis Kelamin", "TTL", "Alamat", "No. Telp", "Fakultas", "Prodi", "Semester"
            }
        ));
        tblmhs.setRowHeight(50);
        tblmhs.setSelectionBackground(new java.awt.Color(155, 131, 165));
        tblmhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmhs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 210, 1220, 760);

        btnCetakP.setBackground(new java.awt.Color(255, 255, 255));
        btnCetakP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCetakP.setText("Cetak Prodi");
        btnCetakP.setBorder(null);
        btnCetakP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCetakP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCetakPMouseClicked(evt);
            }
        });
        btnCetakP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakPActionPerformed(evt);
            }
        });
        getContentPane().add(btnCetakP);
        btnCetakP.setBounds(1740, 650, 150, 40);

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
        bBack.setBounds(1780, 90, 80, 60);

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
        tSearch.setBounds(560, 150, 230, 30);

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Jenis Kelamin");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1440, 290, 230, 33);

        txtJK.setEnabled(false);
        txtJK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJKActionPerformed(evt);
            }
        });
        getContentPane().add(txtJK);
        txtJK.setBounds(1440, 330, 230, 30);

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Semester");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1440, 740, 230, 33);

        txtSMS.setEnabled(false);
        txtSMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSMSActionPerformed(evt);
            }
        });
        getContentPane().add(txtSMS);
        txtSMS.setBounds(1440, 780, 230, 30);

        txtProdi.setEnabled(false);
        txtProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdiActionPerformed(evt);
            }
        });
        getContentPane().add(txtProdi);
        txtProdi.setBounds(1440, 870, 230, 30);

        jLabel20.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Prodi");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(1440, 830, 150, 33);

        btnCetakF.setBackground(new java.awt.Color(255, 255, 255));
        btnCetakF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCetakF.setText("Cetak Fakultas");
        btnCetakF.setBorder(null);
        btnCetakF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCetakF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCetakFMouseClicked(evt);
            }
        });
        btnCetakF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakFActionPerformed(evt);
            }
        });
        getContentPane().add(btnCetakF);
        btnCetakF.setBounds(1740, 590, 150, 40);

        tSearchF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSearchFActionPerformed(evt);
            }
        });
        tSearchF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSearchFKeyReleased(evt);
            }
        });
        getContentPane().add(tSearchF);
        tSearchF.setBounds(850, 150, 230, 30);

        tSearchP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSearchPActionPerformed(evt);
            }
        });
        tSearchP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSearchPKeyReleased(evt);
            }
        });
        getContentPane().add(tSearchP);
        tSearchP.setBounds(1090, 150, 230, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 150, 80, 30);

        jLabel9.setText("Custom print : Prodi");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1090, 180, 190, 16);

        jLabel10.setText("Custom print : Fakultas");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(850, 180, 190, 16);

        BG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin-mahasiswa.jpg"))); // NOI18N
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
        String ambilNIM = txtNIM.getText();
        String ambilnmMhs = txtMhs.getText();
        String ambilJK = txtJK.getText();
        String ambilTTL = txtTTL.getText();
        String ambilAlamat = txtAlamat.getText();
        String ambilntMhs = txtntMhs.getText();
        String ambilFakultas = txtFakultas.getText();
        String ambilProdi = txtProdi.getText();
        String ambilSMS = txtSMS.getText();
        
         if(btnSimpan.getText().compareTo("Simpan")==0){
            int jml = 0;
            ResultSet ketemu;
            koneksiDB.konekDB();
            if(!ambilNIM.isEmpty()){
                try{
                    ketemu = koneksiDB.retrieveData("SELECT * FROM mhs WHERE NIM='"+ambilNIM+"'");
                    ketemu.beforeFirst();
                    while(ketemu.next()){
                        jml++;
                    }
                    if (jml < 1){
                        int hasil = koneksiDB.manipulation("INSERT INTO mhs(NIM,nmMhs,jk,ttl,alamat,ntMhs,fakultas,prodi,sms,status)VALUES('"+ambilNIM+
                                "','"+ambilnmMhs+"','"+ambilJK+"','"+ambilTTL+"','"+ambilAlamat+"','"+ambilntMhs+"','"+ambilFakultas+"','"+ambilProdi+"','"+ambilSMS+"')");
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
            int hasil = koneksiDB.manipulation("UPDATE mhs SET NIM='"+ambilNIM+"',nmMhs='"+ambilnmMhs
                    + "',jk='"+ambilJK+"',ttl='"+ambilTTL+"',alamat='"+ambilAlamat+"',ntMhs='"+ambilntMhs+"',fakultas='"+ambilFakultas
                    + "',prodi='"+ambilProdi+"',sms='"+ambilSMS
                    + "' WHERE NIM='"+ambilNIM+"'");
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
        String ambilNIM = txtNIM.getText();
        int tanya = JOptionPane.showConfirmDialog(rootPane, "Yakin data akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (tanya == JOptionPane.YES_OPTION){
            int hasil = koneksiDB.manipulation("DELETE FROM mhs WHERE NIM='"+ambilNIM+"'");
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

    private void btnCetakPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakPMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        enabledBtn(false, true, true, false,false ,false,true);
        enabledTxt(true);
        btnSimpan.setText("Update");
        String ambilNIM = txtNIM.getText();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void tblmhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmhsMouseClicked
        try {
            int row = tblmhs.rowAtPoint(evt.getPoint());
            String NIM = tblmhs.getValueAt(row, 0).toString();
            String nmMhs = tblmhs.getValueAt(row, 1).toString();
            String jk = tblmhs.getValueAt(row, 2).toString();
            String ttl = tblmhs.getValueAt(row, 3).toString();
            String alamat = tblmhs.getValueAt(row, 4).toString();
            String ntMhs = tblmhs.getValueAt(row, 5).toString();
            String fakultas = tblmhs.getValueAt(row, 6).toString();
            String prodi = tblmhs.getValueAt(row, 7).toString();
            String sms = tblmhs.getValueAt(row, 8).toString();
            txtNIM.setText(String.valueOf(NIM));
            txtMhs.setText(String.valueOf(nmMhs));
            txtJK.setText(String.valueOf(jk));
            txtTTL.setText(String.valueOf(ttl));
            txtAlamat.setText(String.valueOf(alamat));
            txtntMhs.setText(String.valueOf(ntMhs));
            txtFakultas.setText(String.valueOf(fakultas));
            txtProdi.setText(String.valueOf(prodi));
            txtSMS.setText(String.valueOf(sms));
        } catch (Exception e) {
        }
        //tambah-ubah-hapus-simpan-batal-keluar
        enabledBtn(false, true, false, false,true,true,true);              // TODO add your handling code here:
    }//GEN-LAST:event_tblmhsMouseClicked

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
    this.dispose();
    }//GEN-LAST:event_bBackActionPerformed

    private void tSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSearchActionPerformed

    private void tSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyReleased
     DefaultTableModel table = (DefaultTableModel)tblmhs.getModel();
     String search = tSearch.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tblmhs.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tSearchKeyReleased

    private void txtJKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJKActionPerformed

    private void txtTTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTTLActionPerformed
        txtTTL.requestFocus();
    }//GEN-LAST:event_txtTTLActionPerformed

    private void txtNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIMActionPerformed
        txtMhs.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIMActionPerformed

    private void txtMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMhsActionPerformed
        txtTTL.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMhsActionPerformed

    private void txtSMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSMSActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtSMSActionPerformed

    private void txtProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdiActionPerformed

    private void btnCetakPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakPActionPerformed
        koneksiDB.konekDB();
        InputStream reportSource = this.getClass().getResourceAsStream("ListMhsProdi.jrxml");
        Map<String, Object> params = new HashMap<>();
        params.put("tSearchP",tSearchP.getText());
        try{
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,koneksiDB.conn);
            JasperViewer.viewReport(jasperPrint,false);

            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Daftar Mahasiswa");
            jv.setVisible(true);

        }catch(JRException ex){
            System.out.println(ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakPActionPerformed

    private void btnCetakFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakFMouseClicked

    private void btnCetakFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakFActionPerformed
     koneksiDB.konekDB();
        InputStream reportSource = this.getClass().getResourceAsStream("ListMhsFakultas.jrxml");
        Map<String, Object> params = new HashMap<>();
        params.put("tSearchF",tSearchF.getText());
        try{
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,koneksiDB.conn);
            JasperViewer.viewReport(jasperPrint,false);

            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Daftar Mahasiswa");
            jv.setVisible(true);

        }catch(JRException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCetakFActionPerformed

    private void tSearchPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSearchPActionPerformed

    private void tSearchPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchPKeyReleased
    DefaultTableModel table = (DefaultTableModel)tblmhs.getModel();
     String search = tSearchP.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tblmhs.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tSearchPKeyReleased

    private void tSearchFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSearchFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSearchFActionPerformed

    private void tSearchFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchFKeyReleased
    DefaultTableModel table = (DefaultTableModel)tblmhs.getModel();
     String search = tSearchF.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tblmhs.setRowSorter(tr);
     tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tSearchFKeyReleased

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
            java.util.logging.Logger.getLogger(ListMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton bBack;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetakF;
    private javax.swing.JButton btnCetakP;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTextField tSearchF;
    private javax.swing.JTextField tSearchP;
    private javax.swing.JTable tblmhs;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtFakultas;
    private javax.swing.JTextField txtJK;
    private javax.swing.JTextField txtMhs;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextField txtSMS;
    private javax.swing.JTextField txtTTL;
    private javax.swing.JTextField txtntMhs;
    // End of variables declaration//GEN-END:variables
}
