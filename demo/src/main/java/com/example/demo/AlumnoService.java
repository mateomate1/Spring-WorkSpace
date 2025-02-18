package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
	private static final Logger log = LoggerFactory.getLogger(AlumnoService.class);
	
	private final AlumnoRepository repositorioAlumno;

	public AlumnoService(AlumnoRepository repositorioAlumno) {
		this.repositorioAlumno = repositorioAlumno;
	}
	
	public void guardarAlumno(Alumno al) {
		repositorioAlumno.save(al);
	}
	
}
