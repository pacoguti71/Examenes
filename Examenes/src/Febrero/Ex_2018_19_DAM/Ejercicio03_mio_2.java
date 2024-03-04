package Febrero.Ex_2018_19_DAM;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2023/12/30
 */
public class Ejercicio03_mio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String REGEX = "([1-9][0-9])-([1-9][0-9]{2})-([VX])";

        // Variables de entrada
        String codigo;

        // Variables de salida
        String arrayCodigo[];
        String resultado;
        boolean codigoAdecuado;
        boolean codigoValido;
        int comprobador;
        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        Pattern patron = Pattern.compile(REGEX);
        System.out.println("Introduce el código a comprobar:");
        codigo = teclado.nextLine().toUpperCase();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        Matcher detector = patron.matcher(codigo);
        codigoAdecuado = detector.matches();

        if (codigoAdecuado) {

            arrayCodigo = codigo.split("-");
            comprobador = (Integer.parseInt(arrayCodigo[0]) * Integer.parseInt(arrayCodigo[1])) % 2;

            codigoValido = ((comprobador == 0 && arrayCodigo[2].equals("V")) || (comprobador == 1 && arrayCodigo[2].equals("X")));

            resultado = (codigoValido) ? "Código correcto" : "Código incorrecto";
        } else {
            resultado = "Formato de código no adecuado";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println(resultado);
    } // Fin main

} // Fin class
