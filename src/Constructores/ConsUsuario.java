
package Constructores;

public class ConsUsuario {
    private int id_usuario;
    private String usuario;
    private String contrasena;
    private int id_empleado;
    private String puesto;
    private String nombre;
    
    //Contructor Vacio
    public ConsUsuario(){
        
    }
    public ConsUsuario(int id_usuario,String usuario,String contrasena,int id_empleado, String nombre){
     this.id_usuario  = id_usuario;
     this.usuario     = usuario;
     this.contrasena  = contrasena;
     this.id_empleado = id_empleado;
     this.nombre      = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
