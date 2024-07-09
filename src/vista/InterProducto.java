package vista;

import conexion.Conexion;
import controlador.Ctrl_Producto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Producto;


/**
 *
 * @author Fernando Davila
 */
public class InterProducto extends javax.swing.JInternalFrame {

    int obtenerIdCategoriaCombo = 0;
    
    public InterProducto() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("Nuevo producto");
        
        this.CargarComboCategorias();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jButton_guardar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Descripción:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Precio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Categoria:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IGV:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txt_cantidad.setBackground(new java.awt.Color(204, 255, 255));
        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        txt_precio.setBackground(new java.awt.Color(204, 255, 255));
        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        txt_descripcion.setBackground(new java.awt.Color(204, 255, 255));
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        txt_nombre.setBackground(new java.awt.Color(204, 255, 255));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        jComboBox_iva.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox_iva.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IGV:", "Sin IGV", "18%", "19%", "20%" }));
        getContentPane().add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jComboBox_categoria.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox_categoria.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, -1));

        jButton_guardar.setBackground(new java.awt.Color(51, 51, 255));
        jButton_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_guardar.setForeground(new java.awt.Color(204, 255, 255));
        jButton_guardar.setText("Guardar");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        
        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        
        String iva = "";
        String categoria = "";
        iva = jComboBox_iva.getSelectedItem().toString().trim();
        categoria = jComboBox_categoria.getSelectedItem().toString().trim();
                
        //Validar campos
        
        if(txt_nombre.getText().equals("") || txt_cantidad.getText().equals("") || txt_precio.getText().equals("") ){
            
            JOptionPane.showMessageDialog(null, "Complete todos los campos del formulario");
            txt_nombre.setBackground(Color.red);
            txt_cantidad.setBackground(Color.red);
            txt_precio.setBackground(Color.red);
            
            
        } else {
            //consulta para ver si esta registrado el producto
            if (!controlProducto.existeProducto(txt_nombre.getText().trim())) {
                
                if (iva.equalsIgnoreCase("Seleccione IGV:")) {
                    
                     JOptionPane.showMessageDialog(null, "Debe seleccionar un IGV");
                    
                } else {
                    
                    if (categoria.equalsIgnoreCase("Seleccione categoria: ")) {
                        
                        JOptionPane.showMessageDialog(null, "Seleccione una categoria");
                        
                    } else {
                        
                        try {
                            
                            producto.setNombre(txt_nombre.getText().trim());
                            producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));
                            String precioTXT = "";
                            double Precio = 0.0;
                            precioTXT = txt_precio.getText().trim();
                            boolean aux = false;
                            
                            //Si el usuario ingresa una coma (,) como punto decimal, lo transformamos a punto
                            for(int i = 0; i < precioTXT.length(); i++) {
                                
                                if (precioTXT.charAt(i) == ',') {
                                    
                                    String precioNuevo = precioTXT.replace(",", ".");
                                    Precio = Double.parseDouble(precioNuevo);
                                    aux = true;
                                    
                                }
                                
                            }
                            
                            //evaluamos la condicion
                            if (aux == true) {
                                
                                producto.setPrecio(Precio);
                                
                            } else {
                                
                                Precio = Double.parseDouble(precioTXT);
                                producto.setPrecio(Precio);
                                
                            }
                            
                            producto.setDescripcion(txt_descripcion.getText().trim());
                            //porcentaje de IGV
                            
                            if(iva.equalsIgnoreCase("Sin IGV")) {
                                
                                producto.setPorcentajeIva(0);
                                
                                
                            } else if(iva.equalsIgnoreCase("18%")) {
                                
                                producto.setPorcentajeIva(18);
                                
                            } else if(iva.equalsIgnoreCase("19%")) {
                                
                                producto.setPorcentajeIva(19);
                                
                            
                            } else if(iva.equalsIgnoreCase("20%")) {
                                
                                producto.setPorcentajeIva(20);
                                
                            }
                            
                            
                            //Enviamos el id de la categoria mediante el metodo ""
                            this.idCategoria();
                            producto.setIdCategoria(obtenerIdCategoriaCombo);
                            producto.setEstado(1);
                            
                            if(controlProducto.guardar(producto)){
                                
                                 JOptionPane.showMessageDialog(null, "Producto guardado correctamente");
                                 txt_nombre.setBackground(Color.green);
                                 txt_cantidad.setBackground(Color.green);
                                 txt_precio.setBackground(Color.green);
                                 txt_descripcion.setBackground(Color.green);
                                 
                                 this.jComboBox_iva.setSelectedItem("Seleccione IGV:");
                                 this.jComboBox_categoria.setSelectedItem("Seleccione categoria:");
                                 this.Limpiar();
            
                            } else {
                                
                                 JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                                
                            }
                            
                            
                        } catch (HeadlessException | NumberFormatException e) {
                            
                            System.out.println("Error en: "+ e);
                            
                        }
                        
                    }
                    
                }
                
            } else {
                
                JOptionPane.showMessageDialog(null, "El producto ya existe en la base de datos");
                
            }
            
            
        }
        
    }//GEN-LAST:event_jButton_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

    
    //Metodo para limpiar los campos
    private void Limpiar() {
        
        txt_nombre.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
        
        
    }

    //Metodo para cargar categorias al combobox
    private void CargarComboCategorias() {
        
        Connection cn = Conexion.conectar();
        String sql = "SELECT*FROM tb_categoria";
        Statement st;
        
        try {
            
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria:");
            
            while(rs.next()){
                
                jComboBox_categoria.addItem(rs.getString("descripcion"));
                
            }
            cn.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error al cargar las categorias");
            
        }
        
        
    }
    
    
    
    
    //metodo para obtner idCtegoria
    
    private int idCategoria() {
        
        String sql = "SELECT*FROM tb_categoria WHERE descripcion='" + this.jComboBox_categoria.getSelectedItem() + "'";
        Statement st;
        
        try {
            
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
                
            }
            
            
        } catch (SQLException e) {
            
            System.out.println("Error al obtener el id de categoria");
        }
        
        return obtenerIdCategoriaCombo;
    }

}
