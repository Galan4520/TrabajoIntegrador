
package Mclase;

import java.util.Calendar;

/*Diseñe la clase Comprobante, con los siguientes atributos: tipo (<1> Giro, <2> Encomienda), ciudad
origen, ciudad destino, fecha de emisión, monto.*/
public class Comprobante {
    private String tipo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String fechaEmision;
    private double monto; //Se modificara en la clase Tarificador
    //constructores

    public Comprobante(String tipo, String ciudadOrigen, String ciudadDestino,Double monto) {
        Calendar Fecha = Calendar.getInstance();
        this.tipo = tipo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaEmision = Fecha.get(Calendar.DATE) + "/" + (Fecha.get(Calendar.MONTH)+1) + "/" + Fecha.get(Calendar.YEAR);;
        this.monto=monto;
    }
    
    //Getters
    public String getTipo() {
        return tipo;
    }
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
    public String getCiudadDestino() {
        return ciudadDestino;
    }
    public String getFecha() {
        return fechaEmision;
    }
    public double getMonto() {
        return monto;
    }
    //Setter
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }
    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    public void setFechaEmision(String fecha) {
        this.fechaEmision = fechaEmision;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    //Método toString

    @Override
    public String toString() {
        return  "\nTipo=" + tipo + "\nCiudadOrigen=" + ciudadOrigen +
                "\nCiudadDestino=" + ciudadDestino + "\nFechaEmision=" +
                fechaEmision + "\nMonto=" + monto + '}';
    }
    
    
}
