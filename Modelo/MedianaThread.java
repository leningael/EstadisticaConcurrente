package Modelo;

public class MedianaThread extends Thread{
    private final int numCentral = 500000; //Mitad del tamaño total de datos
    private final int numMax = 100; //Valor máximo de cada elemento del arreglo
    private int[] frecuencias = new int[numMax]; //Arreglo que contiene las frecuencias
    
    public MedianaThread(int[] frecuencias) {
        this.frecuencias = frecuencias;
    }

    @Override
    public void run() {
        calculaMediana();
    }
    //Obtiene la mediana de acuerdo al arreglo de frecuencias
    private void calculaMediana(){
        int i = 0, suma = 0;
        do{
            suma+=frecuencias[i];
            i++;
        }while(suma < numCentral); //Suma las frecuencias mientras el acumulado sea menor al número central
        System.out.println("La mediana es: " + i); //Imprime el valor que representa la mediana
    }
}
