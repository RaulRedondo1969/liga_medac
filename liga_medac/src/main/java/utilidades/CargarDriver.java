/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class CargarDriver {
    private static final Logger logDriver = Logger.getLogger("cargarDriver");
    public static void cargarDriver() throws ClassNotFoundException{
       
        Class.forName("com.mysql.cj.jdbc.Driver");
        logDriver.info("Driver Cargado");
        
    }
    
}
