package ventanas;

import Constructores.ConsUsuario;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import conexiones.Conectar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class NuevaVenta extends javax.swing.JInternalFrame {

    private ConsUsuario usuario;

    public NuevaVenta() {
        initComponents();
        folio();
        fecha();
        hora();
        btnactualizar.setVisible(false);
        txtidp.requestFocus();
    }

    public NuevaVenta(ConsUsuario usuario) {
        this();
        this.usuario = usuario;
        String nombre = usuario.getNombre();
        int id = usuario.getId_empleado();
        String puesto = usuario.getPuesto();
        //lblVendedor.setText(puesto + nombre);
        txtidempleado.setText("" + id);
    }

    Conectar cn = new Conectar();
    Connection cc = cn.conexion();

    void mostrardatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        //DefaultTableModel modelo = (DefaultTableModel) tbproductos.getModel();
        modelo.addColumn("FOLIO");
        modelo.addColumn("CODIGO PRODUCTO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO UNIDAD");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO TOTAL");
        tbproductos.setModel(modelo);
        String sql = "";
        sql = "SELECT * FROM detalle_venta WHERE folio = " + lblfolio.getText();
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
            tbproductos.setModel(modelo);
            tbproductos.setRowHeight(70);
            tbproductos.setDefaultEditor(Object.class, null);
        } catch (Exception ex) {
            Logger.getLogger(ProductosModificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txtidp = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbproductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCambiopag = new javax.swing.JLabel();
        txtPagaCon = new javax.swing.JTextField();
        Btncambio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        BtnAñadir = new javax.swing.JButton();
        txtproducto = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblfolio = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnterminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtidempleado = new javax.swing.JTextField();
        btntcancelar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Editar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventasicono.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 20), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpActionPerformed(evt);
            }
        });
        jPanel1.add(txtidp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 120, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 20), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel2.setLayout(null);

        tbproductos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbproductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tbproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOLIO", "CODIGO PRODUCTO", "PRODUCTO", "PRECIO UNIDAD", "CANTIDAD", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbproductos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbproductos);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 30, 630, 220);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 650, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel3.setText("Total $");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 140, 30));

        lblTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lblTotal.setText("0.00");
        jPanel3.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 160, 30));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel5.setText("Paga Con $");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, 40));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel7.setText("Cambio $");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, 30));

        lblCambiopag.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jPanel3.add(lblCambiopag, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 100, 30));

        txtPagaCon.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        txtPagaCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagaConActionPerformed(evt);
            }
        });
        jPanel3.add(txtPagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 100, 40));

        Btncambio.setBackground(new java.awt.Color(153, 255, 255));
        Btncambio.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        Btncambio.setText("Cambio");
        Btncambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtncambioActionPerformed(evt);
            }
        });
        jPanel3.add(Btncambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas1.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 260, 200));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 650, 200));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel1.setText("Ingrese la Informacion de la Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Codigo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 30));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel9.setText("Producto");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 90, 30));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setText("Cantidad");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 90, 30));

        txtprecio.setEditable(false);
        txtprecio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 120, 30));

        BtnAñadir.setBackground(new java.awt.Color(255, 204, 51));
        BtnAñadir.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        BtnAñadir.setText("Añadir");
        BtnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        txtproducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductoActionPerformed(evt);
            }
        });
        jPanel1.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 120, 30));

        txtcantidad.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 120, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 80, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setText("Precio Unidad");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 130, 30));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel10.setText("FOLIO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 80, 30));

        lblfolio.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jPanel1.add(lblfolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 70, 30));

        btnlimpiar.setBackground(new java.awt.Color(153, 255, 255));
        btnlimpiar.setFont(new java.awt.Font("Bookman Old Style", 1, 20)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, -1, -1));

        btnactualizar.setBackground(new java.awt.Color(153, 255, 255));
        btnactualizar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setText("FECHA:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 70, 30));

        lblfecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jPanel1.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 130, 30));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel14.setText("HORA:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 70, 30));

        lblhora.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jPanel1.add(lblhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 130, 30));

        jLabel15.setFont(new java.awt.Font("Ink Free", 1, 20)); // NOI18N
        jLabel15.setText("Empleado: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 30));

        btnterminar.setBackground(new java.awt.Color(255, 204, 51));
        btnterminar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnterminar.setText("Terminar Venta");
        btnterminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnterminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 540, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoventa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 410, 520, 160));

        jButton3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jButton3.setText("1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 40, 30));

        jButton4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jButton4.setText("2");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 40, 30));

        jButton5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jButton5.setText("3");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 40, 30));

        txtidempleado.setEditable(false);
        txtidempleado.setBackground(new java.awt.Color(204, 255, 255));
        txtidempleado.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        txtidempleado.setBorder(null);
        txtidempleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidempleadoFocusGained(evt);
            }
        });
        txtidempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidempleadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtidempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 120, 30));
        txtidempleado.getAccessibleContext().setAccessibleName("");

        btntcancelar.setBackground(new java.awt.Color(255, 102, 102));
        btntcancelar.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btntcancelar.setText("Cancelar");
        btntcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntcancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btntcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 540, -1, -1));

        jButton6.setText("Ticket");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAñadirActionPerformed
        ComprobarUnidades();

    }//GEN-LAST:event_BtnAñadirActionPerformed

    private void txtproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductoActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed

    }//GEN-LAST:event_txtcantidadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        String tot = total_articulo();
        try {
            PreparedStatement pst = cc.prepareStatement("UPDATE detalle_venta SET id_producto = ?, precio_venta = ?, cantidad = ?, totalarti= ? WHERE Folio=" + lblfolio.getText() + " AND id_producto = " + txtidp.getText());
            pst.setString(1, txtidp.getText());
            pst.setString(2, txtprecio.getText());
            pst.setString(3, txtcantidad.getText());
            pst.setString(4, tot);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Hecha");
            btnactualizar.setVisible(false);
            BtnAñadir.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
        mostrardatos();
        totalfinal();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void BtncambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtncambioActionPerformed
        cambioenter();

    }//GEN-LAST:event_BtncambioActionPerformed

    private void btnterminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminarActionPerformed
        imprimirTicketinicio();
        actualizarUnidades();

        try {
            PreparedStatement pst = cc.prepareStatement("UPDATE venta SET total = ? WHERE folio='" + lblfolio.getText() + "'");
            pst.setString(1, lblTotal.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        limpiar();
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.setColumnCount(0);
        modelo1.setRowCount(0);
        tbproductos.setModel(modelo1);
        lblTotal.setText("");
        txtPagaCon.setText("");
        lblCambiopag.setText("");
        folio();
        JOptionPane.showMessageDialog(null, "Gracias Por Su Compra :)");
        //actualizarUnidades();
        fecha();
        hora();
    }//GEN-LAST:event_btnterminarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        BtnAñadir.setVisible(false);
        btnactualizar.setVisible(true);
        int fila = tbproductos.getSelectedRow();
        if (fila >= 0) {
            txtidp.setText(tbproductos.getValueAt(fila, 1).toString());
            txtproducto.setText(tbproductos.getValueAt(fila, 2).toString());
            txtcantidad.setText(tbproductos.getValueAt(fila, 4).toString());
            txtprecio.setText(tbproductos.getValueAt(fila, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = tbproductos.getSelectedRow();
        String cod = "";
        cod = tbproductos.getValueAt(fila, 1).toString();
        int result = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar dicho registro?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = cc.prepareStatement("DELETE FROM detalle_venta WHERE id_producto='" + cod + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                mostrardatos();
            } catch (Exception e) {
            }
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro NO Eliminado");
        }
        totalfinal();
    }//GEN-LAST:event_EliminarActionPerformed

    private void txtPagaConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagaConActionPerformed
        cambioenter();

    }//GEN-LAST:event_txtPagaConActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if ("".equals(txtcantidad.getText())) {
            txtcantidad.setText("1");
        } else {
            int cant = Integer.parseInt(txtcantidad.getText());
            //cant = 0;
            int cantidad = cant + 1;
            txtcantidad.setText(String.valueOf(cantidad));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if ("".equals(txtcantidad.getText())) {
            txtcantidad.setText("2");
        } else {
            int cant = Integer.parseInt(txtcantidad.getText());
            int cantidad = cant + 2;
            txtcantidad.setText(String.valueOf(cantidad));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if ("".equals(txtcantidad.getText())) {
            txtcantidad.setText("3");
        } else {
            int cant = Integer.parseInt(txtcantidad.getText());
            int cantidad = cant + 3;
            txtcantidad.setText(String.valueOf(cantidad));
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtidpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpActionPerformed
        buscar();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidpActionPerformed

    private void txtidempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidempleadoActionPerformed

    private void txtidempleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidempleadoFocusGained
        txtidp.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtidempleadoFocusGained

    private void btntcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntcancelarActionPerformed
        int fila = tbproductos.getSelectedRow();
        String cod = lblfolio.getText();
        //cod = tbproductos.getValueAt(fila, 1).toString();
        int result = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar dicho registro?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = cc.prepareStatement("DELETE FROM venta WHERE folio='" + cod + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                folio();
                mostrardatos();
                lblTotal.setText("");
            } catch (Exception e) {
            }
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro NO Eliminado");
        }
    }//GEN-LAST:event_btntcancelarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        imprimirTicketinicio();
        /*String prod = tbproductos.getValueAt(1, 2).toString();
        String cant = tbproductos.getValueAt(1, 4).toString();
        String prec = tbproductos.getValueAt(1, 3).toString();
        String importe = tbproductos.getValueAt(1, 5).toString();
        System.out.println(prod+cant+prec+importe);*/
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAñadir;
    private javax.swing.JButton Btncambio;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btntcancelar;
    private javax.swing.JButton btnterminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCambiopag;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblfolio;
    private javax.swing.JLabel lblhora;
    private javax.swing.JTable tbproductos;
    private javax.swing.JTextField txtPagaCon;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtidempleado;
    private javax.swing.JTextField txtidp;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables
    public String fecha() {
        String fecha;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada2 = fechaActual.format(formatter2);

        fecha = fechaFormateada;
        lblfecha.setText(fecha);
        return fechaFormateada2;
    }

    void hora() {
        String hor;
        try {
            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String horaFormateada = horaActual.format(formatter);
            hor = horaFormateada;
            lblhora.setText(hor);

        } catch (Exception e) {

        }
    }

    public void folio() {
        String serie = NoSerie();
        if (serie == null) {
            lblfolio.setText("1");
        } else {
            int increment = Integer.parseInt(serie);
            increment = increment + 1;
            String folionuevo = Integer.toString(increment);
            lblfolio.setText(folionuevo);
        }

    }

    public String NoSerie() {
        String serie = "";
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(folio) FROM venta");
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (Exception e) {

        }
        return serie;
    }

    public void ComprobarUnidades() {
        String stockdiponible = "";
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery("SELECT stock FROM producto WHERE id_producto = '" + txtidp.getText() + "'");
            while (rs.next()) {
                stockdiponible = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        int cant = Integer.parseInt(txtcantidad.getText());
        int cantdispo = Integer.parseInt(stockdiponible);
        if (cant >= cantdispo) {
            JOptionPane.showMessageDialog(null, "No hay Suficientes Unidades");
        } else {
            agregar();
        }
    }

    public void agregar() {
        String fecha2 = fecha();
        try {
            String tot = total_articulo();
            int existe = 0;
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM venta WHERE folio = '" + lblfolio.getText() + "'");
            while (rs.next()) {
                existe = rs.getInt(1);
            }
            if (existe == 0) {
                PreparedStatement pst = cc.prepareStatement("INSERT INTO venta(folio,id_empleado,fecha,hora,total)VALUES(?,?,?,?,?)");
                pst.setString(1, lblfolio.getText());
                pst.setString(2, txtidempleado.getText());
                pst.setString(3, fecha2);
                pst.setString(4, lblhora.getText());
                pst.setString(5, "0");
                pst.executeUpdate();
                //modificacion 20/04/2025 -> Producto

                PreparedStatement pst2 = cc.prepareStatement("INSERT INTO detalle_venta(folio,id_producto,producto,precio_venta,cantidad,totalarti)VALUES(?,?,?,?,?,?)");
                pst2.setString(1, lblfolio.getText());
                pst2.setString(2, txtidp.getText());
                pst2.setString(3, txtproducto.getText());
                pst2.setString(4, txtprecio.getText());
                pst2.setString(5, txtcantidad.getText());
                pst2.setString(6, tot);
                pst2.executeUpdate();

            } else {
                PreparedStatement pst2 = cc.prepareStatement("INSERT INTO detalle_venta(folio,id_producto,producto,precio_venta,cantidad,totalarti)VALUES(?,?,?,?,?,?)");
                pst2.setString(1, lblfolio.getText());
                pst2.setString(2, txtidp.getText());
                pst2.setString(3, txtproducto.getText());
                pst2.setString(4, txtprecio.getText());
                pst2.setString(5, txtcantidad.getText());
                pst2.setString(6, tot);
                pst2.executeUpdate();
            }
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            Logger.getLogger(ProductosModificar.class.getName()).log(Level.SEVERE, null, e);
        }
        mostrardatos();
        totalfinal();
    }

    public String total_articulo() {
        double total = 0;
        int cant = Integer.parseInt(txtcantidad.getText());
        double prec = Double.parseDouble(txtprecio.getText());
        total = cant * prec;
        String total2 = String.valueOf(total);
        return total2;
    }

    public void limpiar() {
        txtidp.setText("");
        txtproducto.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
    }

    public void totalfinal() {
        String tot = "";
        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(totalarti) FROM detalle_venta WHERE folio = " + lblfolio.getText());
            while (rs.next()) {
                tot = rs.getString(1);
            }
        } catch (Exception e) {

        }
        lblTotal.setText(tot);
    }

    public void cambio() {
        double tot = Double.parseDouble(lblTotal.getText());
        double pag = Double.parseDouble(txtPagaCon.getText());
        double cambio = pag - tot;
        if (txtPagaCon.getText() != "") {
            lblCambiopag.setText(String.valueOf(cambio));
        }
    }

    public void actualizarUnidades() {
        String dispo = "";

        for (int i = 0; i < tbproductos.getRowCount(); i++) {
            String codpro = tbproductos.getValueAt(i, 1).toString();
            //int codpro = Integer.parseInt(tbproductos.getValueAt(i, 1).toString());
            int cant = Integer.parseInt(tbproductos.getValueAt(i, 4).toString());

            try {
                Statement st = cc.createStatement();
                ResultSet rs = st.executeQuery("SELECT stock FROM producto WHERE id_producto = '" + codpro + "'");
                while (rs.next()) {
                    dispo = rs.getString(1);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error");
            }

            int cantdispo = Integer.parseInt(dispo);
            int cantfinal = cantdispo - cant;
            String cantfinal2 = String.valueOf(cantfinal);
            try {
                PreparedStatement pst = cc.prepareStatement("UPDATE producto SET stock = ? WHERE id_producto=" + codpro);
                pst.setString(1, cantfinal2);
                pst.executeUpdate();
            } catch (Exception e) {
            }
        }
    }

    public void buscar() {
        try {
            if ("".equals(txtidp.getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese el codigo o nombre del Producto");
            } else {
                Statement st = cc.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM producto where id_producto = " + txtidp.getText());
                while (rs.next()) {
                    txtproducto.setText(rs.getString(2));
                    txtprecio.setText(rs.getString(4));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ups Algo Salio Mal");
        }
    }

    void cambioenter() {
        double totpagar = Double.parseDouble(lblTotal.getText());
        double pagacon = Double.parseDouble(txtPagaCon.getText());

        if ("".equals(txtPagaCon.getText())) {
            JOptionPane.showMessageDialog(null, "Paga Con....");
        } else {
            if (pagacon < totpagar) {
                JOptionPane.showMessageDialog(null, "Le Falta Dinero!!");
            } else {
                cambio();
            }
        }
    }

    void imprimirTicketinicio() {

        String fech = lblfecha.getText();
        String hor = lblhora.getText();
        String fol = lblfolio.getText();
        String idem = txtidempleado.getText();

        try {

            PrinterMatrix printer = new PrinterMatrix();

            Extenso e = new Extenso();

            e.setNumber(20.30);

//Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = tbproductos.getRowCount();
            //int filas = 4;
            int tamaño = filas + 13;
            printer.setOutSize(tamaño, 32);

//Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 1, 0, 32, "================================");
            printer.printTextWrap(1, 1, 5, 32, "Papeleria");
            printer.printTextWrap(3, 1, 0, 32, "Chocolates, Regalos y algo mas ANDY");
            printer.printTextWrap(4, 1, 0, 32, " direccion ");
            printer.printTextWrap(5, 1, 0, 32, " codigo postal y rf ");
            printer.printTextWrap(6, 1, 0, 17, "Fecha: " + fech);
            printer.printTextWrap(6, 1, 18, 32, "Hora: " + hor);
            printer.printTextWrap(7, 1, 0, 32, "Numero de Venta: " + fol);
            printer.printTextWrap(8, 1, 0, 32, "Le atendio : " + idem);
            //printer.printTextWrap(9, 1, 0, 32, "Cliente: " + punto_Venta.jtx_cliente.getText());
            printer.printTextWrap(10, 1, 0, 32, "================================");
            printer.printTextWrap(11, 1, 0, 32, "DESCRIPCION CANT PRECIO IMPORTE");
            printer.printTextWrap(12, 1, 0, 32, "");

            for (int i = 0; i < filas; i++) {
                int p = 13 + i;
                
                String prod = tbproductos.getValueAt(i, 2).toString();
                String cant = tbproductos.getValueAt(i, 4).toString();
                String prec = tbproductos.getValueAt(i, 3).toString();
                String importe = tbproductos.getValueAt(i, 5).toString();

                /*printer.printTextWrap(p, 1, 0, 12, "LAPIZ");
                printer.printTextWrap(p, 1, 13, 16, "5");
                String pre = printer.alinharADireita(7, "2");
                printer.printTextWrap(p, 1, 17, 24, pre);
                String inp = printer.alinharADireita(7, "10");
                printer.printTextWrap(p, 1, 25, 32, inp);*/
                printer.printTextWrap(p, 1, 0, 12, prod);  // txtidp.setText(tbproductos.getValueAt(fila, 1).toString());
                printer.printTextWrap(p, 1, 13, 16, cant);
                String pre = printer.alinharADireita(7, prec);
                printer.printTextWrap(p, 1, 17, 24, pre);
                String inp = printer.alinharADireita(7, importe);
                printer.printTextWrap(p, 1, 25, 32, inp);

            }
///CREAR CARPETA tmp EN UNIDAD C
            printer.toFile("impresion.txt");

            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream("impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar");

            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);

            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }

            inputStream.close();
            imprimirFin();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir");

        }
    }

    void imprimirFin() {

        PrinterMatrix printer = new PrinterMatrix();
 
        Extenso e = new Extenso();

        e.setNumber(20.30);

        printer.setOutSize(13, 32);
        DecimalFormat formateador = new DecimalFormat("######.00");
        String sub = printer.alinharADireita(10, lblTotal.getText());
        printer.printTextWrap(1, 1, 5, 32, "Subtotal " + sub);
        String tot = printer.alinharADireita(10, lblTotal.getText());
        printer.printTextWrap(2, 1, 5, 32, "Total a pagar $" + tot);

        String efe = printer.alinharADireita(10, txtPagaCon.getText());
        printer.printTextWrap(3, 1, 5, 32, "Efectivo $" + efe);
        String cam = printer.alinharADireita(10, lblCambiopag.getText());
        printer.printTextWrap(4, 1, 5, 32, "Cambio $" + cam);
        printer.printTextWrap(5, 1, 0, 32, "——————————–");
        printer.printTextWrap(6, 1, 0, 32, " !Gracias por su preferencia! ");
        printer.printTextWrap(7, 1, 0, 32, "================================");

        printer.toFile("impresion1.txt");

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion1.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

//inputStream.close();
    }

}
