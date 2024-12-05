package modelo;

public class DetalleVenta {

    private int id_factura;
    private int id_cliente;
    private int id_inventario;
    private String producto;
    private int cantidad;
    private double precio_unitario;
    private double sub_total;
    private double total;
    private String fecha;

    public DetalleVenta(){
        this.id_factura =0;
        this.id_cliente =0;
        this.id_inventario=0;
        this.producto="";
        this.cantidad=0;
        this.precio_unitario=0.0;
        this.sub_total=0.0;
        this.total=0.0;
        this.fecha = "";
    }
    public DetalleVenta(int id_factura, int id_cliente, int id_inventario, String producto, int cantidad, double precio_unitario, double sub_total, double total, String fecha) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.id_inventario = id_inventario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.sub_total = sub_total;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
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

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
