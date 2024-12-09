package modelo;

public class DetalleCabecera {

    
    private int id_cabecera;
    private int id_cliente;
    private double valorPagar;
    private String fecha;
    private int estado;
    
    public DetalleCabecera(){
        this.id_cabecera =0;
        this.id_cliente =0;
        this.valorPagar=0.0;
        this.fecha="";
        this.estado=0;
    }

    public DetalleCabecera(int id_cabecera, int id_cliente, double valorPagar, String fecha, int estado) {
        this.id_cabecera = id_cabecera;
        this.id_cliente = id_cliente;
        this.valorPagar = valorPagar;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId_cabecera() {
        return id_cabecera;
    }

    public void setId_cabecera(int id_cabecera) {
        this.id_cabecera = id_cabecera;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleCabecera{" + "id_cabecera=" + id_cabecera + ", id_cliente=" + id_cliente + ", valorPagar=" + valorPagar + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}
