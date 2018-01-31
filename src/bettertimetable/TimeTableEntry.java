package bettertimetable;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chin Jia Xiong
 */
public class TimeTableEntry extends javax.swing.JFrame {

    public TimeTableEntry() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            String fileName = "jdbc:sqlite:" + System.getProperty("user.dir") + "/dat/CourseManager.db";
            Connection conn = DriverManager.getConnection(fileName);
            String command = "CREATE TABLE IF NOT EXISTS timetable ("
                    + "id integer PRIMARY KEY, "
                    + "code text NOT NULL, "
                    + "groups text NOT NULL, "
                    + "lecturerCode text,"
                    + "location text,"
                    + "start text,"
                    + "end text,"
                    + "types text"
                    + ");";
            Statement statement = conn.createStatement();
            statement.execute(command);
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        try {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            String fileName = "jdbc:sqlite:" + System.getProperty("user.dir") + "/dat/CourseManager.db";
            Connection conn = DriverManager.getConnection(fileName);
            String command = "SELECT code, groups, lecturerCode, location, start, end, types FROM timetable;";
            PreparedStatement statement = conn.prepareStatement(command);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("code"), rs.getString("groups"), rs.getString("lecturerCode"), rs.getString("location"), rs.getString("start"), rs.getString("end"), rs.getString("types")});
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Just enter your timetable to make it work bruhhh");

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 102, 102));
        jLabel78.setText("Timetable entry");

        jLabel98.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(102, 102, 102));

        jTable1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Group", "Lecturer Code", "Location", "Start Time", "End Time", "L/T/K(Lab/Tutorial/Lecture)"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(36);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jScrollPane11.setViewportView(jTable1);

        jButton9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton9.setText("Save Table");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton10.setText("Add Row");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton11.setText("Delete Row");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton12.setText("Back");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(347, 347, 347)
                                .addComponent(jLabel98))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12)))
                        .addGap(0, 187, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(127, 127, 127)
                .addComponent(jLabel98))
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
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            String fileName = "jdbc:sqlite:" + System.getProperty("user.dir") + "/dat/CourseManager.db";
            Connection conn = DriverManager.getConnection(fileName);
            String command = "DELETE FROM timetable;";
            Statement statement = conn.createStatement();
            statement.execute(command);
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i=0; i<jTable1.getRowCount(); i++){
            String code, group, lecturerCode, location, start, end, types;
            if(model.getValueAt(i, 0)!=null)
            code = model.getValueAt(i, 0).toString();
            else code = "";
            if(model.getValueAt(i, 1)!=null)
            group = model.getValueAt(i, 1).toString();
            else group = "";
            if(model.getValueAt(i, 2)!=null)
            lecturerCode = model.getValueAt(i, 2).toString();
            else lecturerCode = "";
            if(model.getValueAt(i, 3)!=null)
            location = model.getValueAt(i, 3).toString();
            else location = "";
            if(model.getValueAt(i, 4)!=null)
            start = model.getValueAt(i, 4).toString();
            else start = "";
            if(model.getValueAt(i, 5)!=null)
            end = model.getValueAt(i, 5).toString();
            else end = "";
            if(model.getValueAt(i, 6)!=null)
            types = model.getValueAt(i, 6).toString();
            else types = "";
            try {
                String fileName = "jdbc:sqlite:" + System.getProperty("user.dir") + "/dat/CourseManager.db";
                Connection conn = DriverManager.getConnection(fileName);
                String command = "INSERT INTO timetable ("
                + "code,"
                + "groups,"
                + "lecturerCode,"
                + "location, "
                + "start,"
                + "end,"
                + "types"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(command);
                statement.setString(1, code);
                statement.setString(2, group);
                statement.setString(3, lecturerCode);
                statement.setString(4, location);
                statement.setString(5, start);
                statement.setString(6, end);
                statement.setString(7, types);
                statement.executeUpdate();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.addRow(new Object[]{null, null, null, null, null, null, null});
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int row = jTable1.getSelectedRow();
        if(row != -1){
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.removeRow(row);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Main.go();
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(TimeTableEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeTableEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeTableEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeTableEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeTableEntry();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
