package clases;

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

public class ProductosMet {

    Connection conectar;
    PreparedStatement pst;
    ResultSet rs;
    Conectar cn = new Conectar();

    public boolean RegistrarProducto(ConsProducto producto) {

        String sql = "INSERT INTO producto (id_producto,descripcion,stock,precio_venta,precio_compra)"
                + "VALUES (?,?,?,?,?)";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);

            //  vamos a asignarlos en el objeto empleado para mandarlos a la base
            pst.setLong(1, producto.getId_producto());// Cambio por que el codigo de barras es de 13 a 15 numeros
            pst.setString(2, producto.getDescripcion());
            pst.setInt(3, producto.getStock());
            pst.setFloat(4, producto.getPrecio_venta());
            pst.setFloat(5, producto.getPrecio_compra());
            
            
            int filasAfectadas = pst.executeUpdate(); // Ejecutar la actualización y obtener el número de filas afectadas
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
               // JOptionPane.showMessageDialog(null, "Producto registrado  con exito");
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Producto ya existente", "Erro de alta", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    public List ListarProducto() {
        List<ConsProducto> ListaPr = new ArrayList();
        String sql = "SELECT *FROM producto";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            rs = pst.executeQuery();

            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsProducto Cpro = new ConsProducto();
                Cpro.setId_producto(rs.getLong("id_producto"));
                Cpro.setDescripcion(rs.getString("descripcion"));
                Cpro.setStock(rs.getInt("stock"));
                Cpro.setPrecio_venta(rs.getFloat("precio_venta"));
                Cpro.setPrecio_compra(rs.getFloat("precio_compra"));
                //Lo agregamos a la lista
                ListaPr.add(Cpro);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPr;
    }

    public boolean ModificarProducto(ConsProducto producto) {
        String sql = "UPDATE producto SET descripcion=?,stock=?,precio_venta=?,precio_compra=? WHERE id_producto=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            // Tiene que ir en orden como esta la sentencia SQL
            pst.setString(1, producto.getDescripcion());
            pst.setInt(2, producto.getStock());
            pst.setFloat(3, producto.getPrecio_venta());
            pst.setFloat(4, producto.getPrecio_compra());
            pst.setLong(5, producto.getId_producto());

            int filasAfectadas = pst.executeUpdate(); // Ejecutar la actualización y obtener el número de filas afectadas
            if (filasAfectadas > 0) {
                // Se actualizó al menos un registro
                return true;
            } else {
                // No se encontró ningún registro para actualizar
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Mal");

            return false;
        } finally {
            try {
                conectar.close();

            } catch (SQLException ex) {
                System.out.println(ex.toString());

            }
        }

    }

    public List BuscarProductos(ConsProducto productos) {
        String sql;
        List<ConsProducto> BuscarProductos = new ArrayList<>();

        try {
            conectar = cn.conexion();

            // Verificar si se proporcionó el ID del proveedor 
            // recordar quel long es null no es cero(Checar las demas ventanas de  buscar
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

            rs = pst.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No se Encontro el producto");
                //return BuscarProductos; // Devolver lista vacía
            }
            rs.beforeFirst();
            // Se recorre la tabla con rs
            while (rs.next()) {
                ConsProducto product = new ConsProducto();
                product.setId_producto(rs.getLong("id_producto"));
                product.setDescripcion(rs.getString("descripcion"));
                product.setStock(rs.getInt("stock"));
                product.setPrecio_venta(rs.getFloat("precio_venta"));
                product.setPrecio_compra(rs.getFloat("precio_compra"));

                //Lo agregamos a la lista
                BuscarProductos.add(product);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());

        }
        return BuscarProductos;

    }

    public boolean EliminarProductos(ConsProducto productos) {
        String sql;

        try {
            conectar = cn.conexion();

            // Verificar si se proporcionó el ID del proveedor
            if (productos.getId_producto() != null) {
                sql = "DELETE  FROM producto WHERE id_producto = ?";
                pst = conectar.prepareStatement(sql);
                pst.setLong(1, productos.getId_producto());
            } else if (!productos.getDescripcion().isEmpty()) {
                // Si no se proporcionó el ID, verificar si se proporcionó el nombre del proveedor
                sql = "DELETE  FROM producto WHERE descripcion = ?";
                pst = conectar.prepareStatement(sql);
                pst.setString(1, productos.getDescripcion());
            } else {
                // Si no se proporcionó ni el ID ni el nombre, no hay criterios de búsqueda válidos
                throw new IllegalArgumentException("Debe proporcionar al menos el ID o el nombre del producto  para realizar la eliminacion");
            }

            int filasafectadas = pst.executeUpdate();

            if (filasafectadas > 0) {
                // Se actualizó al menos un registro
                JOptionPane.showMessageDialog(null, "Producto borrado exitosamente");
                return true;
            } else {
                // No se encontró ningún registro para actualizar

                JOptionPane.showMessageDialog(null, "No  esta el producto");
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

    public boolean validarP(ConsProducto produc) {
        String sql = "SELECT id_producto FROM producto where id_producto=?";
        try {
            conectar = cn.conexion();
            pst = conectar.prepareStatement(sql);
            pst.setLong(1, produc.getId_producto());

            // Aqui devuelve algo si se encontro
            rs = pst.executeQuery();

            return rs.next(); // EL producto ya existe

        } catch (SQLException e) {
            System.out.println("Ups algo salio mal");
            return false;

        }

    }
}
