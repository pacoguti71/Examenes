package Febrero.Ex_2021_22_DAM;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2023/12/30
 */
public class Ejercicio01_mio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String REGEX = "([HMB])([0-9]{5})([EA])([0-9]{2})";

        // Variables de entrada
        String codigo[] = {"H12345E15", "M00000E00", "A12345E15", "H12345E11", "B00011A02", "B00011A11", "h12345E15", "B1111A04", "B111111A06"};

        // Variables de salida
        boolean codigoValido;
        boolean patronValido;
        int digitoControl;
        int numCodigoValido = 0;
        int numPatronValido = 0;
        String control;
        String tipoCliente = "";
        String origen = "";
        String textoSalida;
        StringBuilder resultado = new StringBuilder("");

        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        Pattern patron = Pattern.compile(REGEX);
        for (int i = 0; i < codigo.length; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
            Matcher detector = patron.matcher(codigo[i]);
            patronValido = detector.matches();

            if (patronValido) {
                numPatronValido++;

                switch (detector.group(1)) {
                    case "H":
                        tipoCliente = "hombre";
                        break;
                    case "M":
                        tipoCliente = "mujer";
                        break;
                    case "B":
                        tipoCliente = "bebé";
                        break;
                }

                origen = (detector.group(3).equals("E")) ? "Europa" : "Asia";

                digitoControl = 0;
                for (int j = 1; j < 6; j++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
                    digitoControl += Integer.parseInt(codigo[i].substring(j, j + 1));
                }

                control = (digitoControl < 10) ? ("0" + digitoControl) : (Integer.toString(digitoControl));

                codigoValido = (control.equals(codigo[i].substring(7, 9)));

                if (codigoValido) {
                    numCodigoValido++;
                    textoSalida = String.format("%s: Prenda de %s. Fabricación: %s\n", codigo[i], tipoCliente, origen);
                } else {
                    textoSalida = String.format("%s: Código inválido\n", codigo[i]);
                }

            } else {
                textoSalida = String.format("%s: Patrón NO válido.\n", codigo[i]);

            }
            resultado.append(textoSalida);

        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("EJERCICIO DE ANÁLISIS DE CÓDIGOS DE PRODUCTOS TEXTILES");
        System.out.println("-".repeat(50));
        System.out.println("Se analizarán los siguientes códigos de producto:");
        System.out.println(Arrays.toString(codigo));
        System.out.println("\n");
        System.out.println("RESULTADO");
        System.out.println("-".repeat(20));
        System.out.println(resultado);
        System.out.println("");
        System.out.println("Número de productos con patrón válido:");
        System.out.printf("%d productos (%d con código válido y %d con código inválido\n", numPatronValido, numCodigoValido, (numPatronValido - numCodigoValido));

    } // Fin main

} // Fin class
