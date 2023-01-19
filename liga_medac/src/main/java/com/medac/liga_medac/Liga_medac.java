/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.medac.liga_medac;

import interfaz_usuario.InterfazAltas;
import java.sql.SQLException;
import utilidades.Conexion;
//import utilidades.EjemploDataSource;
//import utilidades.Conexion;

/**
 *
 * @author usuario
 */
public class Liga_medac {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       System.out.println("Probando Liga Medac");
       Conexion liga_medac =  new Conexion();
       liga_medac.conectar();
       InterfazAltas ventana = new InterfazAltas();
   
        /*EjemploDataSource pruebaDataSource = new EjemploDataSource();
        pruebaDataSource.crearDataSource();*/
    }
}
