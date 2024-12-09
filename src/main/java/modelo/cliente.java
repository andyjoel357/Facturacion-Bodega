
package modelo;
public class cliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String ci;
    private String direcion;
   
    public cliente(){
        this.id_cliente=0;
        this.nombre="";
        this.apellido="";
        this.correo="";
        this.telefono="";
        this.ci="";
        this.direcion="";
    }

    public cliente(int id_cliente, String nombre, String apellido, String correo, String telefono, String ci, String direcion) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.ci = ci;
        this.direcion = direcion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    @Override
    public String toString() {
        return "cliente{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", telefono=" + telefono + ", ci=" + ci + ", direcion=" + direcion + '}';
    }
    
}
