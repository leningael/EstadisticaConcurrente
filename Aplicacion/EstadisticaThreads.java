package Aplicacion;

import Modelo.FrecuenciasThread;
import Modelo.MediaThread;
import Modelo.MedianaThread;
import Modelo.ModaThread;

public class EstadisticaThreads {
    public static void main(String[] args) {
        final int numDatos = 1000000; //Tamaño del arreglo de números
        final int numMax = 100; //Valor máximo de cada elemento del arreglo
        int[] datos = new int[numDatos]; //Arreglo que contiene todos los números
        for(int i = 0; i < numDatos;i++){ //Rellena el arreglo con números aleatorios del 1 al 100
            datos[i] = (int)(Math.random()*numMax+1); 
        }
        //Primera fase
        FrecuenciasThread frec1 = new FrecuenciasThread(datos, 1, 200000); //Frecuencias de los primeros 200,000 datos
        FrecuenciasThread frec2 = new FrecuenciasThread(datos, 200001, 400000); //Frecuencias del dato 200,001 al 400,000
        FrecuenciasThread frec3 = new FrecuenciasThread(datos, 400001, 600000); //Frecuencias del dato 400,001 al 600,000
        FrecuenciasThread frec4 = new FrecuenciasThread(datos, 600001, 800000); //Frecuencias del dato 600,001 al 800,000
        FrecuenciasThread frec5 = new FrecuenciasThread(datos, 800001, 1000000); //Frecuencias del dato 800,001 al 1,000,000
        frec1.start();
        frec2.start();
        frec3.start();
        frec4.start();
        frec5.start();
        try{
            frec1.join();
            frec2.join();
            frec3.join();
            frec4.join();
            frec5.join();
            //Espera a que todos los threads concentren sus resultados para obtener la frecuencia global
            int[] frecuencias = frec1.getFrecuenciasG();
            //Verifica que la suma de las frecuencias coincida con el número de datos
            int suma = 0;
            for(int i = 0; i < numMax; i++){
                suma += frecuencias[i];
            }
            System.out.println("Suma de las frecuencias: " + suma);
            MediaThread media = new MediaThread(frecuencias); //Hilo que calcula la media
            media.start();
            MedianaThread mediana = new MedianaThread(frecuencias); //Hilo que calcula la mediana
            mediana.start();
            ModaThread moda = new ModaThread(frecuencias); //Hilo que calcula la moda
            moda.start();
        }catch(InterruptedException e){
        }
    }
}