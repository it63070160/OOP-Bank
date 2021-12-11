package main;

import java.sql.*;

public class Connect {
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://sql6.freesqldatabase.com/sql6457330?characterEncoding=UTF-8&useUnicode=true";
            Connection con = DriverManager.getConnection(url, "sql6457330", "QVtIlsnJve");
            return con;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
