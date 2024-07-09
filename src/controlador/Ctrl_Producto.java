package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;

/**
 *
 * @author Fernando Davila
 */
public class Ctrl_Producto {

    //metodo para registrar/guardar producto
    public boolean guardar(Producto objeto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al guardar producto: " + e);
        }
        return respuesta;

    }

    //metodo para verificar que no exista producto
    public boolean existeProducto(String producto) {

        boolean respuesta = false;

        String sql = "SELECT nombre FROM tb_producto  WHERE nombre = '" + producto + "'";
        Statement st;

        try {

            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                respuesta = true;

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar producto: " + e);
        }
        return respuesta;

    }

    //metodo para actualizar producto
    public boolean actualizar(Producto objeto, int idProducto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_producto SET nombre=?, cantidad=?, precio=?, descripcion=?, porcentajeIva=?, idCategoria=?, estado=? WHERE idProducto='" + idProducto + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeIva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar producto: " + e);
        }
        return respuesta;

    }

    //metodo para eliminar producto
    public boolean eliminar(int idProducto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("DELETE FROM tb_producto WHERE idProducto='" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;

    }

    //metodo para actualizar stock del producto
    public boolean actualizarStock(Producto object, int idProducto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_producto SET cantidad=? WHERE idProducto='" + idProducto + "'");
            consulta.setInt(1, object.getCantidad());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al alcualizar stock de producto: " + e);
        }
        return respuesta;

    }

}
