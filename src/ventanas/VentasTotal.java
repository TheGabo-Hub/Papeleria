/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas;

import conexiones.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VentasTotal extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentasTotal
     */
    public VentasTotal() {
        initComponents();
        fecha();
        mostrardatos("");
    }
    Conectar cn = new Conectar();
    Connection cc = cn.conexion();

    void mostrardatos(String valor) {

        String fechaFormateada = Formfecha();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("FOLIO");
        modelo.addColumn("ID Empleado");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");
        modelo.addColumn("TOTAL");
        tbventas.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM venta";
        } else {

            sql = "SELECT * FROM venta WHERE fecha = '" + fechaFormateada + "'";
            //SELECT * FROM venta WHERE fecha = '2024-05-14'
        }
        try {
            Object[] datos = new Object[5];
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
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
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ventas Totales");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventasicono.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas Totales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 24), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbventas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbventas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 530, 340));

        txtBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 220, 40));

        jButton3.setBackground(new java.awt.Color(51, 255, 51));
        jButton3.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 120, -1));

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jButton2.setText("Mostrar Ventas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Vendido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 220, 60));

        lblTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 250, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgtotalventa.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 310, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrardatos(txtBuscar.getText());
        totalfinal();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrardatos("");
        lblTotal.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbventas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public String fecha() {
        String fecha;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada2 = fechaActual.format(formatter2);

        fecha = fechaFormateada;
        txtBuscar.setText(fecha);
        return fechaFormateada2;
    }

    String Formfecha() {
            String fechaStr = txtBuscar.getText();

            // Crear un formateador para el formato de entrada
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Convertir la cadena a LocalDate
            LocalDate fecha = LocalDate.parse(fechaStr, formatoEntrada);

            // Crear un formateador para el formato de salida
            DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            // Formatear la fecha en el nuevo formato
            String fechaFormateada = fecha.format(formatoSalida);
            return fechaFormateada;
    }

    public void totalfinal() {
        String fechaformateada = Formfecha();
        String tot = "";
        try {
            
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) FROM venta WHERE fecha = '" + fechaformateada + "'");
            //SELECT SUM(total) FROM venta WHERE fecha = '2024-05-13'
            while (rs.next()) {
                tot = rs.getString(1);
            }
        } catch (Exception e) {

        }
        lblTotal.setText("$"+tot);
    }

}
