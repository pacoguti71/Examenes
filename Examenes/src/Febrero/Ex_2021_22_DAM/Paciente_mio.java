package Febrero.Ex_2021_22_DAM;

/**
 * @author Francisco Gutiérrez Ruiz
 * @version 1.0
 * @since 2024/02/07
 */
// [modificadores public-(final o abstract)] class <NombreClase> [herencia][interfaces] {
public class Paciente_mio {

    // ATRIBUTOS DE CLASE
    // Constantes (Psf -> public static final)
    // Variables (ps -> private static. Se deben inicializar aquí)
    // ATRIBUTOS DE OBJETO
    // Constantes (pf -> private final) (camelCase)
    // Variables (pr -> private)
    private String nombre;
    private float gastoAcumulado;
    private int numPinchazos;

// DECLARACION DE METODOS

    /*
RECUERDA
No olvidar los modificadores de los atributos

NombreClase. para las referencias a atributos de clase
this. para las referencias a atributos de objeto

Borrar los comentarios
     */
    // Constructores -> public-private-protected NombreClase (p1,p2,p3) throws{
    public Paciente_mio(String nombre, float gastoAcumulado, int numPinchazos) throws IllegalArgumentException {
        if (gastoAcumulado < 0 || numPinchazos < 0) {
            throw new IllegalArgumentException("Datos iniciales erróneos");
        }
        this.nombre = nombre;
        this.gastoAcumulado = gastoAcumulado;
        this.numPinchazos = numPinchazos;
    }

    // Métodos estáticos -> (psg) public static tipodevuelto getxxx() {
    // recuerda poner los NombreClase.
    // Métodos getters -> (pg) public tipodevuelto getxxx() { // isXXX
    public String getNombre() {    
        return this.nombre;
    }

    // recuerda poner los this.
    public String tipoPaciente() {
        String resultado;
        if (this.gastoAcumulado <= 4000.0) {
            resultado = "Estándar";
        } else if (this.gastoAcumulado < 7750) {
            resultado = "Interesante";
        } else if (this.gastoAcumulado < 10000) {
            resultado = "Muy interesante";
        } else {
            resultado = "Premium";
        }
        return resultado;
    }

    // Métodos setters -> (pvs) public void setxxx(p1,p2,p3) throws{
    // recuerda poner los this.
    // Métodos de acción -> (pvar) public void infinitivo(p1,p2,p3) throws{
    // recuerda poner los this. a los atributos y a las llamadas de los métodos
    boolean actualizarGastoAcumulado(int numPinchazosHoy, float importePinchazo) {
        if (numPinchazosHoy > 0 && importePinchazo > 0) {
            this.numPinchazos++;
            this.gastoAcumulado += importePinchazo;
            return true;
        } else {
            return false;
        }
    }

    // Método toString -> (psts) public String toString() {
    @Override
    public String toString() {
        return String.format("Paciente: %s, número de pinchazos: %d, gasto acumulado: %.2f\n",this.nombre,this.numPinchazos,this.gastoAcumulado);
    }

    // Métodos privados -> (p) private void/tipodevuelto xxx(p1,p2,p3) throws{
    public static void main(String[] args) {
        // Constantes
        // Variables de entrada
        String nombre;
        float gastoAcumulado;
        int numPichazos;
        // Variables de salida
        Paciente_mio paciente1 = null;
        Paciente_mio paciente2 = null;
        // Variables auxiliares
        // Objeto Scanner para lectura desde teclado

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        nombre = "Roberto";
        gastoAcumulado = -2;
        numPichazos = -3;
        System.out.printf("Intento crear un paciente de nombre %s\n", nombre);
        try {
            paciente1 = new Paciente_mio(nombre, gastoAcumulado, numPichazos);
        } catch (Exception e) {
            System.out.println("Error al intentar crear: " + e.getMessage());
        }

        System.out.println("Vamos a crear dos objetos paciente");

        nombre = "Julián Piqueras Gómez";
        gastoAcumulado = 0.0F;
        numPichazos = 0;
        try {
            paciente1 = new Paciente_mio(nombre, gastoAcumulado, numPichazos);

        } catch (Exception e) {
            System.out.println("Error al intentar crear: " + e.getMessage());
        }

        nombre = "Fulgencio Pérez";
        gastoAcumulado = 5.0F;
        numPichazos = 1;
        try {
            paciente2 = new Paciente_mio(nombre, gastoAcumulado, numPichazos);

        } catch (Exception e) {
            System.out.println("Error al intentar crear: " + e.getMessage());
        }

        System.out.println("Mostramos la información de los dos objetos paciente");
        System.out.println(paciente1.toString());
        System.out.println(paciente2.toString());

        System.out.println("Actualizamos el gasto acumulado de julian con dos pinchazos de 7025.50");
        paciente1.actualizarGastoAcumulado(1, 7025.50F);
        paciente1.actualizarGastoAcumulado(1, 7025.50F);
        System.out.println(paciente1.toString());
        
        System.out.println("Actualizamos el gasto acumulado de Fulgencio con 5 pinchazos de 76.87");
        for (int i = 0; i <5; i++) { // Con <=  da 10 vueltas. Con < da 9 vueltas que es mejor para lenght
                    paciente2.actualizarGastoAcumulado(1, 76.87F);
        } // Fin for
        System.out.println(paciente2.toString());

        System.out.printf("El tipo de paciente de %s es %s\n",paciente1.getNombre(),paciente1.tipoPaciente());
        System.out.printf("El tipo de paciente de %s es %s\n",paciente2.getNombre(),paciente2.tipoPaciente());
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
    } // Fin main
} // Fin class
