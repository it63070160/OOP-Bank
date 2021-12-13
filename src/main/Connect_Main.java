package main;

import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import main.*;

public class Connect_Main{
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private int account_count;
    private String pin;
    private String check_username;
    private String check_fname;
    private String check_lname;
    private int same_user=0;
    private int same_name=0;
    
    public Connect_Main(){
        con = Connect.ConnectDB();
        System.out.println("Success " + con);
//        ShowData();
    }

    public Connection getCon() {
        return con;
    }
    
    public void login(String u, String p){
        try{
            String sql = "SELECT * FROM BankInformation WHERE Username = '"+u+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                pin = rs.getString("PIN");
                String username = rs.getString("Username");
                if(pin.equals(p)){
                    JOptionPane.showMessageDialog(null, "ยินดีต้อนรับ "+username+ " เข้าสู่ระบบ", "OOP Bank", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", "OOP Bank", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void registerData(String f, String l, String u, String p, double m){
        try{
            String sql = "SELECT * FROM BankInformation";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                check_username = rs.getString("Username");
                check_fname = rs.getString("Firstname");
                check_lname = rs.getString("Lastname");
                if(check_username.equals(u)){
                    same_user = 1;
                    break;
                }
                else if(check_fname.equals(f) && check_lname.equals(l)){
                    same_name = 1;
                    break;
                }
            }
            if(same_user==1){
                JOptionPane.showMessageDialog(null, u+" มีผู้ใช้แล้ว", "ระบบสมัครสมาชิก", JOptionPane.ERROR_MESSAGE);
                same_user = 0;
            }
            else if(same_name==1){
                JOptionPane.showMessageDialog(null, f+" "+l+" มีบัญชีอยู่แล้ว", "ระบบสมัครสมาชิก", JOptionPane.ERROR_MESSAGE);
                same_name = 0;
            }
            else{
                sql = "insert into BankInformation(Username, PIN, Firstname, Lastname, Money) values (?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, u);
                pst.setString(2, p);
                pst.setString(3, f);
                pst.setString(4, l);
                pst.setDouble(5, m);
                pst.execute();
                JOptionPane.showMessageDialog(null, "ยินดีต้อนรับคุณ "+f+" "+l+" เข้าสู่ OOP Bank", "ระบบสมัครสมาชิก", JOptionPane.PLAIN_MESSAGE);
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Connect_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void depositMoney(String n, String u, String p, double m){
        try{
            String sql = "SELECT * FROM BankInformation WHERE Number = ("+n+")";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                pin = rs.getString("PIN");
                double money = rs.getInt("Money"); 
                if(p.equals(pin)){
                    System.out.println("PIN Correct !");
                    System.out.println("Money : "+rs.getInt("Money")+" (+"+m+") = "+(money+m)+"");
                    sql = "UPDATE BankInformation SET Money = "+(money+m)+" WHERE Number = ("+n+")";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                }
                else{
                    System.out.println("PIN Incorrect !");
                    JOptionPane.showMessageDialog(null, "PIN ไม่ถูกต้อง", "OOP Bank", JOptionPane.PLAIN_MESSAGE);
                    break;
                }
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Connect_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ShowData(){
        String sql = "SELECT * FROM BankInformation";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("Bank No. : " + rs.getString("Number"));
                System.out.println("Firstname : " + rs.getString("Firstname"));
                System.out.println("Lastname : " + rs.getString("Lastname"));
                System.out.println("Money : " + rs.getString("Money"));
                System.out.println("-------------------------------------");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Connect_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Connect_Main();
    }
}
