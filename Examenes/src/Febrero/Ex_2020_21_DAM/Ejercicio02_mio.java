package Febrero.Ex_2020_21_DAM;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/02/07
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
        final String REGEX = "([0-9]+)/([0-9]+)";
        // Variables de entrada
        String[] arrayEntrada = {"234/24", "24/234", "31/531", "ABCD/ABCD", "ABC/CBA", "23456/65432",
            "23/23", "32/23", "23/32", "32/32", "0/0", "122/122", "3301/1033"};
        Pattern patron = Pattern.compile(REGEX);
        int numElementos;
        int primeraParte;
        int primeraParteInvertida;
        int segundaParte;

        // Variables de salida
        String[] arrayResultado;

        // Variables auxiliares
        int temporal;
        int resto;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALIDADOR DE NÚMEROS DE SERIE");
        System.out.println("-----------------------------");
        System.out.println("Lista de números de serie de prueba:");
        System.out.println(Arrays.toString(arrayEntrada));

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        numElementos = arrayEntrada.length;
        arrayResultado = new String[numElementos];
        for (int i = 0; i < numElementos; i++) {
            Matcher detector = patron.matcher(arrayEntrada[i]);
            arrayResultado[i] = "no";

            if (detector.matches()) {
                primeraParte = Integer.parseInt(detector.group(1));
                segundaParte = Integer.parseInt(detector.group(2));

                temporal = primeraParte;
                primeraParteInvertida = 0;
                while (temporal > 0) {
                    resto = temporal % 10;
                    primeraParteInvertida = primeraParteInvertida * 10 + resto;
                    temporal /= 10;
                }

                if ((primeraParte % 2 == 0 && primeraParte == segundaParte) || (primeraParte % 2 != 0 && segundaParte == primeraParteInvertida)) {
                    arrayResultado[i] = "sí";
                }
            }
        } // Fin for

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.printf("El resultado de la comprobación de la validez de los números de serie es:\n%s\n",
                Arrays.toString(arrayResultado));

    } // Fin main

} // Fin class