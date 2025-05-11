package clases;

import Constructores.ConsEmpleado;
import Constructores.ConsProducto;
import Constructores.ConsProveedor;
import conexiones.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProveedoresMet {

    Connection conectar;
    PreparedStatement pst;
    ResultSet rs;
    Conectar cn = new Conectar();

    public boolean RegistrarProveedor(ConsProveedor proveedor) {

        String sql = "INSERT INTO proveedor (id_proveedor,nombre,telefono,correo,direccion)"
                + "VALUES (?,?,?,?,?)";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);

            //  vamos a asignarlos en el objeto empleado para mandarlos a la base
            pst.setInt(1, proveedor.getId_proveedor());
            pst.setString(2, proveedor.getNombre());
            pst.setString(3, proveedor.getTelefono());
            pst.setString(4, proveedor.getCorreo());
            pst.setString(5, proveedor.getDireccion());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Proveedor agregado  con exito");
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Proveedor ya existente", "Erro de alta", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    public int obtenernumE() {
        int numM = 0;
        String sql = "SELECT * FROM proveedor";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                numM = rs.getInt("id_proveedor"); // aqui obtenemos el numero del id del empleado
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

    public List ListarProveedor() {
        List<ConsProveedor> ListaPr = new ArrayList();
        String sql = "SELECT *FROM proveedor";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsProveedor Cpro = new ConsProveedor();
                Cpro.setId_proveedor(rs.getInt("id_proveedor"));
                Cpro.setNombre(rs.getString("nombre"));
                Cpro.setTelefono(rs.getString("telefono"));
                Cpro.setCorreo(rs.getString("correo"));
                Cpro.setDireccion(rs.getString("direccion"));

                //Lo agregamos a la lista
                ListaPr.add(Cpro);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPr;

    }

    public boolean ModificarProveedor(ConsProveedor pro) {
        String sql = "UPDATE proveedor SET nombre=?,telefono=?,correo=?,direccion=? WHERE id_proveedor=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            // Tiene que ir en orden como esta la sentencia SQL
            pst.setString(1, pro.getNombre());
            pst.setString(2, pro.getTelefono());
            pst.setString(3, pro.getCorreo());
            pst.setString(4, pro.getDireccion());
            pst.setInt(5, pro.getId_proveedor());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Proveedor modificado con exito");
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Mal");
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

    public List BuscarProveedor(ConsProveedor pro) {
        String sql;
        List<ConsProveedor> BuscarPr = new ArrayList<>();

        try {
            conectar = cn.conexion();

            // Verificar si se proporcionó el ID del proveedor
            if (pro.getId_proveedor() != 0) {
                sql = "SELECT * FROM proveedor WHERE id_proveedor = ?";
                pst = conectar.prepareStatement(sql);
                pst.setInt(1, pro.getId_proveedor());
            } else if (!pro.getNombre().isEmpty()) {
                // Si no se proporcionó el ID, verificar si se proporcionó el nombre del proveedor
                sql = "SELECT * FROM proveedor WHERE nombre = ?";
                pst = conectar.prepareStatement(sql);
                pst.setString(1, pro.getNombre());
            } else {
                // Si no se proporcionó ni el ID ni el nombre, no hay criterios de búsqueda válidos
                throw new IllegalArgumentException("Debe proporcionar al menos el ID o el nombre del proveedor para realizar la búsqueda.");
            }

            rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se Encontro el proveedor");
                //return BuscarProductos; // Devolver lista vacía
            }
            rs.beforeFirst();
            
            
            
            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsProveedor proveedorE = new ConsProveedor();
                proveedorE.setId_proveedor(rs.getInt("id_proveedor"));
                proveedorE.setNombre(rs.getString("nombre"));
                proveedorE.setTelefono(rs.getString("telefono"));
                proveedorE.setCorreo(rs.getString("correo"));
                proveedorE.setDireccion(rs.getString("direccion"));

                //Lo agregamos a la lista
                BuscarPr.add(proveedorE);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return BuscarPr;

    }

    public boolean EliminarProveedor(ConsProveedor pro) {
        String sql;

        try {
            conectar = cn.conexion();

            // Verificar si se proporcionó el ID del proveedor
            if (pro.getId_proveedor() != 0) {
                sql = "DELETE  FROM proveedor WHERE id_proveedor = ?";
                pst = conectar.prepareStatement(sql);
                pst.setInt(1, pro.getId_proveedor());

            } else if (!pro.getNombre().isEmpty()) {
                // Si no se proporcionó el ID, verificar si se proporcionó el nombre del proveedor
                sql = "DELETE  FROM proveedor WHERE nombre = ?";
                pst = conectar.prepareStatement(sql);
                pst.setString(1, pro.getNombre());
            } else {
                // Si no se proporcionó ni el ID ni el nombre, no hay criterios de búsqueda válidos
                JOptionPane.showMessageDialog(null, "Ingrese valor valido");

            }

            int filasafectadas = pst.executeUpdate();

            if (filasafectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null, "Se borro perfectamente");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                JOptionPane.showMessageDialog(null, "No se encuentra el proveedor");

                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Algo salio mal");

            return false;
        } finally {
            try {
                conectar.close();

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

    }
    
    public boolean validarP(ConsProveedor proveedor){
        String sql ="SELECT id_proveedor FROM proveedor where id_proveedor=?";
        try{ 
                conectar = cn.conexion();
                pst = conectar.prepareStatement(sql);
                pst.setInt(1, proveedor.getId_proveedor());
                
                
                // Aqui devuelve algo si se encontro
                 rs = pst.executeQuery();
                 
            return rs.next(); // EL producto ya existe
            
        }catch (SQLException e){
            System.out.println("Ups algo salio mal");
            return false;
            
        }        
        
    }
}
