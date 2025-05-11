package clases;

import Constructores.ConsPedidos;
import Constructores.ConsProducto;
import conexiones.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author puppe
 */
public class PedidosMet {

    Connection conectar;
    PreparedStatement pst;
    ResultSet rs;
    Conectar cn = new Conectar();

    public void ChecarProveedor(JList<String> listaNombresEmpleados) {
        // Hacer sentencia SQL para traer el nombre de los empleados de la tabla
        String sql = "SELECT nombre FROM proveedor";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Crear una lista para almacenar los nombres de los empleados
            List<String> nombresEmpleados = new ArrayList<>();

            // Recorrer la tabla con un bucle y agregar los nombres a la lista
            while (rs.next()) {
                nombresEmpleados.add(rs.getString("nombre"));
            }

            // Configurar la lista con los nombres de los empleados
            listaNombresEmpleados.setListData(nombresEmpleados.toArray(new String[0]));

        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        }
    }

    public void ChecarProducto(JList<String> listaNombresProductos) {
        // Hacer sentencia SQL para traer el nombre de los productos de la tabla
        String sql = "SELECT descripcion FROM producto";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Crear una lista para almacenar los nombres de los productos
            List<String> nombresProductos = new ArrayList<>();

            // Recorrer la tabla con un bucle y agregar los nombres a la lista
            while (rs.next()) {
                nombresProductos.add(rs.getString("descripcion"));
            }

            // Configurar el JList con los nombres de los productos
            listaNombresProductos.setListData(nombresProductos.toArray(new String[0]));

        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        }
    }

    public int ChecarIdProveedor(String nombre) {
        int id = 0;
        String sql = "SELECT id_proveedor FROM proveedor WHERE nombre=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setString(1, nombre);
            rs = pst.executeQuery();

            // Se recorre la tabla con rs
            while (rs.next()) {
                id = (rs.getInt("id_proveedor"));

                //Lo agregamos a la lista
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;

    }

    public long ChecarIdProducto(String nombre) {
        long id = 0 ;
        String sql = "SELECT id_producto FROM producto WHERE descripcion=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setString(1, nombre);
            rs = pst.executeQuery();

            // Se recorre la tabla con rs
            while (rs.next()) {
                id = (rs.getLong("id_producto"));

                //Lo agregamos a la lista
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;

    }

    public List ListarPedidos() {
        List<ConsPedidos> ListaPedidos = new ArrayList();
        String sql = "SELECT *FROM pedidos";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsPedidos Cpedidos = new ConsPedidos();
                Cpedidos.setId_pedido(rs.getInt("id_pedido"));
                Cpedidos.setId_proveedor(rs.getInt("id_proveedor"));
                Cpedidos.setId_producto(rs.getLong("id_producto"));
                Cpedidos.setCantidad_producto(rs.getInt("cantidad_producto"));
                Cpedidos.setPrecio_unidad(rs.getFloat("precio_unidad"));
                Cpedidos.setPrecio_total(rs.getFloat("precio_total"));
                Cpedidos.setFecha(rs.getString("fecha"));
                Cpedidos.setHora(rs.getString("hora"));
                //Lo agregamos a la lista
                ListaPedidos.add(Cpedidos);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPedidos;
    }

    public boolean RegistrarPedido(ConsPedidos pedidos) {

        String sql = "INSERT INTO pedidos (id_pedido,id_proveedor,id_producto,cantidad_producto,precio_unidad,precio_total,fecha,hora)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);

            //  vamos a asignarlos en el objeto empleado para mandarlos a la base
            pst.setInt(1, pedidos.getId_pedido());
            pst.setInt(2, pedidos.getId_proveedor());
            pst.setLong(3, pedidos.getId_producto());
            pst.setInt(4, pedidos.getCantidad_producto());
            pst.setFloat(5, pedidos.getPrecio_unidad());
            pst.setFloat(6, pedidos.getPrecio_total());
            pst.setString(7, pedidos.getFecha());
            pst.setString(8, pedidos.getHora());

            int comprobar = pst.executeUpdate();

            if (comprobar > 0) {
                JOptionPane.showMessageDialog(null, "pedido Registrado con exito");

            } else {
                JOptionPane.showMessageDialog(null, "pedido No registrado");
            }

            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ups Algo salio Mal", "Error de alta", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    public boolean ModificarPedido(ConsPedidos pedidos) {
        String sql = "UPDATE pedidos SET id_proveedor=?,id_producto=?,cantidad_producto=?,precio_unidad=?,precio_total=?,fecha=?,hora=? WHERE id_pedido=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            // Tiene que ir en orden como esta la sentencia SQL
            pst.setInt(1, pedidos.getId_proveedor());
            pst.setLong(2, pedidos.getId_producto());
            pst.setInt(3, pedidos.getCantidad_producto());
            pst.setFloat(4, pedidos.getPrecio_unidad());
            pst.setFloat(5, pedidos.getPrecio_total());
            pst.setString(6, pedidos.getFecha());
            pst.setString(7, pedidos.getHora());
            pst.setInt(8, pedidos.getId_pedido());

            int filasAfectadas = pst.executeUpdate(); // Ejecutar la actualización y obtener el número de filas afectadas
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null,"Pedido Modificado con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Ups algo salio Mal");

            return false;
        } finally {
            try {
                conectar.close();

            } catch (SQLException ex) {
                System.out.println(ex.toString());

            }
        }

    }

    public List BuscarPedidos(ConsPedidos pedidos) {
        String sql;
        List<ConsPedidos> BuscarPedidos = new ArrayList<>();

        try {
            conectar = cn.conexion();
            if (pedidos.getId_pedido()!= 0) {

                sql = "SELECT * FROM pedidos WHERE id_pedido = ?";
                pst = conectar.prepareStatement(sql);
                pst.setInt(1, pedidos.getId_pedido());
                rs = pst.executeQuery();
            } else {
                throw new IllegalArgumentException("Debe proporcionar al menos el ID o el nombre del producto para realizar la búsqueda.");

            }
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se Encontro el pedido");
                //return BuscarProductos; // Devolver lista vacía
            }
            rs.beforeFirst();
            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsPedidos Cpedidos = new ConsPedidos();
                Cpedidos.setId_pedido(rs.getInt("id_pedido"));
                Cpedidos.setId_proveedor(rs.getInt("id_proveedor"));
                Cpedidos.setId_producto(rs.getLong("id_producto"));
                Cpedidos.setCantidad_producto(rs.getInt("cantidad_producto"));
                Cpedidos.setPrecio_unidad(rs.getFloat("precio_unidad"));
                Cpedidos.setPrecio_total(rs.getFloat("precio_total"));
                Cpedidos.setFecha(rs.getString("fecha"));
                Cpedidos.setHora(rs.getString("hora"));
                //Lo agregamos a la lista
                BuscarPedidos.add(Cpedidos);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());

        }
        return BuscarPedidos;

    }

    public boolean EliminarPedidos(ConsPedidos pedidos) {
        String sql;

        try {
            conectar = cn.conexion();

            // Verificar si se proporcionó el ID del proveedor
            if (pedidos.getId_pedido()!= 0) {
                sql = "DELETE  FROM pedidos WHERE id_pedido = ?";
                pst = conectar.prepareStatement(sql);
                pst.setInt(1, pedidos.getId_pedido());
            
            } else {
                // Si no se proporcionó ni el ID ni el nombre, no hay criterios de búsqueda válidos
                throw new IllegalArgumentException("Debe proporcionar al menos el ID o el nombre del producto  para realizar la eliminacion");
            }

            int filasafectadas = pst.executeUpdate();

            if (filasafectadas > 0) {
                // Se actualizó al menos un registro
                 JOptionPane.showMessageDialog(null,"Se borro exitosamente");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                System.out.println("No esta el pedido");
                  JOptionPane.showMessageDialog(null,"No se esta el pedido");
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
        String sql = "SELECT * FROM  pedidos";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                numM = rs.getInt("id_pedido"); // aqui obtenemos el numero del id del empleado
            }
            return numM;

        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("a");
            return numM;

        } finally {
            try {
                conectar.close();

            } catch (SQLException e) {
                System.out.println(e.toString());
                System.out.println("a");

            }
        }
    }

    public int numMaxim() {
        int num = obtenernumU();
        if (num >=0) {
            int numMax = num + 1;
            return numMax;

        } else {
            return num;
        }
        // sumarle 1

    }
    
    public void VerSeleccionadoProducto(Long id_producto, JList producto) {
        String sql = "SELECT descripcion FROM producto WHERE id_producto=?";
        String name;
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setLong(1, id_producto);
            rs = pst.executeQuery();
            
            // Crear una lista para almacenar los nombres de los productos
            // Recorrer la tabla con un bucle y agregar los nombres a la lista
            while (rs.next()) {
                name = (rs.getString("descripcion"));
                producto.setSelectedValue(name, true);
            }

            // Configurar el JList con los nombres de los productos
        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        }
    }
        
        
    public void BuscaProducto(ConsProducto productos, JList producto) {
        String sql ;
        String name;
        try {
            conectar = cn.conexion();
            if (productos.getId_producto() != null) {
                sql = "SELECT * FROM producto WHERE id_producto = ?";
                pst = conectar.prepareStatement(sql);
                pst.setLong(1, productos.getId_producto());
            } else if (!productos.getDescripcion().isEmpty()) {
                // Si no se proporcionó el ID, verificar si se proporcionó el nombre del proveedor
                sql = "SELECT * FROM producto WHERE descripcion = ?";
                pst = conectar.prepareStatement(sql);
                pst.setString(1, productos.getDescripcion());
            } else {
                // Si no se proporcionó ni el ID ni el nombre, no hay criterios de búsqueda válidos
                throw new IllegalArgumentException("Debe proporcionar al menos el ID o el nombre del producto para realizar la búsqueda.");
            }

            rs= pst.executeQuery();
            
              if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se Encontro el producto");
                //return BuscarProductos; // Devolver lista vacía
            }
            rs.beforeFirst();
                

            // Crear una lista para almacenar los nombres de los productos
            // Recorrer la tabla con un bucle y agregar los nombres a la lista
            while (rs.next()) {
                name = (rs.getString("descripcion"));
                producto.setSelectedValue(name, true);
            }

            // Configurar el JList con los nombres de los productos
        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        }
    }
    
    public void VerSeleccionadoProveedor(int id_proveedor, JList proveedor) {
        String sql = "SELECT nombre FROM proveedor WHERE id_proveedor=?";
        String name;
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, id_proveedor);
            rs = pst.executeQuery();
            
            
            // Crear una lista para almacenar los nombres de los productos
            // Recorrer la tabla con un bucle y agregar los nombres a la lista
            while (rs.next()) {
                name = (rs.getString("nombre"));
                proveedor.setSelectedValue(name, true);
            }

            // Configurar el JList con los nombres de los productos
        } catch (SQLException e) {
            // Manejar excepciones SQL
            e.printStackTrace();
        }
    }
}
