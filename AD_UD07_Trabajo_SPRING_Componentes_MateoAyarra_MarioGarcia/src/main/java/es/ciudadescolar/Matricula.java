package es.ciudadescolar;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * Clase que representa una matrícula de un vehículo en la base de datos.
 * Esta clase mapea las matrículas a la tabla "matriculas" en la base de datos.
 * 
 * @author Mateo y Mario
 */
@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "matricula")
    private String matricula;

    /**
     * Constructor vacío de la clase Matricula.
     */
    public Matricula() {}

    /**
     * Constructor de la clase Matricula con parámetros.
     * 
     * @param matricula
     */
    public Matricula(String matricula) {
        this.matricula = matricula.toUpperCase();  // Convertir a mayúsculas por convención
    }

    /**
     * Obtiene la matrícula.
     * 
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula.
     * 
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Devuelve una representación en cadena de texto de la matrícula.
     * 
     * @return Representación en cadena de texto de la matrícula
     */
    @Override
    public String toString() {
        return "Matricula{" + "matricula='" + matricula + '\'' + '}';
    }
}
