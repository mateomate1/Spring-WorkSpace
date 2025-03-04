package es.ciudadescolar;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase Controler 
 * @author Mateo y Mario
 */
@RestController
@RequestMapping("/api/v1/concesionario")
public class VehiculoController {

    private final ConcesionarioService concesionarioService;

    /**
     * Constructor con parametros
     * @param concesionarioService
     */
    public VehiculoController(ConcesionarioService concesionarioService) {
        this.concesionarioService = concesionarioService;
    }

    /**
     * Metodo que recupera todos los vehiculos 
     * @return
     */
    @GetMapping
    public List<Vehiculo> listarTodosVehiculos() {
        return concesionarioService.obtenerTodosVehiculos();
    }

    /**
     * Metodo que recupera un vehiculo a partir de un id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable Integer id) {
        Vehiculo vehiculo = concesionarioService.obtenerVehiculoPorId(id);

        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Metodo que recupera un vehiculo a partir de un modelo
     * @param modelo
     * @return
     */
    @GetMapping("/modelo")
    public List<Vehiculo> obtenerVehiculosPorModelo(@RequestParam String modelo) {
        return concesionarioService.consultaVehiculosPorModelo(modelo);
    }
    
    /**
     * Metodo que da de alta un vehiculo en la base de datos
     * @param vehiculo
     * @return
     */
    @PostMapping
    public ResponseEntity<Vehiculo> guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        boolean guardado = concesionarioService.guardarVehiculo(vehiculo);
        if(guardado)
        	return ResponseEntity.ok(vehiculo);
        else
        	return ResponseEntity.badRequest().build();
    }
    
    /**
      * Metodo que da de elimina un vehiculo en la base de datos a partir de un id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable Integer id) {
        boolean eliminado = concesionarioService.eliminarVehiculo(id);
        
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Metodo que actualiza los valores de los atributos de un vehiculo a partir de un id
     * @param id
     * @param nuevoVehiculo
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Integer id, @RequestBody Vehiculo nuevoVehiculo) {
        Vehiculo vehiculoActualizado = concesionarioService.actualizarVehiculo(id, nuevoVehiculo);

        if (vehiculoActualizado != null) {
            return ResponseEntity.ok(vehiculoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
