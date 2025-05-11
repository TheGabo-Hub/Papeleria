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
public class ProveedorAlta extends javax.swing.JInternalFrame {

    ConsProveedor Provee = new ConsProveedor();
    ProveedoresMet ProveedoresM = new ProveedoresMet();
    DefaultTableModel modelo;

    public ProveedorAlta() {
        initComponents();
        
        ListarProveedor();
        lblValidar.setEnabled(false);
 
        //txtID.setText(""+ProveedoresM.numMaxim());
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
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblValidar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProveedor = new javax.swing.JTable();

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
        setTitle("Alta de Proveedores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoprovee.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alta Proveedores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 30), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prove1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 350, 230));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 255), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Direccion ");
        jLabel7.setToolTipText("");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 100, 20));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre del");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Telefono");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 102, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setText("Correo");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 320, -1));

        txtID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 110, -1));

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 320, -1));

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 320, -1));

        txtNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 320, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setText("Id del Proveedor");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Validar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        lblValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        jPanel2.add(lblValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 13, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Proveedor");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 110, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 50, 510, 250));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 130, 40));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 130, 40));

        tbProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbProveedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_proveedor", "Nombre", "Telefono", "Correo", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProveedor.setToolTipText("");
        jScrollPane2.setViewportView(tbProveedor);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 330, 870, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
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
    
    
    
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    
        if (txtID.getText().isEmpty() || txtNombre.getText().isEmpty()||txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty()||txtDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios","Campos VACIOS", JOptionPane.QUESTION_MESSAGE);
            
        }else{
            if (!esEntero(txtID.getText()) ){
                JOptionPane.showMessageDialog(null,"Debe ingresar el id como numero","Valor Invalido", JOptionPane.WARNING_MESSAGE);
               txtID.setText("");
                return;
            }
            if(Integer.parseInt(txtID.getText())<=0 ){
                JOptionPane.showMessageDialog(null, "El valor del id No debe ser Negativos o 0 ","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla
                
                
            }
            int id = Integer.parseInt(txtID.getText());
            Provee.setId_proveedor(id);
            String nombre=txtNombre.getText().toUpperCase();
            Provee.setNombre(nombre);
            Provee.setTelefono(txtTelefono.getText());
            Provee.setCorreo(txtCorreo.getText());
            Provee.setDireccion(txtDireccion.getText());
            
           
            
            // osea que si si se registro lo limpie y  si no no
             boolean v;
              v=ProveedoresM.RegistrarProveedor(Provee);
            
            if (v) {

                LimpiarTabla();
            ListarProveedor();
            limpiar();
            }else{
                txtID.setText("");
            }
            
                    
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ConsProveedor proveedor = new ConsProveedor();

        if (txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"EL campo esta vacio","Campos Vacios",JOptionPane.QUESTION_MESSAGE);

        }else{

            if (!esEntero(txtID.getText())) {
                JOptionPane.showMessageDialog(null, "El campo ID debe ser un número entero","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla
            }
            if (Integer.parseInt(txtID.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "No debe ingrear 0 o numeros negativos","Valor Invalido", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
                return; // Salir del método si la validación falla

            }                   //"Confirmar Eliminacion", JOptionPane.WARNING_MESSAGE
            boolean band;
            int id= Integer.parseInt(txtID.getText());
            proveedor.setId_proveedor(id);
            // Si es true es que el producto ya existe y si no es que se puede guardar
            band=ProveedoresM.validarP(proveedor);
            // Hacer un metodo para valiadar si hay producto dado de alta
            if(band){

                lblValidar.setEnabled(false);
                JOptionPane.showMessageDialog(null,"Id  de proveedor ya registrado, no se puede registrar","Error",JOptionPane.ERROR_MESSAGE);
                txtID.setText("");

            }else{
                lblValidar.setEnabled(true);

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void limpiar(){
        txtID.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
       lblValidar.setEnabled(false);
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lblValidar;
    private javax.swing.JTable tbProveedor;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
