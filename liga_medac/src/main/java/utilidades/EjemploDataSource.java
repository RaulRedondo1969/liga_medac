/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author usuario
 */
public class EjemploDataSource {
    
    private Logger logConexion = Logger.getLogger("EjemploDataSource");
    //private Connection conectar; 
    private String host; 
    private String user;
    private String password;
    private Connection conexion; 
    
   
    public void  crearDataSource() throws SQLException{
        host = "localhost:3306/liga_medac";
        user = "root";
        password = "12345";
        String uri = "jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + password;
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(uri);
        boolean cerrado= ds.isClosed();
        System.out.print(cerrado);
        conexion = ds.getConnection();
        if(conexion != null){
            logConexion.info("Conexion establecida");
        }else{
            logConexion.info("Conexion no establecida");
        }
            
     }
}
