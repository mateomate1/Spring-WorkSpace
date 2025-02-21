package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "es.AlvaroMorales.Contacto")
@Table(name = "alumnoscontactos", schema = "fcts")
public class Contacto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contacto")
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "telefono")
	private String telefono;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_alumno")
	@JsonIgnore
	private Alumno alum;

	public Contacto() {

	}

	public Contacto(String email, String telefono) {
		this.email = email;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Alumno getAlum() {
		return alum;
	}

	public void setAlum(Alumno alum) {
		this.alum = alum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", email=" + email + ", telefono=" + telefono + "]";
	}

}