package es.ciudadescolar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase Service para la gestión de vehículos en el concesionario.
 * Contiene los métodos necesarios para realizar operaciones CRUD sobre los vehículos.
 * 
 * @author Mateo y Mario
 */
@Service
public class ConcesionarioService {

    private static final Logger log = LoggerFactory.getLogger(ConcesionarioService.class);

    private final ConcesionarioRepository concesionarioRepository;

    /**
     * Constructor con parámetros para inyectar el repositorio de vehículos.
     * 
     * @param repositorioVehiculo
     */
    public ConcesionarioService(ConcesionarioRepository repositorioVehiculo) {
        this.concesionarioRepository = repositorioVehiculo;
    }

    /**
     * Método que guarda un vehículo en la base de datos.
     * Si el vehículo ya existe (según su matrícula), no se guarda y retorna false.
     * 
     * @param vehiculo
     * @return
     */
    public boolean guardarVehiculo(Vehiculo vehiculo) {
        if (concesionarioRepository.existsByMatricula(vehiculo.getMatricula())) {
            log.warn("El vehículo con matrícula " + vehiculo.getMatricula().getMatricula() + " ya existe.");
            return false;
        }
        concesionarioRepository.save(vehiculo);
        return true;
    }

    /**
     * Método que guarda una lista de vehículos en la base de datos.
     * 
     * @param vehiculos
     */
    public void guardarVehiculos(List<Vehiculo> vehiculos) {
        concesionarioRepository.saveAll(vehiculos);
        log.info("Vehículos guardados: " + vehiculos.size());
    }

    /**
     * Método que recupera todos los vehículos de la base de datos.
     * 
     * @return
     */
    public List<Vehiculo> obtenerTodosVehiculos() {
        return concesionarioRepository.findAll();
    }

    /**
     * Método que recupera un vehículo a partir de su ID.
     * 
     * @param id
     * @return
     */
    public Vehiculo obtenerVehiculoPorId(Integer id) {
        return concesionarioRepository.findById(id).orElse(null);
    }

    /**
     * Método que recupera los vehículos que coinciden con un modelo específico.
     * 
     * @param modelo
     * @return
     */
    public List<Vehiculo> consultaVehiculosPorModelo(String modelo) {
        return concesionarioRepository.findByModelo(modelo);
    }

    /**
     * Método que elimina un vehículo a partir de su ID.
     * 
     * @param id
     * @return
     */
    public boolean eliminarVehiculo(Integer id) {
        if (concesionarioRepository.existsById(id)) {
            concesionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Método que actualiza los valores de los atributos de un vehículo a partir de su ID.
     * 
     * @param id
     * @param nuevoVehiculo
     * @return
     */
    public Vehiculo actualizarVehiculo(Integer id, Vehiculo nuevoVehiculo) {

        Optional<Vehiculo> vehiculoExistente = concesionarioRepository.findById(id);

        if (vehiculoExistente.isPresent()) {
            Vehiculo vehiculo = vehiculoExistente.get();
            if (nuevoVehiculo.getId() == id) {
                vehiculo.setMatricula(nuevoVehiculo.getMatricula());
                vehiculo.setModelo(nuevoVehiculo.getModelo());
                vehiculo.setColor(nuevoVehiculo.getColor());
            }
            return concesionarioRepository.save(vehiculo);
        }

        return null;
    }
}
