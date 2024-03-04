package Febrero.Ex_2020_21_DAM;

/**
 *
 * Clase para modelar el comportamiento de un camión de reparto
 * 
 * @author profe
 */
public class CamionDeReparto {

    //Atributo que contiene el valor de la carga en cada momento
    private double cargaKg;

    /**
     * Constructor de un nuevo CamionDeReparto con la carga a 0 kilos
     *
     */
    public CamionDeReparto() {
        this.cargaKg = 0;
    }

    /**
     * Se añaden kilos a la carga del Camión
     *
     * @param kilos Cantidad de kilos que se van a cargar en el camión
     */
    public void cargar(double kilos) {
        this.cargaKg += kilos;
    }

    /**
     * Se descargan kilos si hay suficiente carga
     *
     * @param kilos Cantidad de kilos que se quieren descargar del camión
     * @return Resultado de la operación
     */
    public boolean descargar(double kilos) {
        boolean laDescargaEsPosible = false;

        if (this.cargaActual() >= kilos) {
            this.cargaKg -= kilos;
            laDescargaEsPosible = true;
        }
        return laDescargaEsPosible;
    }

    /**
     * Devuelve la carga actual del camión
     *
     * @return La carga actual del camión en kilogramos
     */
    public double cargaActual() { //Se inspecciona la carga actual y se devuelve su valor en kilos
        return this.cargaKg;
    }

    /**
     * Sobrescribe el método toString()
     *
     * @return Cadena con el texto "La carga actual es: cargaKg”
     *
     */
    public String toString() {
        return String.format ("La carga actual es: %.2f Kg", this.cargaKg );
    }

}

