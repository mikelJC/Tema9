/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Contacto;
import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 *
 * @author AlumMati
 */
public class ContactoDAO {
    
    public void añadircontactobd(Contacto con) throws SQLException{
        
        ConexionDB nuevacon = new ConexionDB();
        
        Connection conex = nuevacon.AbrirConexion();

        PreparedStatement stmt = conex.prepareStatement("INSERT INTO contacto(Nombre,Apellidos,Telefono,FechaNac) VALUES (?,?,?,?)");
               
        stmt.setString(1, con.getNombre());
        stmt.setString(2, con.getApellidos());
        stmt.setString(3, con.getTelefono());
        
        java.util.Date utilDate = new java.util.Date();
        
        utilDate = con.getFnacimiento();
        
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        
        stmt.setDate(4, sqlDate);
        
        stmt.executeUpdate();
    };
        
    public void buscar(String nombre) throws SQLException{
       
        
        ConexionDB nuevacon = new ConexionDB();
        
        Connection conex = nuevacon.AbrirConexion();
        
        Statement stmt = conex.createStatement();
        
        ResultSet rst = stmt.executeQuery("SELECT Nombre FROM contacto WHERE Nombre='"+nombre+"'");
        
        while (rst.next()) {
            int id = rst.getInt("Id");
            String nom = rst.getString("Nombre");
            String ap = rst.getString("Apellidos");
            String tl = rst.getString("Telefono");
            Date fc =  rst.getDate("FechaNac");
            
            System.out.println("Id: "+id);
            System.out.println("Nombre: "+nom+"\n"+
                               "Apellido: "+ap+"\n"+
                               "Telefono: "+tl+"\n"+
                               "Fecha Nac: "+fc+"\n");
        }
        
        
    }
    
    
}
