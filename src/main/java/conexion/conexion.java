
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joelj
 */
public class conexion {
      public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_facturacion", "root", "root");
            //En el apartado password se debe poner la contraseña de la base de datos
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local" + e);
        }
        return null;
    }

     public static Connection Conectar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
