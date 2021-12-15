
package form;

import Model.Check_Field;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.Connect;
import main.frame;

public class transfer extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String number;
    private String username;
    
    public transfer(String username, Connection con) {
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
                from.addItem(String.format("%010d", Integer.parseInt(number)) + " " + f + " " + l);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void transferMoney(String n, String u, double m, String t){
        boolean account_found = false;
        try{
            String sql = "SELECT * FROM BankInformation WHERE Number = '"+t+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                if(t.equals(String.format("%010d", rs.getInt("Number")))){
                    account_found = true;
                    frame.setForm(new pin(u, con, "Transfer", m, n, t));
                }
            }
            if (!account_found){
                JOptionPane.showMessageDialog(null, "ไม่พบเลขบัญชีปลายทาง", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        to = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        from = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Transfer");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("To");

        to.setBackground(new java.awt.Color(240, 247, 255));
        to.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        to.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toMouseExited(evt);
            }
        });
        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 84, 84));
        jLabel3.setText("From");

        from.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "กรุณาเลือกบัญชี" }));

        jButton1.setBackground(new java.awt.Color(4, 115, 227));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("โอนเงิน");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 84, 84));
        jLabel4.setText("Amount");

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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(from, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addGap(390, 390, 390))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(503, 503, 503))))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!Check_Field.checkMoney(amount.getText())){
            JOptionPane.showMessageDialog(null, "โปรดระบุจำนวนเงินที่ถูกต้อง", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
        }
        else if (from.getSelectedItem().equals("กรุณาเลือกบัญชี")){
            JOptionPane.showMessageDialog(null, "โปรดเลือกบัญชี", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
        }
        else if (to.getText().equals("")){
            JOptionPane.showMessageDialog(null, "โปรดกรอกเลขบัญชีปลายทาง", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            transferMoney(Integer.parseInt(((String)from.getSelectedItem()).substring(0, 10)) + "", username, Double.parseDouble(amount.getText()), to.getText());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void toMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseEntered
        to.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_toMouseEntered

    private void toMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseExited
        to.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_toMouseExited

    private void amountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountMouseEntered
        amount.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_amountMouseEntered

    private void amountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountMouseExited
       amount.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_amountMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JComboBox<String> from;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private swing.panel panel1;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}
