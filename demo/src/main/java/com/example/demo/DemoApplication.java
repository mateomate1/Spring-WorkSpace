package com.example.demo;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	private AlumnoService servicioAlumno;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public DemoApplication(AlumnoService servicioAlumno) {
		this.servicioAlumno = servicioAlumno;
	}

	@Override
	public void run(String... args) throws Exception {
		//Aqui añadiremos todas las aplicaciones antes de añadirlas al main()
		Alumno al = new Alumno(1000, "Manuel Díaz", LocalDate.of(1990, 12, 31), null);
		Contacto con = new Contacto(null, null, al);
	}

}
