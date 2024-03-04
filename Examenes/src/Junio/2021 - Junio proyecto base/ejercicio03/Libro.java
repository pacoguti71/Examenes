package ejercicio03;

/**
 * Clase que modela un libro con su t�tulo y precio. (El precio es un valore real
 * que est� en el rango entre un  m�nimo y un m�ximo).
 * 
 * @author profesor
 */
public abstract class Libro {

    public static final double MAX_PRECIO = 60_000_000.0 ;
    public static final double MIN_PRECIO = 3.0 ;
    
    protected final String titulo ;
    protected final double precio ;
    

    /**
     * Constructor con par�metros.
     * @param precio Precio del libro.
     * @param titulo T�tulo del libro.
     */
    public Libro(String titulo, double precio) throws IllegalArgumentException {
        if (precio <= Libro.MIN_PRECIO || precio >= Libro.MAX_PRECIO) {
            throw new IllegalArgumentException(String.format("El precio (%.2f) no est� en el rango permitido", precio));
        } else if (titulo == null || titulo.length() == 0) {
            throw new IllegalArgumentException("El t�tulo vac�o no es v�lido");
        } else {
            this.precio = precio ;
            this.titulo = titulo ;
        }
    }


    /**
     * Devuelve el t�tulo del libro.     
     * @return T�tulo del libro.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Devuelve el precio del libro.     
     * @return Precio del libro.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Devuelve una representaci�n textual del libro.     
     * @return Representaci�n textual del libro.
     */
    @Override
    public String toString() {
        return String.format ("%s: T�tulo: %s. Precio:%s.", this.getClass().getSimpleName(), this.titulo, this.precio);
    }

}
