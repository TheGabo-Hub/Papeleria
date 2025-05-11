/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ventanas;

import Constructores.ConsEmpleado;
import clases.EmpleadosMet;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puppe
 */
public class VerEmpleado extends javax.swing.JInternalFrame {

    ConsEmpleado Emple = new ConsEmpleado();
    EmpleadosMet EmpleadosM = new EmpleadosMet();
    
    //Para la tabla
    DefaultTableModel modelo;
    
    public VerEmpleado() {
        initComponents();
        verEmpleado();
    }
    public void verEmpleado (){
        // Para que se guarde al empleado ahi
        List<ConsEmpleado> verEmpleado = EmpleadosM.ListarEmpleado();
        //El modelo
        modelo = (DefaultTableModel) tbVerEmpleado.getModel();
        //Creamos el objeto donde se guardara 
        Object [] obj = new Object[4];
        for (int i = 0; i < verEmpleado.size(); i++) {
            // se va a obtener del ver empleado los datos de el
            obj[0]=verEmpleado.get(i).getId_empleado();
            obj[1]=verEmpleado.get(i).getNombre();
            obj[2]=verEmpleado.get(i).getApellido();
            obj[3]=verEmpleado.get(i).getPuesto();
            
            // despues lo agg al modelo
            modelo.addRow(obj);
            
        }
        tbVerEmpleado1.setModel(modelo);
        
    }
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVerEmpleado = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVerEmpleado1 = new javax.swing.JTable();

        tbVerEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_empleado", "nombre", "apellido", "puesto"
            }
        ));
        jScrollPane1.setViewportView(tbVerEmpleado);

        setClosable(true);

        tbVerEmpleado1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_empleado", "nombre", "apellido", "puesto"
            }
        ));
        jScrollPane2.setViewportView(tbVerEmpleado1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbVerEmpleado;
    private javax.swing.JTable tbVerEmpleado1;
    // End of variables declaration//GEN-END:variables
}
