/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasPc
 */
public class Connect {

    private static String user = "root";
    private static String pass = "overkill00";
    
    /*
    public Connect() {
        user = "root";
        pass = "";
    }
   
    public Connect(String _user, String _pass){
        user = _user;
        pass = _pass;
    }*/
    
    public static void setPass(String _user, String _pass)
    { 
        user = _user;
        pass = _pass;
    }
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clinica?zeroDateTimeBehavior=convertToNull", user, pass);
        } catch (SQLException ex) {
            return null;
        }
   }
    
}
