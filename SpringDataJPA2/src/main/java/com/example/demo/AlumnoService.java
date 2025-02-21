package com.example.demo;

import java.time.LocalDate;
import java.util.List;

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

	public void guardarAlumnos(List<Alumno> alumnos) {
		repositorioAlumno.saveAll(alumnos);
	}

	public List<Alumno> getTodosAlumnos() {
		return repositorioAlumno.findAll();
	}

	public List<Alumno> consultaAlumosNomApe(String nomApe) {
		return repositorioAlumno.FindByNomApe(nomApe);
	}

	public List<Alumno> consultaAlumosPatronNomApe(String patron) {
		return repositorioAlumno.FindByNomApeContaining(patron);
	}

	public List<Alumno> consultaMenoresDeEdad(LocalDate fecha) {
		return repositorioAlumno.FindByFechaNacGreaterThan(fecha);
	}

	public List<Alumno> consultaMayoresDeEdad(LocalDate fecha) {
		return repositorioAlumno.FindByFechaNacLessThan(fecha);
	}

	public void consultaPersonalizada() {
		List<Object[]> alumnos = repositorioAlumno.consultaPersonalizadaAlumno();

		for (Object[] a : alumnos)
			if (a.length == 2)
				log.info(a[0] + "-" + a[1]);
			else
				log.warn("Formato de registro incorrecto");
	}
	
	public Alumno obtenerAlumnoPorId(Integer Id) {
		//Que devuelva el alumno si lo encuentra o null si no lo encuentra
		return repositorioAlumno.findById(Id).orElse(null);
	}
	public Alumno obtenerAlumnoPorEmail(String email) {
		//Que devuelva el alumno si lo encuentra o null si no lo encuentra
		return repositorioAlumno.finByEmail(email);
	}
	

}