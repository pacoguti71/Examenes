package ejercicio03;

/**
 * Crear la clase abstracta Vehiculo y dos clases hijas: Coche y Bicicleta
 * que implemente sus m�todos.
 * La clase Vehiculo tendr� los atributos:
 *   codigo, de tipo entero
 *   nombre, de tipo String
 *   numRuedas, de tipo entero
 * 
 * La clase Coche tendr� un atributo entero para indicar el n�mero de cil�ndros.
 * La clase Bicicleta tendr� un atributo entero para indicar el n�mero de radios de sus ruedas.
 * 
 * @author Campos Robles, Juan Jose
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {
        
        System.out.println("Crear un coche");
        Coche coche1 = new Coche(1, "Seat Fura", 4);
        System.out.println("El primer coche es: " + coche1.toString() + ".");
        System.out.println("Y tiene una velocidad m�xima de: " + coche1.getVelocidadMaxima() + " kms. por hora");
        
        System.out.println("");
        System.out.println("");
        
        System.out.println("Crear una bicicleta");
        Bicicleta bicicleta1 = new Bicicleta(4, "Bicicross BH", 2, 28);
        System.out.println("La primera bicicleta es: " + bicicleta1.toString() + ".");
        System.out.println("Y tiene una velocidad m�xima de: " + bicicleta1.getVelocidadMaxima() + " kms. por hora");
    }
}