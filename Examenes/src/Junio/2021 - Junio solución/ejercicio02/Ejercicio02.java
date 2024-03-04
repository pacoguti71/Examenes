package ejercicio02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dado un array de fechas, comprobar las que sean miércoles o jueves y pasarlas
 * al sábado de la misma semana en la que se encuentren.
 */
public class Ejercicio02 {


    public static void main(String[] args) {

        int contadorDiasCambiados = 0;
        LocalDate[] arrayFechas;
        int mes=1;
        Scanner teclado= new Scanner(System.in);

        System.out.println("COMPROBADOR DE MIÉRCOLES Y JUEVES PARA 2021");
        System.out.println("-------------------------------------------"); 
        boolean entradaCorrecta;
        do {
            entradaCorrecta= true;
            System.out.print ("Introduzca mes para hacer la prueba(1-12): ");
            try {
                mes= teclado.nextInt();
                if (mes<1 || mes>12) {
                    entradaCorrecta= false;
                }
            } catch (InputMismatchException ex) {
                entradaCorrecta= false;
                teclado.next();
            }
        } while (!entradaCorrecta);
        System.out.println();
        
        // Rellenamos el array de fechas.
        arrayFechas = new LocalDate[10];
        for (int i = 0; i < 10; i++) {
            arrayFechas[i] = LocalDate.of(2021, mes, 1 + i);
        }

        // Mostramos el array de fechas.
        System.out.println("CONTENIDO INICIAL DEL ARRAY DE FECHAS");
        System.out.println("-------------------------------------");        
        System.out.println (Arrays.toString(arrayFechas));
        System.out.println();
        
        // Llevamos a cabo las comprobaciones y cambios.
        System.out.println("COMPROBACIÓN DE MIÉRCOLES Y JUEVES");
        System.out.println("----------------------------------");
        for (int i = 0; i < 10; i++) {
            LocalDate fecha = arrayFechas[i];
            DayOfWeek diaSemana = fecha.getDayOfWeek();
            // Si la fecha es miércoles o jueves, la cambiamos por el siguiente día no laborable.
            switch (diaSemana) {
                case WEDNESDAY:
                    contadorDiasCambiados++;
                    arrayFechas[i] = fecha.plusDays(3); // de sábado a lunes.
                    break;
                case THURSDAY:
                    contadorDiasCambiados++;
                    arrayFechas[i] = fecha.plusDays(2); // de domingo a lunes.
                    break;
                default:
                    break;
            }
        }
        System.out.printf ("Total de días cambiados: %d.\n", contadorDiasCambiados);
        System.out.println();
        
        // Mostramos el array de fechas una vez modificado.
        System.out.println("CONTENIDO FINAL DEL ARRAY DE FECHAS");
        System.out.println("-------------------------------------");
        System.out.println (Arrays.toString(arrayFechas));

    }
}

            
