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

    
    public static void main(String[] args) throws IOException, ParseException, SQLException {

        new Inicio();
    }
    
    public Inicio() throws IOException, ParseException, SQLException{
        menu();
    }
    
    public void menu() throws IOException, ParseException, SQLException{
        BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
        
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
                        //eliminarcontacto();
                        break;
                    case 3:
                        //busqueda();
                        break;
                    case 4:
                        //mostrarcumpleaños();
                        break;
                    case 5:
                        //mostraragenda();
                        break;
                    case 6:
                        //guardarfichero();
                        break;                  
                }

            } while (respuesta != 0);
    };
    
    
    public void crearcontacto() throws IOException, ParseException, SQLException{
        BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
        
        
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
 
    public void eliminarcontacto() throws IOException{
        BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
        
        String nombre;
        
        System.out.println("Nombre de la persona a borrar");
        nombre = tec.readLine();
        
        //buscar(nombre);
    
    }
    
    
    
    
}

