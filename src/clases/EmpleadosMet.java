package clases;

import Constructores.ConsEmpleado;
import Constructores.ConsProducto;
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

public class EmpleadosMet {

    Connection conectar;
    PreparedStatement pst;
    ResultSet rs;
    Conectar cn = new Conectar();

    public boolean RegistrarEmpleado(ConsEmpleado empleado) {

        String sql = "INSERT INTO empleado (id_empleado,nombre,apellido,telefono,correo,direccion,puesto)"
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);

            //  vamos a asignarlos en el objeto empleado para mandarlos a la base
            pst.setInt(1, empleado.getId_empleado());
            pst.setString(2, empleado.getNombre());
            pst.setString(3, empleado.getApellido());
            pst.setString(4, empleado.getTelefono());
            pst.setString(5, empleado.getCorreo());
            pst.setString(6, empleado.getDireccion());
            pst.setString(7, empleado.getPuesto());
            
            
            int filasAfectadas = pst.executeUpdate(); // Ejecutar la actualización y obtener el número de filas afectadas
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Empleado Registrado con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Ups error");
            return false;

        }

    }

    public int obtenernumE() {
        int numM = 0;
        String sql = "SELECT * FROM empleado";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                numM = rs.getInt("id_empleado"); // aqui obtenemos el numero del id del empleado
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
        int num = obtenernumE();
     
          
            int numMax = num + 1;
            
            return numMax;

        // sumarle 1

    }

    public List ListarEmpleado() {
        List<ConsEmpleado> ListaEm = new ArrayList();
        String sql = "SELECT *FROM empleado";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsEmpleado Cemp = new ConsEmpleado();
                Cemp.setId_empleado(rs.getInt("id_empleado"));
                Cemp.setNombre(rs.getString("nombre"));
                Cemp.setApellido(rs.getString("apellido"));
                Cemp.setTelefono(rs.getString("telefono"));
                Cemp.setCorreo(rs.getString("correo"));
                Cemp.setDireccion(rs.getString("direccion"));
                Cemp.setPuesto(rs.getString("puesto"));

                //Lo agregamos a la lista
                ListaEm.add(Cemp);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaEm;

    }

    public boolean EliminarEmpleado(int ide) {
        String sql = "DELETE FROM empleado WHERE  id_empleado=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, ide);
           
            
             int filasAfectadas = pst.executeUpdate(); 
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Empleado eliminado con exito");
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

    public boolean ModificarEmpleado(ConsEmpleado Cem) {
        String sql = "UPDATE empleado SET nombre=?,apellido=?,telefono=?,correo=?,direccion=?,puesto=? WHERE id_empleado=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            // Tiene que ir en orden como esta la sentencia SQL
            pst.setString(1, Cem.getNombre());
            pst.setString(2, Cem.getApellido());
            pst.setString(3, Cem.getTelefono());
            pst.setString(4, Cem.getCorreo());
            pst.setString(5, Cem.getDireccion());
            pst.setString(6, Cem.getPuesto());
            pst.setInt(7, Cem.getId_empleado());
             int filasAfectadas = pst.executeUpdate(); 
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Empleado modificado con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Mal");
            return false;
        } finally {
            try {
                conectar.close();

            } catch (SQLException ex) {
                System.out.println(ex.toString());

            }
        }

    }
    
     public boolean validarEmpleado(ConsEmpleado empleado) {
        String sql = "SELECT nombre FROM empleado where nombre=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setString(1, empleado.getNombre());

            // Aqui devuelve algo si se encontro
            rs = pst.executeQuery();

            return rs.next();
            
           

        } catch (SQLException e) {
            System.out.println("Ups algo salio mal");
            return false;

        }

    }
}
