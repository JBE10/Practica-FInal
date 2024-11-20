package negocios;

public class Envio implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String direccion;
    private double peso;
    private double recargo;
    private double costo;
    private Cliente cliente;
    private double altura;
    private double ancho;
    private int estado=0;
    private final int PENDIENTE=0;
    private final int ENVIADO=1;
    private final int ENTREGADO=2;

    public Envio(){
        this.id=0;
        this.direccion="";
        this.peso=0;
        this.recargo=0;
        this.costo=0;
        this.cliente=null;
        this.altura=0;
        this.ancho=0;
    }

    public Envio(int id, String direccion, double peso, double recargo, double costo, Cliente cliente, double altura, double ancho, int estado) {
        this.id = id;
        this.direccion = direccion;
        this.peso = peso;
        this.recargo = recargo;
        this.costo = costo;
        this.cliente = cliente;
        this.altura = altura;
        this.ancho = ancho;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public void calcularRecargo(){
        if (this.peso>70){

            for (double i=getPeso(); i>70; i--){
                this.recargo+=0.2;
            }
        } else if (this.peso>30) {
            for (double i=getPeso(); i>30; i--){
                this.recargo+=0.1;
            }
        }

        for (int ladoMayor=(int) Math.max(this.altura, this.ancho); ladoMayor>(int) Math.min(this.altura,this.ancho); ladoMayor--){
            this.recargo+=0.1;
        }
    }
    public void calcularCosto(){
        calcularRecargo();
        this.costo=costo*this.recargo;
    }


}
