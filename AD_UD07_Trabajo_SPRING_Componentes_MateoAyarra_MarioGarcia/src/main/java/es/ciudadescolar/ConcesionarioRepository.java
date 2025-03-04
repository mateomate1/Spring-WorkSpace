package es.ciudadescolar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que extiende JpaRepository para operaciones de acceso a datos sobre vehículos.
 * Permite realizar consultas y operaciones sobre la base de datos relacionadas con los vehículos.
 * 
 * @author Mateo y Mario
 */
public interface ConcesionarioRepository extends JpaRepository<Vehiculo, Integer> {

    /**
     * Método que recupera una lista de vehículos que coinciden con un modelo específico.
     * 
     * @param modelo
     * @return
     */
    List<Vehiculo> findByModelo(String modelo);

    /**
     * Método que verifica si existe un vehículo en la base de datos con una matrícula específica.
     * 
     * @param matricula
     * @return
     */
    boolean existsByMatricula(Matricula matricula);
}
