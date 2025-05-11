package ventanas;

import Constructores.ConsProveedor;
import clases.ProveedoresMet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class ProveedorModificar extends javax.swing.JInternalFrame {

    ConsProveedor Provee = new ConsProveedor();
    ProveedoresMet ProveedoresM = new ProveedoresMet();
    DefaultTableModel modelo;

    public ProveedorModificar() {
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProveedor = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtProveedorBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
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
        setTitle("Proveedor Modificar");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoprovee.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar Proveedores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 26), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prove3.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 210, 190));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setText("Direccion ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Id del proveedor");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setText("Telefono");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setText("Correo");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 320, -1));

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 80, -1));

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 320, -1));

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 320, -1));

        txtNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 320, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nombre del");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 110, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Proveedor");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 110, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 550, 210));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 40));

        btnModificar.setBackground(new java.awt.Color(255, 255, 153));
        btnModificar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 160, 40));

        tbProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_proveedor", "Nombre", "Telefono", "Correo", "Direccion"
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 850, 190));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel11.setText("Nombre o ID");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        txtProveedorBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtProveedorBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProveedorBuscar.setName(""); // NOI18N
        jPanel1.add(txtProveedorBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 320, 30));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, 30));

        btnBuscar1.setBackground(new java.awt.Color(255, 255, 153));
        btnBuscar1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(255, 0, 0));
        btnBuscar1.setText("Mostrar Datos");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty()||txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty()||txtDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios","Campos VACIOS", JOptionPane.QUESTION_MESSAGE);
            
        }else{
            //Parseamos el id
            int id_Prove= Integer.parseInt(txtID.getText());
            Provee.setId_proveedor(id_Prove);
            String nombre=txtNombre.getText().toUpperCase();
            Provee.setNombre(nombre);
            Provee.setTelefono(txtTelefono.getText());
            Provee.setCorreo(txtCorreo.getText());
            Provee.setDireccion(txtDireccion.getText());
            
            ProveedoresM.ModificarProveedor(Provee);
            LimpiarTabla();
            ListarProveedor();
            limpiar();
                    
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProveedorMouseClicked
       
        int fila = tbProveedor.rowAtPoint(evt.getPoint());

        txtID.setText(tbProveedor.getValueAt(fila, 0).toString());
        txtNombre.setText(tbProveedor.getValueAt(fila, 1).toString());
        txtTelefono.setText(tbProveedor.getValueAt(fila, 2).toString());
        txtCorreo.setText(tbProveedor.getValueAt(fila, 3).toString());
        txtDireccion.setText(tbProveedor.getValueAt(fila, 4).toString());
            
        
        
        
        
    }//GEN-LAST:event_tbProveedorMouseClicked

      public static boolean esNumero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (txtProveedorBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo esta vacio","Campo VACIO", JOptionPane.QUESTION_MESSAGE);

        } else {
            //Parseamos el id

            if (esNumero(txtProveedorBuscar.getText())) {

                int n = Integer.parseInt(txtProveedorBuscar.getText());
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                    txtProveedorBuscar.setText("");
                    return;
                } else {
                    ConsProveedor Proveed = new ConsProveedor();
                    int id_Provee = Integer.parseInt(txtProveedorBuscar.getText());
                    Proveed.setId_proveedor(id_Provee);
                    LimpiarTabla();
                    BuscaPro(Proveed);
                }

            } else {
                ConsProveedor proveed = new ConsProveedor();
                String nom = txtProveedorBuscar.getText().toUpperCase();
                proveed.setNombre(nom);
                LimpiarTabla();
                BuscaPro(proveed);

                //ListarProveedor();
                limpiar();
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        LimpiarTabla();
        ListarProveedor();
    }//GEN-LAST:event_btnBuscar1ActionPerformed
    
    private void limpiar(){
        txtProveedorBuscar.setText("");
        txtID.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbProveedor;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProveedorBuscar;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
