package Febrero.Ex_2019_20_DAW;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado el siguiente programa que ya tiene implementada la entrada de datos y
 * la salida de resultados, escribir el código necesario en Java para que se 
 * procese el array de entrada con números de serie y se rellene un array de
 * salida indicando para cada número de serie si es válido o no (cadena “válido” o “inválido”).
 * 
 * Los requisitos que debe cumplir un número de serie para ser válido son:
1.	Debe comenzar por dos letras mayúsculas. La primera obligatoriamente tiene que ser X o Y. La segunda puede ser cualquiera (sin contar la eñe).
2.	A continuación habrá un guión (‘-’).
3.	Ha de terminar por un año que debe encontrarse entre 1970 y el año actual.
4.	Si el año es impar, la primera letra del número de serie debe ser ‘Y’. Si el año es par, la primera letra debe ser ‘X’.

 * @author profe
 */
public class Ejercicio02 {

    /**
     * Programa principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        String[] arrayEntrada = {"ZA-2000", "XAZ2000", "XA2000", "XA-1969", "YH-1969", 
            "XB-2022", "YV-2022", "YA-1970", "YH-2002", "XB-2021",
            "XQ-1970", "XJ-2002", "YV-2021",};

        // Variables de salida
        String[] arrayResultado;

        // Variables auxiliares
        int contador;
        int currentYear= LocalDate.now().getYear(); // Año actual

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
        arrayResultado = new String[arrayEntrada.length];
        String cadenaPatron = "([XY][A-Z])-([0-9]{4})";  // Patrón general que debe cumplir el número de serie
        Pattern patron = Pattern.compile(cadenaPatron);
        contador = 0;
        for (String entrada : arrayEntrada) {
            boolean valido = true;  // Suponemos que es válido y comprobamos las condiciones de invalidez
            Matcher encaje = patron.matcher(entrada);
            if (encaje.matches()) {
                String letras = encaje.group(1);
                int year = Integer.valueOf(encaje.group(2));
                if (year < 1970 || year > currentYear) { // Si el año no está en el rango -> No es válido
                    valido = false;
                } else if (letras.charAt(0) != 'Y' && year % 2 == 1) { // Si el año es impar y la primera letra no es Y -> No es válido
                    valido = false;
                } else if (letras.charAt(0) != 'X' && year % 2 == 0) { // Si el año es   par y la primera letra no es X -> No es válido
                    valido = false;
                }
            } else { // Si no cumple el patrón -> No es válido
                valido = false;
            }
            arrayResultado[contador++] = valido ? "válido" : "inválido";
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.printf("El resultado de la comprobación de la validez de los números de serie es:\n%s\n",
                Arrays.toString(arrayResultado));

    }

}
