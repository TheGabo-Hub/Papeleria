/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas;

import Constructores.ConsEmpleado;
import clases.EmpleadosMet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class Empleados extends javax.swing.JInternalFrame {

    ConsEmpleado Emple = new ConsEmpleado();
    EmpleadosMet EmpleadosM = new EmpleadosMet();

    // Para la tabla
    DefaultTableModel modelo;

    public Empleados() {
        initComponents();
        ListarEmpleado();
        txtId.setText(""+EmpleadosM.numMaxim());
        System.out.println("numero maximo es :" + EmpleadosM.numMaxim());
        comboEmpleado.setSelectedIndex(-1);

    }

    public void ListarEmpleado() {
        List<ConsEmpleado> ListarEmpleado = EmpleadosM.ListarEmpleado();
        modelo = (DefaultTableModel) tbEmpleados.getModel();
        // Creamos el objeto que utiliza la tabla 
        Object[] obj = new Object[7];
        // Recorremos la lista para obtener los datos
        for (int i = 0; i < ListarEmpleado.size(); i++) {
            obj[0] = ListarEmpleado.get(i).getId_empleado();
            obj[1] = ListarEmpleado.get(i).getNombre();
            obj[2] = ListarEmpleado.get(i).getApellido();
            obj[3] = ListarEmpleado.get(i).getTelefono();
            obj[4] = ListarEmpleado.get(i).getCorreo();
            obj[5] = ListarEmpleado.get(i).getDireccion();
            obj[6] = ListarEmpleado.get(i).getPuesto();

            // despues lo agregamos al modelo
            modelo.addRow(obj);

        }
        //Despues el modelo se agg a la tabla
        tbEmpleados.setModel(modelo);
        tbEmpleados.setRowHeight(40);

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

        jPanel1 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        txtApellidos = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboEmpleado = new javax.swing.JComboBox<>();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados1.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bookman Old Style", 1, 30), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 68, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setText("Apellidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel5.setText("Correo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel6.setText("Direccion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setText("Puesto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        tbEmpleados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Empleado", "Nombre", "Apellidos", "Telefono", "Correo", "Direccion", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 690, 180));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        txtApellidos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 200, -1));

        txtNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, -1));

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 200, -1));

        txtCorreo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 200, -1));

        txtDireccion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 200, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        btnModificar.setBackground(new java.awt.Color(255, 255, 153));
        btnModificar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        btnLimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados2.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 180, 220));

        comboEmpleado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        comboEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "EMPLEADO" }));
        jPanel1.add(comboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked

        int fila = tbEmpleados.rowAtPoint(evt.getPoint());

        txtId.setText(tbEmpleados.getValueAt(fila, 0).toString());
        txtNombre.setText(tbEmpleados.getValueAt(fila, 1).toString());
        txtApellidos.setText(tbEmpleados.getValueAt(fila, 2).toString());
        txtTelefono.setText(tbEmpleados.getValueAt(fila, 3).toString());
        txtCorreo.setText(tbEmpleados.getValueAt(fila, 4).toString());
        txtDireccion.setText(tbEmpleados.getValueAt(fila, 5).toString());
        comboEmpleado.setSelectedItem(tbEmpleados.getValueAt(fila, 6).toString());

    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //Verificar que los campos estan vacios
        if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || comboEmpleado.getSelectedIndex() == -1) {
            // Estan vacios
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Campos Vacios", JOptionPane.QUESTION_MESSAGE);

        } else {
            

            Emple.setId_empleado(EmpleadosM.numMaxim());
           
            String nomnbre=txtNombre.getText();
             ConsEmpleado veriE = new ConsEmpleado();
            veriE.setNombre(nomnbre);
            boolean bandera = EmpleadosM.validarEmpleado(veriE);
            if (bandera){
                JOptionPane.showMessageDialog(null,"Nombre ya ingresado pruebe otro");
                
                return;
            }
            
            
            
            Emple.setNombre(txtNombre.getText());
            Emple.setApellido(txtApellidos.getText());
            Emple.setTelefono(txtTelefono.getText());
            Emple.setCorreo(txtCorreo.getText());
            Emple.setDireccion(txtDireccion.getText());
            // para ponerlo en mayusculas primero
            String prueba = (String) comboEmpleado.getSelectedItem();
            Emple.setPuesto(prueba);

            EmpleadosM.RegistrarEmpleado(Emple);
            limpiar();
            LimpiarTabla();
            ListarEmpleado();
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || comboEmpleado.getSelectedIndex() == -1) {
            System.out.println("Campos vacios");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar", "Confirmar Eliminacion", JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0) {
                int id = Integer.parseInt(txtId.getText());
                EmpleadosM.EliminarEmpleado(id);
                LimpiarTabla();
                ListarEmpleado();

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || comboEmpleado.getSelectedIndex() == -1) {

            System.out.println("Los campos estan vacios");

        } else {
            // parseamos el id
            int ide = Integer.parseInt(txtId.getText());
            String puesto = comboEmpleado.getSelectedItem().toString();
            Emple.setId_empleado(ide);
            Emple.setNombre(txtNombre.getText());
            Emple.setApellido(txtApellidos.getText());
            Emple.setTelefono(txtTelefono.getText());
            Emple.setCorreo(txtCorreo.getText());
            Emple.setDireccion(txtDireccion.getText());
            Emple.setPuesto(puesto);
            EmpleadosM.ModificarEmpleado(Emple);
            LimpiarTabla();
            ListarEmpleado();

        }

    }//GEN-LAST:event_btnModificarActionPerformed
    private void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        comboEmpleado.setSelectedIndex(-1);
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
