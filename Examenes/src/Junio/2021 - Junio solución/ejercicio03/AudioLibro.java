package ejercicio03;

/**
 * Clase AudioLibro que hereda de libro e implementa la interface Repoducible.
 * @author Profesor.
 */
public class AudioLibro extends Libro implements Reproducible {

    // Constantes para indicar el m�nimo y m�ximo n�mero de pistas que puede
    // tener un audiolibro
    public static final int MIN_PISTAS =  1;
    public static final int MAX_PISTAS = 20;

    // N�mero de pistas de audio.
    private final int numeroPistas;
    private final String formato;
    private int numVecesReproducido;

    /**
     * Constructor b�sico con cuatro par�metros.
     * @param precio Precio del audiolibro.
     * @param titulo T�tulo del audiolibro.
     * @param numeroPistas N�mero de pistas del audiolibro.
     * @param formato Formato de audio del audio libro (MP3/WAV).
     * @throws IllegalArgumentException Si alguno de los par�metros no es correcto o no est� dentro del rango.
     */
    public AudioLibro(String titulo, double precio,
            int numeroPistas, String formato) throws IllegalArgumentException {

        // Invocar al constructor de la clase padre.
        super(titulo, precio);

        // Si el n�mero de pistas no est� en el rango permitido se lanzar� excepci�n.
        if (numeroPistas < MIN_PISTAS || numeroPistas > MAX_PISTAS) {
            throw new IllegalArgumentException("El n�mero de pistas no est� en el rango permitido");
        } else if (formato.length() == 0) {
            throw new IllegalArgumentException("El formato no puede estar vac�o");
        } else if (!formatoCorrecto(formato)) {
            throw new IllegalArgumentException("El formato no es correcto: s�lo puede ser MP3 o WAV");
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
     * Simula la reproducci�n del audiolibro.
     * Genera un texto con tantas l�neas como n�mero de pistas tenga.
     * @return Tepresentaci�n textual de la reproducci�n (tantas l�neas como n�mero de pistas tenga).
     */
    @Override
    public String reproducir() {

        StringBuilder stringSonido = new StringBuilder();
        for (int contador = 1; contador <= this.numeroPistas; contador++) {
            stringSonido.append("#");
            stringSonido.append("Aqu� sonar�a la pista n�mero: ");
            stringSonido.append(contador);
            stringSonido.append("#\r\n");
        }
        this.numVecesReproducido++;
        return stringSonido.toString();
    }

    /**
     * Devuelve el n�mero de veces que el audiolibro ha sido reproducido. 
     * @return N�mero de veces que ha sido reproducido.
     */
    @Override
    public int getNumVecesReproducido() {
        return this.numVecesReproducido;
    }
    
    
    /**
     * El m�todo toString aprovecha el del padre con super.
     * @return representaci�n textual del audiolibro.
     */
    @Override
    public String toString() {
        return String.format ("%s Formato: %s. N�m. de pistas: %d. N�m. veces reproducido: %d.", 
                super.toString(), this.formato, this.numeroPistas, this.numVecesReproducido);
    }

}
