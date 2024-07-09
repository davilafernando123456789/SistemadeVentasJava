package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;
import conexion.Conexion;
import java.sql.PreparedStatement;
import modelo.Cliente;

/**
 *
 * @author Fernando Davila
 */
public class Ctrl_Usuario {
    
    // Creamos el método para iniciar sesión
    public boolean loginUser(Usuario objeto) {
        
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario, password FROM tb_usuario WHERE usuario='" + objeto.getUsuario() + "' AND password='" + objeto.getPassword() + "'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                respuesta = true;
            } else {
                respuesta = false;
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        } finally {
            try {
                cn.close(); // Cierra la conexión después de usarla
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        
        return respuesta; 
    }
    
    //metodo para guardar usuario
    
     public boolean guardar(Usuario objeto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_usuario values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword()); 
            consulta.setString(6, objeto.getTelefono());      
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al registrar usuario: " + e);
        }
        return respuesta;

    }

    //metodo para verificar que no exista usuario
    public boolean existeUsuario(String usuario) {

        boolean respuesta = false; 
        
        String sql = "SELECT usuario FROM tb_usuario WHERE usuario = '" + usuario + "'";
        Statement st;

        try {

            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                respuesta = true;

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;

    }
    
    
    //metodo para actualizar usuario
    public boolean actualizar(Usuario objeto, int idUsuario) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_usuario SET nombre=?, apellido=?, usuario=?, password=?, telefono=?, estado=? WHERE idUsuario='"+ idUsuario +"'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;

    } 
    
    
    //metodo para eliminar usuario
    public boolean eliminar(int idUsuario) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("DELETE FROM tb_usuario WHERE idUsuario='"+ idUsuario +"'");
            consulta.executeUpdate();
           

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;

    } 
}