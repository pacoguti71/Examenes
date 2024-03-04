package ejercicio04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * - Declarar dos HashMap uno de clave entera y valor String y otro de clave y valor
 *   ambos enteros.
 * - Leer del fichero.txt dado e introducir en uno u otro Hashmap según sea String
 *   o entero lo que se vaya leyendo línea a línea.
 * - Escribir el contenido de los mapas.
 * 
 * 
 * @author Profesor.
 */
public class Ejercicio04 {
    
    public static void main(String[] args) {
        
        System.out.println("PASO DE ARCHIVO DE TEXTO A MAPS");
        System.out.println("-------------------------------");

        HashMap<Integer, String>  mapNombres = new HashMap<>();
        HashMap<Integer, Integer> mapNumeros = new HashMap<>();
        
        try ( // Abrimos el archivo para lectura.
                FileReader fr = new FileReader("fichero.txt");  
                BufferedReader entrada = new BufferedReader(fr);) {

            String linea; //lí­nea del archivo.

            int contador = 1 ;
            while ((linea = entrada.readLine()) != null) {  //mientras no se llegue al final del archivo.
                
                //System.out.println(linea); //se nuestra por pantalla (para comprobar funcionamiento)
                 
                // Intento pasar a entero, si puedo es entero, si no puedo es
                // porque es un String.
                try {
                    
                    int numero = Integer.parseInt(linea);
                    mapNumeros.put(contador, numero);
                    
                } catch (NumberFormatException excepcion) {
                    mapNombres.put(contador, linea);
                    
                }
                contador++ ;
                 
            }
            
            // Escribir el contenido de los mapas.
            System.out.println("Contenido del primer HashMap: ");
            mapNombres.forEach((k,v) -> System.out.println("Clave: " + k + ": Valor: " + v));
            
            System.out.println("\nContenido del segundo HashMap: ");
            mapNumeros.forEach((k,v) -> System.out.println("Clave: " + k + ": Valor: " + v));

            
            // No es necesario close() porque se usa un try-with-resources.
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("Error");
        } 
        
    }
    
}
