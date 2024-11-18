package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.inventario;

public class Inventario {
    //Metodo para registrar libros 

    public boolean guardar(inventario objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("insert into lista_libros values(?,?,?,?,?,?,?)");
            consulta.setInt(1, objeto.getId_inventario());
            consulta.setInt(2, objeto.getCodigo_barra());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getDescription());
            consulta.setDouble(5, objeto.getPrecio_unitario());
            consulta.setInt(6, objeto.getStock());
            consulta.setString(7, objeto.getCategoria());
            consulta.setString(8, objeto.getFecha());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Libro " + e);
        }

        return respuesta;

    }
    //aqui va  // ,int id

    public boolean editar(inventario objeto, int id) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("update lista_libros set titulo = ?, autor = ?, numero_paginas = ?, codigo = ?, stock = ?, precioU = ? where id_libro ='" + id + "'");

            consulta.setInt(1, objeto.getId_inventario());
            consulta.setInt(2, objeto.getCodigo_barra());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getDescription());
            consulta.setDouble(5, objeto.getPrecio_unitario());
            consulta.setInt(6, objeto.getStock());
            consulta.setString(7, objeto.getCategoria());
            consulta.setString(8, objeto.getFecha());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Libro " + e);
        }

        return respuesta;

    }

    public boolean eliminar(Inventario objeto, int id) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("delete from lista_libros where id_libro ='" + id + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;

            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar Libro " + e);
        }

        return respuesta;

    }

    //SI SE REQUIERE CONSULTAR CATEGORIA
    //public boolean existeCategoria(String inventario) {
    //  boolean respuesta = false;
    // String sql="select autor from lista_libros where autor ='"+inventario+"';";
    // Statement st;
    // try {
    //   Connection cn = Conexion.conectar();
    //  st=cn.createStatement();
    //  ResultSet rs= st.executeQuery(sql);
    // while(rs.next()){
    //   respuesta = true;
    //  }
    //  } catch (SQLException e) {
    //    System.out.println("Error al consultar Libro " + e);
    //   }
    //  return respuesta;
    // }
}
