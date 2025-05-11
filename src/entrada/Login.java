/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package entrada;

import Constructores.ConsUsuario;
import clases.LoginUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author puppe
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private int intentosFallidos;
    public Login() {
        initComponents();
        intentosFallidos=3;
        this.setLocationRelativeTo(null);
        txtUsuario.setText("sa");
        txtContrasena.setText("1");
    }

     // Hacer un metodo para validar el usuario
  public void validar() {
    // Hacemos los metodos de las clases que tiene los contructores
    // y tambien donde esta la consulta sql ala base de datos

    ConsUsuario usuario = new ConsUsuario();  // Donde vienen los constructores y set y get
    LoginUsuario inicio = new LoginUsuario(); // La consulta SQL 

    // Para hacer un controlador de las veces que ingresa el usuario mas de 3 veces cerrar el programa
    // mandar un mensaje de intentos fallidos muchas veces
 
    // Se obtienen los datos usuario y la contraseña
    String usuar = txtUsuario.getText();
    // Como es una contraseña se tiene que parcear
    String contra = String.valueOf(txtContrasena.getPassword());

    // Primero verificar si no estan vacios los campos
    if (txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
        //Se mostrara un mensaje
        txtUsuario.requestFocus();// Para hacer un focus al campo usuario
        JOptionPane.showMessageDialog(null, "Los campos están vacíos. Ingrese los datos nuevamente");
    } else {
        //Para cuando sí hay datos
        if (!"".equals(usuar) && !"".equals(contra)) {
            // Utilizamos el objeto de los constructores y el metodo que esta en la 
            // otra clase de LoginUsuario
            usuario = inicio.sesion(usuar, contra);

            // Metemos otro if paara verificar si el usuario no esta vacio o la contraseña
            if (usuario.getUsuario() != null || usuario.getContrasena() != null) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido!     "+usuario.getPuesto());
                // Aqui es donde ponemos la instancia del sistema
                Sistema sis= new Sistema(usuario); // mandammos todo lo que tiene el 
                //Sistema sis= new Sistema(); // mandammos todo lo que tiene el usuario
                sis.setVisible(true);
                dispose();
            } else {
                // aqui es donde estan los intentos fallidos aqui tiene que incrementar el contador
                intentosFallidos--; // para que solo incremente cuando falla
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta \n"
                        + "Intentos Restantes :"+ intentosFallidos);
                txtUsuario.setText("");
                txtContrasena.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Espacios en blanco");
            txtUsuario.setText("");
            txtContrasena.setText("");
        }
    }
    System.out.println(intentosFallidos);
    if (intentosFallidos ==0){
        JOptionPane.showMessageDialog(null,"Demasiados intentos regrese mas tarde");
        System.exit(0);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ver = new javax.swing.JLabel();
        nover = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(237, 208, 162));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/p.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Inicio de Sesion");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 21));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iniciar-sesion (1).png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Usuario ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 105, -1));

        txtUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 210, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user2.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/password.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 285, -1, -1));

        txtContrasena.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txtContrasena.setBorder(null);
        jPanel2.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 210, -1));

        btnEntrar.setBackground(new java.awt.Color(0, 0, 0));
        btnEntrar.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(0, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setText("Contraseña");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png"))); // NOI18N
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMouseClicked(evt);
            }
        });
        jPanel2.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        nover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ocultarO.png"))); // NOI18N
        nover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noverMouseClicked(evt);
            }
        });
        jPanel2.add(nover, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // llamamos al metodo validar

        validar();

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void verMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseClicked

        ver.setVisible(false);
        nover.setVisible(true);
        txtContrasena.setEchoChar((char)0);

    }//GEN-LAST:event_verMouseClicked

    private void noverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noverMouseClicked

        ver.setVisible(true);
        nover.setVisible(false);
        txtContrasena.setEchoChar('°');

    }//GEN-LAST:event_noverMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nover;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel ver;
    // End of variables declaration//GEN-END:variables
}
