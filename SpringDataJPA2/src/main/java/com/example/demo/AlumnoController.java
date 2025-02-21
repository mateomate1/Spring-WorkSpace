package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {
	private final AlumnoService alumnoService;
	
	public AlumnoController(AlumnoService alSer) {
		this.alumnoService = alSer;
	}
	
	@GetMapping
	public List<Alumno> listarTodosAlumnos(){
		return alumnoService.getTodosAlumnos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Integer id){
		Alumno al = alumnoService.obtenerAlumnoPorId(id);
		
		if(al != null) {
			return ResponseEntity.ok(al);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Alumno> busquedaAlumnoEmail(@RequestParam String correo) {
		Alumno al = alumnoService.obtenerAlumnoPorEmail(correo);
		return ResponseEntity.ok(al);
	}
	
}
