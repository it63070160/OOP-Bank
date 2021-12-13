
package form;

import Model.Check_Field;
import java.awt.event.MouseAdapter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;
import main.Connect;
import main.frame;

public class addaccount extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String pin,username,number;
    
    public addaccount(String username, Connection con) {
        this.username = username;
        this.con = con;
        initComponents();
        PlainDocument document = (PlainDocument) jPasswordField1.getDocument();
        document.setDocumentFilter(new DocumentFilter() {

            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= 6) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

        });
    }

    
    public void addacct(String f, String l, String u){
        this.username = u;
//        System.out.println(firstnamefield.getText() + " " + lastnamefield.getText() + " " + username);
        String sql = "SELECT * FROM BankInformation";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                sql = "insert into BankInformation(Username, Firstname, Lastname) values (?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, u);
                pst.setString(2, f);
                pst.setString(3, l);
                pst.execute();
            }
            JOptionPane.showMessageDialog(null, "เพิ่มบัญชีสำเร็จ", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
            frame.setForm(new account(u, con));
        }
        catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "เพิ่มบัญชีไม่สำเร็จ", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel2 = new javax.swing.JLabel();
        lastnamefield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
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

        lastnamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnamefieldActionPerformed(evt);
            }
        });

        jButton1.setText("เพิ่มบัญชี");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 84, 84));
        jLabel4.setText("PIN");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Add acoount");

        firstnamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnamefieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(84, 84, 84));
        jLabel5.setText("Lastname");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("<- Back to account");
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
                        .addGap(472, 472, 472)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lastnamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jPasswordField1)
                                .addComponent(firstnamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
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
        else if (!Check_Field.checkPIN(String.valueOf(jPasswordField1.getPassword()), con, username)){
            JOptionPane.showMessageDialog(null, "PIN ไม่ถูกต้อง", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
        }
        else{
//            System.out.println("Everything correct");
            addacct(firstnamefield.getText(), lastnamefield.getText(), username);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lastnamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnamefieldActionPerformed

    private void firstnamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnamefieldActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        frame.setForm(new account(frame.getUsername(), con));
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstnamefield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField lastnamefield;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables
}
