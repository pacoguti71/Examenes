package Febrero.Ex_2018_19_DAM;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/02/07
 */
public class Vino_mio {

    // ATRIBUTOS DE CLASE
    // Constantes
    public static final int DEFAULT_CODIGO = 1;
    public static final String DEFAULT_DENOMINACION = "Vino Peleón";
    public static final double DEFAULT_GRADOS = 25.0;
    public static final String DEFAULT_ORIGEN = "Jumilla";
    // Variables
    private static int numVinos;

    // ATRIBUTOS DE OBJETO
    // Constantes
    // Variables
    private int codigo;
    private String denominacion;
    private double grados;
    private String origen;

// DECLARACION DE METODOS
    // Constructores
    public Vino_mio(int codigo, String denominacion, double grados, String origen) throws IllegalArgumentException {
        if (codigo < 0 || grados < 0) {
            throw new IllegalArgumentException("Error: parámetros no válidos en el constructor");
        }
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.grados = grados;
        this.origen = origen;
        Vino_mio.numVinos++;
    }

    public Vino_mio() {
        this(Vino_mio.DEFAULT_CODIGO, Vino_mio.DEFAULT_DENOMINACION, Vino_mio.DEFAULT_GRADOS, Vino_mio.DEFAULT_ORIGEN);
    }

    // Métodos estáticos
    public static int getNumVinos() {
        return numVinos;
    }

    // Métodos getters
    public boolean isRiojaFuerte() {
        return (this.origen.equals("Rioja") && this.grados >= 17);
    }

    // Métodos setters
    public void setGrados(double grados) {
        this.grados = grados;
    }

    // Métodos de acción
    // Método toString
    @Override
    public String toString() {
        return "Vino{" + "codigo=" + this.codigo + ", denominacion=" + this.denominacion + ", grados=" + this.grados + ", origen=" + this.origen + '}';
    }

// Métodos privados
    /**
     * **********************
     * METODO MAIN 
     **********************
     */
    public static void main(String[] args) {
        // Variables de entrada
        Vino_mio vino1 = null;
        Vino_mio vino2 = null;
        Vino_mio vino3 = null;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        System.out.println("Crear vino 1 con el constructor por defecto");
        vino1 = new Vino_mio();
        System.out.println(vino1.toString());
        System.out.println("");

        System.out.println("Crear vino 2 con el constructor con parámetros");
        try {
            vino2 = new Vino_mio(2, "Conmorcillo Rioja Reserva", 19.0, "Rioja");
            System.out.println(vino2.toString());
            System.out.println((vino2.isRiojaFuerte() ? "Es" : "No es") + " rioja fuerte");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("");

        System.out.println("Modificar graduación vino 2 a 15 grados");
        vino2.setGrados(15.0); // O se controla aquí que no sea negativo o en el método setter
        System.out.println(vino2.toString());
        System.out.println((vino2.isRiojaFuerte() ? "Es" : "No es") + " rioja fuerte");
        System.out.println("");

        System.out.println("Intentar crear vino 3 con datos incorrectos (-7 grados):");
        try {
            vino3 = new Vino_mio(3, "Conmorcillo Rioja Reserva", -7.0, "Rioja");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("");

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.printf("Total vinos: %d\n", Vino_mio.numVinos);

    } // Fin main

} // Fin class