package ejercicio04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Dada la clase Coche que se te da ya en el ejercicio (atributo: nombre). Crear
 * un mapa para almacenar los valores leídos, por tanto la clave entera y el
 * valor de la clase Coche Abrir el fichero coches.txt que se te proporciona y
 * para cada línea leíada, crear el objeto coche con el valor leído, almacenar
 * el el mapa con la clave contador actual y el objeto coche recién creado
 *
 *
 * @author Campos Robles, Juan Jose
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        String linea;

        //Definimos el mapa para los coches
        Map<Integer, Coche> mapaCoches = new HashMap<>();

        //las rutas a cada uno de los ficheros a emplear    
        String rutaCoches = System.getProperty("user.dir") + "\\coches.txt";

        Integer contador = 1;
        //Abrimos el archivo para leer
        try {
            //abrimos flujos
            FileReader fCoche = new FileReader(rutaCoches);
            BufferedReader brTexto = new BufferedReader(fCoche);
            //leemos el objeto lista desde el fichero y lo guardamos en la variable
            while ((linea = brTexto.readLine()) != null) {
                 Coche obcoche = new Coche(linea);
                 mapaCoches.put(contador, obcoche);
                 contador++;
            }
            //cerramos flujos
            brTexto.close();
            fCoche.close();
        }
        catch (FileNotFoundException ex){
            System.err.println("Error en el archivo");
        }
        catch (IOException ex) {
            System.out.println("Error en el acceso a la lectura de los datos");
        }
        System.out.println("-- Lectura de fichero de Texto --");
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println("----- Contenido del mapa -----");
        
        //recorremos el mapa para imprimirlo por pantalla
        for (Integer llave:mapaCoches.keySet()){ 
            //Para cada llave, accedemos a su valor para imprimirlo
            System.out.println("Clave: " + llave + " -> " + "Valor: " + mapaCoches.get(llave).toString());  
        }
        
    }

}
