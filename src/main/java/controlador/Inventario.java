package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.inventario;

public class Inventario {
    
    // Método para registrar  
    public boolean guardar(inventario objeto) {
        boolean respuesta = false;
        String sql = "INSERT INTO productos (id_producto, codigo_barra, nombre, descripcion, precio_unitario, stock, categoria, fecha_creacion) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection cn = conexion.conexion.conectar();
             PreparedStatement consulta = cn.prepareStatement(sql)) {

            consulta.setInt(1, objeto.getId_inventario());
            consulta.setInt(2, objeto.getCodigo_barra());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getDescription());
            consulta.setDouble(5, objeto.getPrecio_unitario());
            consulta.setInt(6, objeto.getStock());
            consulta.setString(7, objeto.getCategoria());
            consulta.setString(8, objeto.getFecha());

            respuesta = consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
        }

        return respuesta;
    }

    // Método para editar libros
    public boolean editar(inventario objeto, int id) {
        boolean respuesta = false;
        String sql = "UPDATE productos SET id_producto = ?, codigo_barra = ?, nombre = ?, descripcion = ?, precio_unitario = ?, stock = ?, categoria = ?, fecha_creacion = ? WHERE id_inventario = ?";

        try (Connection cn = conexion.conexion.conectar();
             PreparedStatement consulta = cn.prepareStatement(sql)) {

            consulta.setInt(1, objeto.getId_inventario());
            consulta.setInt(2, objeto.getCodigo_barra());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getDescription());
            consulta.setDouble(5, objeto.getPrecio_unitario());
            consulta.setInt(6, objeto.getStock());
            consulta.setString(7, objeto.getCategoria());
            consulta.setString(8, objeto.getFecha());
            consulta.setInt(9, id); // Establecer el ID para la cláusula WHERE

            respuesta = consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al editar producto: " + e.getMessage());
        }

        return respuesta;
    }

    // Método para eliminar libros
    public boolean eliminar(int id) {
        boolean respuesta = false;
        String sql = "DELETE FROM productos WHERE id_producto = ?";

        try (Connection cn = conexion.conexion.conectar();
             PreparedStatement consulta = cn.prepareStatement(sql)) {

            consulta.setInt(1, id); // Usar parámetro para evitar inyecciones SQL

            respuesta = consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }

        return respuesta;
    }
}

