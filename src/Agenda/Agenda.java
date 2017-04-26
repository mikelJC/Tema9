/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.sql.*;
import DAO.*;

/**
 *
 * @author AlumMati
 */
public class Agenda {

    public static void main(String[] args) {
        try {
                    ConexionDB conexionDB = new ConexionDB();
                    System.out.println("Abrir Conexion");
                    Connection con = conexionDB.AbrirConexion();
                    System.out.println("Conexión abierta");

                    System.out.println("Cerrar conexión");
                    conexionDB.CerrarConexion((com.mysql.jdbc.Connection) con);
                    System.out.println("Conexión cerrada");
            }catch (Exception e) {
                System.out.println("Error"+ e.getMessage());
            }
}
}

