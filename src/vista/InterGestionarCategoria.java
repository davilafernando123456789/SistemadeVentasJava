
package vista;

import conexion.Conexion;
import controlador.Ctrl_Categoria;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Categoria;


/**
 *
 * @author Fernando Davila
 */
public class InterGestionarCategoria extends javax.swing.JInternalFrame {
    
    private int idCategoria;


    public InterGestionarCategoria() {
        
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setTitle("Gestionar categoria");
        
        this.CargarTablaCategoria();

        
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_categorias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Categorias");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_categorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_categorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 250));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 102, 255));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(204, 255, 255));
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(204, 0, 0));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(204, 255, 255));
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 150, 80));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Descripcion");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_descripcion.setBackground(new java.awt.Color(204, 255, 255));
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 190, 80));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //boton de actualizar
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        
        if(!txt_descripcion.getText().isEmpty()) {
            
            Categoria categoria = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
            
            categoria.setDescripcion(txt_descripcion.getText().trim());
            
            if (controlCategoria.actualizar(categoria, idCategoria)) {
                
                JOptionPane.showMessageDialog(null, "Categoria actualizada correctamenta");
                //limpiamos el text field
                txt_descripcion.setText("");
                //Mostramos nuevamente los registros
                this.CargarTablaCategoria();
                
            } else {
                
                JOptionPane.showMessageDialog(null, "Error al actualizar categoria");
                
            }
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
            
        }
        
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    //boton de eliminar
    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        
        if(!txt_descripcion.getText().isEmpty()) {
            
            Categoria categoria = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
            
            categoria.setDescripcion(txt_descripcion.getText().trim());
            
            if (!controlCategoria.eliminar(idCategoria)) {
                
                JOptionPane.showMessageDialog(null, "Categoria eliminada correctamenta");
                //limpiamos el text field
                txt_descripcion.setText("");
                //Mostramos nuevamente los registros
                this.CargarTablaCategoria();
                
            } else {
                
                JOptionPane.showMessageDialog(null, "Error al eliminar categoria");
                
            }
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
            
        }
        
        
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_categorias;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables

    
    //Metodo para mostrar todas las categorias
    private void CargarTablaCategoria() {
        
        
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql="SELECT idCategoria, descripcion, estado FROM tb_categoria";
        Statement st;
        
        
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarCategoria.jTable_categorias = new JTable(model);
            InterGestionarCategoria.jScrollPane1.setViewportView(InterGestionarCategoria.jTable_categorias);
            
            model.addColumn("idCategoria");
            model.addColumn("Descripcion");
            model.addColumn("Estado");
            
            while(rs.next()) {
                
                Object fila[] = new Object[3];
                
                for(int i = 0; i <3 ; i++) {
                    
                    fila[i] = rs.getObject(i + 1);
                    
                }
                model.addRow(fila);
                
            }
            con.close();
            
            
        } catch (SQLException e){
            
            
            System.out.println("Error al llenar la tabla categoria: " + e);
            
        }
        
        jTable_categorias.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent e) {
                
                int fila_point = jTable_categorias.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if(fila_point > -1) {
                    
                    idCategoria = (int) model.getValueAt(fila_point, columna_point);
                    
                    EnviarDatosCategoriaSeleccionada(idCategoria);
                    
                    
                } else {
                    
                    
                    
                }
            }
        
        });
        
        
        
    }
    
    
    private void EnviarDatosCategoriaSeleccionada(int idCategoria) {
        
        try {
        
             Connection con = Conexion.conectar();
             PreparedStatement pst = con.prepareStatement(
                     "SELECT*FROM tb_categoria WHERE idcategoria = '"+ idCategoria + "' ");
             
             ResultSet rs = pst.executeQuery();
             
             
             if(rs.next()){
                 
                 txt_descripcion.setText(rs.getString("descripcion"));
                 
             }
             
             con.close();
             
             
             
        } catch (SQLException e) {
        
            System.out.println("Error al seleccionar categoria: " + e);
        
        }
        
        
    }
    

}
