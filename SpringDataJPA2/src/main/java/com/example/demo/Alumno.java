package com.example.demo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "es.AlvaroMorales.Alumno")
@Table(name = "alumnos", schema = "fcts")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno")
	private Integer id;

	@Column(name = "nombreyapellido")
	private String nomApe;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNac;

	@OneToOne(mappedBy = "alum", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Contacto contactoAl;

	public Alumno() {

	}

	public Alumno(int idAl, String nomApe, LocalDate fechaNac) {
		id = idAl;
		this.nomApe = nomApe;
		this.fechaNac = fechaNac;
	}

	public Contacto getContactoAl() {
		return contactoAl;
	}

	public void setContactoAl(Contacto contactoAl) {
		this.contactoAl = contactoAl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomApe() {
		return nomApe;
	}

	public void setNomApe(String nomApe) {
		nomApe = nomApe;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomApe, contactoAl, fechaNac, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nomApe, other.nomApe) && Objects.equals(contactoAl, other.contactoAl)
				&& Objects.equals(fechaNac, other.fechaNac) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", NomApe=" + nomApe + ", fechaNac=" + fechaNac + ", contactoAl=" + contactoAl
				+ "]";
	}

}