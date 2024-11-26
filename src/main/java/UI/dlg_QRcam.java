/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import DAO.NhanVien;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Frame;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import untils.Auth;
/**
 *
 * @author ASUS
 */
public class dlg_QRcam extends javax.swing.JFrame {
        String user = "myuser";
        String pass = "myuser";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyOTO;encrypt=true;trustServerCertificate=true";
        WebcamPanel panel = null;
        Webcam webcam = null;
        Result result = null;
        public dlg_QRcam(Frame frame, boolean rootPaneCheckingEnabled1) {
             
        initComponents();
        initWebcam();
        // Start QR code scanning
        startQRCodeScanning(webcam);
    }
        private void initWebcam(){
            Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getWebcams().get(0);
            webcam.setViewSize(size);
            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(true);
            jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65,40,470,300));
}
        
        private void startQRCodeScanning(Webcam webcam) {
        Thread thread = new Thread(() -> {
            while (true) {
                BufferedImage image = webcam.getImage();
                if (image != null) {
                    try {
                         result = scanQRCode(image);
                        if (result != null) {
                        // Process the QR code result (e.g., login)
                        String MaNhanVien = result.getText();
                        System.out.println("QR Code Detected: " + MaNhanVien);
                        
                        // Call DanhNhap method to handle login
                        DanhNhap(MaNhanVien);
                    }
                    } catch (NotFoundException e) {
                        // QR code not found in the image
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
        private Result scanQRCode(BufferedImage image) throws NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(image)));
        return new MultiFormatReader().decode(binaryBitmap);
    }
    /**
     * Creates new form CamUI
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 580, 350));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 615, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(dlg_QRcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_QRcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_QRcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_QRcam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_QRcam dialog = new dlg_QRcam(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
public void DanhNhap(String MaNhanVien) {
    try {
        Connection con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT * FROM NhanVien WHERE MaNhanVien=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, MaNhanVien);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            String password = rs.getString(3);
            // Login with the obtained password
            // Add your login logic here
            JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "QR code không hợp lệ");
        }
        
        rs.close();
        pstmt.close();
        con.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Lỗi Chương trình: " + e.getMessage());
    }
}
}
