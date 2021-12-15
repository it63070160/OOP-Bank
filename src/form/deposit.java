
package form;

import Model.Check_Field;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import main.frame;

public class deposit extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String pin,username,number;
    
    public deposit(String username, Connection con) {
        this.username = username;
        this.con = con;
        initComponents();
        getAccount();
    }
    
    public void depositMoney(String n, String u, double m){
        frame.setForm(new pin(u, con, "Deposit", m, n, ""));
    }
    
    public void getAccount(){
        try{
            String sql = "SELECT * FROM BankInformation WHERE Username = '"+username+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                number = rs.getString("Number");
                String f = rs.getString("Firstname");
                String l = rs.getString("Lastname");
                jComboBox2.addItem(String.format("%010d", Integer.parseInt(number)) + " " + f + " " + l);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public JTextField getAmount() {
        return amount1;
    }

    public void setAmount(JTextField amount) {
        this.amount1 = amount;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox2;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox2 = jComboBox1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        amount1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Deposit");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("Amount");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 197, -1, -1));

        amount1.setBackground(new java.awt.Color(240, 247, 255));
        amount1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        amount1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        amount1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                amount1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                amount1MouseExited(evt);
            }
        });
        amount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount1ActionPerformed(evt);
            }
        });
        panel1.add(amount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 247, 380, 50));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 84, 84));
        jLabel3.setText("Account");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 349, -1, -1));

        jComboBox2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "กรุณาเลือกบัญชี" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 399, 380, 50));

        jButton1.setBackground(new java.awt.Color(4, 115, 227));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ฝากเงิน");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 513, 220, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/deposie_icon.png"))); // NOI18N
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 50, 50));

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
        if (!Check_Field.checkMoney(amount1.getText())){
            JOptionPane.showMessageDialog(null, "โปรดระบุจำนวนเงินที่ถูกต้อง", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
        }
        else if (jComboBox2.getSelectedItem().equals("กรุณาเลือกบัญชี")){
            JOptionPane.showMessageDialog(null, "โปรดเลือกบัญชี", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            depositMoney(Integer.parseInt(((String)jComboBox2.getSelectedItem()).substring(0, 10)) + "", username, Double.parseDouble(amount1.getText()));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amount1ActionPerformed

    private void amount1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amount1MouseExited
        amount1.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_amount1MouseExited

    private void amount1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amount1MouseEntered
        amount1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_amount1MouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables
}
