
package form;

import Model.Check_Field;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import main.frame;

public class addaccount extends javax.swing.JPanel {
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String pin,username,number;
    public static String fname;
    public static String lname;
    
    public addaccount(String username, Connection con) {
        this.username = username;
        this.con = con;
        initComponents();
    }

    public void addacct(String f, String l, String u){
        frame.setForm(new pin(u, con, "Add", 0.0, "", ""));
    }

    public static String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public static String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public JTextField getFirstnamefield() {
        return firstnamefield;
    }

    public void setFirstnamefield(JTextField firstnamefield) {
        this.firstnamefield = firstnamefield;
    }

    public JTextField getLastnamefield() {
        return lastnamefield;
    }

    public void setLastnamefield(JTextField lastnamefield) {
        this.lastnamefield = lastnamefield;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel2 = new javax.swing.JLabel();
        lastnamefield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        firstnamefield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("Firstname");

        lastnamefield.setBackground(new java.awt.Color(240, 247, 255));
        lastnamefield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        lastnamefield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lastnamefieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lastnamefieldMouseExited(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(4, 115, 227));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("เพิ่มบัญชี");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Add account");

        firstnamefield.setBackground(new java.awt.Color(240, 247, 255));
        firstnamefield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        firstnamefield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                firstnamefieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                firstnamefieldMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(84, 84, 84));
        jLabel5.setText("Lastname");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("<- Back to account");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lastnamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(firstnamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(firstnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!Check_Field.checkFirstname(firstnamefield.getText())){
            JOptionPane.showMessageDialog(null, "ชื่อต้องเป็นตัวอักษรและไม่ใช่ช่องว่าง", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
        }
        else if (!Check_Field.checkLastname(lastnamefield.getText())){
            JOptionPane.showMessageDialog(null, "นามสกุลต้องเป็นตัวอักษรและไม่ใช่ช่องว่าง", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            setFname(firstnamefield.getText());
            setLname(lastnamefield.getText());
            addacct(fname, lname, username);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
//        Back to account
        frame.setForm(new account(frame.getUsername(), con));
    }//GEN-LAST:event_jLabel3MouseClicked

    private void firstnamefieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstnamefieldMouseEntered
        firstnamefield.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_firstnamefieldMouseEntered

    private void firstnamefieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstnamefieldMouseExited
        firstnamefield.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_firstnamefieldMouseExited

    private void lastnamefieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnamefieldMouseEntered
        lastnamefield.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_lastnamefieldMouseEntered

    private void lastnamefieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnamefieldMouseExited
        lastnamefield.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_lastnamefieldMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstnamefield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lastnamefield;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables
}
