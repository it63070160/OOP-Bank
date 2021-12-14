/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Check_Field {
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;
    
    public static boolean checkUsername(String u){
        boolean isAlphaNumeric = !"".equals(u);
        return isAlphaNumeric;
    }
    
    public static boolean checkFirstname(String f){
        boolean isAlphaNumeric = !"".equals(f) && f.chars().allMatch(Character::isLetter);
        return isAlphaNumeric;
    }
    
    public static boolean checkLastname(String l){
        boolean isAlphaNumeric = !"".equals(l) && l.chars().allMatch(Character::isLetter);
        return isAlphaNumeric;
    }
    
    public static boolean checkPIN(String p, Connection con, String username){
        try {
            String sql = "SELECT * FROM BankInformation WHERE Username = '"+username+"'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                return p.equals(rs.getString("PIN"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Check_Field.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean checkMoney(String m){
        try {
            Double d = Double.parseDouble(m);
            if (d <= 0){
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean checkPIN(String p){
        try {
            if (p.length() == 6){
                int d = Integer.parseInt(p);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
