/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author AlumMati
 */
public class ConexionDB {
    
    public Connection AbrirConexion(){
        Connection con=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");//Cargar el driver
            String urldbc ="jdbc:mysql://localhost:3306/agendadb";
            con = (Connection)(java.sql.DriverManager.getConnection(urldbc,"root",""));
            
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Ha sido imposible establecer la conexión "+ e.getMessage());
        }
        return con;
}
    
    
    public void CerrarConexion(Connection con) {
        try {
            if(con!=null){
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Ha sido imposible cerrar la conexión "+ e.getMessage());
        }
    }
}
