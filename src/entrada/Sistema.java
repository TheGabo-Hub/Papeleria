package entrada;

import Constructores.ConsUsuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import ventanas.Empleados;
import ventanas.HistorialVenta;
import ventanas.NuevaVenta;
import ventanas.PedidosAlta;
import ventanas.PedidosBorrar;
import ventanas.PedidosBuscar;
import ventanas.PedidosModificar;
import ventanas.ProductosAlta;
import ventanas.ProductosBorrar;
import ventanas.ProductosBuscar;
import ventanas.ProductosModificar;
import ventanas.ProveedorAlta;
import ventanas.ProveedorBorrar;
import ventanas.ProveedorBuscar;
import ventanas.ProveedorModificar;
import ventanas.Usuarios;
import ventanas.VentasTotal;

/**
 *
 * @author puppe
 */
public class Sistema extends javax.swing.JFrame {

    private ConsUsuario usuario;
    Login log = new Login();

    public Sistema() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        foto();

    }

    public Sistema(ConsUsuario usuario) {
        this();
        this.usuario = usuario;
        configMenu();
        String nombre = usuario.getNombre();
        String vendedor = "Vendedor : ";
        lblVendedor.setText(vendedor + nombre);
        foto();

    }

    private void configMenu() {
        String puesto = usuario.getPuesto();
        System.out.println(puesto);

        if (puesto.equals("EMPLEADO")) {
            MenuProveedor.setEnabled(false);
            MenuProductos.setEnabled(false);
            MenuVendedor.setEnabled(false);

        } else {
            System.out.println("ADMINISTRADOR");
        }

    }

    private void foto() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/s1.jpg")); // Cambiar "ruta_de_tu_imagen.png" con la ruta de tu imagen
        Image image = imageIcon.getImage(); // Transformar el ícono en una imagen 
        Image newImg = image.getScaledInstance(screenWidth, screenHeight, java.awt.Image.SCALE_SMOOTH); // Escalar la imagen
        ImageIcon newIcon = new ImageIcon(newImg); // Transformar la imagen nuevamente en un ícono

        // Establecer la imagen como fondo del JPanel
        contenedor.setOpaque(false); // Hacer el JPanel transparente
        contenedor.setLayout(new BorderLayout()); // Establecer el layout BorderLayout para que la imagen se ajuste al tamaño del contenedor
        JLabel background = new JLabel(newIcon);
        contenedor.add(background);
        background.setLayout(new FlowLayout()); // Establecer el layout del JLabel para que ocupe todo el contenedor
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        contenedor = new javax.swing.JPanel();
        lblVendedor = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuProveedor = new javax.swing.JMenu();
        altaProveedor_S = new javax.swing.JMenuItem();
        modiProveedor_S = new javax.swing.JMenuItem();
        buscarProveedor_S = new javax.swing.JMenuItem();
        eliminarProveedor_S = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        altaPedidos_S = new javax.swing.JMenuItem();
        modiPedidos_S = new javax.swing.JMenuItem();
        buscarPedidos_S = new javax.swing.JMenuItem();
        eliminarPedidos_S = new javax.swing.JMenuItem();
        MenuProductos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuHistorial = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        MenuVentas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuVendedor = new javax.swing.JMenu();
        Vendedor_usuario = new javax.swing.JMenuItem();
        Vendedor_Empleado = new javax.swing.JMenuItem();
        MenuCerrarSesion = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        cambiarUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblVendedor.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        lblVendedor.setText("jLabel1");

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(851, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVendedor)
                .addContainerGap(550, Short.MAX_VALUE))
        );

        escritorio.setLayer(contenedor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proveedor.png"))); // NOI18N
        MenuProveedor.setText("Proveedores");
        MenuProveedor.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        altaProveedor_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        altaProveedor_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        altaProveedor_S.setText("Alta");
        altaProveedor_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaProveedor_SActionPerformed(evt);
            }
        });
        MenuProveedor.add(altaProveedor_S);

        modiProveedor_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        modiProveedor_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mo.png"))); // NOI18N
        modiProveedor_S.setText("Modificación");
        modiProveedor_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modiProveedor_SActionPerformed(evt);
            }
        });
        MenuProveedor.add(modiProveedor_S);

        buscarProveedor_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        buscarProveedor_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        buscarProveedor_S.setText("Buscar");
        buscarProveedor_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProveedor_SActionPerformed(evt);
            }
        });
        MenuProveedor.add(buscarProveedor_S);

        eliminarProveedor_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        eliminarProveedor_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        eliminarProveedor_S.setText("Eliminar");
        eliminarProveedor_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProveedor_SActionPerformed(evt);
            }
        });
        MenuProveedor.add(eliminarProveedor_S);

        jMenuBar1.add(MenuProveedor);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedido.png"))); // NOI18N
        jMenu1.setText("Pedidos");
        jMenu1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        altaPedidos_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        altaPedidos_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        altaPedidos_S.setText("Alta");
        altaPedidos_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaPedidos_SActionPerformed(evt);
            }
        });
        jMenu1.add(altaPedidos_S);

        modiPedidos_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        modiPedidos_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mo.png"))); // NOI18N
        modiPedidos_S.setText("Modificar");
        modiPedidos_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modiPedidos_SActionPerformed(evt);
            }
        });
        jMenu1.add(modiPedidos_S);

        buscarPedidos_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        buscarPedidos_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        buscarPedidos_S.setText("Buscar");
        buscarPedidos_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPedidos_SActionPerformed(evt);
            }
        });
        jMenu1.add(buscarPedidos_S);

        eliminarPedidos_S.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        eliminarPedidos_S.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        eliminarPedidos_S.setText("Eliminar");
        eliminarPedidos_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPedidos_SActionPerformed(evt);
            }
        });
        jMenu1.add(eliminarPedidos_S);

        jMenuBar1.add(jMenu1);

        MenuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        MenuProductos.setText("Productos");
        MenuProductos.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        jMenuItem1.setText("Alta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuProductos.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mo.png"))); // NOI18N
        jMenuItem2.setText("Modificación");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuProductos.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jMenuItem3.setText("Buscar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuProductos.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jMenuItem4.setText("Eliminar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuProductos.add(jMenuItem4);

        jMenuBar1.add(MenuProductos);

        MenuHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Carrito-de-compras.png"))); // NOI18N
        MenuHistorial.setText("Historial");
        MenuHistorial.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jMenuItem6.setText("Detalle de Ventas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenuHistorial.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jMenuItem7.setText("Total Ventas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MenuHistorial.add(jMenuItem7);

        jMenuBar1.add(MenuHistorial);

        MenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nventa.png"))); // NOI18N
        MenuVentas.setText("Ventas");
        MenuVentas.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jMenuItem5.setText("Nueva Venta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuVentas.add(jMenuItem5);

        jMenuBar1.add(MenuVentas);

        MenuVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usu.png"))); // NOI18N
        MenuVendedor.setText("Vendedores");
        MenuVendedor.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        Vendedor_usuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Vendedor_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados1.png"))); // NOI18N
        Vendedor_usuario.setText("Usuarios");
        Vendedor_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vendedor_usuarioActionPerformed(evt);
            }
        });
        MenuVendedor.add(Vendedor_usuario);

        Vendedor_Empleado.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Vendedor_Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ayuda.png"))); // NOI18N
        Vendedor_Empleado.setText("Informacion Empleados");
        Vendedor_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vendedor_EmpleadoActionPerformed(evt);
            }
        });
        MenuVendedor.add(Vendedor_Empleado);

        jMenuBar1.add(MenuVendedor);

        MenuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clientes.png"))); // NOI18N
        MenuCerrarSesion.setText("Cerrar Sesión");
        MenuCerrarSesion.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        Salir.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        MenuCerrarSesion.add(Salir);

        cambiarUsuario.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        cambiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        cambiarUsuario.setText("Cambiar Usuario");
        cambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarUsuarioActionPerformed(evt);
            }
        });
        MenuCerrarSesion.add(cambiarUsuario);

        jMenuBar1.add(MenuCerrarSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
        System.exit(0);

    }//GEN-LAST:event_SalirActionPerformed

    private void cambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarUsuarioActionPerformed
        dispose();
        log.setVisible(true);
    }//GEN-LAST:event_cambiarUsuarioActionPerformed

    private void Vendedor_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vendedor_EmpleadoActionPerformed
        Empleados em = new Empleados();
        escritorio.add(em);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = em.getSize();
        em.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        em.show();
        //em.setVisible(true);

    }//GEN-LAST:event_Vendedor_EmpleadoActionPerformed

    private void Vendedor_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vendedor_usuarioActionPerformed
        Usuarios us = new Usuarios();
        escritorio.add(us);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = us.getSize();
        us.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        us.show();
        //us.setVisible(true);

    }//GEN-LAST:event_Vendedor_usuarioActionPerformed

    private void altaProveedor_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaProveedor_SActionPerformed
        ProveedorAlta prove = new ProveedorAlta();
        escritorio.add(prove);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = prove.getSize();
        prove.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prove.show();
        //prove.setVisible(true);

    }//GEN-LAST:event_altaProveedor_SActionPerformed

    private void modiProveedor_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modiProveedor_SActionPerformed
        ProveedorModificar prove = new ProveedorModificar();
        escritorio.add(prove);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = prove.getSize();
        prove.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prove.show();
        //prove.setVisible(true);

    }//GEN-LAST:event_modiProveedor_SActionPerformed

    private void buscarProveedor_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProveedor_SActionPerformed

        ProveedorBuscar prove = new ProveedorBuscar();
        escritorio.add(prove);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = prove.getSize();
        prove.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prove.show();
        //prove.setVisible(true);


    }//GEN-LAST:event_buscarProveedor_SActionPerformed

    private void eliminarProveedor_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProveedor_SActionPerformed

        ProveedorBorrar prove = new ProveedorBorrar();
        escritorio.add(prove);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = prove.getSize();
        prove.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        prove.show();
        //prove.setVisible(true);
    }//GEN-LAST:event_eliminarProveedor_SActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        ProductosAlta produc = new ProductosAlta();
        escritorio.add(produc);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = produc.getSize();
        produc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        produc.show();
        ///produc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        ProductosModificar produc = new ProductosModificar();
        escritorio.add(produc);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = produc.getSize();
        produc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        produc.show();
        //produc.setVisible(true);


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ProductosBuscar produc = new ProductosBuscar();
        escritorio.add(produc);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = produc.getSize();
        produc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        produc.show();
        //produc.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ProductosBorrar produc = new ProductosBorrar();
        escritorio.add(produc);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = produc.getSize();
        produc.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        produc.show();
        //produc.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void altaPedidos_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaPedidos_SActionPerformed
        PedidosAlta pedidos = new PedidosAlta();
        escritorio.add(pedidos);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = pedidos.getSize();
        pedidos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        pedidos.show();
        //pedidos.setVisible(true);

    }//GEN-LAST:event_altaPedidos_SActionPerformed

    private void modiPedidos_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modiPedidos_SActionPerformed

        PedidosModificar pedidos = new PedidosModificar();
        escritorio.add(pedidos);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = pedidos.getSize();
        pedidos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        pedidos.show();
        //pedidos.setVisible(true);
    }//GEN-LAST:event_modiPedidos_SActionPerformed

    private void buscarPedidos_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPedidos_SActionPerformed
        PedidosBuscar pedidos = new PedidosBuscar();
        escritorio.add(pedidos);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = pedidos.getSize();
        pedidos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        pedidos.show();
        //pedidos.setVisible(true);
    }//GEN-LAST:event_buscarPedidos_SActionPerformed

    private void eliminarPedidos_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPedidos_SActionPerformed

        PedidosBorrar pedidos = new PedidosBorrar();
        escritorio.add(pedidos);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = pedidos.getSize();
        pedidos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        pedidos.show();
        //pedidos.setVisible(true);
    }//GEN-LAST:event_eliminarPedidos_SActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        NuevaVenta venta = new NuevaVenta(usuario);
        escritorio.add(venta);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = venta.getSize();
        venta.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        venta.show();
        //venta.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        HistorialVenta histo = new HistorialVenta();
        escritorio.add(histo);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = histo.getSize();
        histo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        histo.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        VentasTotal ventastot = new VentasTotal();
        escritorio.add(ventastot);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ventastot.getSize();
        ventastot.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        ventastot.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCerrarSesion;
    private javax.swing.JMenu MenuHistorial;
    private javax.swing.JMenu MenuProductos;
    private javax.swing.JMenu MenuProveedor;
    private javax.swing.JMenu MenuVendedor;
    private javax.swing.JMenu MenuVentas;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem Vendedor_Empleado;
    private javax.swing.JMenuItem Vendedor_usuario;
    private javax.swing.JMenuItem altaPedidos_S;
    private javax.swing.JMenuItem altaProveedor_S;
    private javax.swing.JMenuItem buscarPedidos_S;
    private javax.swing.JMenuItem buscarProveedor_S;
    private javax.swing.JMenuItem cambiarUsuario;
    private javax.swing.JPanel contenedor;
    private javax.swing.JMenuItem eliminarPedidos_S;
    private javax.swing.JMenuItem eliminarProveedor_S;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JMenuItem modiPedidos_S;
    private javax.swing.JMenuItem modiProveedor_S;
    // End of variables declaration//GEN-END:variables
}
