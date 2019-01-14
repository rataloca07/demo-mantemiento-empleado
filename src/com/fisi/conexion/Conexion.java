/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author anthony
 */
public class Conexion {
    public static Connection getConnexion() throws SQLException{
        Connection cn =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/demomantenimientoempleado", "root", "");
            System.out.println("Conexion exitosa gaaaa");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion: "+e);
            
        }
        return cn;
        
    }

    
    

}
