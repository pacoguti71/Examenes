package ejercicio02;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dado un array de fechas, comprobar las que sean miércoles o jueves y pasarlas
 * al sábado de la misma semana en la que se encuentren.
 */
public class Ejercicio02 {


    public static void main(String[] args) {
        
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

        
    }
}

            
