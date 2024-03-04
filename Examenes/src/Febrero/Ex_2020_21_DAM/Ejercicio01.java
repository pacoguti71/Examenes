package Febrero.Ex_2020_21_DAM;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Crea un programa en Java para leer cinco números reales que estén en el
 * intervalo [100.00, 200.00] El programa debe iterar mediante un bucle leyendo
 * valores hasta que se hayan leído los 5 valores necesarios, es decir, que
 * estén en ese intervalo.
 *
 * Se deben controlar las excepciones ante posibles lecturas de datos no válidos
 * como caracteres alfanuméricos en vez de números. Si el número real leído está
 * en el rango permitido, se contabilizará como tal, se escribirá el total de
 * números contabilizados en el intervalo hasta ahora y se escribirá por consola
 * con dos decimales, tal y como se puede ver más abajo. Tras salir del bucle se
 * escribirá por consola el total acumulado, la suma de los números que están en
 * el rango.
 *
 * @author profe
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Constantes
        final int CANTIDAD_NUMEROS = 5;

        // Variables
        float numero;         // Valores de entrada
        int totalLeidos = 0;  // Total de números válidos
        float sumaTotal = 0;  // Suma total acumulada de los números válidos

        // Clase Scanner para petición de datos por teclado
        Scanner teclado = new Scanner(System.in);

        System.out.println("Leer números reales hasta que se hayan leído 5 en el rango [100.00 a 200.00]");
        System.out.println("----------------------------------------------------------------------------");

        do {
            System.out.print("Introduzca un número real comprendido entre 100.00 y 200.00: ");
            try {
                // Leer número real
                numero = teclado.nextFloat();

                // Si el número está en el rango que nos piden 
                if (numero >= 100 && numero <= 200) {
                    // Aumentamos el contador
                    totalLeidos++;
                    sumaTotal += numero;
                    // Escribir que es correcto y el total
                    System.out.println("Correcto. Total de números reales válidos hasta ahora: " + totalLeidos);
                    // Escribir formateado con dos decimales el último número leído.
                    System.out.printf("El último número que acabamos de leer es el: %.2f \n\n", numero);
                } else {
                    System.out.printf("Incorrecto. Número descartado. Total de números reales válidos hasta ahora: %s\n\n", totalLeidos);
                }

            } catch (InputMismatchException e) {
                System.out.println("Número no válido.");
                System.out.printf("Incorrecto. Número descartado. Total de números reales válidos hasta ahora: %s\n\n", totalLeidos);
                teclado.nextLine();
            }
        } while (totalLeidos < CANTIDAD_NUMEROS);

        System.out.printf("Suma total: %.2f \n\n", sumaTotal);
    }

}
