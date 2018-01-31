package bettertimetable;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Chin Jia Xiong
 */
public class LecturerInfo extends javax.swing.JFrame {
    
    BufferedImage img1, imgA;

    public LecturerInfo(String code) {
        FileInputStream fis = null;
        try {
            initComponents();
            setLocationRelativeTo(null);
            setVisible(true);
            jTextField89.setText(code);
            try {
                String fileName = "jdbc:sqlite:" + System.getProperty("user.dir") + "/dat/CourseManager.db";
                Connection conn = DriverManager.getConnection(fileName);
                String command = "SELECT name, cv FROM lecturer WHERE code=?;";
                PreparedStatement statement = conn.prepareStatement(command);
                statement.setString(1, code);
                ResultSet rs = statement.executeQuery();
                String name = "", cv = "";
                try{
                    name = rs.getString("name");
                }catch(Exception e){
                    name = "Unavailable";
                }
                try{
                    cv = rs.getString("cv");
                }catch(Exception e){
                    cv = "Unavailable";
                }
                jTextField91.setText(name);
                jTextField90.setText(cv);
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            fis = new FileInputStream(new File(System.getProperty("user.dir") + "/font/whatever it takes bold.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, fis).deriveFont(Font.BOLD, 36);
            img1 = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmall.jpg"));
            imgA = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmallHover.jpg"));
            Graphics g = img1.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Close", 110, 50);
            g.dispose();
            g = imgA.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Close", 110, 50);
            g.dispose();
            jLabel4.setIcon(new ImageIcon(img1));
            jLabel78.setFont(font);
            jLabel114.setFont(font);
            jLabel115.setFont(font);
            jLabel116.setFont(font);
            jTextField89.setFont(font);
            jTextField90.setFont(font);
            jTextField91.setFont(font);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturerInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(LecturerInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturerInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(LecturerInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jTextField89 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField90 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jTextField91 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lecturer Info");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 102, 102));
        jLabel78.setText("Lecturer Information");

        jTextField89.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jLabel114.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(102, 102, 102));
        jLabel114.setText("Lecturer Code :");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chin Jia Xiong\\Documents\\NetBeansProjects\\BetterTimeTable\\img\\ButtonSmall.jpg")); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jTextField90.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jLabel115.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(102, 102, 102));
        jLabel115.setText("Lecturer Name :");

        jTextField91.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jLabel116.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(102, 102, 102));
        jLabel116.setText("Lecturer CV :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel116))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField89, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                    .addComponent(jTextField91)
                                    .addComponent(jTextField90)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel4)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(553, 553, 553))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new ImageIcon(imgA));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new ImageIcon(img1));
    }//GEN-LAST:event_jLabel4MouseExited

    public static void go(String lecturer) {
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
            java.util.logging.Logger.getLogger(LecturerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerInfo(lecturer);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField89;
    private javax.swing.JTextField jTextField90;
    private javax.swing.JTextField jTextField91;
    // End of variables declaration//GEN-END:variables
}
