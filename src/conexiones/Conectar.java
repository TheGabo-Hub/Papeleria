/*
package conexiones;
// Importamos las extensiones
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    // Las variables
    Connection conectar;
    String usuario    = "root";
    String contrasena = "";
    String db         = "pape";
    String ip         = "localhost";
    String puerto     = "3306";
    
    String cadena     = "jdbc:sqlite://"+ip+":"+puerto+"/"+db;
    
   // un metodo para la conexion
    public Connection conexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena,usuario,contrasena);
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return conectar;
        
    }
    
    
    
}*/
package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {

    private Connection conectar;
    private final String db = "pape.db"; // El archivo SQLite
    private final String cadena = "jdbc:sqlite:" + db;

    // Método principal para conectar y crear tablas
    public Connection conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection(cadena);
            System.out.println("Conexion exitosa a SQLite: " + db);

            // Activar claves foráneas
            try (Statement stmt = conectar.createStatement()) {
                stmt.execute("PRAGMA journal_mode=WAL;");
                stmt.execute("PRAGMA foreign_keys = ON;");
            }

            // Crear las tablas si no existen
            crearTablas();
             insertarRegistrosIniciales();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conectar;
    }

    // Método para crear todas las tablas
    private void crearTablas() {
        try (Statement stmt = conectar.createStatement()) {
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS empleado (
                    id_empleado INTEGER PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    apellido TEXT NOT NULL,
                    telefono TEXT NOT NULL,
                    correo TEXT NOT NULL,
                    direccion TEXT NOT NULL,
                    puesto TEXT NOT NULL
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS producto (
                    id_producto INTEGER PRIMARY KEY AUTOINCREMENT,
                    descripcion TEXT NOT NULL,
                    stock INTEGER NOT NULL,
                    precio_venta REAL NOT NULL,
                    precio_compra REAL NOT NULL
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS proveedor (
                    id_proveedor INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    telefono TEXT NOT NULL,
                    correo TEXT NOT NULL,
                    direccion TEXT NOT NULL
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS venta (
                    folio INTEGER PRIMARY KEY AUTOINCREMENT,
                    id_empleado INTEGER NOT NULL,
                    fecha TEXT NOT NULL,
                    hora TEXT NOT NULL,
                    total REAL NOT NULL,
                    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado) ON DELETE CASCADE ON UPDATE CASCADE
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS detalle_venta (
                    folio INTEGER NOT NULL,
                    id_producto INTEGER NOT NULL,
                    producto TEXT NOT NULL,
                    precio_venta REAL NOT NULL,
                    cantidad INTEGER NOT NULL,
                    totalarti REAL NOT NULL,
                    FOREIGN KEY (folio) REFERENCES venta(folio) ON DELETE CASCADE ON UPDATE CASCADE,
                    FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE ON UPDATE CASCADE
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS pedidos (
                    id_pedido INTEGER PRIMARY KEY AUTOINCREMENT,
                    id_proveedor INTEGER NOT NULL,
                    id_producto INTEGER NOT NULL,
                    cantidad_producto INTEGER NOT NULL,
                    precio_unidad REAL NOT NULL,
                    fecha TEXT NOT NULL,
                    hora TEXT NOT NULL,
                    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor) ON DELETE CASCADE ON UPDATE CASCADE,
                    FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE ON UPDATE CASCADE
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS usuarios (
                    id_usuario INTEGER PRIMARY KEY,
                    usuario TEXT NOT NULL,
                    contrasena TEXT NOT NULL,
                    id_empleado INTEGER NOT NULL,
                    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado) ON DELETE CASCADE ON UPDATE CASCADE
                );
            """);

            System.out.println("Tablas creadas o ya existentes.");

        } catch (SQLException e) {
            System.out.println("Error al crear tablas: " + e.getMessage());
        }
    }

    private void insertarRegistrosIniciales() {
        try (Statement stmt = conectar.createStatement()) {
            // Verificar si ya existe un empleado con nombre "Gabriel"
            ResultSet rs = stmt.executeQuery("SELECT id_empleado FROM empleado WHERE nombre='Gabriel'");
            if (!rs.next()) {
                stmt.executeUpdate("""
                    INSERT INTO empleado (nombre, apellido, telefono, correo, direccion, puesto)
                    VALUES ('Gabriel', 'Perez', '1234567890', 'gabriel@correo.com', 'Calle Falsa 123', 'ADMINISTRADOR');
                """);

                // Obtener el id_empleado recién insertado
                ResultSet empleadoRs = stmt.executeQuery("SELECT id_empleado FROM empleado WHERE nombre='Gabriel'");
                if (empleadoRs.next()) {
                    int idEmpleado = empleadoRs.getInt("id_empleado");

                    // Insertar un usuario vinculado al empleado
                    stmt.executeUpdate(String.format("""
                        INSERT INTO usuarios (usuario, contrasena, id_empleado)
                        VALUES ('sa', '1', %d);
                    """, idEmpleado));
                }
                System.out.println("Empleado y usuario de ejemplo insertados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar registros iniciales: " + e.getMessage());
        }
    }
}
