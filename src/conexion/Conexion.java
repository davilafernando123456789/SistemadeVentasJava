package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


/**
 *
 * @author Fernando Davila
 */
public class Conexion {
    
    //metodo para conexion local
    
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_ventas","root","");
            return cn;
        } catch (SQLException e){
            System.out.println("Error l conectar a base de datos" + e);
        }
        return null;
    }
    
}
