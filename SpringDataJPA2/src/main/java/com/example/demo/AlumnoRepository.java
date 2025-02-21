package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

//recuperamos los alumnos con un determinado nombre
	List<Alumno> FindByNomApe(String nomApellido);

//recuperamos los alumnos con cierto patron en el nombre y apellido(LIKE ...)
	List<Alumno> FindByNomApeContaining(String patron);

	List<Alumno> FindByFechaNacGreaterThan(LocalDate fecha);

	List<Alumno> FindByFechaNacLessThan(LocalDate fecha);

	//Si queremos hacer una consulta personalizada sin poder apoyarnos en Spring
	@Query("SELECT a.nomApe, c.email FROM Alumno a INNER JOIN a.contacto c")
	List<Object[]> consultaPersonalizadaAlumno();
	
	@Query("FROM Alumno a INNER JOIN a.contacto c WHERE C.email = :emailParam")
	Alumno finByEmail(String emailParam);
}