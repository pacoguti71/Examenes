package Febrero.Ex_2020_21_DAM;

import java.util.*;

/**
 * Camión de Reparto de Fruta - Versión POO
 *
 * @author profe
 *
 */
public class PruebaEjercicio3_CamionDeReparto {

    public static void main(String args[]) {

        //Declaración e instanciación de objeto CamionDeReparto
        CamionDeReparto camion = new CamionDeReparto();

        // Variables de entrada
        double carga = 0; //Variable auxiliar para leer de teclado los kilos de carga       

        // Variables auxiliares
        Scanner teclado = new Scanner(System.in);
        String seguir = "N";
        boolean errorEntrada = true;

        // Bucle para cargar el camión inicialmente
        do {
            System.out.print("¿Cuántos kilos se van a cargar? :");
            errorEntrada = false;
            try {
                carga = teclado.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Formato de entrada incorrecto.");
                teclado.nextLine();
                errorEntrada = true;
            }
            if (carga < 0) {
                System.out.println("La carga no puede ser negativa.");
                errorEntrada = true;
            }
        } while (errorEntrada);
        camion.cargar(carga);

        System.out.println("EMPIEZA EL REPARTO");
        //Bucle para gestionar las descargas
        do {
            // Bucle para pedir la cantidad de kilos a descargar
            do {
                System.out.printf("En el camión hay ahora %.2f kilos\n", camion.cargaActual());
                System.out.print("¿Cuántos kilos se van a descargar? :");

                errorEntrada = false;
                try {
                    carga = teclado.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Formato de entrada incorrecto.");
                    teclado.nextLine();
                    errorEntrada = true;
                }
                if (carga < 0) {
                    System.out.println("La descarga no puede ser negativa.");
                    errorEntrada = true;
                }
            } while (errorEntrada);

            if (camion.descargar(carga)) {
                System.out.printf("Se descargaron %.2f kilos\n", carga);
            } else {
                System.out.println("Imposible descargar, no hay suficientes kilos en el camión.");
            }
            System.out.printf("En el camión quedan %.2f kilos\n", camion.cargaActual());
            do {
                System.out.print("¿(T)erminar o (N)ueva descarga? :");
                seguir = teclado.next();
            } while (!seguir.matches("[TtNn]"));
        } while (seguir.toLowerCase().equals("n"));

        System.out.println(camion.toString());
    }

}
