package Febrero.Ex_2021_22_DAM;

import java.util.Arrays;

/**
 * Programa para trabajar con arrays de números
 */
public class Ejercicio02 {

    /**
     * Método Main Ejecutable del Ejercicio 1
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int[] arrayEnteros1 = {1, 8, 3, 1, 3, 7, 5, 2, 4, 6};
        int[] arrayEnteros2 = {3, 4, 5, 6, 2, 5, 1, 7, 5, 5};

        // Variables de salida
        int[] arrayResultado;
        int mayor3;

        // Variables auxiliares
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("EJERCICIO DE ARRAYS");
        System.out.println("-------------------");
        System.out.printf("Array 1:         %s\n", Arrays.toString(arrayEnteros1));
        System.out.printf("Array 2:         %s\n", Arrays.toString(arrayEnteros2));

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        arrayResultado = new int[arrayEnteros1.length];

        // Tomamos inicialmente como valores máximo y minimo el valor de la primera posición
        int mayor = arrayEnteros1[0] > arrayEnteros2[0] ? arrayEnteros1[0] : arrayEnteros2[0];
        int menor = arrayEnteros1[0] < arrayEnteros2[0] ? arrayEnteros1[0] : arrayEnteros2[0];

        mayor3 = mayor;
        for (int i = 1; i < arrayResultado.length - 1; i++) {
            // Exploración del mayor
            int mayorLocal = arrayEnteros1[i] > arrayEnteros2[i] ? arrayEnteros1[i] : arrayEnteros2[i];
            mayor = mayorLocal > mayor ? mayorLocal : mayor;

            // Exploración del menor
            int menorLocal = arrayEnteros1[i] < arrayEnteros2[i] ? arrayEnteros1[i] : arrayEnteros2[i];
            menor = menorLocal < menor ? mayorLocal : menor;

            // Suma
            arrayResultado[i] = arrayEnteros1[i] + arrayEnteros2[i];

            // Calculamos el mayor de lo que llevamos hasta el momento
            mayor3 = arrayResultado[i] > mayor3 ? arrayResultado[i] : mayor3;

        }

        // Asignamos valor a la primera y última posición
        arrayResultado[0] = menor;
        arrayResultado[arrayResultado.length - 1] = mayor;

        // Tenemos en cuenta estos dos valores para el cálculo del mayor en el array resultado
        mayor3 = mayor > mayor3 ? mayor : mayor3;

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.printf("Array resultado: %s\n", Arrays.toString(arrayResultado));
        System.out.printf("Máximo del array resultado: %d\n", mayor3);

    }

}
