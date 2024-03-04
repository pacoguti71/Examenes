package ejercicio03;

/**
 * Clase abstracta Vehiculo
 * @author Campos Robles, Juan Jose
 */
public abstract class Vehiculo {

    protected int codigo;
    protected String nombre;
    protected int numRuedas;

    public Vehiculo(int codigo, String nombre, int ruedas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numRuedas = ruedas;
    }

    @Override
    public String toString() {
        return ("Código: " + codigo + " nombre: " + nombre + " con: " + numRuedas + " ruedas");
    }

    public abstract float getVelocidadMaxima();

}
