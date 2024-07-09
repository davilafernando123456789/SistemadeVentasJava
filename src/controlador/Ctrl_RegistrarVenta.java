
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.CabeceraVenta;
import java.sql.Statement;
import modelo.DetalleVenta;
import java.sql.ResultSet;
import modelo.Cliente;

/**
 *
 * @author Fernando Davila
 */
public class Ctrl_RegistrarVenta {
    
    //ultimo id de la cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal idColVar;
    
    //metodo para registrar/guardar cabecera de venta
    public boolean guardar(CabeceraVenta objeto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_cabecera_venta values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());      
            consulta.setInt(5, objeto.getEstado());
            
            
            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }
            ResultSet rs = consulta.getGeneratedKeys();
            while(rs.next()){
                idColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = idColVar.intValue();
                
            }

           

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al registrar cabecera de venta: " + e);
        }
        return respuesta;

    }
    
     //metodo para registrar/guardar detalle venta    
    public boolean guardarDetalle(DetalleVenta objeto) {

        boolean respuesta = false;
        Connection cn = (Connection) conexion.Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_detalle_venta values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCabeceraVenta());
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());        
            consulta.setDouble(7, objeto.getDescuento());        
            consulta.setDouble(8, objeto.getIva());        
            consulta.setDouble(9, objeto.getTotalPagar());        
            consulta.setInt(10, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {

                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al registrar cliente: " + e);
        }
        return respuesta;

    }
    
         /**
     * **************************************************
     * metodo para actualizar un producto
     * **************************************************
     */
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn =  (Connection) conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_cabecera_venta set idCliente = ?, estado = ? "
                            + "where idCabeceraVenta ='" + idCabeceraVenta + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta: " + e);
        }
        return respuesta;
    }

    
}
