package ventanas;

import Constructores.ConsEmpleado;
import Constructores.ConsProveedor;
import clases.ProveedoresMet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class ProveedorBorrar extends javax.swing.JInternalFrame {

    ConsProveedor Provee = new ConsProveedor();
    ProveedoresMet ProveedoresM = new ProveedoresMet();
    DefaultTableModel modelo;

    public ProveedorBorrar() {
        initComponents();

        ListarProveedor();

    }

    public void ListarProveedor() {
        List<ConsProveedor> ListarEmpleado = ProveedoresM.ListarProveedor();
        modelo = (DefaultTableModel) tbProveedor.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[5];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < ListarEmpleado.size(); i++) {
            obj[0] = ListarEmpleado.get(i).getId_proveedor();
            obj[1] = ListarEmpleado.get(i).getNombre();
            obj[2] = ListarEmpleado.get(i).getTelefono();
            obj[3] = ListarEmpleado.get(i).getCorreo();
            obj[4] = ListarEmpleado.get(i).getDireccion();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbProveedor.setModel(modelo);
        tbProveedor.setRowHeight(40);

    }

    public void BuscaPro(ConsProveedor pr) {
        List<ConsProveedor> BuscaPro = ProveedoresM.BuscarProveedor(pr);
        modelo = (DefaultTableModel) tbProveedor.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[5];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < BuscaPro.size(); i++) {
            obj[0] = BuscaPro.get(i).getId_proveedor();
            obj[1] = BuscaPro.get(i).getNombre();
            obj[2] = BuscaPro.get(i).getTelefono();
            obj[3] = BuscaPro.get(i).getCorreo();
            obj[4] = BuscaPro.get(i).getDireccion();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbProveedor.setModel(modelo);

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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProveedor = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();

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
        setTitle("Eliminar Proveedores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoprovee.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar Proveedores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 26), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/elimprove2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, 240));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel8.setText("Nombre o ID");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, -1, 30));

        txtID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 45, 320, 30));

        btnBorrar.setBackground(new java.awt.Color(255, 255, 153));
        btnBorrar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, 40));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/elimprove.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 110, 110));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 640, 220));

        tbProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_proveedor", "nombre", "telefono", "correo", "direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProveedor);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 300, 900, 200));

        btnBuscar1.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar1.setText("Mostrar Datos");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public static boolean esNumero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL campo esta vacio","Campo VACIO", JOptionPane.QUESTION_MESSAGE);

        } else {
            //Parseamos el id
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar","Confirmar Eliminacion", JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0) {

                if (esNumero(txtID.getText())) {
                    int n = Integer.parseInt(txtID.getText());
                    if (n <= 0) {
                        JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {
                        ConsProveedor Proveedor = new ConsProveedor();
                        int id_Prove = Integer.parseInt(txtID.getText());
                        Proveedor.setId_proveedor(id_Prove);

                        ProveedoresM.EliminarProveedor(Proveedor);
                    }

                } else {
                    ConsProveedor Proveedor = new ConsProveedor();
                    String nom = txtID.getText().toUpperCase();
                    Proveedor.setNombre(nom);
                    ProveedoresM.EliminarProveedor(Proveedor);
                    
                }
                LimpiarTabla();
                ListarProveedor();

                limpiar();
            }
        }


    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProveedorMouseClicked

        int fila = tbProveedor.rowAtPoint(evt.getPoint());

        txtID.setText(tbProveedor.getValueAt(fila, 0).toString());


    }//GEN-LAST:event_tbProveedorMouseClicked

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        LimpiarTabla();
        ListarProveedor();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo esta vacio","Campo VACIO", JOptionPane.QUESTION_MESSAGE);

        } else {
            //Parseamos el id

            if (esNumero(txtID.getText())) {

                int n = Integer.parseInt(txtID.getText());
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                    txtID.setText("");
                    return;
                } else {
                    ConsProveedor Proveed = new ConsProveedor();
                    int id_Provee = Integer.parseInt(txtID.getText());
                    Proveed.setId_proveedor(id_Provee);
                    LimpiarTabla();
                    BuscaPro(Proveed);
                }

            } else {
                ConsProveedor proveed = new ConsProveedor();
                String nom = txtID.getText().toUpperCase();
                proveed.setNombre(nom);
                LimpiarTabla();
                BuscaPro(proveed);

                //ListarProveedor();
                
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void limpiar() {
        txtID.setText("");
        /*txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
         */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbProveedor;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
