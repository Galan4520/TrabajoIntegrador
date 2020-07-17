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
public class Tarificador {
    //Tarifa que considere la empressa por Km
    double valor=2.765;

    public Tarificador() {
    }

    public Tarificador(int valor) {
        this.valor = valor;
    }
    /*
    Diseñe la clase Tarificador, la cual permitirá realizar un cálculo más exacto de la tarifa tomando en
    cuenta la ciudad de origen, la ciudad de destino y la tarifa que considera la empresa por kilómetro.
    Para este caso, considere las estructuras de datos, datos de constructor y métodos que crea
    conveniente para la solución del problema. La estructura de datos seleccionada debe permitir
    almacenar la información de distancia en kilómetros entre cada una de las ciudades. Tome en cuenta
    que, por factores geográficos, es posible que para conectar las ciudades A y B sea más eficiente pasar
    por una ciudad intermedia (por ejemplo, C). En ese caso, la ruta sería A  C  B. Su clase debe
    contener la funcionalidad necesaria para poder seleccionar la ruta más óptima, calcular la cantidad
    de kilómetros que se recorrerán y retornar el monto que se debería cobrar al cliente.
    */
    public void AlmacenDeDistancia(String CiudadOrigen,String CiudadDestuno){
        
    }
    public double CalcularValor(String origen,String destino){
        //Metodo que se modificara más adelante modificar más adelante
        //La validación de si se puede hacer o no, no se especifica
        /*
        Vamos a representar los que no tienen conexión con 9999999 que es una 
        representación del infinito
        */
        long distancia[][]={{0,500,999999999,900,999999999},
                            {500,0,300,1000,570},
                            {999999999,200,0,500,999999999},
                            {900,350,570,0,999999999},
                            {999999999,258,999999999,670,0}};       
        CaminoMinimos rutaMinima = new CaminoMinimos();
        int origenDato=0;
        int destinoDato=0;
        //Leemos los valores para determinar a donde va
        //Pudimos utilizar opciones como A o B, si no utilizamos una String
        if(origen.equals("Lima")){
            origenDato=1;
        }else if(origen.equals("Arequipa")){
            origenDato = 2;
        }else if(origen.equals("Cusco")){
            origenDato = 3;
        }else if(origen.equals("Cajamarca")){
            origenDato = 4;
        }else if(origen.equals("Loreto")){
            origenDato = 5;
        }else{
            origenDato=1;
        }
        if(destino.equals("Lima")){
            destinoDato=1;
        }else if(destino.equals("Arequipa")){
            destinoDato = 2;
        }else if(destino.equals("Cusco")){
            destinoDato = 3;
        }else if(destino.equals("Cajamarca")){
            destinoDato = 4;
        }else if(destino.equals("Loreto")){
            destinoDato = 5;
        }else{
            destinoDato=2;
        }
        double valorTotal10=rutaMinima.algoritmiFloyd(distancia,origenDato,destinoDato);
        return valor*valorTotal10;
    }
}
