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
        
    public ResultSet buscar(Contacto con) throws SQLException, IOException{
       

        ConexionDB nuevacon = new ConexionDB();
        
        Connection conex = nuevacon.AbrirConexion();
        
        Statement stmt = conex.createStatement();
        
        ResultSet rst = stmt.executeQuery("SELECT Nombre FROM contacto WHERE Nombre='"+con.getNombre()+"'");
        
        return rst;

    }
    
    public void eliminar(int indice) throws SQLException{
        ConexionDB nuevacon = new ConexionDB();
        
        Connection conex = nuevacon.AbrirConexion();
        
        PreparedStatement stmt = conex.prepareStatement("DELETE from contacto WHERE Id ='"+indice+"'");
        
        stmt.executeUpdate();
        
        System.out.println("Contacto con indice "+indice+" eliminado");
    }
    
    
    public ResultSet cumpleaños() throws SQLException{
        
        
        
        ConexionDB nuevacon = new ConexionDB();
        
        Connection conex = nuevacon.AbrirConexion();
        
        Statement stmt = conex.createStatement();
        
        ResultSet rst = stmt.executeQuery("SELECT * FROM contacto WHERE day(FechaNac) = day(curdate()) AND month(FechaNac)=month(curdate())");
                
        return rst;
    }

    public ResultSet mostraragenda() throws SQLException{
        ConexionDB nuevacon = new ConexionDB();
        
        Connection conex = nuevacon.AbrirConexion();
        
        Statement stmt = conex.createStatement();
        
        ResultSet rst = stmt.executeQuery("SELECT * FROM contacto ORDER BY Nombre, Apellidos DESC");
        
        return rst;
    }
    
    
}
