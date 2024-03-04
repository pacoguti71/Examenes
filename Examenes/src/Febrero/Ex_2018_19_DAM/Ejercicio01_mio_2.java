package Febrero.Ex_2018_19_DAM;

import com.sun.jdi.request.MethodEntryRequest;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2023/12/30
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
        // Variables de entrada
        int i;
        int numElementos;
        int numAnterior;

        // Variables de salida
        int arrayNumeros[] = new int[20];
        StringBuilder resultado = new StringBuilder("\"{");

        // Variables auxiliares
        boolean condicionSalida;

        // Objeto Scanner para lectura desde teclado
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        numElementos = arrayNumeros.length;
        i = (int) (Math.random() * 10);
        arrayNumeros[0] = i;
        resultado.append(i);

        for (int j = 1; j < numElementos; j++) {
            numAnterior = arrayNumeros[j - 1];
            i = (int) (Math.random() * 10);

            if (numAnterior != 9) {
                do {
                    i = (int) (Math.random() * 10);
                } while (numAnterior > i);
            }
            
            arrayNumeros[j] = i;
            resultado.append(i);
        }
        resultado.append("}\"");
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println(resultado);

    } // Fin main

} // Fin class
