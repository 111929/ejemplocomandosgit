package com.curso.proyecto.integrador.bo;

import java.util.Date;

import javax.persistence.*;

@Entity(name= "Comentarios")
public class Comentario {
	@Id
	@GeneratedValue
	private Long idComentario;
	
	private Date fecha= new Date();
	
	
	public Long getIdComentario() {
		return idComentario;
	}

	public void setId_Comentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(Usuario creadoPor) {
		this.creadoPor = creadoPor;
	}

	private String descripcion;
 
	@ManyToOne
	private Usuario creadoPor;

	@ManyToOne
	private Tarea tarea;
	
	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
 
 
}
