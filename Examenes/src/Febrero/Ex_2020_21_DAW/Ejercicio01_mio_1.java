package Febrero.Ex_2020_21_DAW;

import java.util.Scanner;

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
        final double NUM_MENOR_NEGATIVO = -100.0;
        final double NUM_MAYOR_NEGATIVO = -50.0;
        final double NUM_MENOR_POSITIVO = 60.0;
        final double NUM_MAYOR_POSITIVO = 200.0;
        final int NUM_INTENTOS=7;

        // Variables de entrada
        double numero;

        // Variables de salida
        int intentosValidos=0;
        // Variables auxiliares
        boolean entradaCorrecta;

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.printf("Leer %d números reales y comprobar que estén en el intervalo [%.0f, %.0f] o bien en el [%.0f, %.0f]\n",NUM_INTENTOS,NUM_MENOR_NEGATIVO, NUM_MAYOR_NEGATIVO, NUM_MENOR_POSITIVO, NUM_MAYOR_POSITIVO);
        System.out.println("-".repeat(120));

        for (int i = 0; i <NUM_INTENTOS; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
            
        try {
            entradaCorrecta = true;
            System.out.printf("Introduzca un número real que esté en el intervalo [%.0f, %.0f] o bien en el [%.0f, %.0f]\n", NUM_MENOR_NEGATIVO, NUM_MAYOR_NEGATIVO, NUM_MENOR_POSITIVO, NUM_MAYOR_POSITIVO);
            numero = teclado.nextDouble();
            if ((numero>=NUM_MENOR_NEGATIVO&& numero<=NUM_MAYOR_NEGATIVO)||(numero>=NUM_MENOR_POSITIVO&&numero<=NUM_MAYOR_POSITIVO)) {
                intentosValidos++;
                System.out.printf("Correcto. Total de números reales válidos hasta ahora: %d\n",intentosValidos);
                System.out.printf("El último número que acabamos de leer es el: %.2f\n\n",numero);
            } else {
                System.out.printf("Incorrecto. Número descartado. Total de números reales válidos hasta ahora: %d\n\n",intentosValidos);
            }


        } catch (Exception e) {
            System.out.println("Número no válido.");
            entradaCorrecta = false;
            teclado.next();
        }
        
                } // Fin for

        

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.printf("Total de números válidos leídos: %d\n",intentosValidos);
    } // Fin main

} // Fin class
