package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJPA2Application {
	private static final Logger log = LoggerFactory.getLogger(SpringDataJPA2Application.class);
	
	private AlumnoService servicioAlumno;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPA2Application.class, args);
	}
	
	public SpringDataJPA2Application(AlumnoService servicioAlumno) {
		this.servicioAlumno = servicioAlumno;
	}

}
