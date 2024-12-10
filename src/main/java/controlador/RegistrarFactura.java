package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import InternalView.Factura;

public class RegistrarFactura {
    private String numeroF;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String ci;

    private String fecha = "";
    private String nombrePDF = "";

    public void Datos(int id) {
        Connection cn = conexion.conexion.conectar();
        String sql = "select*from clientes where id_cliente= '" + id + "'";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                numeroF = rs.getString("id_cliente");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                correo = rs.getString("correo");
                telefono = rs.getString("telefono");
                ci = rs.getString("ci");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("ERROR AL OBTENER DATOS" + e);
        }
    }

    public void generarPDF() {
        try {
            //fecha actual
            Date date = new Date();
            fecha = new SimpleDateFormat("yyyy/MM/dd").format(date);
            fecha = fecha.replace("/", "_"); // Cambiar la variable a la correcta

            nombrePDF = "Venta_" + nombre + "_" + apellido + "_" + fecha + ".pdf";

            FileOutputStream archivo;
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            File file = new File(desktopPath + nombrePDF);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

// Agregar encabezado
            Paragraph fechas = new Paragraph();
            Font negr = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fechas.add("Nota de venta: " + numeroF + "\nFecha: " + fecha + "\n\n");
            doc.add(fechas); // Asegúrate de agregar el párrafo al documento

// Encabezado de la tabla
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
// Datos de la bodega
            String rucE = "Ruc bodega";
            String nombreE = "Bodega";
            String telefonoE = "telefono bodega";
            String direccionE = "Direccion bodega";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + rucE + "\nNombre: " + nombreE + "\nTelefono: " + telefonoE + "\nDireccion: " + direccionE);
            Encabezado.addCell(fechas);
            doc.add(Encabezado); // Asegúrate de agregar la tabla al documento

            //Cuerpo
            Paragraph datos = new Paragraph();
            datos.add(Chunk.NEWLINE);
            datos.add("DATOS: " + "\n\n");
            doc.add(datos);

            //datos cliente
            PdfPTable clienteDatos = new PdfPTable(5);
            clienteDatos.setWidthPercentage(100);
            clienteDatos.getDefaultCell().setBorder(0);

            float[] ColumnaCliente = new float[]{20f, 20f, 20f, 20f, 20f};
            clienteDatos.setWidths(ColumnaCliente);
            clienteDatos.setHorizontalAlignment(Element.ALIGN_LEFT);

            PdfPCell cliente1 = new PdfPCell(new Phrase("Cedula/Ruc: ", negr));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negr));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Apellido: ", negr));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Correo: ", negr));
            PdfPCell cliente5 = new PdfPCell(new Phrase("Telefono: ", negr));

            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            cliente5.setBorder(0);

            clienteDatos.addCell(cliente1);
            clienteDatos.addCell(cliente2);
            clienteDatos.addCell(cliente3);
            clienteDatos.addCell(cliente4);
            clienteDatos.addCell(cliente5);
            clienteDatos.addCell(ci);
            clienteDatos.addCell(nombre);
            clienteDatos.addCell(apellido);
            clienteDatos.addCell(correo);
            clienteDatos.addCell(telefono);

            doc.add(clienteDatos);

            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            PdfPTable productos = new PdfPTable(4);

            productos.setWidthPercentage(100);
            productos.getDefaultCell().setBorder(0);

            float[] ColumnaProductos = new float[]{25f, 45f, 30f, 40f};
            productos.setWidths(ColumnaProductos);
            productos.setHorizontalAlignment(Element.ALIGN_LEFT);

            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negr));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descipcion: ", negr));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negr));
            PdfPCell producto4 = new PdfPCell(new Phrase("PrecioTotal: ", negr));

            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);

            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);

            productos.addCell(producto1);
            productos.addCell(producto2);
            productos.addCell(producto3);
            productos.addCell(producto4);

            for (int i = 0; i < Factura.visor.getRowCount(); i++) {
                String cantidad = Factura.visor.getValueAt(i, 1).toString();
                String producto = Factura.visor.getValueAt(i, 2).toString();
                String precio = Factura.visor.getValueAt(i, 3).toString();
                String total = Factura.visor.getValueAt(i, 4).toString();

                productos.addCell(producto);
                productos.addCell(cantidad);
                productos.addCell(precio);
                productos.addCell(total);

            }

            doc.add(productos);

            //total a pagar
            Paragraph info = new Paragraph();

            info.add(Chunk.NEWLINE);
            info.add("Subtotal: " +Factura.txt_subtotal.getText());
            info.add(Chunk.NEWLINE);
            info.add("Iva: " + Factura.clc_iva.getText() + "%\n\n");
            info.add("Total a pagar: " + Factura.txt_total.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma Autorizada\n\n");
            firma.add("________________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por la Compra");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("ERROR AL GENERAR PDF " + e);
        }

    }

}
