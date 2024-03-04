package Febrero.Ex_2023_24_DAM;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 1. Pluvi�metro
 *
 * @author Sergio S S
 */
public class Ejercicio01 {

    public static void main(String args[]) {
        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        String entradaHora = "";
        String patronHora= "HH:mm:ss";
        boolean entradaCorrecta;
        boolean entradaCorrecta2 = false;
        String[] entradaDividida;
        int horas;
        int minutos;
        LocalTime horasyMinutos;
        float lluviaCaida = 0;
        float acumuladoLluvia = 0;
        DateTimeFormatter horasMinutosSegundos = DateTimeFormatter.ofPattern(patronHora);

        //-------------clase Scanner
        Scanner tecladoNumerico = new Scanner(System.in);
        Scanner tecladoAlfanumerico = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //                       +
        //                 Procesamiento 
        //----------------------------------------------
        StringBuilder resultado = new StringBuilder();
        resultado.append("Las LLuvias totales por horas son: \n");//Vamos formando la cadena de salida con StringBuilder)

        do { // Repetimos las preguntas mientras los datos no sean correctos o la entrada no sea vac�a
            entradaCorrecta = false; // Controlamos la salida del bucle
            try {
                System.out.println("Introduce las horas y minutos en los que se ha realizado la lectura con formato hh-mm (enter para terminar)");
                entradaHora = tecladoAlfanumerico.nextLine();
                if (entradaHora.contains("-")) { // Si la entrada contiene " - " (si tiene m�s de uno hay un problema que deber� ser capturado
                    entradaCorrecta = true; // La entrada es correcta
                    entradaDividida = entradaHora.split("-"); // Dividimos la cadena en las partes divididas por :
                    horas = Integer.parseInt(entradaDividida[0]); // La primera parte se la asignamos a las horas
                    minutos = Integer.parseInt(entradaDividida[1]); // La segunda parte se la asignamos los minutos. 
                    horasyMinutos = LocalTime.of(horas, minutos); // Asignamos la horas y minutos con los datos extra�dos 

                    do {

                        try {
                            System.out.printf( "Introduce la lluvia caida para las  " +  horasMinutosSegundos.format(horasyMinutos) + "\n");
                            lluviaCaida = tecladoNumerico.nextFloat();
                            acumuladoLluvia += lluviaCaida; // Aumentamos el acumulador
                        } catch (Exception e) {
                            System.out.println("Debe introducir un n�mero.");
                        }
                    } while (entradaCorrecta2);

                    resultado.append(horasyMinutos.toString());
                    resultado.append(" cantidad ").append(lluviaCaida).append(" litros.\n");

                } else if (entradaHora.isEmpty()) { // Si pulsa enter salimos del bucle
                    entradaCorrecta = true;
                }

            } catch (NumberFormatException e) { // Controlamos las distintas excepciones posibles
                System.out.println("Error en el formato de entrada, el formato debe ser hh-mm");
                entradaCorrecta = false;
            } catch (DateTimeException e) {
                System.out.println("Error en el formato de horas-minutos, la hora debe estar entre 0 y 23 y los minutos entre 0 y 59");
                entradaCorrecta = false;
            } catch (InputMismatchException e) {
                System.out.println("Error en el formato de entrada de datos");
                entradaCorrecta = false;
            }

        } while (!entradaCorrecta || !entradaHora.isEmpty());
        resultado.append("Total : ").append(acumuladoLluvia).append(" litros.");

        //----------------------------------------------
        //          Salida de resultados 
        //----------------------------------------------
        // Se presentan los resultados
        System.out.println(resultado);

    }
}
