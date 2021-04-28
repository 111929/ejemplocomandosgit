package com.curso.proyecto.integrador.bo;

import javax.persistence.*;

@Entity(name= "TiposTareas")
public class TipoDeTarea {
	@Id
	@GeneratedValue
	private Long idTipoTarea;
	public Long getIdTipoTarea() {
		return idTipoTarea;
	}
	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	private String Descripcion;
}
