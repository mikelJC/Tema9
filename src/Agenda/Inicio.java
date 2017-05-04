/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.sql.*;
import DAO.*;
import Entidad.Contacto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 *
 * @author AlumMati
 */
public class Inicio {
    ContactoDAO contacdao = new ContactoDAO();
    BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException, ParseException, SQLException {

        new Inicio();
    }
    
    public Inicio() throws IOException, ParseException, SQLException{
        menu();
    }
    
    public void menu() throws IOException, ParseException, SQLException{
        

        int respuesta;
        
        do {
                System.out.println("\n******MENU PRINCIPAL****** \n"
                        + "        " + "1.Añadir a agenda\n"
                        + "        " + "2.Eliminar de agenda\n"
                        + "        " + "3.Busqueda en agenda\n"
                        + "        " + "4.Consulta cumpleaños de hoy\n"
                        + "        " + "5.Mostrar agenda\n"
                        + "        " + "6.Guardar\n"
                        + "        " + "0.Salir\n"
                );

                respuesta = Integer.parseInt(tec.readLine());

                switch (respuesta) {
                    case 1:
                        crearcontacto();
                        break;
                    case 2:
                        eliminarcontacto();
                        break;
                    case 3:
                        mostrarRst(contacdao.buscar(buscarcontacto()));
                        break;
                    case 4:
                        mostrarRst(contacdao.cumpleaños());
                        break;
                    case 5:
                        mostrarRst(contacdao.mostraragenda());
                        break;
                    case 6:
                        //guardarfichero();
                        break;                  
                }

            } while (respuesta != 0);
    };
    
    
    public void crearcontacto() throws IOException, ParseException, SQLException{
        
        
        
        String nombre;
        String apellido;
        String telefono;
        String fechanac;
        
        
        System.out.println("Introduce el nombre");
        nombre = tec.readLine();
        System.out.println("Introduce el apellido");
        apellido = tec.readLine();
        System.out.println("Introduce el Teléfono");
        telefono = tec.readLine();
        System.out.println("Introduce la fecha de nacimiento");
        fechanac =  tec.readLine();
    
        Contacto contac = new Contacto(nombre,apellido,telefono,fechanac);
        
        ContactoDAO contacDAO = new ContactoDAO();
        
        contacDAO.añadircontactobd(contac);
        
    };
 
    public void eliminarcontacto() throws IOException, SQLException, ParseException{
        

        int indice;
        String nombre;
        
        
        System.out.println("Introduce nombre de contacto a borrar");
        nombre = tec.readLine();
        
        Contacto con = new Contacto();
        con.setNombre(nombre);
        
        ResultSet srt = contacdao.buscar(con);
        mostrarRst(srt);
        
        System.out.println("Selecciona indice del contacto a borrar");
        indice = Integer.parseInt(tec.readLine());
        
        contacdao.eliminar(indice);
    }
    
    
    public Contacto buscarcontacto() throws IOException{
        System.out.println("Introduce Nombre del Contacto");
        String nombre = tec.readLine();
        
        Contacto contac = new Contacto();
        contac.setNombre(nombre);
        
        return contac;
    }
    
    public void mostrarRst(ResultSet rst) throws SQLException{
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

