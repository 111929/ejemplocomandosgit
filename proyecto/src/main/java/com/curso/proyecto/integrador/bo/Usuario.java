package com.curso.proyecto.integrador.bo;

import java.util.*;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long idUsuario;
	private String nombre;
	private String apellido;

	@ManyToMany(mappedBy="usuarios")
	private List<Tarea> tareas= new ArrayList <Tarea>();

	public Long getIdUsuario() {
	return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
	this.idUsuario = idUsuario;
	}

	public String getNombre() {
	return nombre;
	}

	public void setNombre(String nombre) {
	this.nombre = nombre;
	}

	public String getApellido() {
	return apellido;
	}

	public void setApellido(String apellido) {
	this.apellido = apellido;
	}

	public List<Tarea> getTareas() {
	return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
	this.tareas = tareas;
	}


}
