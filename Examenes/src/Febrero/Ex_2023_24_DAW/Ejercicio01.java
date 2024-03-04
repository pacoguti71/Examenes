package Febrero.Ex_2023_24_DAW;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 1. Intensidad lumínica
 *
 * @author Francisco Gutiérrez Ruiz
 */
public class Ejercicio01 {

    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        String entradaHora = ""; // Hora introducida por el usuario
        String[] entradaDividida; // Hora descompuesta en minutos y segundos
        int anno; // Año
        int mes; // Mes
        int dia; // Día
        int hora; // Hora
        int minutos; // Minutos
        int segundos; // Segundos
        LocalDateTime fechaHora; // Objeto LocalDateTime para la fecha y la hora

        int luminosidad = 0; // Entrada del valor de luminosidad
        int acumuladoLuminosidad = 0; // Acumulado de luminosidad
        int numEntradas = 0; // Número de entradas válidas
        double media; // Cálculo de la media de luminosidad
        String resultado = "La media de los registros luminicos de hoy es:\n";

        boolean entradaCorrecta; // Controlan la salida de los bucles
        boolean entradaCorrecta2;

        Scanner tecladoAlfanumerico = new Scanner(System.in);
        Scanner tecladoNumerico = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //                       +
        //                 Procesamiento 
        //----------------------------------------------
        fechaHora = LocalDateTime.now(); // Establecemos la fecha y hora actual
        anno = fechaHora.getYear(); // Obenemos los alores de año, mes, día y hora de la fecha actual
        mes = fechaHora.getMonthValue();
        dia = fechaHora.getDayOfMonth();
        hora = fechaHora.getHour();

        do { // Repetimos las preguntas mientras los datos no sean correctos o la entrada no sea vacía 
            entradaCorrecta = false; // Controlamos la salida del bucle

            try {
                System.out.println("Introduce los minutos y segundos en los que se ha realizado la lectura con formato mm:ss (o Enter para terminar)");
                entradaHora = tecladoAlfanumerico.nextLine();
                if (entradaHora.contains(":")) { // Si la entrada contiene : (si tiene más de uno hay un problema que deberá ser capturado
                    entradaCorrecta = true; // La entrada es correcta
                    entradaDividida = entradaHora.split(":"); // Dividimos la cadena en las partes divididas por :
                    minutos = Integer.parseInt(entradaDividida[0]); // La primera parte se la asignamos a los minutos
                    segundos = Integer.parseInt(entradaDividida[1]); // La segunda parte se la asignamos a los segundos. Si hay más partes se pierden, pero al no controlar con REGEX obviamos esto
                    fechaHora = LocalDateTime.of(anno, mes, dia, hora, minutos, segundos); // Asignamos la fecha y hora con los datos extraídos de la actual añadiendo los minutos y segundos introducidos

                    do {
                        entradaCorrecta2 = true; // Controlamos la entrada de un número
                        try {
                            System.out.println("Introduce un número entero para el registro de luminosidad");
                            luminosidad = tecladoNumerico.nextInt();
                            acumuladoLuminosidad += luminosidad; // Aumentamos el acumulador
                        } catch (Exception e) {
                            System.out.println("Debe introducir un número.");
                            entradaCorrecta2 = false;
                            tecladoNumerico.next();
                        }
                    } while (!entradaCorrecta2);

                    resultado += fechaHora.toString() + " Registro: " + luminosidad + " lúmenes\n"; //Vamos formando la cadena de salida (sería mejor con StringBuilder)
                    numEntradas++; // Contamos las entradas válidas
                } else if (entradaHora.isEmpty()) { // Si pulsa enter salimos del bucle
                    entradaCorrecta = true;
                }

            } catch (NumberFormatException e) { // Controlamos las distintas excepciones posibles
                System.out.println("El valor introducido no es numérico o no es adecuado");
                entradaCorrecta = false;
            } catch (DateTimeException e) {
                System.out.println("Los minutos o segundos introducidos no están en los rangos permitidos (0 hasta 59)");
                entradaCorrecta = false;
            } catch (InputMismatchException e) {
                System.out.println("Se ha producido un error en la entrada de datos numérica de la intensidada lumínica");
                entradaCorrecta = false;
            }

        } while (!entradaCorrecta || !entradaHora.isEmpty());

        if (numEntradas > 0) {
            media = acumuladoLuminosidad / numEntradas; // Calculamos la media de las entradas
            resultado += String.format("Media: %.2f lúmenes", media); // Añadimos a la cadena la media calculada
        }

        //----------------------------------------------
        //          Salida de resultados 
        //----------------------------------------------
        System.out.println(resultado);
    }
}
