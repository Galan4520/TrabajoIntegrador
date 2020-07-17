/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mclase;

import ListaEnlazada.Nodo;
import edu.ulima.eda.colas.Cola;
import edu.ulima.eda.listas.ListaEnlazada;
import edu.ulima.eda.pilas.Pila;
import javax.swing.JOptionPane;

/**
 *
 * @author atgal
 */
public class GestionMensajeria {

    private double recaudacionEcomienda;
    private double recaudacionGiros;
    private Cola Cola = new Cola();
    private ClienteCorporativo Persona;
    //Constructor sin parámetros. Métodos getters. 

    public GestionMensajeria() {
        this.recaudacionEcomienda = recaudacionEcomienda;
        this.recaudacionGiros = recaudacionGiros;
        this.Cola = Cola;
        this.Persona = Persona;
    }

    public double getRecaudacionEcomienda() {
        return recaudacionEcomienda;
    }

    public double getRecaudacionGiros() {
        return recaudacionGiros;
    }

    public Cola<ClienteCorporativo> getCola() {
        return Cola;
    }

    //Método que se ocupe de encolar un objeto ClienteCorporativo alcanzado como
    //parámetro, donde incluya su pila de comprobantes.
    public void Encolar(ClienteCorporativo datos) {

        Cola.encolar(datos);
    }

    //Método reporte de recaudación, este método calcula los montos de recaudación que
    //ha habido en giros y encomiendas. (Aquí todos los clientes de la cola se procesan).
    public String MetodoRecaudacion() {
        int MontoGiros = 0;
        int MontoEncomientas = 0;
        Cola<ClienteCorporativo> Auxiliar = new Cola<>();
        //Metod de pasar los datos al aux y devolverlo
        while (!Cola.estaVacia()) {
            ClienteCorporativo Persona1 = (ClienteCorporativo) Cola.desencolar();
            Auxiliar.encolar(Persona1);
            //Caluclo de los monto giros y encomientas
            MontoEncomientas += Persona1.CalcularTipo();
            //Fallo --> Poner el método adecuado
            MontoGiros += Persona1.CalcularTipoB();
        }
        while (!Auxiliar.estaVacia()) {
            ClienteCorporativo Persona1 = Auxiliar.desencolar();
            Cola.encolar(Persona1);
        }
        return "Monto total de giros: " + MontoGiros
                + "\nMonto Total de Encomiendas: " + MontoEncomientas;
    }

    public ClienteCorporativo buscar(String RUC) {
        ClienteCorporativo auxiliar = null;
        Cola<ClienteCorporativo> ColaDato = new Cola<>();
        boolean respuesta = false;
        //Si encuentra el valor salimos del while,
        //En caso contrario podemos esperar al ultimo elemento de la Cola
        while (!Cola.estaVacia()) {
            ClienteCorporativo DatoBuscado = (ClienteCorporativo) Cola.desencolar();
            ColaDato.encolar(DatoBuscado);
            //Para no perder datos solo vamos a devolver el dato
            if (DatoBuscado.getRUC().equals(RUC)) {
                auxiliar = DatoBuscado;
                respuesta = true;
            }
        }
        while (!ColaDato.estaVacia()) {
            Cola.encolar(ColaDato.desencolar());
        }
        return auxiliar;
    }

    public void CalculoMontoPorDia() {
        String[]fechas =new String[50];
        float[] monto = new float[50];
        int contador=0;
        Cola<ClienteCorporativo> Persona = new Cola();
        while(!Cola.estaVacia()){           
            ClienteCorporativo ClieAux = (ClienteCorporativo) Cola.desencolar();
            Persona.encolar(ClieAux);
            Pila ListaComprobante = ClieAux.getListaComprobante();
            Comprobante ComprAux = (Comprobante) ListaComprobante.desapilar();
            if(contador==0){
                fechas[contador]=ComprAux.getFecha();
                monto[contador]=(float) ComprAux.getMonto();
                contador++;
            }else{
                //Fecha actual
               for(int i=0; i<contador; i++){
               
                    if(fechas[i].equals(ComprAux.getFecha())){
                        //Almacenamos los resultados de los montos
                        monto[i] += ComprAux.getMonto();
                    }
                    //Fecha un dia despues o fecha que no pertenece
                    else{
                    
                        fechas[contador] = ComprAux.getFecha();
                        monto[contador] = (float) ComprAux.getMonto();
                        contador++;
                    }
                }
            }
        }
        
        //Devuelve los datos originales
        while (!Persona.estaVacia()) {
            Cola.encolar(Persona.desencolar());
        }
        for(int i=0; i<contador; i++)
        {
            System.out.println(fechas[i]+"--> S/."+monto[i]);
            JOptionPane.showMessageDialog(null, "Fecha"+fechas[i]+"\nMonto por el día: "+monto[i]);
            
        }
        
        /*
        edu.ulima.eda.listas.Nodo ptr = lista.getL();
         */
 /*
        Cola: Cola
        --> ColaAux
        Pila: PilaAux
        --> PilaAux2
         */
 /*Cola<Comprobante> ColaFinal = new Cola<>();
        System.out.println("DATOS");
        while(!Cola.estaVacia()){
            ClienteCorporativo Datos = (ClienteCorporativo) Cola.desencolar();
            ColaAux.encolar(Datos);
            Pila<Comprobante> PilaAux = Datos.getListaComprobante();
            Pila PilaAux2=new Pila<>();
            Pila<Comprobante> Comparacion2 = Datos.getListaComprobante();
            
            Pila<Comparable> PilaComparacion = Datos.getListaComprobante();
            PilaComparacion.apilar(Datos.DatosDelCliente());
            PilaComparacion.mostrarElementos();
            
            while(!PilaComparacion.estaVacia()){               
                //Desapilamos los comprobantes
                              
                while(!PilaComparacion.estaVacia()){
                    //String valores;
                    Comprobante Datos1 = (Comprobante) Comparacion2.desapilar();
                    PilaAux2.apilar(Datos1);
                    Comprobante Dato2 = (Comprobante) PilaComparacion.desapilar();
                    if(Comparacion2.desapilar().getFecha().equals(Dato2.getFecha())){
                        Datos1.setMonto(Datos1.getMonto()+Dato2.getMonto());
                        //Almacena los datos
                        ColaFinal.encolar(Datos1);
                    }
                }
                                
            }
        }
        while(!ColaAux.estaVacia()){
            Cola.encolar(ColaAux.desencolar());
        }
        while(!ColaFinal.estaVacia()){
            Comprobante DatoFinal = (Comprobante) Cola.desencolar();
            respuesta= respuesta + "Monto en la fecha -->"+DatoFinal.getFecha()+": S/."+DatoFinal.getMonto() ;
            respuesta+="\n";
        }*/

    }

    @Override
    public String toString() {

        String Respuesta1 = "";
        Cola<ClienteCorporativo> Personas = new Cola<>();
        while (!Cola.estaVacia()) {
            // Si queremos saber el número del clienteRespuesta+="\nComprobante "+NumeroCliente;
            ClienteCorporativo auxiliar1 = (ClienteCorporativo) Cola.desencolar();
            Respuesta1 += auxiliar1.DatosDelCliente();
            Respuesta1 += "\n";
            Personas.encolar(auxiliar1);
        }
        while (!Personas.estaVacia()) {
            Cola.encolar(Personas.desencolar());
        }
        return Respuesta1;
    }

}
