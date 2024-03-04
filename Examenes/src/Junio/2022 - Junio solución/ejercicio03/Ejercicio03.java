package ejercicio03;

/**
 * Dado el interface Poligono crear dos clases: Rectangulo y PentagonoRegular
 * que implemente sus m�todos. Completar el main usando los m�todos para 
 * escribir los datos tal y como se ven en la ejecuci�n de la hoja de examen, creando
 * un rect�ngulo de base 2.5 y altura 8.5, as� como un pent�gono regular de lado 6
 * 
 * @author portatil_profesorado
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        // Crear rect�ngulo
        System.out.println("Crear un rect�ngulo de base 2.5 y altura 8.5") ;
        Rectangulo rectangulo = new Rectangulo(2.5, 8.5);
        
        System.out.printf("El n�mero de lados del rect�ngulo es: %d\n", rectangulo.getLados());
        System.out.printf("El �rea del rect�ngulo es: %.2f\n", rectangulo.getArea());
        System.out.printf("El per�metro del rect�ngulo es: %.2f\n", rectangulo.getPerimetro());
		
	/** NOTA:  recuerda que el �rea de un pent�gono regular es: lado multiplicado por lado multiplicado por 1.72 **/
        System.out.println("----------------------------------------------------------");
        System.out.println("Crear un pent�gono regular de lado 6.0");
        PentagonoRegular pentagono = new PentagonoRegular(6.0);
        
        System.out.printf("El n�mero de lados del pent�gono es: %d\n", pentagono.getLados());
        System.out.printf("El �rea del pent�gono es: %.2f\n", pentagono.getArea());
        System.out.printf("El per�metro del pent�gono es: %.2f\n", pentagono.getPerimetro());
    }
    
}
