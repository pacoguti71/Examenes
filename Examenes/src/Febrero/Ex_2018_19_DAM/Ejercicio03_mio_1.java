package Febrero.Ex_2018_19_DAM;

import java.util.Scanner;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/02/07
 */
public class Ejercicio03_mio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String REGEX = "[1-9][0-9]-[1-9][0-9]{2}-[VX]";

        // Variables de entrada
        String entrada;

        // Variables de salida
        int N1;
        int N2;
        String[] partesEntrada;

        // Variables auxiliares
        boolean codigoCorrecto = false;

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.print("Introduce el código a comprobar: ");
        entrada = teclado.nextLine();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        if (entrada.matches(REGEX)) {
            partesEntrada = entrada.split("-");
            N1 = Integer.parseInt(partesEntrada[0]);
            N2 = Integer.parseInt(partesEntrada[1]);
            switch ((N1 * N2) % 2) {
                case 0:
                    codigoCorrecto = partesEntrada[2].equals("V");
                    break;
                case 1:
                    codigoCorrecto = partesEntrada[2].equals("X");
                    break;
            }
        } else {
            System.out.println("Formato de código no adecuado\n");
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.printf("El código %s correcto\n", (codigoCorrecto ? "es" : "no es"));

    } // Fin main

} // Fin class