package Febrero.Ex_2021_22_DAM;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa para analizar códigos de productos
 */
public class Ejercicio01 {

    /**
     * Método Main Ejecutable del Ejercicio 1
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String[] productos = {"H12345E15", "M00000E00", "A12345E15", "H12345E11",
            "B00011A02", "B00011A11", "h12345E15", "B1111A04", "B111111A06"};

        // Variables de salida
        String[] descripcionProductos;
        int cantidadPatronesValidos = 0, cantidadCodigosValidos = 0;

        // Variables auxiliares
        String pExpReg = "([HMB])([0-9]{5})([EA])([0-9]{2})";
        Pattern patron = Pattern.compile(pExpReg);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("EJERCICIO DE ANÁLISIS DE CÓDIGOS DE PRODUCTOS TEXTILES");
        System.out.println("------------------------------------------------------");
        System.out.printf("Se analizarán los siguientes códigos de producto: \n%s\n",
                Arrays.toString(productos));

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Reservamos espacio para el array de descripciones de los productos
        descripcionProductos = new String[productos.length];

        // Recorremos cada producto
        for (int i = 0; i < productos.length; i++) {

            // Analizamos cada elemento
            String elemento = productos[i];
            String tipoCliente, identificador, origen, control;
            Matcher acoplamiento = patron.matcher(elemento);

            // Comprobamos si el elemento cumple el patrón
            if (acoplamiento.matches()) { // Se cumple el patrón del número de serie
                cantidadPatronesValidos++;
                // Extraemos cada grupo
                tipoCliente = acoplamiento.group(1);
                identificador = acoplamiento.group(2);
                origen = acoplamiento.group(3);
                control = acoplamiento.group(4);
                // Comprobamos si la letra de control es correcta
                int sumaDigitos = 0;
                for (int j = 0; j < identificador.length(); j++) {
                    sumaDigitos += (int) (identificador.charAt(j) - '0');
                }
                String codigoCalculado = String.format("%02d", sumaDigitos);

                // Añadimos la descripción al array de resultados
                if (codigoCalculado.equals(control)) { // Si el codigo de control es correcto
                    cantidadCodigosValidos++;
                    String descripcion = "Prenda de ";
                    switch (tipoCliente) {
                        case "H":
                            descripcion += "hombre.";
                            break;
                        case "M":
                            descripcion += "mujer. ";
                            break;
                        case "B":
                            descripcion += "bebé.  ";
                            break;
                    }
                    descripcion += " Fabricación: ";
                    switch (origen) {
                        case "E":
                            descripcion += "Europa.";
                            break;
                        case "A":
                            descripcion += " Asia.";
                            break;
                    }
                    descripcionProductos[i] = descripcion;
                } else { // Si el código no es correcto
                    descripcionProductos[i] = "Código inválido.";
                }

            } else {  // Si el patrón no es correcto
                descripcionProductos[i] = "Patrón NO válido.";
            }
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%-12s %s\n", productos[i] + ":", descripcionProductos[i]);
        }

        System.out.println();
        System.out.println("Número de productos con patrón válido: ");
        System.out.printf("%d productos (%d con código válido y %d con código inválido)\n",
                cantidadPatronesValidos, cantidadCodigosValidos,
                cantidadPatronesValidos - cantidadCodigosValidos);

    }

}
