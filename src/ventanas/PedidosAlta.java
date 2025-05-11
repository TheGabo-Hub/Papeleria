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
import static ventanas.ProductosBuscar.esNumero;

/**
 *
 * @author puppe
 */
public class PedidosAlta extends javax.swing.JInternalFrame {

    ConsProducto Produc = new ConsProducto();
    ProductosMet ProductosM = new ProductosMet();
    ConsPedidos pedi = new ConsPedidos();
    PedidosMet pedidosM = new PedidosMet();
    DefaultTableModel modelo;
    int num;

    public PedidosAlta() {
        initComponents();
        pedidosM.ChecarProveedor(ListaProveedor);
        pedidosM.ChecarProducto(ListaProducto);
         txtId.setText(""+pedidosM.numMaxim());
        ListarPedidos();
        fecha();
        hora();

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
        lblFecha = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtIDProducto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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
        setTitle("Alta de Pedidos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconopedi.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alta Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 28), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedidos1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 250, 190));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFecha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, 30));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, -1));

        jLabel11.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel11.setText("Proveedor");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        lblHora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 120, 30));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setText("Fecha ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 30));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel15.setText("Hora");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 50, 30));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setText("Precio");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 52, 60, -1));

        txtPrecio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 100, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setText("Cantidad");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 52, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 80, -1));

        jLabel16.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel16.setText("Producto");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel17.setText("Precio Total");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 155, -1, -1));

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel2.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, -1));

        txtPrecioTotal.setEditable(false);
        txtPrecioTotal.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        txtPrecioTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 150, 40));

        ListaProveedor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(ListaProveedor);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, 110));

        ListaProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane4.setViewportView(ListaProducto);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 200, 110));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setText("Id del Pedido");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 620, 240));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 130, 40));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 130, 40));

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
                false, false, false, false, false, false, false, false
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 880, 190));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("ID o nombre del producto");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel1.add(txtIDProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 340, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
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

        if (txtId.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty() || ListaProducto.getSelectedValue()==null ||  ListaProveedor.getSelectedValue()==null || txtPrecioTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios","Campos VACIOS", JOptionPane.QUESTION_MESSAGE);

        } else {
            if (!esEntero(txtId.getText())) {
                JOptionPane.showMessageDialog(null, "El campo ID debe ser un número entero","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtId.setText("");
                return; // Salir del método si la validación falla
            }
            if (Integer.parseInt(txtId.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos ","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtId.setText("");
                return; // Salir del método si la validación falla

            }
            if (!esEntero(txtCantidad.getText())) {
                JOptionPane.showMessageDialog(null, "El campo stock debe ser un número entero","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtCantidad.setText("");
                return; // Salir del método si la validación falla
            }
            

            if (!esFloat(txtPrecio.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio de venta debe ser un número.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtPrecio.setText("");
                return; // Salir del método si la validación falla
            }
            int id_pedido = Integer.parseInt(txtId.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            float precioUnidad = Float.parseFloat(txtPrecio.getText());
            float precioTotal = Float.parseFloat(txtPrecioTotal.getText());
            fecha(); //Actualiza la fecha
            hora();  // actualiza la hora
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
            

            pedidosM.RegistrarPedido(pedi);
            LimpiarTabla();
            ListarPedidos();
            limpiar();

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
         limpiar();

        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPedidosMouseClicked

    
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
     
        if (txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Los campos estan vacios","Campos Vacios",JOptionPane.QUESTION_MESSAGE);
            
        }else{
            if (!esEntero(txtCantidad.getText())) {
                JOptionPane.showMessageDialog(null, "El campo cantidad debe ser un número entero.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtCantidad.setText("");
                return; // Salir del método si la validación falla
            }
            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (!esFloat(txtPrecio.getText())) {
                JOptionPane.showMessageDialog(null, "El campo precio de venta debe ser un número.","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtPrecio.setText("");
                return; // Salir del método si la validación falla
            }
            float precio = Float.parseFloat(txtPrecio.getText());
            
            float precioTotal = cantidad*precio;
            txtPrecioTotal.setText(""+precioTotal);
            
        }
        
        
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
 
    
    }//GEN-LAST:event_txtIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtIDProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo esta vacio","Campo Vacio",JOptionPane.QUESTION_MESSAGE);

        } else {

            if (esNumero(txtIDProducto.getText())) {
                Long n = Long.parseLong(txtIDProducto.getText());

                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                    txtIDProducto.setText("");
                    return;
                }  else {
                    ConsProducto produc = new ConsProducto();
                    Long id_Prove = Long.parseLong(txtIDProducto.getText());
                    produc.setId_producto(id_Prove);
                    
                   
                 pedidosM.BuscaProducto(produc, ListaProducto);
  

                }

            } else if (!esNumero(txtIDProducto.getText())) {
                ConsProducto produc = new ConsProducto();
                String nom = txtIDProducto.getText().toUpperCase();
                produc.setDescripcion(nom);
               
                pedidosM.BuscaProducto(produc, ListaProducto);

            }

        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiar() {
       txtId.setText(""+pedidosM.numMaxim());
       txtIDProducto.setText("");
        txtPrecioTotal.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        ListaProducto.clearSelection();
        ListaProveedor.clearSelection();
        
        //txtPrecio_Venta.setText("");
        //txtPrecio_Compra.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaProducto;
    private javax.swing.JList<String> ListaProveedor;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
