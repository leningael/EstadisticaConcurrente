package Modelo;

public class FrecuenciasThread extends Thread{
    private int inicio; //Inicio del arreglo de datos que le corresponde al thread
    private int fin;   //Fin del arreglo de datos que le corresponde al thread
    private int[] datos; //Arreglo que contiene todos los números
    private static final int numMax = 100; //Valor máximo de cada elemento del arreglo
    private static int[] frecuenciasG = new int[numMax]; //Arreglo global de frecuencias que comparten los hilos
    private int[] frecuenciasL = new int[numMax]; //Arreglo local de frecuencias para cada hilo

    public FrecuenciasThread(int[] datos, int inicio, int fin) {
        this.datos = datos;
        this.inicio = inicio-1;
        this.fin = fin-1;
    }

    @Override
    public void run() {
        agregaFrecuenciasL();
        agregaFrecuenciasG();
    }
    //Calcula las frecuencia local de acuerdo al arreglo de datos
    private void agregaFrecuenciasL(){
        for(int i = inicio; i <= fin; i++){
            frecuenciasL[datos[i]-1]++;
        }
    }
    //Concentra las frecuencias locales en el arreglo global de frecuencias
    private void agregaFrecuenciasG(){
        for(int i = 0; i < numMax; i++){
            synchronized(this){ //Exclusión mutua a nivel elemento del arreglo
                frecuenciasG[i]+=frecuenciasL[i];
            }
        }
    }
    //Getter frecuenciasG
    public int[] getFrecuenciasG() {
        return frecuenciasG;
    }
}
