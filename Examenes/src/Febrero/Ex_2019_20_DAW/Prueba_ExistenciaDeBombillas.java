package Febrero.Ex_2019_20_DAW;

import java.util.*;

/**
 * Existencias de Bombillas - Versión POO
 *
 * @author IES Aguadulce - FPaD - Programación
 *
 */
public class Prueba_ExistenciaDeBombillas {

    public static void main(String args[]) {

        //Declaración e instanciación de objeto ExistenciasDeBombillas
        ExistenciasDeBombillas bombillas = new ExistenciasDeBombillas();

        // Variables de entrada
        int cantidad = 0; //Variable auxiliar para leer de teclado la cantidad de bombillas       

        // Variables auxiliares
        Scanner teclado = new Scanner(System.in);
        String seguir = "N";
        boolean errorEntrada = true;

        // Bucle para aumentar el número de bombillas inicialmente
        do {
            System.out.print("¿Cuántas bombillas se van a reponer?: ");
            errorEntrada = false;
            try {
                cantidad = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Formato de entrada incorrecto.");
                teclado.nextLine();
                errorEntrada = true;
            }
            if (cantidad < 0) {
                System.out.println("La cantidad de bombillas no puede ser negativa.");
                errorEntrada = true;
            }
        } while (errorEntrada);
        bombillas.reponer(cantidad);

        System.out.println("EMPIEZA LA VENTA DE BOMBILLAS TRAS HABERSE REPUESTO LA CANTIDAD DE BOMBILLAS EN EL ALMACÉN");
        //Bucle para gestionar las ventas de bombillas
        do {
            // Bucle para pedir la cantidad de bombillas a vender
            do {
                System.out.printf("En el almacén hay ahora "+ bombillas.existenciasActuales() +" bombillas\n");
                System.out.print("¿Cuántas bombillas se van a vender?: ");

                errorEntrada = false;
                try {
                    cantidad = teclado.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Formato de entrada incorrecto.");
                    teclado.nextLine();
                    errorEntrada = true;
                }
                if (cantidad < 0) {
                    System.out.println("La cantidad de bombillas no puede ser negativa.");
                    errorEntrada = true;
                }
            } while (errorEntrada);

            if (bombillas.vender(cantidad)) {
                System.out.printf("Se vendieron "+ cantidad +" bombillas\n");
            } else {
                System.out.println("Imposible vender, no hay suficientes bombillas en el almacén.");
            }
            System.out.printf("En el almacén hay ahora "+ bombillas.existenciasActuales() +" bombillas\n");
            do {
                System.out.print("¿(T)erminar o (N)ueva venta?: ");
                seguir = teclado.next();
            } while (!seguir.matches("[TtNn]"));
        } while (seguir.toLowerCase().equals("n"));

        System.out.println(bombillas.toString());
    }

}

