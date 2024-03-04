package ejercicio01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado un array con marcas de coches, recorrerlo buscando las marcas que no
 * contengan vocal.
 * @author Profesor.
 */
public class Ejercicio01 {
    
    /**
     * Método principal.
     *
     * @param args Argumentos de la línea de órdenes.
     */
    public static void main(String[] args) {
        
        int totalSinVocal = 0 ;
        
        String[] arrayCoches = {"Volvo", "BMW", "Ford", "Mazda", "Renault",
            "Seat", "Chevrolet", "GMC", "Audi", "KTM", "Peugeout", "KIA"};
        
        System.out.println ("COMPROBACIÓN DE PATRONES");
        System.out.println ("------------------------");        
        for (String coche : arrayCoches) {
            // Buscar las cadenas que no contengan vocal.
            Pattern p=Pattern.compile("[aeiouAEIOU]+");
            Matcher m = p.matcher(coche);
            // Si no contiene vocal, nos interesa.
            if (!m.find()) {
                totalSinVocal++ ;
                System.out.println("La marca: " + coche + " no contiene vocal.");
            }
        }
        
        // Escribir el total de marcas sin vocal.
        System.out.println("Total de marcas sin vocal: " + totalSinVocal) ;
                        
    }
            
}