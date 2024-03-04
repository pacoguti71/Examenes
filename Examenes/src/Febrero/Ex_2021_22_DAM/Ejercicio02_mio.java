package Febrero.Ex_2021_22_DAM;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2023/12/30
 */
public class Ejercicio02_mio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int ARRAY1[] = {1, 8, 3, 1, 3, 7, 5, 2, 4, 6};
        final int ARRAY2[] = {3, 4, 5, 6, 2, 5, 1, 7, 5, 5};
final int LONG_ARRAYS=ARRAY1.length;

        // Variables de entrada
        int numMenor = ARRAY1[0];
        int numMayor = ARRAY1[0];

        // Variables de salida
        int arrayresultado[] = new int[10];
        int mayorArrayResultado=0;

        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        for (int i = 0; i < ARRAY1.length; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
            if (ARRAY1[i] > ARRAY2[i]) {
                if (ARRAY1[i] > numMayor) {
                    numMayor = ARRAY1[i];
                }
            } else {
                if (ARRAY2[i] > numMayor) {
                    numMayor = ARRAY2[i];
                }
            }
            
            
            if (ARRAY1[i] < ARRAY2[i]) {
                if (ARRAY1[i] < numMenor) {
                    numMenor = ARRAY1[i];
                }
            } else {
                if (ARRAY2[i] < numMenor) {
                    numMenor = ARRAY2[i];
                }
            }
        }
        arrayresultado[LONG_ARRAYS-1]=numMayor;
        arrayresultado[0]=numMenor;
        
        for (int i = 1; i <LONG_ARRAYS-1; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
            arrayresultado[i]=ARRAY1[i]+ARRAY2[i];
            if (mayorArrayResultado<arrayresultado[i]) {
                mayorArrayResultado=arrayresultado[i];
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("EJERCICIO DE ARRAYS");
        System.out.println("-".repeat(19));
        System.out.println("Array 1: " + Arrays.toString(ARRAY1));
        System.out.println("Array 2: " + Arrays.toString(ARRAY2));
        System.out.println("\nRESULTADO");
        System.out.println("-".repeat(10));
        System.out.println("Array resultado: "+Arrays.toString(arrayresultado));
        System.out.printf("Máximo del array resultado: %d\n",mayorArrayResultado);

    } // Fin main

} // Fin class
