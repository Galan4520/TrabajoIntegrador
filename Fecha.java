/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mclase;

/**
 *
 * @author atgal
 */
public class Fecha {
    public int fecha;
    public int Mes;
    public int anio;

    public Fecha(int fecha, int Mes, int anio) {
        this.fecha = fecha;
        this.Mes = Mes;
        this.anio = anio;
    }

    public int getFecha() {
        return fecha;
    }

    public int getMes() {
        return Mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Fecha=" + fecha + ", Mes=" + Mes + ", anio=" + anio + '}';
    }
    
    
}
