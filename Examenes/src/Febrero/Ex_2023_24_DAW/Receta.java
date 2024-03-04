package Febrero.Ex_2023_24_DAW;

/**
 * Ejercicio 3. Clase Receta
 *
 * @author Francisco Gutiérrez TRuiz
 */
public class Receta {

    // Atributos
    //Constantes de clase
    public final static String DEFAULT_AUTOR = "DESCONOCIDO";
    //Variables de clase
    private static int numRecetas;

    // Variables de objeto
    private String nombre;
    private String autor;
    private int duracion;
    private int numIngredientes;

    /**
     * Constructor de 4 parámetros que genera un objeto de tipo Receta.
     *
     * @param nombre
     * @param autor
     * @param duracion
     * @param numIngredientes
     * @throws
     */
    public Receta(String nombre, String autor, int duracion, int numIngredientes) throws IllegalArgumentException {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la receta no puede estar vacío.");
        } else if (duracion < 0) {
            throw new IllegalArgumentException("La duración de la receta no puede ser negativa.");
        } else if (numIngredientes < 0) {
            throw new IllegalArgumentException("El número de ingredientes no puede ser negativo.");
        }
        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.numIngredientes = numIngredientes;
        Receta.numRecetas++;
    }

    /**
     * Constructor de 3 parámetros que genera un objeto de tipo Receta.
     *
     * @param nombre
     * @param duracion
     * @param numIngredientes
     * @throws
     */
    public Receta(String nombre, int duracion, int numIngredientes) throws IllegalArgumentException {
        this(nombre, Receta.DEFAULT_AUTOR, duracion, numIngredientes);
    }

    /**
     * Actualiza la duración de la receta.
     *
     * @param nuevaDuracion
     * @return
     */
    public boolean setDuracion(int nuevaDuracion) {
        boolean efectuarCambio = nuevaDuracion >= 0; // Si el parámetro es mayor o igual a 0 (no es negativo) pone la variable a true
        this.duracion = efectuarCambio ? nuevaDuracion : this.duracion; // Si la variable es true cambia el valor de duracion y si no, deja el que tenía
        return efectuarCambio; // Devuelve true o false si se ha efectuado el cambio
    }

    /**
     * Obtiene la informaci�n de la receta con formato.
     *
     * @return
     */
    public String obtenerInformacion() {
        return this.nombre.toUpperCase() + "@" + this.autor.toUpperCase() + "@" + String.valueOf(this.duracion) + "@" + String.valueOf(this.numIngredientes);
    }

    /**
     * Imprime la información de la receta, mostrando cada campo en una línea.
     */
    public void mostrarInformacion() {
        // Construimos un objeto StringBuilder para ir componiendo la salida
        StringBuilder cadena = new StringBuilder();
        // Dividimos la cadena devuelta por el método según el separador
        String[] arrayCadena = this.obtenerInformacion().split("@");

        // Añadimos a la cadena a mostrar cada campo almacenado en el array descompuesto
        cadena.append("- Nombre: ").append(arrayCadena[0]).append("\n")
                .append("- Autor: ").append(arrayCadena[1]).append("\n")
                .append("- Duración: ").append(arrayCadena[2]).append("\n")
                .append("- Número de ingredientes: ").append(arrayCadena[3]);
        // Imprimimos la salida
        System.out.println(cadena);
    }

    /**
     * Devuelve si la receta es "LARGA", "MEDIA" o "RÁPIDA".
     *
     * @return
     */
    public String tipoReceta() {
        String cadena;
        if (this.duracion < 30) {
            cadena = "RÁPIDA";
        } else if (this.duracion > 60) {
            cadena = "LARGA";
        } else {
            cadena = "MEDIA";
        }
        return cadena;
    }

    /**
     * Método estático que devuelve un entero con la cantidad de recetas
     * creadas.
     *
     * @return
     */
    public static int obtenerNumRecetas() {
        return Receta.numRecetas;
    }

    /**
     * Programa de pruebas.
     *
     * @param args argumentos de consola
     */
    public static void main(String[] args) {
        // Variables de entrada
        Receta miReceta1; //Reservamos memoria para los objetos a crear
        Receta miReceta2;
        Receta miReceta3;

        // Intento de crear una receta sin nombre
        try {
            miReceta1 = new Receta("", "Paco", 25, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error!! " + e.getMessage());
        }

        // Intento de crear una receta con duraci�n negativa
        try {
            miReceta1 = new Receta("Paella", "Paco", -3, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error!! " + e.getMessage());
        }

        // Intento de crear una receta con n�mero de ingredientes negativo
        try {
            miReceta1 = new Receta("Paella", "Paco", 25, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error!! " + e.getMessage());
        }

        // Llamamos al constructor de tres parámetros
        miReceta1 = new Receta("Paella", 100, 25);
        // Llamamos al constructor de cuatro parámetros
        miReceta2 = new Receta("Pollo al curry con leche de coco", "Jamie Oliver", 50, 35);

        // Mostramos el total de recetas creadas
        System.out.println("");
        System.out.printf("Número total de recetas: %d\n", Receta.obtenerNumRecetas());

        // Mostramos la información de las dos recetas
        System.out.println("\nInformación de la receta 1");
        miReceta1.mostrarInformacion();
        System.out.println("\nInformación de la receta 2");
        miReceta2.mostrarInformacion();

        // Modificamos la duración de la receta 1
        miReceta1.setDuracion(128);

        // Mostramos la información de la receta modificada
        System.out.println("\nInformación de la receta 1");
        miReceta1.mostrarInformacion();

    } // Fin main
} // Fin class