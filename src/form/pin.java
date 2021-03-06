
package form;

import Model.Check_Field;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import javax.swing.text.*;
import main.frame;

public class pin extends javax.swing.JPanel {
    
    private String trans;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String checkPin;
    private String inputPin;
    private String username;
    private String acct;
    private String transfer_to;
    private Double amount;
    private String user_transfer;

    public pin(String username, Connection con, String trans, Double amount, String acct, String transfer_to) {
        this.trans = trans;
        this.con = con;
        this.username = username;
        this.acct = acct;
        this.amount = amount;
        this.transfer_to = transfer_to;
        initComponents();
        setOpaque(false);
        PlainDocument document = (PlainDocument) jPasswordField1.getDocument();
        jPasswordField1.setEchoChar('\u25CF');
        document.setDocumentFilter(new DocumentFilter() {

            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= 11) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

        });
    }
    
    public void check(){
        inputPin = String.valueOf(jPasswordField1.getPassword());
        if(this.trans.equals("Deposit")){
            try{
                String sql = "SELECT * FROM BankInformation WHERE Number = ("+acct+")";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()){
                    checkPin = rs.getString("PIN");
                    double money = rs.getDouble("Money"); 
                    if(inputPin.equals(checkPin)){
                        String sql2 = "UPDATE BankInformation SET Money = "+(money+amount)+" WHERE Number = ("+acct+")";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        String sql3 = "SELECT * FROM Transaction WHERE Username = ('"+username+"')";
                        try {
                            pst = con.prepareStatement(sql3);
                            rs = pst.executeQuery();
                            String sql4 = "insert into Transaction(Username, AccountNumber, Type, Date, Amount) values (?,?,?,?,?)";
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            pst = con.prepareStatement(sql4);
                            pst.setString(1, username);
                            pst.setString(2, acct);
                            pst.setString(3, "Deposit");
                            pst.setString(4, dtf.format(LocalDateTime.now()));
                            pst.setDouble(5, amount);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "???????????????????????????????????????", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
                            frame.setForm(new home(username, con));
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "PIN ??????????????????????????????", "OOP Bank - Deposit", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if(this.trans.equals("Withdrawn")){
            try{
                String sql = "SELECT * FROM BankInformation WHERE Number = ("+acct+")";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()){
                    checkPin = rs.getString("PIN");
                    double money = rs.getDouble("Money"); 
                    if(inputPin.equals(checkPin)){
                        if(money-amount>=0){
                            String sql2 = "UPDATE BankInformation SET Money = "+(money-amount)+" WHERE Number = ("+acct+")";
                            pst = con.prepareStatement(sql2);
                            pst.execute();
                            String sql3 = "SELECT * FROM Transaction WHERE Username = ('"+username+"')";
                            try {
                                pst = con.prepareStatement(sql3);
                                rs = pst.executeQuery();
                                while (rs.next()){
                                    if (rs.getString("Username").equals(username)){
                                        String sql4 = "insert into Transaction(Username, AccountNumber, Type, Date, Amount) values (?,?,?,?,?)";
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                        pst = con.prepareStatement(sql4);
                                        pst.setString(1, username);
                                        pst.setString(2, acct);
                                        pst.setString(3, "Withdrawn");
                                        pst.setString(4, dtf.format(LocalDateTime.now()));
                                        pst.setDouble(5, amount);
                                        pst.execute();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "???????????????????????????????????????", "OOP Bank - Withdrawn", JOptionPane.PLAIN_MESSAGE);
                                frame.setForm(new home(username, con));
                            }
                            catch (SQLException ex) {
                                System.out.println(ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "?????????????????????????????????????????????????????????????????????", "OOP Bank - Withdrawn", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "PIN ??????????????????????????????", "OOP Bank - Withdrawn", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if(this.trans.equals("Transfer")){
            try{
                String sql = "SELECT * FROM BankInformation WHERE Number = ("+acct+")";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()){
                    checkPin = rs.getString("PIN");
                    double money = rs.getDouble("Money"); 
                    if(inputPin.equals(checkPin)){
                        if(money-amount>=0){
                            String sql2 = "UPDATE BankInformation SET Money = "+(money-amount)+" WHERE Number = ("+acct+")";
                            pst = con.prepareStatement(sql2);
                            pst.execute();
                            String sql3 = "SELECT * FROM Transaction WHERE Username = ('"+username+"')";
                            try {
                                pst = con.prepareStatement(sql3);
                                rs = pst.executeQuery();
                                while (rs.next()){
                                    if (rs.getString("Username").equals(username)){
                                        String sql4 = "insert into Transaction(Username, AccountNumber, Type, Date, Amount, Note) values (?,?,?,?,?,?)";
                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                        pst = con.prepareStatement(sql4);
                                        pst.setString(1, username);
                                        pst.setString(2, acct);
                                        pst.setString(3, "Transfer");
                                        pst.setString(4, dtf.format(LocalDateTime.now()));
                                        pst.setDouble(5, amount);
                                        pst.setString(6, "???????????????????????????????????????????????????????????? "+transfer_to);
                                        pst.execute();
                                        break;
                                    }
                                }
                            }
                            catch (SQLException ex) {
                                System.out.println(ex);
                            }
                            
                            String sql5 = "SELECT * FROM BankInformation WHERE Number = ("+transfer_to+")";
                            pst = con.prepareStatement(sql5);
                            rs = pst.executeQuery();
                            while (rs.next()){
                                user_transfer = rs.getString("Username");
                                double user_transfer_money = rs.getDouble("Money"); 
                                String sql6 = "UPDATE BankInformation SET Money = "+(user_transfer_money+amount)+" WHERE Number = ("+transfer_to+")";
                                pst = con.prepareStatement(sql6);
                                pst.execute();
                                String sql7 = "SELECT * FROM Transaction WHERE Username = ('"+user_transfer+"')";
                                try {
                                    pst = con.prepareStatement(sql7);
                                    rs = pst.executeQuery();
                                    while (rs.next()){
                                        if (rs.getString("Username").equals(user_transfer)){
                                            String sql8 = "insert into Transaction(Username, AccountNumber, Type, Date, Amount, Note) values (?,?,?,?,?,?)";
                                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                            pst = con.prepareStatement(sql8);
                                            pst.setString(1, user_transfer);
                                            pst.setString(2, transfer_to);
                                            pst.setString(3, "Transfer");
                                            pst.setString(4, dtf.format(LocalDateTime.now()));
                                            pst.setDouble(5, amount);
                                            pst.setString(6, "??????????????????????????????????????????????????????????????? "+ String.format("%010d", Integer.parseInt(acct)));
                                            pst.execute();
                                            break;
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, "???????????????????????????????????????", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
                                    frame.setForm(new home(username, con));
                                }
                                catch (SQLException ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "?????????????????????????????????????????????????????????????????????", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "PIN ??????????????????????????????", "OOP Bank - Transfer", JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else if(this.trans.equals("Add")){
            if (Check_Field.checkPIN(String.valueOf(jPasswordField1.getPassword()), con, username)){
                String sql = "SELECT * FROM BankInformation";
                try {
                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()){
                        int n = (int)(Math.random() * 99999999) + 1;
                        String sql_check = "SELECT * FROM BankInformation WHERE Number = (" + n + ")";
                        pst = con.prepareStatement(sql_check);
                        rs = pst.executeQuery();
                        while (rs.next()){
                            n = (int)(Math.random() * 99999999) + 1;
                            pst = con.prepareStatement(sql_check);
                            rs = pst.executeQuery();
                        }
                        sql = "insert into BankInformation(Username, Firstname, Lastname, PIN, Number) values (?,?,?,?,?)";
                        pst = con.prepareStatement(sql);
                        pst.setString(1, username);
                        pst.setString(2, addaccount.getFname());
                        pst.setString(3, addaccount.getLname());
                        pst.setString(4, String.valueOf(jPasswordField1.getPassword()));
                        pst.setString(5, n+"");
                        pst.execute();
                    }
                    JOptionPane.showMessageDialog(null, "????????????????????????????????????????????????", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
                    frame.setForm(new account(username, con));
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "?????????????????????????????????????????????????????????", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "PIN ??????????????????????????????", "OOP Bank - Add account", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel5 = new swing.panel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        btn_con = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setOpaque(false);

        panel5.setBackground(new java.awt.Color(255, 255, 255));
        panel5.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PIN");

        jPanel6.setOpaque(false);

        btn7.setBackground(new java.awt.Color(4, 115, 227));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(4, 115, 227));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(4, 115, 227));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(4, 115, 227));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(4, 115, 227));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(4, 115, 227));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(4, 115, 227));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(4, 115, 227));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(4, 115, 227));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn0.setBackground(new java.awt.Color(4, 115, 227));
        btn0.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btn_del.setBackground(new java.awt.Color(4, 115, 227));
        btn_del.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn_del.setForeground(new java.awt.Color(255, 255, 255));
        btn_del.setText("Del");
        btn_del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPasswordField1.setEditable(false);
        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btn_con.setBackground(new java.awt.Color(4, 115, 227));
        btn_con.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_con.setForeground(new java.awt.Color(255, 255, 255));
        btn_con.setText("??????????????????");
        btn_con.setBorder(null);
        btn_con.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/back.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(250, 250, 250)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btn_con, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addContainerGap(686, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_con, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        jPasswordField1.setText(String.valueOf(jPasswordField1.getPassword())+"0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        jPasswordField1.setText("");
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conActionPerformed
        check();
    }//GEN-LAST:event_btn_conActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if(this.trans.equals("Deposit")){
            frame.setForm(new deposit(username, con));
        }
        else if(this.trans.equals("Withdrawn")){
            frame.setForm(new withdraw(username, con));
        }
        else if(this.trans.equals("Transfer")){
            frame.setForm(new transfer(username, con));
        }
        else if(this.trans.equals("Add")){
            frame.setForm(new addaccount(frame.getUsername(), con));
        }
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btn_con;
    private javax.swing.JButton btn_del;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private swing.panel panel5;
    // End of variables declaration//GEN-END:variables
}
