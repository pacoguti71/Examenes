package Febrero.Ex_2019_20_DAW;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa en Java para leer siete números reales y comprobar que
 * estén en el intervalo [-100, -50] o bien en el [60, 200]
 * El programa debe iterar mediante un bucle.
 * Se deben controlar las excepciones ante posibles lecturas de datos no 
 * válidos como caracteres alfanuméricos en vez de números.
 * Si el número real leído está en uno de los dos rangos permitidos, se 
 * contabilizará como tal, se escribirán el total de números contabilizados en
 * los intervalos hasta ahora y se escribirá por consola con dos decimales, 
 * tal y como se puede ver más abajo.
 * Tras salir del bucle se escribirá por consola el total de números válidos
 * (que estén en uno de los rangos permitidos) leídos.
 * 
 * @author profe
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int NUM_TOTAL = 7;

        // Clase Scanner para petición de datos por teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Leer 7 números reales y comprobar que estén en el intervalo [-100, -50] o bien en el [60, 200]");
        System.out.println("----------------------------------------------------------------------------------------------");

        // Total de números válidos
        int total = 0;

        // Bucle para procesar 7 elementos
        for (int contador = 0; contador < NUM_TOTAL; contador++) {

            System.out.println("Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200] ");
            try {
                // Leer número real
                float numero = teclado.nextFloat();

                // Si el número está en el rango que nos piden 
                if ((numero >= -100 && numero <= -50) || (numero >= 60 && numero <= 200)) {
                    // Aumentamos el contador
                    total++;
                    // Escribir que es correcto y el total
                    System.out.println("Correcto. Total de números reales válidos hasta ahora: " + total);
                    // Escribir formateado con dos decimales el último número leído.
                    System.out.printf("El último número que acabamos de leer es el: %.2f \n\n", numero);
                } else {
                    System.out.printf("Incorrecto. Número descartado. Total de números reales válidos hasta ahora: %s\n\n", total);
                }

            } catch (InputMismatchException e) {
                System.out.println("Número no válido.");
                System.out.printf("Incorrecto. Número descartado. Total de números reales válidos hasta ahora: %s\n\n", total);
                teclado.nextLine();
            }
        }

        System.out.println("\nTotal de números válidos leídos: " + total);
    }

}
