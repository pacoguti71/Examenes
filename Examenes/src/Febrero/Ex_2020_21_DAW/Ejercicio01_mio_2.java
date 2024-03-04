package Febrero.Ex_2020_21_DAW;


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
final double MINIMO_NEGATIVO=-100;
final double MINIMO_POSITIVO=60;
final double MAXIMO_NEGATIVO=-50;
final double MAXIMO_POSITIVO=200;
final int VECES=7;

        // Variables de entrada
double  numero=0;

        // Variables de salida
int numValido=0;
String resultado="";

        // Variables auxiliares
boolean numCorrecto;

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
System.out.println("Leer 7 números reales y comprobar que estén en el intervalo [-100, -50] o bien en el [60, 200]");
        System.out.println("-".repeat (100));
        for (int i = 0; i <VECES; i++) {


            numCorrecto=false;
            try {
            System.out.println("Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]");
            numero=teclado.nextDouble();
                if ((numero>=-100.0&&numero<=-50)|| (numero>=60&&numero<=200)){
                    numCorrecto=true;
                    numValido++;
                    resultado="Correcto.";
                } else {
                resultado="Incorrecto. Número descartado. ";
                }
            } catch (Exception e) {
                System.out.println("Número no válido");
                teclado.nextLine();
            }
            
        System.out.println(resultado+"Total de números reales válidos hasta ahora: "+numValido+"\n");
            System.out.println("El último número que acabamos de leer es el: "+numero);
        }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------



        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
System.out.println("Total de números válidos leídos: "+numValido);


    } // Fin main

} // Fin class
