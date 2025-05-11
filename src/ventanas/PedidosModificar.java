package ventanas;

import Constructores.ConsPedidos;
import Constructores.ConsProducto;
import clases.PedidosMet;
import clases.ProductosMet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class PedidosModificar extends javax.swing.JInternalFrame {

    ConsProducto Produc = new ConsProducto();
    ProductosMet ProductosM = new ProductosMet();
    ConsPedidos pedi = new ConsPedidos();
    PedidosMet pedidosM = new PedidosMet();
    DefaultTableModel modelo;

    public PedidosModificar() {
        initComponents();
        pedidosM.ChecarProveedor(ListaProveedor);
        pedidosM.ChecarProducto(ListaProducto);
        ListarPedidos();
        fecha();
        hora();

        //txtID.setText(""+ProveedoresM.numMaxim());
    }

     public void BuscaPedidos(ConsPedidos pedidos) {
        List<ConsPedidos> BuscaPedidos = pedidosM.BuscarPedidos(pedidos);
        modelo = (DefaultTableModel) tbPedidos.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[8];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < BuscaPedidos.size(); i++) {
            obj[0] = BuscaPedidos.get(i).getId_pedido();
            obj[1] = BuscaPedidos.get(i).getId_proveedor();
            obj[2] = BuscaPedidos.get(i).getId_producto();
            obj[3] = BuscaPedidos.get(i).getCantidad_producto();
            obj[4] = BuscaPedidos.get(i).getPrecio_unidad();
            obj[5] = BuscaPedidos.get(i).getPrecio_total();
            obj[6] = BuscaPedidos.get(i).getFecha();
            obj[7] = BuscaPedidos.get(i).getHora();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbPedidos.setModel(modelo);
    }
    public void ListarPedidos() {
        List<ConsPedidos> ListarPedidos = pedidosM.ListarPedidos();
        modelo = (DefaultTableModel) tbPedidos.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[8];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < ListarPedidos.size(); i++) {
            obj[0] = ListarPedidos.get(i).getId_pedido();
            obj[1] = ListarPedidos.get(i).getId_proveedor();
            obj[2] = ListarPedidos.get(i).getId_producto();
            obj[3] = ListarPedidos.get(i).getCantidad_producto();
            obj[4] = ListarPedidos.get(i).getPrecio_unidad();
            obj[5] = ListarPedidos.get(i).getPrecio_total();
            obj[6] = ListarPedidos.get(i).getFecha();
            obj[7] = ListarPedidos.get(i).getHora();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbPedidos.setModel(modelo);
        tbPedidos.setRowHeight(40);


    }

    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }

    }
    
    
    

    public void fecha() {
        String fecha;
        try {
            LocalDate fechaActual = LocalDate.now();
            fecha = fechaActual.toString();
            lblFecha.setText(fecha);
        } catch (Exception e) {

        }
    }

    public void hora() {
        String hora;
        try {
            LocalTime horaActual = LocalTime.now();
            // Extraer horas, minutos y segundos
            int horas = horaActual.getHour();
            int minutos = horaActual.getMinute();
            int segundos = horaActual.getSecond();

            hora = String.format("%02d:%02d:%02d", horas, minutos, segundos);
            lblHora.setText(hora);
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioUnidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        txtPrecioTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListaProveedor = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaProducto = new javax.swing.JList<>();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        btnLimpiar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIDBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

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
        setTitle("Modificar Pedidos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconopedi.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 30), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedidos4.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 210, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Id del Pedido");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblFecha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 120, 20));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        jLabel11.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel11.setText("Proveedor");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        lblHora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 120, 30));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setText("Fecha ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel15.setText("Hora");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, 30));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setText("Precio");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 60, -1));

        txtPrecioUnidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPrecioUnidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtPrecioUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 100, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setText("Cantidad");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 80, -1));

        jLabel16.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel16.setText("Producto");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel17.setText("Precio Total");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel2.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, -1));

        txtPrecioTotal.setEditable(false);
        txtPrecioTotal.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        txtPrecioTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioTotalActionPerformed(evt);
            }
        });
        jPanel2.add(txtPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 40));

        ListaProveedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(ListaProveedor);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, 110));

        ListaProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ListaProducto.setToolTipText("");
        jScrollPane4.setViewportView(ListaProducto);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 200, 110));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 630, 240));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 40, 130, 40));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 0, 0));
        btnAgregar.setText("Actualizar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 170, 40));

        tbPedidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbPedidos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "ID Proveedor", "ID Producto", "Cantidad Producto", "Precio Unidad", "Precio Total", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPedidos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 960, 190));

        btnLimpiar1.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar1.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar1.setText("Mostrar Datos");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 210, 40));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel9.setText("ID del pedido");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txtIDBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtIDBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtIDBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 120, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean esEntero(String texto) {
        try {
            Integer.parseInt(texto);
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

        if (txtId.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtPrecioUnidad.getText().isEmpty() || ListaProducto.getSelectedValue()==null ||  ListaProveedor.getSelectedValue()==null || txtPrecioTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios","Campos Vacios",JOptionPane.QUESTION_MESSAGE);

        } else {
            if (!esEntero(txtId.getText())) {
                JOptionPane.showMessageDialog(null, "El campo ID debe ser un número entero.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtId.setText("");
                return; // Salir del método si la validación falla
            }
            if (Integer.parseInt(txtId.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtId.setText("");
                return; // Salir del método si la validación falla

            }
            if (!esEntero(txtCantidad.getText())) {
                JOptionPane.showMessageDialog(null, "El campo stock debe ser un número entero.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtCantidad.setText("");
                return; // Salir del método si la validación falla
            }
            

            if (!esFloat(txtPrecioUnidad.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio de venta debe ser un número.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtPrecioUnidad.setText("");
                return; // Salir del método si la validación falla
            }
            int id_pedido = Integer.parseInt(txtId.getText());
             int cantidad = Integer.parseInt(txtCantidad.getText());
            float precioUnidad = Float.parseFloat(txtPrecioUnidad.getText());
            float precioTotal = Float.parseFloat(txtPrecioTotal.getText());
            String fecha=lblFecha.getText();
            String hora = lblHora.getText();
            

            

           
            // Lista de los nombres proveedores y productos
           
            
            // Aqui obtengo el nombre de los proveedores y productos seleccionados en el scrollpane
             String nombreProveedor = ListaProveedor.getSelectedValue();
             String nombreProducto = ListaProducto.getSelectedValue();
             
            int id_proveedor;
            Long id_producto ;
            id_proveedor=pedidosM.ChecarIdProveedor(nombreProveedor);
            id_producto=pedidosM.ChecarIdProducto(nombreProducto);

        // Obtener el elemento seleccionado
     
            //Produc.setDescripcion(nombre);
            //Produc.setStock(stock);
            //Produc.setPrecio_venta(precio_venta);
            //Produc.setPrecio_compra(precio_compra);
            pedi.setId_pedido(id_pedido);
            pedi.setId_proveedor(id_proveedor);
            pedi.setId_producto(id_producto);
            pedi.setCantidad_producto(cantidad);
            pedi.setPrecio_unidad(precioUnidad);
            pedi.setPrecio_total(precioTotal);
            pedi.setFecha(fecha);
            pedi.setHora(hora);
            

            pedidosM.ModificarPedido(pedi);
            LimpiarTabla();
            ListarPedidos();
            limpiar();

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
         limpiar();
         tbPedidos.clearSelection();

        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMouseClicked
       
        int fila = tbPedidos.rowAtPoint(evt.getPoint());

        txtId.setText(tbPedidos.getValueAt(fila, 0).toString());
        txtCantidad.setText(tbPedidos.getValueAt(fila, 3).toString());
        txtPrecioUnidad.setText(tbPedidos.getValueAt(fila, 4).toString());
        
        // Vamos a obtener el id del producto primero
        Long id_producto=(Long) (tbPedidos.getValueAt(fila, 2));
        System.out.println(id_producto);
        
        int id_proveedor=(int)(tbPedidos.getValueAt(fila, 1));
        
        pedidosM.VerSeleccionadoProducto(id_producto,ListaProducto);
        pedidosM.VerSeleccionadoProveedor(id_proveedor,ListaProveedor);
        
        
       fecha();
       hora();
 
    }//GEN-LAST:event_tbPedidosMouseClicked

    
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
     
        if (txtCantidad.getText().isEmpty() || txtPrecioUnidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Los campos estan vacios","Campos Vacios",JOptionPane.QUESTION_MESSAGE);
            
        }else{
            if (!esEntero(txtCantidad.getText())) {
                JOptionPane.showMessageDialog(null, "El campo cantidad debe ser un número entero.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtCantidad.setText("");
                return; // Salir del método si la validación falla
            }
            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (!esFloat(txtPrecioUnidad.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio de venta debe ser un número.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtPrecioUnidad.setText("");
                return; // Salir del método si la validación falla
            }
            float precio = Float.parseFloat(txtPrecioUnidad.getText());
            
            float precioTotal = cantidad*precio;
            txtPrecioTotal.setText(""+precioTotal);
            
        }
        
        
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtPrecioTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioTotalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (txtIDBuscar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios","Campos Vacios",JOptionPane.QUESTION_MESSAGE);

        } else {
            if (!esEntero(txtIDBuscar.getText())) {
                JOptionPane.showMessageDialog(null, "El campo ID debe ser un número entero.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtIDBuscar.setText("");
                return; // Salir del método si la validación falla
            }
            if (Integer.parseInt(txtIDBuscar.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtIDBuscar.setText("");
                return; // Salir del método si la validación falla

            }

            int id_pedido = Integer.parseInt(txtIDBuscar.getText());

            LimpiarTabla();
            pedi.setId_pedido(id_pedido);
            BuscaPedidos(pedi);

            //ListarPedidos();
            limpiar();

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        LimpiarTabla();
        ListarPedidos();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void limpiar() {
        txtId.setText("");
        txtIDBuscar.setText("");
        txtPrecioTotal.setText("");
        txtCantidad.setText("");
        txtPrecioUnidad.setText("");
        ListaProducto.clearSelection();
        ListaProveedor.clearSelection();
        
        //txtPrecio_Venta.setText("");
        //txtPrecio_Compra.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaProducto;
    private javax.swing.JList<String> ListaProveedor;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIDBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrecioTotal;
    private javax.swing.JTextField txtPrecioUnidad;
    // End of variables declaration//GEN-END:variables
}
