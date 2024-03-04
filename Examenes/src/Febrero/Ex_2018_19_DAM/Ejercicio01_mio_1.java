package Febrero.Ex_2018_19_DAM;

import java.util.Arrays;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/02/07
 */
public class Ejercicio01_mio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int NUM_ELEMENTOS = 20;

        // Variables de entrada
        int numero;
        int[] arrayNumeros;

        // Variables de salida
        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        arrayNumeros = new int[NUM_ELEMENTOS];

        for (int i = 0; i < NUM_ELEMENTOS; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
            if (i == 0) {
                numero = (int) (Math.random() * 10);
            } else {
                do {
                    numero = (int) (Math.random() * 10);
                } while (arrayNumeros[i - 1] != 9 && arrayNumeros[i - 1] > numero);
            }
            arrayNumeros[i] = numero;
        }
//----------------------------------------------
//              Salida de resultados 
//----------------------------------------------
        System.out.println(Arrays.toString(arrayNumeros));

    } // Fin main
} // Fin class

/*
SOLUCION DE CHATGPT

import java.util.Arrays;

public class RellenarArray {

    public static void main(String[] args) {
        int[] array = new int[20];

        // Rellenar la primera posición del array con un número aleatorio entre 0 y 9
        array[0] = (int) (Math.random() * 10);

        // Rellenar el resto del array siguiendo las reglas dadas
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == 9) {
                // Si el número anterior es 9, el nuevo número puede ser cualquiera entre 0 y 9
                array[i] = (int) (Math.random() * 10);
            } else {
                // Si el número anterior no es 9, el nuevo número debe ser mayor o igual al anterior
                array[i] = (int) (Math.random() * (10 - array[i - 1]) + array[i - 1]);
            }
        }

        // Mostrar el array por pantalla
        System.out.println(Arrays.toString(array));
    }
}

 */
