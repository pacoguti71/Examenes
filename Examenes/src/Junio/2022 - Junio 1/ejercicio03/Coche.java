package ejercicio03;

/**
 * Clase hija Coche
 * @author Campos Robles, Juan Jose
 */
public class Coche extends Vehiculo{
    public int cilindros;

    public Coche(int codigo, String nombre, int cilindros) {
        super(codigo, nombre, 4);
        this.cilindros = cilindros;
    }

    @Override
    public String toString() {
        return (super.toString() + " con " + cilindros + " cilindros");
    }

    @Override
    public float getVelocidadMaxima() {
        return (this.cilindros*100/(float)1.85);
    }
    
}
