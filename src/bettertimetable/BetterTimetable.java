package bettertimetable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Chin Jia Xiong
 */

class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
    
    // wrap each cell to fit the words
    WordWrapCellRenderer() {
        setFont(new Font("Verdana", Font.PLAIN, 24));
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    // draw the text and background color
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try{
            setText(value.toString());
            this.setBackground(new Color(113, 170, 186));
            if(value.toString().equals("")) this.setBackground(new Color(123, 222, 159));
        }catch(Exception e){
            setText("");
            this.setBackground(new Color(123, 222, 159));
        }
        return this;
    }
}

public class BetterTimetable extends javax.swing.JFrame {
    
    String[] codes;  // codes selected by the user
    LinkedList<String> selected = new LinkedList();
    String groups, lecturerCode, location, start, end, types, crtCode;
    BufferedImage img1, img2, img3, img4, imgA, imgB, imgC, imgD;
    LinkedList<String> items;  // items available for that code
    DefaultTableModel model1;
    DefaultTableModel model2;
    
    public BetterTimetable(String[] codes) {
        FileInputStream fis = null;  // to insert custom fonts
        try {
            initComponents();
            setLocationRelativeTo(null);
            setVisible(true);
            this.codes = codes;
            // add the codes to first combo box
            model1 = (DefaultTableModel)jTable1.getModel();
            model2 = (DefaultTableModel)jTable2.getModel();
            for(String i: codes)
                jComboBox1.addItem(i);
            jComboBox1.addActionListener (new ActionListener () {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateComboBox2();
                }
            });
            model1.setValueAt("MON", 0, 0);
            model1.setValueAt("TUE", 1, 0);
            model1.setValueAt("WED", 2, 0);
            model1.setValueAt("THU", 3, 0);
            model1.setValueAt("FRI", 4, 0);
            model2.setValueAt("MON", 0, 0);
            model2.setValueAt("TUE", 1, 0);
            model2.setValueAt("WED", 2, 0);
            model2.setValueAt("THU", 3, 0);
            model2.setValueAt("FRI", 4, 0);
            setTableWrapper();
            jTable1.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
            jTable1.setShowGrid(true);
            jTable1.setGridColor(Color.BLACK);
            jTable2.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
            jTable2.setShowGrid(true);
            jTable2.setGridColor(Color.BLACK);
            jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
            fis = new FileInputStream(new File(System.getProperty("user.dir") + "/font/whatever it takes bold.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, fis).deriveFont(Font.BOLD, 42);
            FileInputStream fis2 = new FileInputStream(new File(System.getProperty("user.dir") + "/font/whatever it takes bold.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, fis2).deriveFont(Font.BOLD, 36);
            img1 = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmall.jpg"));
            img2 = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonLong.jpg"));
            img3 = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonLong.jpg"));
            img4 = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmall.jpg"));
            imgA = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmallHover.jpg"));
            imgB = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonLongHover.jpg"));
            imgC = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonLongHover.jpg"));
            imgD = ImageIO.read(new File(System.getProperty("user.dir") + "/img/ButtonSmallHover.jpg"));
            Graphics g = img1.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Add Slot", 75, 50);
            g.dispose();
            g = img2.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Remove selected item", 30, 50);
            g.dispose();
            g = img3.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Save timetable!", 95, 50);
            g.dispose();
            g = img4.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Back", 95, 50);
            g.dispose();
            g = imgA.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Add Slot", 95, 50);
            g.dispose();
            g = imgB.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Remove selected item", 30, 50);
            g.dispose();
            g = imgC.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Save timetable!", 95, 50);
            g.dispose();
            g = imgD.getGraphics();
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("Back", 95, 50);
            g.dispose();
            jLabel1.setIcon(new ImageIcon(img1));
            jLabel2.setIcon(new ImageIcon(img2));
            jLabel3.setIcon(new ImageIcon(img3));
            jLabel4.setIcon(new ImageIcon(img4));
            jLabel78.setFont(font2);
            jLabel114.setFont(font2);
            jComboBox1.setFont(font2);
            jComboBox2.setFont(font2);
            jLabel116.setFont(font2);
            jLabel115.setFont(font2);
            jComboBox3.setFont(font2);
            jTable2.setBackground(new Color(0,161,183));
            updateComboBox2();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void setTableWrapper(){
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new WordWrapCellRenderer());
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(3).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(4).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(5).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(6).setCellRenderer(new WordWrapCellRenderer());
        jTable2.getColumnModel().getColumn(7).setCellRenderer(new WordWrapCellRenderer());
    }
    
    private void updateComboBox2(){
        items = new LinkedList();
        jComboBox2.removeAllItems();  // clear combo box 2
        crtCode = jComboBox1.getSelectedItem().toString();  // get current code
        try {
            String fileName = "jdbc:sqlite:" + System.getProperty("user.dir") + "/dat/CourseManager.db";
            Connection conn = DriverManager.getConnection(fileName);
            String command = "SELECT groups, lecturerCode, location, start, end, types FROM timetable WHERE code=?;";
            PreparedStatement statement = conn.prepareStatement(command);
            statement.setString(1, crtCode);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                groups = rs.getString("groups");
                lecturerCode = rs.getString("lecturerCode");
                location = rs.getString("location");
                start = rs.getString("start");
                end = rs.getString("end");
                types = rs.getString("types");
                // example: WIX1002: G1(L) FRI9.00-FRI9.59 DK2 ATF
                String rslt = crtCode + " : G" + groups + "(" + types + ") " + start + "-" + end + " " + location + " " + lecturerCode;
                boolean alreadyExists = false;
                for(String x: selected){
                    StringTokenizer st = new StringTokenizer(x);
                    String tmpCode = st.nextToken();
                    st.nextToken(); // skip groups part
                    String tmpTypes = st.nextToken();
                    if(tmpCode.equals(crtCode) && tmpTypes.equals(types)){
                        alreadyExists = true;
                        break;
                    }
                }
                if(!alreadyExists){
                    jComboBox2.addItem(rslt);
                }
                int timeStart = Integer.parseInt(start.substring(3, start.indexOf(".")));
                int timeEnd = Integer.parseInt(end.substring(3, end.indexOf(".")));
                boolean removeItem = false;
                for(int i=timeStart; i<=timeEnd; i++){
                    String day = start.substring(0, 3);
                    int row = 0;
                    switch(day){
                        case "MON":
                            row = 0;
                            break;
                        case "TUE":
                            row = 1;
                            break;
                        case "WED":
                            row = 2;
                            break;
                        case "THU":
                            row = 3;
                            break;
                        case "FRI":
                            row = 4;
                            break;
                    }
                    int col;
                    DefaultTableModel model;
                    if(i<=13) model = (DefaultTableModel)jTable1.getModel();
                    else model = (DefaultTableModel)jTable2.getModel();
                    if(i-8 == 12) col =  6;
                    else col = (i-8) % 6 + 1;
                    if(model.getValueAt(row, col) != null){
                        if(!model.getValueAt(row, col).toString().equals("")){
                            removeItem = true;
                            break;
                        }
                    }
                }
                if(removeItem) jComboBox2.removeItem(rslt);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel114 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel115 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Better Timetable");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 102, 102));
        jLabel78.setText("Better Timetable");

        jLabel98.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(102, 102, 102));

        jTable1.setBackground(new java.awt.Color(0, 161, 183));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Day", "8.00-8.59", "9.00-9.59", "10.00-10.59", "11.00-11.59", "12.00-12.59", "13.00-13.59"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(100);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel114.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(102, 102, 102));
        jLabel114.setText("Select Course Code ......");

        jLabel116.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(102, 102, 102));
        jLabel116.setText("There you go! (Want to know lecturer details? Click on the cell in the timetable!)");

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jLabel115.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(102, 102, 102));
        jLabel115.setText("AND.. available groups are shown here! (Slots that don't clash with other classes)");

        jTable2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Day", "14.00-14.59", "15.00-15.59", "16.00-16.59", "17.00-17.59", "18.00-18.59", "19.00-19.59", "20.00-20.59"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setRowHeight(100);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jComboBox3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chin Jia Xiong\\Documents\\NetBeansProjects\\BetterTimeTable\\img\\ButtonSmall.jpg")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chin Jia Xiong\\Documents\\NetBeansProjects\\BetterTimeTable\\img\\ButtonSmall.jpg")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Chin Jia Xiong\\Documents\\NetBeansProjects\\BetterTimeTable\\img\\ButtonSmall.jpg")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel78))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(jLabel98))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel115)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1415, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel116)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(303, 303, 303))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jLabel115))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel116))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel98))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setIcon(new ImageIcon(imgA));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setIcon(new ImageIcon(img1));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if(jComboBox2.getSelectedItem()!=null){
            String tempor = jComboBox2.getSelectedItem().toString();
            // example: WIX1002: G1(L) 9.00-9.59 DK2 ATF
            crtCode = tempor.substring(0, tempor.indexOf(":")-1);
            groups = tempor.substring(tempor.indexOf(":")+2, tempor.indexOf("("));
            types = tempor.substring(tempor.indexOf("(")+1, tempor.indexOf(")"));
            start = tempor.substring(tempor.indexOf(")")+2, tempor.indexOf("-"));
            end = tempor.substring(tempor.indexOf("-")+1, tempor.lastIndexOf(".")+3);
            lecturerCode = tempor.substring(tempor.lastIndexOf(" ")+1);
            String tempor2 = tempor.substring(0, tempor.lastIndexOf(" "));
            location = tempor2.substring(tempor2.lastIndexOf(" ")+1);
            selected.add(crtCode + " " + groups + " " + types + " " + start + " " + end + " " + location + " " + lecturerCode);
            jComboBox3.addItem(crtCode + " " + types);
            int timeStart = Integer.parseInt(start.substring(3, start.indexOf(".")));
            int timeEnd = Integer.parseInt(end.substring(3, end.indexOf(".")));
            int col;
            String day = start.substring(0, 3);
            int row = 0;
            switch(day){
                case "MON":
                    row = 0;
                    break;
                case "TUE":
                    row = 1;
                    break;
                case "WED":
                    row = 2;
                    break;
                case "THU":
                    row = 3;
                    break;
                case "FRI":
                    row = 4;
                    break;
            }
            String rslt = crtCode + " : " + groups + "(" + types + ")" + location + " " + lecturerCode;
            DefaultTableModel model;
            for(int i=timeStart; i<=timeEnd; i++){
                if(i<=13) model = model1;
                else model = model2;
                if(i-8 == 12) col =  6;
                else col = (i-8) % 6 + 1;
                model.setValueAt(rslt, row, col);
            }
            updateComboBox2();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new ImageIcon(imgB));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new ImageIcon(img2));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(jComboBox3.getSelectedItem() != null){
            String item = jComboBox3.getSelectedItem().toString();
            StringTokenizer st2 = new StringTokenizer(item);
            String codeToBeDeleted = st2.nextToken();
            String typeToBeDeleted = st2.nextToken();
            for(int i=0; i<selected.size(); i++){
                String x = selected.get(i);
                StringTokenizer st = new StringTokenizer(x);
                String tmpCode = st.nextToken();
                st.nextToken();
                String tmpTypes = st.nextToken();
                String tmpStart = st.nextToken();
                String tmpEnd = st.nextToken();
                if(codeToBeDeleted.equals(tmpCode) && typeToBeDeleted.equals(tmpTypes)){
                    selected.remove(i);
                    jComboBox3.removeItem(item);
                    int timeStart = Integer.parseInt(tmpStart.substring(3, tmpStart.indexOf(".")));
                    int timeEnd = Integer.parseInt(tmpEnd.substring(3, tmpEnd.indexOf(".")));
                    int col;
                    String day = tmpStart.substring(0, 3);
                    int row = 0;
                    switch(day){
                        case "MON":
                            row = 0;
                            break;
                        case "TUE":
                            row = 1;
                            break;
                        case "WED":
                            row = 2;
                            break;
                        case "THU":
                            row = 3;
                            break;
                        case "FRI":
                            row = 4;
                            break;
                    }
                    DefaultTableModel model;
                    for(int j=timeStart; j<=timeEnd; j++){
                        if(j<=13) model = model1;
                        else model = model2;
                        if(j-8 == 12) col =  6;
                        else col = (j-8) % 6 + 1;
                        model.setValueAt("", row, col);
                    }
                }
            }
            updateComboBox2();
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new ImageIcon(imgD));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new ImageIcon(img4));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Main.go();
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new ImageIcon(imgC));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new ImageIcon(img3));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            Dimension size = jTable1.getSize();
            BufferedImage img = new BufferedImage(size.width, size.height + jTable1.getTableHeader().getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D grp = img.createGraphics();
            jTable1.getTableHeader().paint(grp);
            grp.translate(0, jTable1.getTableHeader().getHeight());
            jTable1.paint(grp);
            File output = new File(System.getProperty("user.dir") + "/tableImg/timetable1.png");
            ImageIO.write(img, "png", output);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try {
            Dimension size = jTable2.getSize();
            BufferedImage img = new BufferedImage(size.width, size.height + jTable2.getTableHeader().getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D grp = img.createGraphics();
            jTable2.getTableHeader().paint(grp);
            grp.translate(0, jTable2.getTableHeader().getHeight());
            jTable2.paint(grp);
            File output = new File(System.getProperty("user.dir") + "/tableImg/timetable2.png");
            ImageIO.write(img, "png", output);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BetterTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Table successfully saved! \nPlease go to project directory/tableImg to find the images.");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if(col > 0 && row >= 0){
            try{
                String val = model1.getValueAt(row, col).toString();
                if(!val.equals("")){
                    String lecturer = val.substring(val.lastIndexOf(" ")+1, val.length());
                    LecturerInfo.go(lecturer);
                }
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.rowAtPoint(evt.getPoint());
        int col = jTable2.columnAtPoint(evt.getPoint());
        if(col > 0 && row >= 0){
            try{
                String val = model2.getValueAt(row, col).toString();
                if(!val.equals("")){
                    String lecturer = val.substring(val.lastIndexOf(" ")+1, val.length());
                    LecturerInfo.go(lecturer);
                }
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    public static void go(String codes[]) {
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
            java.util.logging.Logger.getLogger(BetterTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BetterTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BetterTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BetterTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BetterTimetable(codes);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
