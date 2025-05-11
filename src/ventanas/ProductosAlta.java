package ventanas;

import Constructores.ConsProducto;
import clases.ProductosMet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class ProductosAlta extends javax.swing.JInternalFrame {

    ConsProducto Produc = new ConsProducto();
    ProductosMet ProductosM = new ProductosMet();
    DefaultTableModel modelo;

    public ProductosAlta() {
        initComponents();

        ListarProductos();
        lblValidar.setEnabled(false);

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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio_Compra = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPrecio_Venta = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblValidar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

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
        setTitle("Alta de Productos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoproduct.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alta Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 30), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setText("Precio Compra");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 222, 140, 20));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Id del Producto");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setText("Stock");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 122, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setText("Precio Venta");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 172, 120, -1));

        txtPrecio_Compra.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPrecio_Compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtPrecio_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 110, -1));

        txtID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 190, -1));

        txtStock.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        jPanel2.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 110, -1));

        txtPrecio_Venta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPrecio_Venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtPrecio_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 110, -1));

        txtDescripcion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 330, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setText("Descripcion");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 72, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Validar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        lblValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        jPanel2.add(lblValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 130, 40));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 130, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 530, 270));

        tbProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbProductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Descripcion", "Stock", "Precio Venta", "Precio Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbProductos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 350, 850, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos1png.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 280, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean esEntero(String texto) {
        try {
            Long.parseLong(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esFloat(String texto) {
        try {
            Float.parseFloat(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (txtID.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtStock.getText().isEmpty() || txtPrecio_Venta.getText().isEmpty() || txtPrecio_Compra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios", "Campos Vacios", JOptionPane.QUESTION_MESSAGE);

        } else {
            if (!esEntero(txtID.getText())) {
                JOptionPane.showMessageDialog(null, "El campo ID debe ser un número entero.", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla
            }
            if (Long.parseLong(txtID.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos.", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla

            }
            Long id = Long.parseLong(txtID.getText());
            String nombre = txtDescripcion.getText().toUpperCase();

            if (!esEntero(txtStock.getText())) {
                JOptionPane.showMessageDialog(null, "El campo stock debe ser un número entero.", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtStock.setText("");
                return; // Salir del método si la validación falla
            }
            int stock = Integer.parseInt(txtStock.getText());

            if (!esFloat(txtPrecio_Venta.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio de venta debe ser un número.", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtPrecio_Venta.setText("");
                return; // Salir del método si la validación falla
            }
            float precio_venta = Float.parseFloat(txtPrecio_Venta.getText());

            if (!esFloat(txtPrecio_Compra.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio de compra debe ser un número.", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtPrecio_Compra.setText("");
                return; // Salir del método si la validación falla
            }
            float precio_compra = Float.parseFloat(txtPrecio_Compra.getText());

            Produc.setId_producto(id);
            Produc.setDescripcion(nombre);
            Produc.setStock(stock);
            Produc.setPrecio_venta(precio_venta);
            Produc.setPrecio_compra(precio_compra);

            // Comprueba si ya se inserto
            boolean v;
            v = ProductosM.RegistrarProducto(Produc);
            if (v) {
                JOptionPane.showMessageDialog(null, "Producto Registrado con exito");
                LimpiarTabla();
                ListarProductos();
                limpiar();
            } else {
                txtID.setText("");
            }

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // Hacer el metodo para validar si se puede registrar un producto


    }//GEN-LAST:event_txtIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ConsProducto producto = new ConsProducto();

        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL campo esta vacio", "Campos Vacios", JOptionPane.QUESTION_MESSAGE);

        } else {

            if (!esEntero(txtID.getText())) {
                JOptionPane.showMessageDialog(null, "El campo ID debe ser un número entero.", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla
            }
            if (Long.parseLong(txtID.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos ", "Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla

            }
            boolean band;
            Long id = Long.parseLong(txtID.getText());
            producto.setId_producto(id);
            // Si es true es que el producto ya existe y si no es que se puede guardar
            band = ProductosM.validarP(producto);
            // Hacer un metodo para valiadar si hay producto dado de alta
            if (band) {

                lblValidar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Id ya registrado, no se puede registrar", "Error", JOptionPane.ERROR_MESSAGE);
                txtID.setText("");

            } else {
                lblValidar.setEnabled(true);

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void limpiar() {
        txtID.setText("");
        txtDescripcion.setText("");
        txtStock.setText("");
        txtPrecio_Venta.setText("");
        txtPrecio_Compra.setText("");
        lblValidar.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblValidar;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPrecio_Compra;
    private javax.swing.JTextField txtPrecio_Venta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
