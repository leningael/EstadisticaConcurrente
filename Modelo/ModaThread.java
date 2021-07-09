package Modelo;

import java.util.ArrayList;

public class ModaThread extends Thread{
    private final int numMax = 100; //Valor máximo de cada elemento del arreglo
    private int[] frecuencias = new int[numMax]; //Arreglo que contiene las frecuencias

    public ModaThread(int[] frecuencias) {
        this.frecuencias = frecuencias;
    }

    @Override
    public void run() {
        calculaModa();
    }
    //Obtiene la moda de acuerdo al arreglo de frecuencias
    private void calculaModa(){
        int frecMayor = -1; //Variable que contiene la frecuencia mayor
        ArrayList<Integer> moda = new ArrayList<>(); //Lista multimodal
        //Obtención de la frecuencia mayor
        for(int i = 0; i<numMax;i++){
            if(frecuencias[i]>frecMayor){
                frecMayor = frecuencias[i];
            }
        }
        //Generación de la lista multimodal
        for(int i = 0; i<numMax;i++){
            if(frecuencias[i] == frecMayor){
                moda.add(i+1);
            }
        }
        System.out.println("La lista de moda(s) es: " + moda); //Imprime el contenido de la lista multimodal
    }
}
