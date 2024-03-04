package ejercicio03;

/**
 * Clase hija Bicicleta
 * @author Campos Robles, Juan Jose
 */
public class Bicicleta extends Vehiculo {
    public int numRadios;

    public Bicicleta(int codigo, String nombre, int ruedas, int numRadios) {
        /*aunque se admite el numero de ruedas como parametro de entrada siempre 
        se exige que para las bicicletas ese valor sea 2 por lo tanto se llama 
        al constructor del padre con ese valor constante que es 2.  */
        super(codigo, nombre, 2);
        this.numRadios = numRadios;
    }

    @Override
    public String toString() {
        return (super.toString() + " número de radios: " + numRadios);
    }

    @Override
    public float getVelocidadMaxima() {
        return (numRadios*(float)1.75);
    }
    
    
    
}
