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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Chin Jia Xiong
 */
public class Credit extends javax.swing.JFrame {

    BufferedImage img1, imgA;
    
    public Credit() {
        FileInputStream fis = null;
        try {
            initComponents();
            setLocationRelativeTo(null);
            fis = new FileInputStream(new File(System.getProperty("user.dir") + "/font/whatever it takes bold.ttf"));
            FileInputStream fis2 = new FileInputStream(new File(System.getProperty("user.dir") + "/font/polya.ttf"));
            FileInputStream fis3 = new FileInputStream(new File(System.getProperty("user.dir") + "/font/polya.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, fis).deriveFont(Font.BOLD, 36);
            Font titleFont = Font.createFont(Font.TRUETYPE_FONT, fis2).deriveFont(Font.BOLD, 80);
            Font titleFont2 = Font.createFont(Font.TRUETYPE_FONT, fis3).deriveFont(Font.BOLD, 32);
            jLabel78.setFont(titleFont);
            jLabel114.setFont(titleFont2);
            jLabel118.setFont(titleFont2);
            jLabel115.setFont(font);
            jLabel116.setFont(font);
            jLabel117.setFont(font);
            jLabel120.setFont(font);
            jLabel121.setFont(titleFont2);
            jLabel119.setFont(font);
            img1 = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmall.jpg"));
            imgA = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmallHover.jpg"));
            Graphics g = img1.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Back", 110, 50);
            g.dispose();
            g = imgA.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Back", 110, 50);
            g.dispose();
            jLabel4.setIcon(new ImageIcon(img1));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Credits");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("CREDITS");

        jLabel114.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jLabel114.setText("Special thanks to my amazing friends");

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

        jLabel115.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jLabel115.setText("Chee Wai Xiong");

        jLabel116.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 0));
        jLabel116.setText("Ang Chun Wah");

        jLabel117.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 0));
        jLabel117.setText("Wong Hao Shan");

        jLabel118.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 0, 0));
        jLabel118.setText("Open Source Fonts: (Non-commercial use)");

        jLabel119.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jLabel119.setText("polya                   - http://adrien-coquet.com/work/polya-font");

        jLabel120.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 0, 0));
        jLabel120.setText("whatever it takes - https://www.dafont.com/whatever-it-takes.font");

        jLabel121.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jLabel121.setText("who help me in Data Entry:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel116)
                            .addComponent(jLabel115)
                            .addComponent(jLabel117)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel78))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel114)
                    .addComponent(jLabel118)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel120)
                            .addComponent(jLabel119)))
                    .addComponent(jLabel121))
                .addGap(0, 96, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel121)
                .addGap(21, 21, 21)
                .addComponent(jLabel115)
                .addGap(18, 18, 18)
                .addComponent(jLabel116)
                .addGap(18, 18, 18)
                .addComponent(jLabel117)
                .addGap(57, 57, 57)
                .addComponent(jLabel118)
                .addGap(18, 18, 18)
                .addComponent(jLabel120)
                .addGap(18, 18, 18)
                .addComponent(jLabel119)
                .addGap(93, 93, 93)
                .addComponent(jLabel4)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Main.go();
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new ImageIcon(imgA));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new ImageIcon(img1));
    }//GEN-LAST:event_jLabel4MouseExited

    public static void go() {
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
            java.util.logging.Logger.getLogger(Credit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Credit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
