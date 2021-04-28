package com.curso.proyecto.integrador.bo;

import javax.persistence.*;

@Entity(name= "Comentarios")
public class Comentario {
	@Id
	@GeneratedValue
 private Long idComentario;
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
 
 
}
