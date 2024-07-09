package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Categoria;

/**
 *
 * @author Fernando Davila
 */
public class Ctrl_Categoria {

    //metodo para registrar/guardar categoria
    public boolean guardar(Categoria objeto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al guardar categoria: " + e);
        }
        return respuesta;

    }

    //metodo para verificar que no exista categoria
    public boolean existeCategoria(String categoria) {

        boolean respuesta = false; 
        
        String sql = "SELECT descripcion FROM tb_categoria WHERE descripcion = '" + categoria + "'";
        Statement st;

        try {

            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                respuesta = true;

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar categoria: " + e);
        }
        return respuesta;

    }
    
    
    //metodo para actualizar categoria
    public boolean actualizar(Categoria objeto, int idCategoria) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_categoria SET descripcion=? WHERE idcategoria='"+ idCategoria +"'");
            consulta.setString(1, objeto.getDescripcion());
           

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar categoria: " + e);
        }
        return respuesta;

    } 
    
    
    //metodo para eliminar categoria
    public boolean eliminar(int idCategoria) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("DELETE FROM tb_categoria WHERE idcategoria='"+ idCategoria +"'");
            consulta.executeUpdate();
           

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar categoria: " + e);
        }
        return respuesta;

    } 

}
