package main;

import Model.Check_Field;
import Model.Model_Menu;
import event.*;
import form.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class frame extends javax.swing.JFrame implements ActionListener {

    public deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(deposit deposit) {
        this.deposit = deposit;
    }

    public start_frame getSframe() {
        return sframe;
    }

    public void setSframe(start_frame sframe) {
        this.sframe = sframe;
    }

    public home getHome() {
        return home;
    }

    public void setHome(home home) {
        this.home = home;
    }

    ImageIcon winlogo = new ImageIcon(getClass().getClassLoader().getResource("minorcomponent/winlogo.png"));

    private static String username;
    private home home;
    private account account;
    private deposit deposit;
    private withdraw witdrawn;
    private start_frame sframe;
    private login login;
    private register reg;
    private transaction transaction;
    private Connection con;
    private boolean logout = true;
    
    public frame(String u) {
        con = Connect.ConnectDB();
        login = new login();
        login.getjButton1().addActionListener(this);
        reg = new register();
        reg.getjButton1().addActionListener(this);
        deposit = new deposit(u, con);
        witdrawn = new withdraw(u, con);
//        account = new account(u, con);
//        account.getjButton1().addActionListener(this);
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        menu1.initMoving(frame.this);
        setIconImage(winlogo.getImage());
        header1.getMin().addActionListener(this);
        menu1.addEventMenuSelected(new EventMenuSelected() {
            
            @Override
            public void selected(int index) {
                if (index == 0) {
                    if (logout) {
                        setForm(login);
                    } 
                    else {
                        setForm(new home(username, con));
                    }
                } 
                else if (index == 1) {
                    if (logout) {
                        setForm(reg);
                    } 
                    else {
                        account = new account(username, con);
                        setForm(account);
                        addEventButton(account);
                    }
                } 
                else if (index == 2) {
                    setForm(new deposit(username, con));
                } 
                else if (index == 3) {
                    setForm(new withdraw(username, con));
                } 
                else if (index == 4) {
//                    Transfer
                } 
                else if (index == 5) {
                    setForm(new transaction(username, con));
                } 
                else if (index == 9) {
//                    About
                }
                else if (index == 10) {
                    logoutMenu();
                    logout = true;
                    setForm(login);
                }
            }
        });
        setForm(login);
    }
    public static void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    
    private void addEventButton(account acct){
        acct.getjButton1().addActionListener(this);
    }
    
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String pin;
    private boolean same_user = false;
    private boolean same_name = false;
    private String check_username,check_fname,check_lname;
    
    
    private void register(String u, String p, String f, String l){
        try{
//            con = Connect.ConnectDB();
            String sql = "SELECT * FROM BankInformation";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                check_username = rs.getString("Username");
                check_fname = rs.getString("Firstname");
                check_lname = rs.getString("Lastname");
                if(check_username.equals(u)){
                    same_user = true;
                    break;
                }
                else if(check_fname.equals(f) && check_lname.equals(l)){
                    same_name = true;
                    break;
                }
            }
            if(same_user){
                JOptionPane.showMessageDialog(null, u+" มีผู้ใช้แล้ว", "ระบบสมัครสมาชิก", JOptionPane.ERROR_MESSAGE);
                same_user = false;
            }
            else if(same_name){
                JOptionPane.showMessageDialog(null, f+" "+l+" มีบัญชีอยู่แล้ว", "ระบบสมัครสมาชิก", JOptionPane.ERROR_MESSAGE);
                same_name = false;
            }
            else{
                sql = "insert into BankInformation(Username, PIN, Firstname, Lastname) values (?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, u);
                pst.setString(2, p);
                pst.setString(3, f);
                pst.setString(4, l);
                pst.execute();
                login(u,p);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void login(String u, String p){
        try{
            String sql = "SELECT * FROM BankInformation WHERE Username = '"+u+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                pin = rs.getString("PIN");
                username = rs.getString("Username");
                if(pin.equals(p) && username.equals(u)){
                    JOptionPane.showMessageDialog(null, "ยินดีต้อนรับ "+username+ " เข้าสู่ระบบ", "OOP Bank", JOptionPane.PLAIN_MESSAGE);
                    setUsername(u);
                    logout = false;
                    loginMenu();
                    setForm(new home(username, con));
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", "OOP Bank", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            frame.username = u;
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void loginMenu(){
        menu1.getListMenu1().resetItem();
        menu1.getListMenu1().addItem(new Model_Menu("1", "Overview", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("2", "Account", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("3", "Deposit", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("4", "Withdrawn", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("5", "Transfer", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("6", "Transaction", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        menu1.getListMenu1().addItem(new Model_Menu("", "Others", Model_Menu.MenuType.TITLE));
        menu1.getListMenu1().addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        menu1.getListMenu1().addItem(new Model_Menu("7", "About", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("logout", "Logout", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }
    
    public void logoutMenu(){
        menu1.getListMenu1().resetItem();
        menu1.getListMenu1().addItem(new Model_Menu("1", "Login", Model_Menu.MenuType.MENU));
        menu1.getListMenu1().addItem(new Model_Menu("2", "Register", Model_Menu.MenuType.MENU));
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(login.getjButton1())){
            if (!Check_Field.checkUsername(login.getUser().getText())){
                JOptionPane.showMessageDialog(null, "โปรดกรอกชื่อผู้ใช้\nชื่อผู้ใช้ต้องเป็นตัวอักษรและไม่ใช่ช่องว่าง", "OOP Bank - Login", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                login(login.getUser().getText(), String.valueOf(login.getjPasswordField1().getPassword()));
            }
        }
        else if(ae.getSource().equals(reg.getjButton1())){
            if (!Check_Field.checkUsername(reg.getUser().getText())){
                JOptionPane.showMessageDialog(null, "โปรดกรอกชื่อผู้ใช้\nชื่อผู้ใช้ต้องเป็นตัวอักษรและไม่ใช่ช่องว่าง", "OOP Bank - Register", JOptionPane.PLAIN_MESSAGE);
            }
            else if (!Check_Field.checkFirstname(reg.getFname().getText())){
                JOptionPane.showMessageDialog(null, "โปรดกรอกชื่อ\nชื่อต้องเป็นตัวอักษรและไม่ใช่ช่องว่าง", "OOP Bank - Register", JOptionPane.PLAIN_MESSAGE);
            }
            else if (!Check_Field.checkLastname(reg.getLname().getText())){
                JOptionPane.showMessageDialog(null, "โปรดกรอกนามสกุล\nนามสกุลต้องเป็นตัวอักษรและไม่ใช่ช่องว่าง", "OOP Bank - Register", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                register(reg.getUser().getText(), String.valueOf(reg.getPinfield().getPassword()), reg.getFname().getText(), reg.getLname().getText());
            }
        }
        else if(ae.getSource().equals(account.getjButton1())){
            System.out.println("add button press at frame");
            setForm(new addaccount(username, con));
        }
    }

    public transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(transaction transaction) {
        this.transaction = transaction;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        header1 = new component.Header();
        menu1 = new component.menu();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1600, 820));

        panel1.setBackground(new java.awt.Color(242, 242, 242));

        menu1.setPreferredSize(new java.awt.Dimension(250, 660));

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header header1;
    public static javax.swing.JPanel mainPanel;
    private component.menu menu1;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables

    public account getAccount() {
        return account;
    }

    public void setAccount(account account) {
        this.account = account;
    }

}
