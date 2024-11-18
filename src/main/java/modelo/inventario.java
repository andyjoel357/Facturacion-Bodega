package modelo;

public class inventario {
    private int id_inventario;
    private int codigo_barra;
    private String nombre;
    private String description;
    private double precio_unitario;
    private int stock;
    private String categoria;
    private String fecha;
public inventario (){
    this.id_inventario =0;
    this.codigo_barra = 0;
    this.nombre = "";
    this.description="";
    this.precio_unitario=0.0;
    this.stock = 0;
    this.categoria="";
    this.fecha="";
    
    
}
    public inventario(int id_inventario, int codigo_barra, String nombre, String description, double precio_unitario, int stock, String categoria, String fecha) {
        this.id_inventario = id_inventario;
        this.codigo_barra = codigo_barra;
        this.nombre = nombre;
        this.description = description;
        this.precio_unitario = precio_unitario;
        this.stock = stock;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(int codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
