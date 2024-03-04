package Febrero.Ex_2020_21_DAM;

import java.util.Scanner;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2023/12/30
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
        final double MINIMO = 100.0;
        final double MAXIMO = 200.0;
        final int veces = 5;

        // Variables de entrada
        double numero = 0;

        // Variables de salida
        String mensaje;
        int numValidos = 0;
        double suma = 0;
        
        // Variables auxiliares
        boolean condicionCorrecta;
        
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        for (int i = 0; i < veces; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
            do {
                condicionCorrecta = false;
                try {
                    System.out.print("Introduzca un número real comprendido entre 100.00 y 200.00: ");
                    numero = teclado.nextDouble();
                } catch (Exception e) {
                    System.out.println("Número no válido");
                    teclado.nextLine();
                    condicionCorrecta = false;
                }

                //----------------------------------------------
                //                 Procesamiento 
                //----------------------------------------------
                if (numero >= MINIMO && numero <= MAXIMO) {
                    condicionCorrecta = true;
                    suma += numero;
                    numValidos++;
                    mensaje = "Correcto. Total de números reales válidos hasta ahora: " + numValidos + "\nEl último número que acabamos de leer es el: " + numero;
                } else {
                    mensaje = "Incorrecto. Número descartado. Total de números reales válidos hasta ahora: " + numValidos;
                }
                System.out.println(mensaje + "\n");
            } while (!condicionCorrecta);
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("Suma total: " + suma);
    } // Fin main

} // Fin class
