/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas;

import conexiones.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class HistorialVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form HistorialVenta
     */
    public HistorialVenta() {
        initComponents();
        mostrardatos("");
    }
    Conectar cn = new Conectar();
    Connection cc = cn.conexion();

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("FOLIO");
        modelo.addColumn("ID Producto");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total Articulo");
        tbventas.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM detalle_venta";
        } else {
            sql = "SELECT * FROM detalle_venta WHERE folio = '" + valor + "'";
        }
        try {
            Object[] datos = new Object[6];
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                modelo.addRow(datos);
            }
            tbventas.setModel(modelo);
            tbventas.setRowHeight(70);
            tbventas.setDefaultEditor(Object.class, null);
        } catch (Exception ex) {
            Logger.getLogger(ProductosModificar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbventas = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Detalle de las Ventas");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventasicono.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 24), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbventas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 920, 400));

        txtBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 130, 40));

        jButton3.setBackground(new java.awt.Color(51, 255, 51));
        jButton3.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 160, -1));

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jButton2.setText("Mostrar Ventas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, -1, -1));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel1.setText("Folio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrardatos(txtBuscar.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrardatos("");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbventas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
