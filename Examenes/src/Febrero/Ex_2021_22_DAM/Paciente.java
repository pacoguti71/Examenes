package Febrero.Ex_2021_22_DAM;

/**
 * Clase que modela un paciente considerando su nombre, ngasto acumulado y
 * número de pinchazos que lleva puestos en la clínica
 *
 * @author Profesor
 */
public class Paciente {

    private final String nombre;
    private double gastoAcumulado;
    private int numPinchazos;

    private static final int LIM_ESTANDAR_INTERESANTE = 4000;
    private static final int LIM_INTERESANTE_MINTERESANTE = 7750;
    private static final int LIM_MINTERESANTE_PREMIUM = 10000;
    private static final String TIPO_ESTANDAR = "Estándar";
    private static final String TIPO_INTERESANTE = "Interesante";
    private static final String TIPO_MINTERESANTE = "Muy Interesante";
    private static final String TIPO_PREMIUM = "Premium";

    /**
     * Constructor
     *
     * @param nombre Nombre del paciente
     * @param gastoAcumulado
     * @param numPinchazos
     */
    public Paciente(String nombre, double gastoAcumulado, int numPinchazos)
            throws IllegalArgumentException {

        // Si el gasto o el número de pinchazos es negativo, se lanza una
        // excepción
        if (gastoAcumulado < 0 || numPinchazos < 0) {
            throw new IllegalArgumentException("Datos iniciales erróneos");
        } else {
            this.nombre = nombre;
            this.gastoAcumulado = gastoAcumulado;
            this.numPinchazos = numPinchazos;
        }

    }

    /**
     * Actualizar el gasto acumulado y el número de pinchazos.
     *
     * @param numPinchazosHoy
     * @param importePinchazo
     * @return true si se actualizó el número de pinchazos y el gasto acumulado
     * en función del importe de cada uno.
     */
    public boolean actualizarGastoAcumulado(int numPinchazosHoy,
            float importePinchazo) {

        boolean actualizada = false;

        // Si el número de pinchazos y el importe de cada uno no es negativo
        if (numPinchazosHoy > 0 && importePinchazo > 0) {
            actualizada = true;
            this.numPinchazos = this.numPinchazos + numPinchazosHoy;
            this.gastoAcumulado = this.gastoAcumulado
                    + importePinchazo * numPinchazosHoy;
        }
        return actualizada;
    }

    /**
     * Según el gasto acumulado se devuelve una cadena
     *
     * @return Un String dependiendo del gasto acumulado
     */
    public String tipoPaciente() {
        String tipo = TIPO_ESTANDAR;

        if (this.gastoAcumulado >= LIM_MINTERESANTE_PREMIUM) {
            tipo = TIPO_PREMIUM;
        } else if (this.gastoAcumulado >= LIM_INTERESANTE_MINTERESANTE) {
            tipo = TIPO_MINTERESANTE;
        } else if (this.gastoAcumulado >= LIM_ESTANDAR_INTERESANTE) {
            tipo = TIPO_INTERESANTE;

        }
        return tipo;
    }

    @Override
    public String toString() {

        String gasto = String.format("%.2f", this.gastoAcumulado);

        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(nombre);
        sb.append(", número de pinchazos: ").append(numPinchazos);
        sb.append(", gasto acumulado: ").append(gasto);

        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * @param args the command line arguments
     */
    //----------------------------------------------
    //   PROGRAMA DE PRUEBA DE LA CLASE PACIENTE
    //----------------------------------------------
    public static void main(String[] args) {

        System.out.println("PROGRAMA DE PRUEBA DE LA CLASE PACIENTE");
        System.out.println("---------------------------------------");

        // Intento crear un estudiante con datos errónes para que sale la 
        // excepción
        System.out.println("Intento crear un paciente de nombre Roberto");
        try {
            Paciente fallido = new Paciente("Roberto", -2, -2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al intentar crear: " + e.getMessage() + "\n");
        }

        // Crear pacientes correctos
        System.out.println("\nVamos a crear dos objetos paciente");
        Paciente julian = new Paciente("Julián Piqueras Gómez", 0.0, 0);
        Paciente fulgencio = new Paciente("Fulgencio Pérez", 5.0, 1);

        System.out.println("\nMostramos la información de los dos objetos paciente");
        System.out.println(julian.toString());
        System.out.println(fulgencio.toString());

        // Actualizar el gasto acumulado de julian  con Dos pinchazos de 7025.50 cada uno
        System.out.println("\nActualizamos el gasto acumulado de julian  con dos pinchazos de 7025.50 ");
        julian.actualizarGastoAcumulado(2, 7025.50f);
        System.out.println(julian.toString());

        // Cinco pinchazos de 76.87 cada uno
        // Actualizar el gasto acumulado de fulgencio con 5 pinchazos de 76.87 cada uno
        System.out.println("\nActualizamos el gasto acumulado de Fulgencio con 5 pinchazos de 76.87");
        fulgencio.actualizarGastoAcumulado(5, 76.87f);
        System.out.println(fulgencio.toString());

        System.out.printf("\nEl tipo de paciente de: %s es %s\n", julian.getNombre(),
                julian.tipoPaciente());

        System.out.printf("\nEl tipo de paciente de: %s es %s\n", fulgencio.getNombre(),
                fulgencio.tipoPaciente());

    }

}
