package Febrero.Ex_2019_20_DAW;

/**
 *
 * Clase para modelar la gestión de las existencias de bombillas
 * 
 * @author profe
 */
public class ExistenciasDeBombillas {

    //Variable atributo que contiene el valor de las existencias de bombillas en cada momento
    private int existenciasDeBombillas;

    /**
     * Constructor del almacén de bombillas
     *
     */
    public ExistenciasDeBombillas() {
        this.existenciasDeBombillas = 0;
    }

    /**
     * Se reponen bombillas en la ferretería
     *
     * @param bombillas Cantidad de bombillas que se van a añadir al stock.
     */
    public void reponer(int bombillas) {
        this.existenciasDeBombillas += bombillas;
    }

    /**
     * Se vende un número de bombillas si hay suficiente stock.
     *
     * @param bombillas Cantidad de bombillas que se quieren vender.
     * @return Resultado de la operación.
     */
    public boolean vender(int bombillas) {
        boolean laVentaEsPosible = false;

        if (this.existenciasActuales() >= bombillas) {
            this.existenciasDeBombillas -= bombillas;
            laVentaEsPosible = true;
        }
        return laVentaEsPosible;
    }

    /**
     * Devuelve el stock actual de bombillas
     *
     * @return El stock actual de bombillas
     */
    public int existenciasActuales() { //Se inspeccionan las existencias y se devuelve su valor actual
        return this.existenciasDeBombillas;
    }

    /**
     * Sobrescribe el método toString()
     *
     * @return Cadena con el texto "El stock actual de bombillas es: stock”
     *
     */
    @Override
    public String toString() {
        return String.format ("En el almacén hay ahora: %d bombillas", this.existenciasActuales() );
    }
}

