package Modelo;

public class MediaThread extends Thread{
    private final int numDatos = 1000000; //Tamaño del arreglo de números
    private final int numMax = 100; //Valor máximo de cada elemento del arreglo
    private int[] frecuencias = new int[numMax]; //Arreglo que contiene las frecuencias
    
    public MediaThread(int[] frecuencias) {
        this.frecuencias = frecuencias;
    }

    @Override
    public void run() {
        calculaMedia();
    }
    //Obtiene la media de acuerdo al arreglo de frecuencias
    private void calculaMedia(){
        int suma = 0;
        for(int i = 0; i<numMax; i++){
            suma+=frecuencias[i]*(i+1); //Acumulación de las frecuencias por su valor
        }
        System.out.printf("La media es: %.2f\n",(double)suma/numDatos); //Imprime la suma entre el número total de datos
    }
}
