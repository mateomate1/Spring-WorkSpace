package es.ciudadescolar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Concesionario_MarioMateo implements CommandLineRunner {
    
    private final ConcesionarioService concesionarioService;
    private final Logger log = LoggerFactory.getLogger(Concesionario_MarioMateo.class);
    
    public Concesionario_MarioMateo(ConcesionarioService concesionarioService) {
        this.concesionarioService = concesionarioService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Concesionario_MarioMateo.class, args);
    }

    @Override
    public void run(String... args) {
        /*Vehiculo vehiculo1 = new Vehiculo(new Matricula("4422ABC"), "Ford Fiesta", "Rojo");
        Vehiculo vehiculo2 = new Vehiculo(new Matricula("5691MNK"), "Toyota Corolla", "Azul");

        concesionarioService.guardarVehiculo(vehiculo1);
        concesionarioService.guardarVehiculo(vehiculo2);

        log.info("Lista de vehículos:");
        for (Vehiculo vehiculo : concesionarioService.obtenerTodosVehiculos()) {
            log.info(vehiculo.toString());
        }

        Vehiculo vehiculoEncontrado = concesionarioService.obtenerVehiculoPorId(1);
        if (vehiculoEncontrado != null) {
            log.info("Vehículo encontrado: " + vehiculoEncontrado);
        } else {
            log.warn("Vehículo no encontrado.");
        }

        log.info("Vehículos modelo 'Ford Fiesta':");
        for (Vehiculo vehiculo : concesionarioService.consultaVehiculosPorModelo("Ford Fiesta")) {
            log.info(vehiculo.toString());
        }

        boolean eliminado = concesionarioService.eliminarVehiculo(1);
        if (eliminado) {
            log.info("Vehículo eliminado.");
        } else {
            log.warn("Vehículo no encontrado para eliminar.");
        }*/
    }
}
