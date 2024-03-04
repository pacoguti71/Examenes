package Febrero.Ex_2023_24_DAW;

/**
 * Ejercicio 2. Operaciones con arrays
 *
 * @author Francisco Gutiérrez Ruiz
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //-------------------------------------------------------------------------
        //                        Declaraci�n de variables 
        //-------------------------------------------------------------------------
        //Variables de entrada
        int longitud; // Longitud de los array
        int[] arrayA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Array proporcionado
        int[] arrayB = {4, 6, 2, 1, 7, 5, 2, 8, 1, 3}; // Array proporcionado
        int[] arrayBInverso; // Array B invertido
        int[] arrayResultado; // Array resultado
        String array1 = ""; // cadena para mostrar el array A con formato
        String array2 = ""; // cadena para mostrar el array B con formato
        String array2atras = ""; // cadena para mostrar el array B invertido con formato
        String resultado = "";  // cadena para mostrar el array resultado con formato
        int suma=0; // Suma de los valores del array resultado

        //-------------------------------------------------------------------------
        //                              Procesamiento
        //-------------------------------------------------------------------------
         // Determinamos la longitud de los arrays
        longitud = arrayA.length;
        // Creamos el array B invertido
        arrayBInverso = new int[longitud];
        // Recorremos el array B y lo almacenamos invertido
        for (int i = 0; i < longitud; i++) {
            arrayBInverso[i] = arrayB[longitud - i - 1];
        } // Fin for

        // Creamos el array resultado
        arrayResultado = new int[longitud];
        // Recoremos los arrays A y B invertido
        for (int i = 0; i < longitud; i++) {
            // Almacenamos en las cadenas los valores de cada array con formato
            array1 += String.format("%02d ", arrayA[i]);
            array2 += String.format("%02d ", arrayB[i]);
            array2atras += String.format("%02d ", arrayBInverso[i]);

            // Recorremos cada array y vemos si es par (primer if, si es impar (segundo if) o si son par/impar (else)
            // Y almacenamos el valor calculado en el array resultado
            if (arrayA[i] % 2 == 0 && arrayBInverso[i] % 2 == 0) {
                arrayResultado[i] = (arrayA[i] > arrayBInverso[i] ? arrayA[i] : arrayBInverso[i]);
            } else if (arrayA[i] % 2 != 0 && arrayBInverso[i] % 2 != 0) {
                arrayResultado[i] = (arrayA[i] > arrayBInverso[i] ? arrayBInverso[i] : arrayA[i]);
            } else {
                arrayResultado[i] = arrayA[i] + arrayBInverso[i];
            }
            // Almacenamos en la cadena el valor del array con formato
            resultado += String.format("%02d ", arrayResultado[i]);
            // Calculamos la suma de los valores del array resultado. Todo lo hemos hecho aprovechando el mismo bucle
            suma+=arrayResultado[i];
        } // Fin for

        //-------------------------------------------------------------------------
        //  Salida de resultados (no modifiques lo siguiente, debe funcionar as�)
        //-------------------------------------------------------------------------
        System.out.println("EJERCICIO 2. OPERACIONES CON ARRAYS");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("- Array A (hacia adelante):\t\t" + array1);
        System.out.println("- Array B (hacia adelante):\t\t" + array2);
        System.out.println("- Array B (mostrado al rev�s):\t\t" + array2atras);

        System.out.println("\nRESULTADO");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("- Array Resultado (hacia adelante):\t" + resultado);
        System.out.println("\nSuma de todos valores del array resultado:  " + suma);
    } // Fin main
} // Fin class
