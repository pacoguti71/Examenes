package Febrero.Ex_2023_24_DAM;

/**
 * Ejercicio 3. Clase Libro
 *
 * @author Sergio S S
 */
public class Libro {

    // Atributos
    public static int numlibros;
    public static String AUTOR_DESCONOCIDO = "DESCONOCIDO";
    public static int nuevoNumeroPaginas;
    private String titulo;
    private String autor;
    private int numPaginas;
    private int anyoPublicacion;

    /**
     * Constructor de 4 par�metros que genera un objeto de tipo Libro.
     *
     * @param titulo
     * @param autor
     * @param numPaginas
     * @param anyoPublicacion
     * @throws IllegalArgumentException
     */
    public Libro(String titulo, String autor, int numPaginas, int anyoPublicacion) throws IllegalArgumentException {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException("Error!! El t�tulo del libro no puede estar vac�o");
        }
        if (numPaginas < 0) {
            throw new IllegalArgumentException("Error!! El n�mero de p�ginas del libro no puede ser negativo");
        }
        if (anyoPublicacion < 0) {
            throw new IllegalArgumentException("Error!! El a�o de publicaci�n del libro no puede ser negativo");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.anyoPublicacion = anyoPublicacion;

        Libro.numlibros++;

    }

    /**
     * Constructor de 3 par�metros que genera un objeto de tipo Libro.
     *
     * @param titulo
     * @param numPaginas
     * @param anyoPublicacion
     * @throws IllegalArgumentException
     */
    public Libro(String titulo, int numPaginas, int anyoPublicacion) throws IllegalArgumentException {

        this(AUTOR_DESCONOCIDO, titulo, numPaginas, anyoPublicacion);
    }

    /**
     * Actualiza el n�mero de p�ginas.
     *
     * @param nuevasPaginas
     * @return boolean Indica si hay paginas nuevas o no (TRUE / FALSE)
     */
    public boolean actualizarNumPaginas(int nuevasPaginas) {
        
        if (numPaginas >= 0) {
            numPaginas += nuevasPaginas;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Obtiene la informaci�n del libro con formato.
     *
     * @return String Estado del objeto
     */
    public String obtenerInformacion() {
        
        return String.format("%s#%s#%d#%d\n",
                this.titulo.toUpperCase(),
                this.autor.toUpperCase(),
                this.numPaginas,
                this.anyoPublicacion);
    }

    /**
     * Imprime la informaci�n del libro, mostrando cada campo en una l�nea.
     */
    public void mostrarInformacion() {

        StringBuilder cadena = new StringBuilder();

        String[] arrayCadena = this.obtenerInformacion().split("#");
        cadena.append("-T�tulo: ").append(arrayCadena[0]).append("\n")
                .append("-Autor: ").append(arrayCadena[1]).append("\n")
                .append("-N�mero de p�ginas: ").append(arrayCadena[2]).append("\n")
                .append("-A�o de Publicaci�n: ").append(arrayCadena[3]).append("\n");

        System.out.print(cadena);
    }

    /**
     * Devuelve si el libro es "CORTO", "MEDIANO" o "LARGO".
     *
     * @return String Indica si el libro es "CORTO", "MEDIANO" o "LARGO"
     */
    public String tipoLibro() {
        
        String tipoLibro;
        if (numPaginas < 100) {
            tipoLibro= "CORTO";
        } else if (numPaginas >= 100 && numPaginas <= 200) {
            tipoLibro= "MEDIANO";
        } else {
            tipoLibro= "LARGO";
        }
        return tipoLibro;

    }

    /**
     * M�todo est�tico que devuelve un entero con la cantidad de libros creados.
     *
     * @return int devulve el n�mero de libros creados
     */
    public static int Libro() {
        return Libro.numlibros;
    }

    /**
     * Programa de pruebas.
     *
     * @param args argumentos de consola
     */
    public static void main(String[] args) {

        System.out.print("EJERCICIO 3. PRUEBAS DE LA CLASE LIBRO\n");
        System.out.println("--------------------------------------");

        try {
            Libro libro = new Libro(" ", "Shakespeare", 500, 1800);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Libro libro = new Libro("LA VIDA", "Shakespeare", -100, 1800);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Libro libro = new Libro("LA VIDA", "Shakespeare", 100, -1800);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Libro libro1 = new Libro("EL LAZARILLO DE TORMES", Libro.AUTOR_DESCONOCIDO, 100, 1554);
        Libro libro2 = new Libro("MALDITA ROMA", "SANTIAGO POSTEGUILLO", 896, 2023);

        System.out.println();
        System.out.println("N�mero total de libros: " + Libro.numlibros);
        System.out.println();

        System.out.printf("Informaci�n del Libro 1:\n");
        libro1.mostrarInformacion();
        System.out.printf("Informaci�n del Libro 2:\n");
        libro2.mostrarInformacion();

        libro1.actualizarNumPaginas(28);
        System.out.printf("Informaci�n del Libro 1:\n");
        libro1.mostrarInformacion();

    }
}
