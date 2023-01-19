/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-overview.html
 * @author usuario
 */
public class Conexion {
    private Logger logConexion = Logger.getLogger("conexion");
    private Connection conectar; 
    private String host; 
    private String user;
    private String password;
    
    public Connection conectar() throws ClassNotFoundException, SQLException{
        host = "localhost:3306/liga_medac";
        user = "root";
        password = "12345";
        CargarDriver.cargarDriver();
        //Class.forName("com.mysql.cj.jdbc.Driver");//clase deprecated
        conectar = DriverManager.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + password );
        if (conectar != null){
            logConexion.info("Se ha establecido la conexión");
        }
        else {
            logConexion.info("No se ha podido establecer la conexión");
        }
        return conectar;
        
       }
    
    public void cerrarConexion() throws SQLException{
        
         if (conectar != null){
             conectar.close();
            logConexion.info("Se ha cerrado la conexion la conexión");
        }
        else {
            logConexion.info("La conexión no esta abierta");
        }
    }
}
