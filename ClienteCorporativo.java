/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mclase;

import edu.ulima.eda.pilas.Pila;

/**
 *
 */
public class ClienteCorporativo{
    private String RUC;
    private String RazonSocial;
    private Pila ListaComprobante;
        
    //Constructores
    
    public ClienteCorporativo(String RUC, String RazonSocial, Pila ListaComprobante) {
        this.RUC = RUC;
        this.RazonSocial = RazonSocial;
        this.ListaComprobante = ListaComprobante;
    }
    //Getters
    public String getRUC() {
        return RUC;
    }
    public String getRazonSocial() {
        return RazonSocial;
    }   
    public Pila getListaComprobante() {
        return ListaComprobante;
    }
    

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public void setListaComprobante(Pila ListaComprobante) {
        this.ListaComprobante = ListaComprobante;
    }   
    /*
    Método que permite apilar un comprobante al cliente corporativo. Tome en cuenta que
    antes de apilar debe realizar el cálculo final de la tarifa utilizando las funcionalidades de
    la clase Tarificador. En caso no sea posible realizar el servicio no se realizará ningún
    registro en la pila.
    Se creara una clase que calcule la nueva tarifa.
    */
//Método
    //Llamamos a la clase Comprobante para que agregue a la pila sus atributos
    //Antes de apilar se necesita una verificación y si no se puede no se apila
    public void Apilar(Comprobante datos){
        ListaComprobante.apilar(datos);
    }
    
    //Calcular el tipo del cliente
    public double CalcularTipo(){
        double calculoDelTipo=0;
        Pila Auxiliar = new Pila();
        while(!ListaComprobante.estaVacia()){
            Comprobante DatoPersona = (Comprobante) ListaComprobante.desapilar();
            Auxiliar.apilar(DatoPersona);
            if(DatoPersona.getTipo().equals("Encomienda")){
                calculoDelTipo = DatoPersona.getMonto();
            }
        }while(!Auxiliar.estaVacia()){
            Comprobante DatoPersona2 = (Comprobante) Auxiliar.desapilar();
            ListaComprobante.apilar(DatoPersona2);
        }      
        return calculoDelTipo;
    }public double CalcularTipoB(){
        double calculoDelTipo = 0;
        Pila Auxiliar = new Pila();
        while(!ListaComprobante.estaVacia()){
            Comprobante DatoPersona = (Comprobante) ListaComprobante.desapilar();
            Auxiliar.apilar(DatoPersona);
            if(DatoPersona.getTipo().equals("Giro")){
                calculoDelTipo = DatoPersona.getMonto();
            }
        }while(!Auxiliar.estaVacia()){
            Comprobante DatoPersona2 = (Comprobante) Auxiliar.desapilar();
            ListaComprobante.apilar(DatoPersona2);
        }      
        return calculoDelTipo;
        
    }
    /*
    Método redefinido toString (), retorna toda la información del cliente, incluido su lista
    de comprobantes. (recuerde conservar la información original) 
    */
    public String DatosDelCliente(){
        String Respuesta= "RUC: " + RUC + 
                "\nRazon Social: " + RazonSocial+"\n";
        Pila auxiliar = new Pila();
        while(!ListaComprobante.estaVacia()){
            Comprobante Persona = (Comprobante) ListaComprobante.desapilar();   
            Respuesta+=Persona.toString();
            Respuesta+="\n";
            auxiliar.apilar(Persona);
        }while(!auxiliar.estaVacia()){
            Comprobante PersonaAux = (Comprobante) auxiliar.desapilar();
            ListaComprobante.apilar(PersonaAux);
        }
        
        //Retornamos la información almacenada hasta ahora en la pila hasta
        //el momento del cliente.
        return Respuesta;
    }     
}