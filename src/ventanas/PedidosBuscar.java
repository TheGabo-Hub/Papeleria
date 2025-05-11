package ventanas;

import Constructores.ConsPedidos;
import Constructores.ConsProducto;
import clases.PedidosMet;
import clases.ProductosMet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class PedidosBuscar extends javax.swing.JInternalFrame {

    ConsProducto Produc = new ConsProducto();
    ProductosMet ProductosM = new ProductosMet();
    ConsPedidos pedi = new ConsPedidos();
    PedidosMet pedidosM = new PedidosMet();
    DefaultTableModel modelo;

    public PedidosBuscar() {
        initComponents();
        ListarPedidos();
       

        //txtID.setText(""+ProveedoresM.numMaxim());
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
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiar1 = new javax.swing.JButton();

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
        setTitle("Buscar Pedidos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconopedi.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 28), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel8.setText("Id del Pedido");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 130, 40));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 130, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 630, 120));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 880, 290));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedidos3.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 190, 180));

        btnLimpiar1.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar1.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar1.setText("Mostrar Datos");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 210, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo esta Vacio","Campos Vacios",JOptionPane.QUESTION_MESSAGE);

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
            
            int id_pedido = Integer.parseInt(txtId.getText());
          
            
            LimpiarTabla();
            pedi.setId_pedido(id_pedido);
            BuscaPedidos(pedi);
            
            //ListarPedidos();
            limpiar();

        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
         limpiar();

        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMouseClicked
       
        int fila = tbPedidos.rowAtPoint(evt.getPoint());

        txtId.setText(tbPedidos.getValueAt(fila, 0).toString());
        
        
        
        
        
    }//GEN-LAST:event_tbPedidosMouseClicked

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        LimpiarTabla();
        ListarPedidos();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    
    
    private void limpiar() {
        //txtId.setText("");
       
        
        //txtPrecio_Venta.setText("");
        //txtPrecio_Compra.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
