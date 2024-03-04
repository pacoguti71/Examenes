package ejercicio01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dado el array proporcionado con diversas cadenas correspondientes a n�meros,
 * averiguar cu�les son binarios  y cuales no empleando una expresi�n regular.
 * Indicar el n�mero total tal y como se ve en en el enunciado.
 * @author 
 */
public class Ejercicio01 {
    
    /**
     * M�todo principal.
     *
     * @param args Argumentos de la l�nea de �rdenes.
     */
    public static void main(String[] args) {
        
                
        String[] arrayNumeros = {"13", "01011101", "1A", "0", "1",
            "003", "1011", "FF", "63", "111", "10", "57", "7F"};
        int binarios = 0;
        int noBinarios = 0;
        
        for (String arrayNumero : arrayNumeros) {
            Matcher m = Pattern.compile("[01]+").matcher(arrayNumero);
            if (m.matches()){
                binarios++;
            }else{
                noBinarios++;
            }
        }
   
        System.out.println ("    COMPROBACI�N DE PATRONES   ");
        System.out.println ("-------------------------------");        
        System.out.printf("Numeros binarios totales en el array: %d\n", binarios);
        System.out.printf("Numeros no binarios totales en el array: %d\n", noBinarios);
                  
    }
            
}