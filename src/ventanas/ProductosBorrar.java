package ventanas;

import Constructores.ConsEmpleado;
import Constructores.ConsProducto;
import Constructores.ConsProveedor;
import clases.ProductosMet;
import clases.ProveedoresMet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static ventanas.ProveedorBorrar.esNumero;

/**
 *
 * @author puppe
 */
public class ProductosBorrar extends javax.swing.JInternalFrame {

    ConsProducto Produc = new ConsProducto();
    ProductosMet ProductosM = new ProductosMet();
    DefaultTableModel modelo;

    public ProductosBorrar() {
        initComponents();

        ListarProductos();

        //txtID.setText(""+ProveedoresM.numMaxim());
    }

    public void ListarProductos() {
        List<ConsProducto> ListarProductos = ProductosM.ListarProducto();
        modelo = (DefaultTableModel) tbProductos.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[5];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < ListarProductos.size(); i++) {
            obj[0] = ListarProductos.get(i).getId_producto();
            obj[1] = ListarProductos.get(i).getDescripcion();
            obj[2] = ListarProductos.get(i).getStock();
            obj[3] = ListarProductos.get(i).getPrecio_venta();
            obj[4] = ListarProductos.get(i).getPrecio_compra();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbProductos.setModel(modelo);
        tbProductos.setRowHeight(40);

    }
    
      public void BuscaPro(ConsProducto productos) {
        List<ConsProducto> BuscaProducto = ProductosM.BuscarProductos(productos);
        modelo = (DefaultTableModel) tbProductos.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[5];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < BuscaProducto.size(); i++) {
            obj[0] = BuscaProducto.get(i).getId_producto();
            obj[1] = BuscaProducto.get(i).getDescripcion();
            obj[2] = BuscaProducto.get(i).getStock();
            obj[3] = BuscaProducto.get(i).getPrecio_venta();
            obj[4] = BuscaProducto.get(i).getPrecio_compra();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbProductos.setModel(modelo);
        tbProductos.setRowHeight(40);

    }

    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarDatos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Eliminar Productos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoproduct.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 30), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Nombre o ID");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 32, -1, -1));

        txtID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 340, -1));

        btnBorrar.setBackground(new java.awt.Color(255, 255, 153));
        btnBorrar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, 40));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 130, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 130, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 640, 150));

        tbProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbProductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Descripcion ", "Stock", "Precio Venta", "Precio Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 800, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, -20, 210, 300));

        btnMostrarDatos.setBackground(new java.awt.Color(255, 255, 153));
        btnMostrarDatos.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnMostrarDatos.setForeground(new java.awt.Color(255, 0, 0));
        btnMostrarDatos.setText("Mostrar Datos");
        btnMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMostrarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 280, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public static boolean esNumero(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
   


    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
      if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios","Campos Vacios",JOptionPane.QUESTION_MESSAGE);

        } else {
            //Parseamos el id
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar","Confirmar Eliminacion", JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0) {

                if (esNumero(txtID.getText())) {
                    Long n = Long.parseLong(txtID.getText());
                    if (n <= 0) {
                        JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        ConsProducto Producto = new ConsProducto();
                        Long id_Producto = Long.parseLong(txtID.getText());
                        Producto.setId_producto(id_Producto);

                        ProductosM.EliminarProductos(Producto);
                    }

                } else {
                    ConsProducto Producto = new ConsProducto();
                    String nom = txtID.getText().toUpperCase();
                    Producto.setDescripcion(nom);
                     ProductosM.EliminarProductos(Producto);
                  

                }
                LimpiarTabla();
                ListarProductos();

                limpiar();
            }
        }


        

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

        int fila = tbProductos.rowAtPoint(evt.getPoint());

        txtID.setText(tbProductos.getValueAt(fila, 0).toString());
       


    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosActionPerformed
        
        LimpiarTabla();
        ListarProductos();
        
        
        
        
    }//GEN-LAST:event_btnMostrarDatosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo esta vacio","Campo Vacio",JOptionPane.QUESTION_MESSAGE);

        } else {

            if (esNumero(txtID.getText())) {
                Long n = Long.parseLong(txtID.getText());

                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                    txtID.setText("");
                    return;
                }  else {
                    ConsProducto produc = new ConsProducto();
                    Long id_Prove = Long.parseLong(txtID.getText());
                    produc.setId_producto(id_Prove);
                    LimpiarTabla();
                    BuscaPro(produc);

                    //ListarProveedor();
                    

                }

            } else if (!esNumero(txtID.getText())) {
                ConsProducto produc = new ConsProducto();
                String nom = txtID.getText().toUpperCase();
                produc.setDescripcion(nom);
                LimpiarTabla();
                BuscaPro(produc);

                //ListarProveedor();
                
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void limpiar() {
        txtID.setText("");
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
