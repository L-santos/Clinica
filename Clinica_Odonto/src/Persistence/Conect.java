/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasPc
 */
public class Conect {
    
    public Connection getConnection(String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
        }
     try {
        return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/clinica?zeroDateTimeBehavior=convertToNull, ");
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
   }
}
