
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
public class ListMhs_DS extends javax.swing.JFrame {
    String ambilNIM;
    /**
     * Creates new form dataMobil
     */
    public ListMhs_DS() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    
    void kosong(){
        txtNIM.setText("");    
        txtMhs.setText(""); 
        txtMK.setText("");
        txtAlamat.setText("");
        txtntMhs.setText("");
        txtProdi.setText("");
        txtSMS.setText("");
        txtNIM.requestFocus();    
    }

//Aktifkan Komponen Text Box
    void enabledTxt(boolean kondisi){
        txtNIM.setEnabled(kondisi);
        txtMhs.setEnabled(kondisi);
        txtMK.setEnabled(kondisi);
        txtAlamat.setEnabled(kondisi);
        txtntMhs.setEnabled(kondisi);
        txtProdi.setEnabled(kondisi);
        txtSMS.setEnabled(kondisi);
    }

    void enabledBtn(boolean aktifTambah, boolean aktifSimpan, boolean aktifBatal,boolean aktifKeluar,boolean aktifHapus,boolean aktifUbah,boolean aktifBack){
        bBack.setEnabled(aktifBack);
    }

    public void browseData(){
        koneksiDB.konekDB();
        ResultSet hasil = null;
        hasil = koneksiDB.retrieveData("SELECT * FROM mhs INNER JOIN jadwal ON mhs.NIM=jadwal.NIM");
        String[] header = {"NIM","Nama Mahasiswa/i","Alamat","No. Telp","Prodi","Mata Kuliah","Semester"};
        Object[][] isiData;

        try{
            hasil.beforeFirst();
            int jmlBaris = 0;
            while(hasil.next()){
                jmlBaris = hasil.getRow();
            }
            isiData = new Object[jmlBaris][7];
            hasil.beforeFirst();
            int urutanKolom = 0;
    
        while(hasil.next()){
                    isiData[urutanKolom][0] = hasil.getString("NIM");
                    isiData[urutanKolom][1] = hasil.getString("nmMhs");
                    isiData[urutanKolom][2] = hasil.getString("alamat");
                    isiData[urutanKolom][3] = hasil.getString("ntMhs");
                    isiData[urutanKolom][4] = hasil.getString("prodi");
                    isiData[urutanKolom][5] = hasil.getString("nmMKtp");
                    isiData[urutanKolom][6] = hasil.getString("SMStp");
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
        txtntMhs = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMhs = new javax.swing.JTextField();
        txtNIM = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmhs = new javax.swing.JTable();
        bBack = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSMS = new javax.swing.JTextField();
        txtProdi = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        txtntMhs.setEnabled(false);
        getContentPane().add(txtntMhs);
        txtntMhs.setBounds(1440, 430, 230, 30);

        txtAlamat.setEnabled(false);
        getContentPane().add(txtAlamat);
        txtAlamat.setBounds(1440, 330, 230, 30);

        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Mata Kuliah");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1440, 590, 230, 20);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nama Mahasiswa/i");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1440, 200, 230, 33);

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("No. Telp");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1440, 390, 230, 33);

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("NIM");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1440, 110, 230, 33);

        txtMhs.setEnabled(false);
        getContentPane().add(txtMhs);
        txtMhs.setBounds(1440, 240, 230, 30);

        txtNIM.setEnabled(false);
        getContentPane().add(txtNIM);
        txtNIM.setBounds(1440, 150, 230, 30);

        txtMK.setEnabled(false);
        getContentPane().add(txtMK);
        txtMK.setBounds(1440, 630, 230, 30);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblmhs.setAutoCreateRowSorter(true);
        tblmhs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblmhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama Mahasiswa/i", "Alamat", "No. Telp", "Prodi", "Mata Kuliah", "Semester"
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

        tSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSearchKeyReleased(evt);
            }
        });
        getContentPane().add(tSearch);
        tSearch.setBounds(980, 150, 340, 30);

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Alamat");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1440, 290, 230, 33);

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Semester");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1440, 690, 230, 33);

        txtSMS.setEnabled(false);
        getContentPane().add(txtSMS);
        txtSMS.setBounds(1440, 740, 230, 30);

        txtProdi.setEnabled(false);
        getContentPane().add(txtProdi);
        txtProdi.setBounds(1440, 530, 230, 30);

        jLabel20.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Prodi");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(1440, 490, 150, 33);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mata Kuliah :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(850, 150, 130, 30);

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

    private void tblmhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmhsMouseClicked
        try {
            int row = tblmhs.rowAtPoint(evt.getPoint());
            String NIM = tblmhs.getValueAt(row, 0).toString();
            String nmMhs = tblmhs.getValueAt(row, 1).toString();
            String alamat = tblmhs.getValueAt(row, 2).toString();
            String ntMhs = tblmhs.getValueAt(row, 3).toString();
            String prodi = tblmhs.getValueAt(row, 4).toString();
            String MK = tblmhs.getValueAt(row, 5).toString();
            String sms = tblmhs.getValueAt(row, 6).toString();
            txtNIM.setText(String.valueOf(NIM));
            txtMhs.setText(String.valueOf(nmMhs));
            txtMK.setText(String.valueOf(MK));
            txtAlamat.setText(String.valueOf(alamat));
            txtntMhs.setText(String.valueOf(ntMhs));
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

    private void tSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSearchKeyReleased
     DefaultTableModel table = (DefaultTableModel)tblmhs.getModel();
     String search = tSearch.getText().toString();
     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
     tblmhs.setRowSorter(tr);
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
            java.util.logging.Logger.getLogger(ListMhs_DS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMhs_DS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMhs_DS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMhs_DS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ListMhs_DS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton bBack;
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tSearch;
    private javax.swing.JTable tblmhs;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMhs;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextField txtSMS;
    private javax.swing.JTextField txtntMhs;
    // End of variables declaration//GEN-END:variables
}
