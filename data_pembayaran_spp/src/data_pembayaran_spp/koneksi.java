/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_pembayaran_spp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    
    private  static Connection koneksi;
    
    public static Connection getConnection() throws SQLException {
       String db = "jdbc:mysql://localhost/datapembayaranspp";
        String user = "root";
        String pass = "";
        
        
        
        if(koneksi == null) {
            koneksi = DriverManager.getConnection(db, user, pass);
        }
        return koneksi ;
        
        
    }
    }
       
    

