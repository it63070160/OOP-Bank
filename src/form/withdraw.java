
package form;

import Model.Check_Field;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import main.frame;

public class withdraw extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String username,number;
    
    public withdraw(String username, Connection con) {
        this.username = username;
        this.con = con;
        initComponents();
        getAccount();
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
                jComboBox1.addItem(String.format("%010d", Integer.parseInt(number)) + " " + f + " " + l);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void withdrawMoney(String n, String u, double m){
        frame.setForm(new pin(u, con, "Withdrawn", m, n, ""));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel2 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("Amount");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 197, -1, -1));

        amount.setBackground(new java.awt.Color(240, 247, 255));
        amount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                amountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                amountMouseExited(evt);
            }
        });
        panel1.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 247, 380, 50));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 84, 84));
        jLabel3.setText("Account");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 349, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "กรุณาเลือกบัญชี" }));
        panel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 399, 380, 50));

        jButton1.setBackground(new java.awt.Color(4, 115, 227));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ถอนเงิน");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 513, 220, 60));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Withdrawn");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 92, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/withdraw_icon.png"))); // NOI18N
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 50, 40));

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
        if (!Check_Field.checkMoney(amount.getText())){
            JOptionPane.showMessageDialog(null, "โปรดระบุจำนวนเงินที่ถูกต้อง", "OOP Bank - Withdraw", JOptionPane.PLAIN_MESSAGE);
        }
        else if (jComboBox1.getSelectedItem().equals("กรุณาเลือกบัญชี")){
            JOptionPane.showMessageDialog(null, "โปรดเลือกบัญชี", "OOP Bank - Withdraw", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            withdrawMoney(Integer.parseInt(((String)jComboBox1.getSelectedItem()).substring(0, 10)) + "", username, Double.parseDouble(amount.getText()));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void amountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountMouseEntered
        amount.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_amountMouseEntered

    private void amountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountMouseExited
       amount.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_amountMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables
}
