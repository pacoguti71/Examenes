package Febrero.Ex_2018_19_DAM;

/**
 * Ejercicio 1.
 * 
 * El siguiente c�digo genera un n�mero aleatorio entre 0 y 9, ambos incluidos:
 *
 * i=(int)(Math.random()*10);
 *
 * En este ejercicio deber�s rellenar un array de 20 elementos con n�meros
 * enteros entre 0 y 9 elegidos al azar. Para hacerlo, deber�s seguir los
 * siguientes criterios:
 *
 * ? La primera posici�n del array se rellenar� con un n�mero aleatorio.
 * 
 * ? A partir de ah�, el resto de posiciones del array se rellenar�n con un n�mero
 * aleatorio mayor o igual al de la posici�n anterior. Solo habr� una excepci�n
 * a esta regla, si el n�mero justo anterior es 9, situaci�n en la cual el
 * n�mero podr� ser cualquiera entre 0 y 9. 
 * 
 * ? Una vez relleno el array, este array se mostrar� por pantalla siguiendo
 * igual que en el siguiente ejemplo: "{89589066788895913897}"
 *
 * @author salva
 */
public class Ejercicio01 {
    public static void main (String args[])
    {
        int[] array=new int[20];
        
        array[0]=(int)(Math.random()*10);
        
        for (int i=1;i<array.length;i++)
        {
            boolean completado=false;
            do
            {   
                int numAle=(int)(Math.random()*10);
                if (array[i-1]<=numAle || array[i-1]==9)
                {
                    array[i]=numAle;              
                    completado=true;
                }
            } while (!completado);            
        }
        
        System.out.print("{");
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i]);
        }
        System.out.print("}");
    }
}
