package ejercicio04;

//importamos la libreria para serializar
import java.io.Serializable;

/**
 * Clase Coche, con solo un atributo: nombre
 * @author Profesor - serializado por Campos Robles, Juan Jose
 */
public class Coche implements Serializable{
    
    //definimos el atributo necesario para serializar el objeto
    private static final long serialVersionUID = 42L;
    private final String nombre ;
    
    public Coche(String nombre) {
        this.nombre = nombre;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coche: ").append(nombre);
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

       
    
}
