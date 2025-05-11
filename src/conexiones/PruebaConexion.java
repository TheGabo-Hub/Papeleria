/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class PruebaConexion {
     public static void main(String[] args) {
        String db = "pape.db"; // nombre de tu base de datos
        String url = "jdbc:sqlite:" + db;

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println(" Conexion exitosa a SQLite: " + db);

            Statement stmt = conn.createStatement();

            // Activar claves foráneas por si no estaban
            //stmt.execute("PRAGMA foreign_keys = ON;");

            // Consulta de prueba
            String sql = "SELECT u.usuario, u.contrasena, e.nombre, e.puesto " +
                         "FROM usuarios u " +
                         "JOIN empleado e ON u.id_empleado = e.id_empleado";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ddddddd");
            System.out.println("Ruta de DB usada: " + new java.io.File("pape.db").getAbsolutePath());


            while (rs.next()) {
                System.out.println("dddddd");
                System.out.println("Usuario: " + rs.getString("usuario"));
                System.out.println("Contraseña: " + rs.getString("contrasena"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Puesto: " + rs.getString("puesto"));
                System.out.println("--------------------------");
            }

        } catch (Exception e) {
            System.out.println("❌ Error al conectar o consultar: " + e.getMessage());
        }
     }
    
}
