package Febrero.Ex_2023_24_DAM;

/**
 * Ejercicio 2. Arrays
 *
 * @author MaryWeny
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //-------------------------------------------------------------------------
        //                        Declaración de variables 
        //-------------------------------------------------------------------------
        //Variables de entrada
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrizB = {{0, 6, 2}, {1, 5, 2}, {6, 1, 3}};

        int[][] resultado = new int[3][3];
        int suma = 0;
        //-------------------------------------------------------------------------
        //                              Procesamiento
        //-------------------------------------------------------------------------
        //Suma
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                if (matrizA[i][j] % 2 == 0 && matrizB[i][j] % 2 == 0) {
                    resultado[i][j] = matrizA[i][j] + matrizB[i][j];
                    suma += resultado[i][j];
                }
            }
        }
        //Division
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                if (matrizA[i][j] % 2 != 0 && matrizB[i][j] % 2 != 0) {
                    resultado[i][j] = matrizA[i][j] / matrizB[i][j];
                    suma += resultado[i][j];
                }
            }
        }
        //Resta
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                if ((matrizA[i][j] % 2 == 0 && matrizB[i][j] % 2 != 0) || (matrizA[i][j] % 2 != 0 && matrizB[i][j] % 2 == 0)) {
                    resultado[i][j] = matrizA[i][j] - matrizB[i][j];
                    suma += resultado[i][j];
                }
            }
        }
        //-------------------------------------------------------------------------
        //  Salida de resultados (no modifiques lo siguiente, debe funcionar así)
        //-------------------------------------------------------------------------
        System.out.println("EJERCICIO 2. OPERACIONES CON MATRICES");
        System.out.println("----------------------------------------");

        System.out.println("Matriz A:");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                System.out.print("0" + matrizA[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("\nMatriz B:");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                System.out.print("0" + matrizB[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("\nRESULTADO");
        System.out.println("---------------------------------------");
        System.out.println("Matriz Resultado:");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                System.out.print("0" + resultado[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Suma de todos valores de la matriz resultado:\t" + suma);
    }
}
