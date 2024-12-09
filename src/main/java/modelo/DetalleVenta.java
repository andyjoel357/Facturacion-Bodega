package modelo;

public class DetalleVenta {

    private int id_factura;
    private int id_producto;
    
    private String nombre;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;
    private double iva;
    private double total;

    public DetalleVenta(){
        this.id_factura =0;
        this.id_producto=0;
        this.nombre="";
        this.cantidad=0;
        this.precio_unitario=0.0;
        this.subtotal=0.0;
        this.iva=0.0;
        this.total=0.0;
    }

    public DetalleVenta(int id_factura, int id_producto, String nombre, int cantidad, double precio_unitario, double subtotal, double iva, double total) {
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id_factura=" + id_factura + ", id_producto=" + id_producto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + '}';
    }

}
