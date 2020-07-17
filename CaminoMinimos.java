/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mclase;

/**
 *
 * @author AgalanF
 */
public class CaminoMinimos {

    public double algoritmiFloyd(long[][] nAndy,int Orgien,int destino) {
        int vertices = nAndy.length;
        long matrizAdyacencia[][] = nAndy;
        //Vertices iguales
        String caminos[][] = new String[vertices][vertices];
        String caminosAuxiliares[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;
        //Inicializamos las matrices caminos y caminos auxiliares
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAuxiliares[i][j] = "";
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //Parte del código que nos ayuda a determinar el camino mínimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j] = CaminosR(i, k, caminosAuxiliares, caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;

                }
            }
            
        }
        Orgien--;
        destino--;       
        
        //retornar el camino minimo
        
        //agregar el camino a cadena
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena += " " + matrizAdyacencia[i][j] + " ";
            }
            cadena += "\n";
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 1000000000) {
                    //Q no se encuentre en el mismo vertice
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De " + (i + 1) + "-->" + (j + 1) + "Irse por "
                                    + (i + 1) + ",  " + (j + 1) + "\n";
                        } else {
                            caminitos += "De " + (i + 1) + "-->" + (j + 1) + "Irse por "
                                    + (i + 1) + ",  " + caminos[i][j] + ", " + (j + 1) + "\n";
                        }
                    }
                }
            }
        }
        return matrizAdyacencia[Orgien][destino];
    }
    public String CaminosR(int i,int k,String[][]caminosAuxiliares,String caminoRecorrido){
        if(caminosAuxiliares[i][k].equals("")){
            return "";
        }else{
            //Recursividad
            caminoRecorrido+=CaminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido) 
                    + (Integer.parseInt(caminosAuxiliares[i][k].toString())+1);
            
        }
        return caminoRecorrido;
    }
}
