
package Constructores;

public class ConsPedidos {
    private int id_pedido;
    private int id_proveedor;
    private Long id_producto;
    private int cantidad_producto;
    private float precio_unidad;
    private float precio_total;
    private String fecha;
    private String hora;

    public ConsPedidos() {
    }

    public ConsPedidos(int id_pedido, int id_proveedor, Long id_producto, int cantidad_producto, float precio_unidad, float precio_total, String fecha, String hora) {
        this.id_pedido = id_pedido;
        this.id_proveedor = id_proveedor;
        this.id_producto = id_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_unidad = precio_unidad;
        this.precio_total = precio_total;
        this.fecha = fecha;
        this.hora = hora;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }

    

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

  
    
    

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public float getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(float precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
            
    
}
