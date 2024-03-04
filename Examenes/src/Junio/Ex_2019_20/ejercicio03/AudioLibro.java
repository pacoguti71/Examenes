package ejercicio03;

/**
 * Clase AudioLibro que hereda de libro e implementa la interface Repoducible.
 * @author Profesor.
 */
public class AudioLibro extends Libro implements Reproducible {

    // Constantes para indicar el mínimo y máximo número de pistas que puede
    // tener un audiolibro
    public static final int MIN_PISTAS =  1;
    public static final int MAX_PISTAS = 20;

    // Número de pistas de audio.
    private final int numeroPistas;
    private final String formato;
    private int numVecesReproducido;

    /**
     * Constructor básico con cuatro parámetros.
     * @param precio Precio del audiolibro.
     * @param titulo Título del audiolibro.
     * @param numeroPistas Número de pistas del audiolibro.
     * @param formato Formato de audio del audio libro (MP3/WAV).
     * @throws IllegalArgumentException Si alguno de los parámetros no es correcto o no está dentro del rango.
     */
    public AudioLibro(String titulo, double precio,
            int numeroPistas, String formato) throws IllegalArgumentException {

        // Invocar al constructor de la clase padre.
        super(titulo, precio);

        // Si el número de pistas no está en el rango permitido se lanzará excepción.
        if (numeroPistas < MIN_PISTAS || numeroPistas > MAX_PISTAS) {
            throw new IllegalArgumentException("El número de pistas no está en el rango permitido");
        } else if (formato.length() == 0) {
            throw new IllegalArgumentException("El formato no puede estar vacío");
        } else if (!formatoCorrecto(formato)) {
            throw new IllegalArgumentException("El formato no es correcto: sólo puede ser MP3 o WAV");
        } else {
            this.numeroPistas = numeroPistas;
            this.formato = formato;
            this.numVecesReproducido= 0;
        }

    }

    /*
        Comprueba si el formato del audiolibro es corrcto: o MP3 o WAV.
    */
    private boolean formatoCorrecto(String elFormato) {
        boolean resultado = false;

        if (elFormato.equalsIgnoreCase("MP3") || elFormato.equalsIgnoreCase("WAV")) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Simula la reproducción del audiolibro.
     * Genera un texto con tantas líneas como número de pistas tenga.
     * @return Tepresentación textual de la reproducción (tantas líneas como número de pistas tenga).
     */
    @Override
    public String reproducir() {

        StringBuilder stringSonido = new StringBuilder();
        for (int contador = 1; contador <= this.numeroPistas; contador++) {
            stringSonido.append("#");
            stringSonido.append("Aquí sonaría la pista número: ");
            stringSonido.append(contador);
            stringSonido.append("#\r\n");
        }
        this.numVecesReproducido++;
        return stringSonido.toString();
    }

    /**
     * Devuelve el número de veces que el audiolibro ha sido reproducido. 
     * @return Número de veces que ha sido reproducido.
     */
    @Override
    public int getNumVecesReproducido() {
        return this.numVecesReproducido;
    }
    
    
    /**
     * El método toString aprovecha el del padre con super.
     * @return representación textual del audiolibro.
     */
    @Override
    public String toString() {
        return String.format ("%s Formato: %s. Núm. de pistas: %d. Núm. veces reproducido: %d.", 
                super.toString(), this.formato, this.numeroPistas, this.numVecesReproducido);
    }

}
