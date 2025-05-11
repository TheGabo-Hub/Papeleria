
package Constructores;

public class ConsProducto {
    private Long id_producto;
    private String descripcion;
    private int stock;
    private float precio_venta;
    private float precio_compra;

    public ConsProducto() {
    }

    public ConsProducto(Long id_producto, String descripcion, int stock, float precio_venta, float precio_compra) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }
    
            
    
}
