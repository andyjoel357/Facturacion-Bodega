
package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.DetalleVenta;
import modelo.cliente;

public class venta {
    public static int idClienteRegistrado;
    java.math.BigDecimal idColVar;
       public boolean guardarCabezera(cliente objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into clientes values(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getCorreo());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getCi());
            consulta.setString(7, objeto.getDirecion());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;

            }
            ResultSet rs=consulta.getGeneratedKeys();
            while(rs.next()){
            idColVar = rs.getBigDecimal(1);
            idClienteRegistrado = idColVar.intValue();
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar cabecera de venta " + e);
        }

        return respuesta;

    }
     public boolean guardarDetalle( DetalleVenta objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("insert factura values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setInt(2, idClienteRegistrado);
            consulta.setInt(3, objeto.getId_cabecera());
            consulta.setInt(4, objeto.getId_producto());
            consulta.setDouble(5, objeto.getPrecio_unitario());
            consulta.setDouble(6, objeto.getSubtotal());
            consulta.setDouble(7, objeto.getIva());
            consulta.setDouble(8, objeto.getTotal());
            
            

            if (consulta.executeUpdate() > 0) {
                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta " + e);
        }

        return respuesta;

    }
    
}
