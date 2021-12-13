
package form;

import Model.Check_Field;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;
import main.Connect;
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
    
    public void depositMoney(String n, String u, String p, double m){
        try{
            String sql = "SELECT * FROM BankInformation WHERE Number = ("+n+")";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                pin = rs.getString("PIN");
                double money = rs.getDouble("Money"); 
                if(p.equals(pin)){
                    System.out.println("PIN Correct !");
                    System.out.println("Money : "+rs.getInt("Money")+" (+"+m+") = "+(money+m)+"");
                    String sql2 = "UPDATE BankInformation SET Money = "+(money+m)+" WHERE Number = ("+n+")";
                    pst = con.prepareStatement(sql2);
                    pst.execute();
                    String sql3 = "SELECT * FROM Transaction WHERE Username = ('"+u+"')";
                    try {
                        pst = con.prepareStatement(sql3);
                        rs = pst.executeQuery();
                        String sql4 = "insert into Transaction(Username, AccountNumber, Type, Date, Amount) values (?,?,?,?,?)";
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        pst = con.prepareStatement(sql4);
                        pst.setString(1, u);
                        pst.setString(2, n);
                        pst.setString(3, "Deposit");
                        pst.setString(4, dtf.format(LocalDateTime.now()));
                        pst.setDouble(5, m);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "ฝากเงินสำเร็จ", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
                        frame.setForm(new home(username, con));
                    } catch (SQLException ex) {
                        Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    System.out.println("PIN Incorrect !");
                    JOptionPane.showMessageDialog(null, "PIN ไม่ถูกต้อง", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
                    break;
                }
            }
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Deposit");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("Amount");

        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 84, 84));
        jLabel3.setText("Account");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "กรุณาเลือกบัญชี" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("ฝากเงิน");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 84, 84));
        jLabel4.setText("PIN");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jLabel1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amount)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, 0, 380, Short.MAX_VALUE)
                            .addComponent(jPasswordField1))))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
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

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!Check_Field.checkMoney(amount.getText())){
            JOptionPane.showMessageDialog(null, "โปรดระบุจำนวนเงินที่ถูกต้อง", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
        }
        else if (jComboBox1.getSelectedItem().equals("กรุณาเลือกบัญชี")){
            JOptionPane.showMessageDialog(null, "โปรดเลือกบัญชี", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            depositMoney(Integer.parseInt(((String)jComboBox1.getSelectedItem()).substring(0, 10)) + "", username, String.valueOf(jPasswordField1.getPassword()), Double.parseDouble(amount.getText()));
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables
}
