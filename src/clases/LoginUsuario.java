package clases;

import Constructores.ConsUsuario;
import java.sql.PreparedStatement;
import conexiones.Conectar;
//import java.awt.List;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class LoginUsuario {

    // tenemos que hacer las variables para conectar a la base de datos
    Connection conectar;
    PreparedStatement pst;
    ResultSet rs;     // te permite iterar sobre los resultados obtenidos se ocupa con un while
    Conectar cn = new Conectar();
    // Hacer un Metodo de tipo Contructores 

    public ConsUsuario sesion(String usuario, String contrasena) {
        ConsUsuario us = new ConsUsuario();
        // Hacer la consulta a la base de datos
        String sql = "SELECT u.*,e.puesto,e.nombre "
                + "FROM usuarios u "
                + "INNER JOIN empleado e ON u.id_empleado = e.id_empleado "
                + "WHERE u.usuario=? AND u.contrasena=?";
        try {
            // se ejecuta
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();

            // Se extrae los valores de la base de datos 
            if (rs.next()) {
                // si es correcto la informacion va a actualizarla 
                
                us.setUsuario(rs.getString("usuario"));
                us.setContrasena(rs.getString("contrasena"));
                us.setPuesto(rs.getString("puesto"));
                us.setNombre(rs.getString("nombre"));
                us.setId_empleado(rs.getInt("id_empleado"));
                
                return us;
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Error");
            return null;
        }
       return us;
    }

    public void ChecarEmpleado(JComboBox Box) {
        // Hacer sentencia sql para traer el id_usuario de la tabla de usuarios
        String sql = "SELECT id_empleado FROM empleado";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            //Recorrer la tabla con un bucle
            while (rs.next()) {
                Box.addItem(rs.getInt("id_empleado"));
            }

        } catch (SQLException e) {

        }

    }

    public boolean RegistrarUsuario(ConsUsuario us) {
        String sql = "INSERT INTO usuarios (id_usuario,usuario,contrasena,id_empleado) VALUES (?,?,?,?)";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, us.getId_usuario());       // Se pone aunque no se guarde nada
            pst.setString(2, us.getUsuario());
            pst.setString(3, us.getContrasena());
            pst.setInt(4, us.getId_empleado());
            
            
            int filasAfectadas = pst.executeUpdate(); 
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Usuario Registrado con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println(numMaxim());
            System.out.println("Mal");
            return false;

        }

    }

    public List ListarUsuarios() {
        // Se crea una lista para listar a los usuarios y aparezcan en la tabla
        List<ConsUsuario> ListaUsu = new ArrayList();

        String sql = "SELECT * FROM usuarios";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Vamos a recorrer la tabla
            while (rs.next()) {
                ConsUsuario us = new ConsUsuario();
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setUsuario(rs.getString("usuario"));
                us.setContrasena(rs.getString("contrasena"));
                us.setId_empleado(rs.getInt("id_empleado"));
                ListaUsu.add(us);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("a");
        }
        return ListaUsu;

    }

    public boolean EliminarUsuario(int idu) {
        String sql = "DELETE FROM usuarios WHERE id_usuario =?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, idu);
            
             int filasAfectadas = pst.executeUpdate(); 
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Usuario Eliminado  con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
            
            
            
            
            
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                conectar.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean ModificarUsuario(ConsUsuario us) {

        String sql = "UPDATE usuarios SET usuario=?,contrasena=?,id_empleado=? WHERE id_usuario=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            // el cero seria el id pero ese no se puede modificar
            pst.setString(1, us.getUsuario());
            pst.setString(2, us.getContrasena());
            pst.setInt(3, us.getId_empleado());
            pst.setInt(4, us.getId_usuario());
             int filasAfectadas = pst.executeUpdate(); 
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Usuario Modificado  con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                conectar.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        }
    }

    public int obtenernumU() {
        int numM = 0;
        String sql = "SELECT * FROM  usuarios";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                numM = rs.getInt("id_usuario"); // aqui obtenemos el numero del id del empleado
            }
            return numM;

        } catch (SQLException e) {
            System.out.println(e.toString());
          
            return numM;

        } finally {
            try {
                conectar.close();

            } catch (SQLException e) {
                System.out.println(e.toString());
              

            }
        }
    }

    public int numMaxim() {
        int num = obtenernumU();
        if (num >-1) {
            int numMax = num + 1;
            return numMax;

        } else {
            return num;
        }
        // sumarle 1

    }

}
