package Febrero.Ex_2020_21_DAM;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado el siguiente programa que ya tiene implementada la entrada de datos y 
 * la salida de resultados, escribir el código necesario en Java para que se
 * procese el array de entrada con números de serie y se rellene un array de
 * salida indicando para cada número de serie si es válido o no (cadena “sí” o “no”).
 * 
 * Los requisitos que debe cumplir un número de serie para ser válido son:
1.	Debe estar formado por dos partes separadas por el carácter barra (‘/’).
2.	Las dos partes estarán compuestas únicamente por caracteres numéricos.
3.	Si la primera parte es un número par, entonces la segunda parte tiene que ser exactamente igual que la primera.
4.	Si la primera parte es un número impar, entonces la segunda parte tiene que ser exactamente el inverso de la primera (“capicúa”).
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
        String[] arrayEntrada = {"234/24", "24/234", "31/531", "ABCD/ABCD", "ABC/CBA", "23456/65432",
            "23/23", "32/23", "23/32", "32/32", "0/0", "122/122",  "3301/1033"};

        // Variables de salida
        String[] arrayResultado;

        // Variables auxiliares
        int contador;

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
        String cadenaPatron = "([0-9]+)/([0-9]+)"; // Patrón que debe cumplir todo número de serie
        Pattern patron = Pattern.compile(cadenaPatron);
        contador = 0;
        for (String entrada : arrayEntrada) {
            boolean valido = true;  // De primeras suponemos que es válido y comprobamos los casos de invalidez
            Matcher encaje = patron.matcher(entrada);
            if (encaje.matches()) {
                String primeraParte = encaje.group(1);  // Extracción de la primera parte
                String segundaParte = encaje.group(2);  // Extracción de la segunda parte
                
                /* // Otra opción para sacar las partes: método split de la clase String
                String[] partes= entrada.split("/");
                String primeraParte= partes[0];
                String segundaParte= partes[1];*/
                
                String segundaParteInvertida = new StringBuilder(segundaParte).reverse().toString();
                int primerNumero = Integer.valueOf(primeraParte);
                if (primerNumero % 2 == 0 && !primeraParte.equals(segundaParte)) { // Si es par y no son iguales -> no es váido
                    valido = false;
                } else if (primerNumero % 2 != 0 && !primeraParte.equals(segundaParteInvertida)) { // Si es par y no son invertidos -> no es váido
                    valido = false;
                }
            } else { // Si no cumple el patrón -> no es váido
                valido= false;
            }
            arrayResultado[contador++] = valido ? "sí" : "no";
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
