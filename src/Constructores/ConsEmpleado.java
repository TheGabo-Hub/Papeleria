/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constructores;

/**
 *
 * @author puppe
 */
public class ConsEmpleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String direccion;
    private String puesto;
    
    public ConsEmpleado(){
        
    }
    public ConsEmpleado(int id_empleado, String nombre, String apellido,String telefono,String correo,String direccion,String puesto){
        
        this.id_empleado=id_empleado;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono= telefono;
        this.correo= correo;
        this.direccion=direccion;
        this.puesto =puesto;
        
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    
    
}
