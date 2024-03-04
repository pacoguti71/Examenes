package Febrero.Ex_2020_21_DAM;

import java.util.Scanner;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/02/07
 */
public class Ejercicio01_mio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final double MIN_NUMERO = 100.0;
        final double MAX_NUMERO = 200.0;
        final int NUM_INTENTOS = 5;

        // Variables de entrada
        double numero = 0;

        // Variables de salida
        int contador = 0;
        double suma = 0;

        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Leer números reales hasta que se hayan leído 5 en el rango [100.00 a 200.00]");
        System.out.println("-".repeat(70));
        do {
            try {
                System.out.printf("Introduzca un número real comprendido entre %.2f y %.2f: ", MIN_NUMERO, MAX_NUMERO);
                numero = teclado.nextDouble();
            } catch (Exception e) {
                System.out.println("Número no válido.");
                numero = MIN_NUMERO - 1;
                teclado.next();
            }

            if (numero >= MIN_NUMERO && numero <= MAX_NUMERO) {
                contador++;
                suma += numero;
                System.out.printf("Correcto. Total de números reales válidos hasta ahora: %d\n", contador);
                System.out.printf("El último número que acabamos de leer es el: %.2f\n\n", numero);
            } else {
                System.out.printf("Incorrecto. Número descartado. Total de números reales válidos hasta ahora: %d\n\n", contador);
            }

        } while (contador < 5);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.printf("Suma total: %.2f\n", suma);

    } // Fin main

} // Fin class
