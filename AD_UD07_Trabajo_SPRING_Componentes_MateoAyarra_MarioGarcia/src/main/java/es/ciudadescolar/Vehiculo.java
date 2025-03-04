package es.ciudadescolar;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * Clase que representa un vehículo en la base de datos.
 * Esta clase mapea los vehículos a la tabla "vehiculos" en la base de datos.
 * 
 * @author Mateo y Mario
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula", referencedColumnName = "matricula")
    private Matricula matricula;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    /**
     * Constructor vacío de la clase Vehiculo.
     */
    public Vehiculo() {}

    /**
     * Constructor de la clase Vehiculo con parámetros.
     * 
     * @param matricula
     * @param modelo
     * @param color
     */
    public Vehiculo(Matricula matricula, String modelo, String color) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
    }

    /**
     * Obtiene el id del vehículo.
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id del vehículo.
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene la matrícula del vehículo.
     * 
     * @return matricula
     */
    public Matricula getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo.
     * 
     * @param matricula
     */
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el color del vehículo.
     * 
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     * 
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve una representación en cadena de texto del vehículo.
     * 
     * @return Representación en cadena de texto del vehículo
     */
    @Override
    public String toString() {
        return "Vehiculo{id=" + id + ", matricula=" + matricula + ", modelo='" + modelo + "', color='" + color + "'}";
    }
}
