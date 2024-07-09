package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

/**
 *
 * @author Fernando Davila
 */
public class Ctrl_Cliente {
    
     //metodo para registrar/guardar cliente
    
    public boolean guardar(Cliente objeto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_cliente values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getCedula());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());        
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al registrar cliente: " + e);
        }
        return respuesta;

    }

    //metodo para verificar que no exista producto
    public boolean existeCliente(String cedula) {

        boolean respuesta = false; 
        
        String sql = "SELECT cedula FROM tb_cliente WHERE cedula = '" + cedula + "'";
        Statement st;

        try {

            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                respuesta = true;

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar cliente: " + e);
        }
        return respuesta;

    }
    
    
    //metodo para actualizar cliente
    public boolean actualizar(Cliente objeto, int idCliente) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_cliente SET nombre=?, apellido=?, cedula=?, telefono=?, direccion=?, estado=? WHERE idCliente='"+ idCliente +"'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;

    } 
    
    
    //metodo para eliminar cliente
    public boolean eliminar(int idCliente) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("DELETE FROM tb_cliente WHERE idCliente='"+ idCliente +"'");
            consulta.executeUpdate();
           

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;

    } 
    
}
