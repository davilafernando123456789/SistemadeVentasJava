/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.InterFacturacion;

/**
 *
 * @author Fernando Davila
 */
public class VentaPDF {

    private String nombreCliente;
    private String cedulaCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private String fechaActual = "";
    private String nombreArchivoPDFVenta;

    //metodos
    public void DatosCliente(int IdCliente) {

        Connection cn = Conexion.conectar();
        String sql = "SELECT*FROM tb_cliente WHERE idCliente = '" + IdCliente + "'";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                cedulaCliente = rs.getString("cedula");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");

            }
            cn.close();

        } catch (SQLException e) {

            System.out.println("Error al obtener los datos del cliente" + e);
        }

    }

    //metodo para generar la factura
    public void generarFacturaPDF() {

        try {

            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String fechaNueva = "";

            for (int i = 0; i < fechaActual.length(); i++) {

                if (fechaActual.charAt(i) == '/') {

                    fechaNueva = fechaActual.replace("/", "_");

                }

            }

            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);

            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/img/ventas.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.CYAN);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");

            //diseñamos la tabla
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregamos las celdas
            Encabezado.addCell(img);

            String ruc = "7896541232";
            String nombre = "Jose Davila";
            String telefono = "9874563212";
            String direccion = "Av. Los Angeles";
            String razon = "FERNANDO";

            Encabezado.addCell("");
            Encabezado.addCell("ruc: " + ruc + "\nNombre: " + nombre + "\nTelefono: " + telefono + "\nDirección: " + direccion + "\nRazon Social: ");
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //Cuerpo del pdf
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            //datos del cliente
            PdfPTable tableCliente = new PdfPTable(4);
            tableCliente.setWidthPercentage(100);
            tableCliente.getDefaultCell().setBorder(0);

            //tamaños de las celdas de la tabla
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tableCliente.setWidths(ColumnaCliente);
            tableCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Dirección: ", negrita));

            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            tableCliente.addCell(cliente1);
            tableCliente.addCell(cliente2);
            tableCliente.addCell(cliente3);
            tableCliente.addCell(cliente4);

            tableCliente.addCell(cedulaCliente);
            tableCliente.addCell(nombreCliente);
            tableCliente.addCell(telefonoCliente);
            tableCliente.addCell(direccionCliente);

            //agregamos al documento
            doc.add(tableCliente);

            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //agregamos los productos
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0);
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProductos.setWidths(ColumnaProducto);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripción: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio total: ", negrita));

            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);

            producto1.setBackgroundColor(BaseColor.BLACK);
            producto2.setBackgroundColor(BaseColor.BLACK);
            producto3.setBackgroundColor(BaseColor.BLACK);
            producto4.setBackgroundColor(BaseColor.BLACK);

            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);

            for (int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++) {

                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();

                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(producto);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(total);

            }

            doc.add(tablaProductos);
            //total a pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + InterFacturacion.txt_total_pagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add(" Cancelcion y firma\n\n");
            firma.add("______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //mensaje final
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add(" Gracias por su compra ");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //cerramos el documento
            doc.close();
            archivo.close();
            //abrir pdf automaticamente
            Desktop.getDesktop().open(file);
            

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);

        }

    }
}
