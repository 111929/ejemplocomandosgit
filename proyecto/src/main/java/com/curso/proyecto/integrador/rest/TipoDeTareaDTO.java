package com.curso.proyecto.integrador.rest;

import com.curso.proyecto.integrador.bo.TipoDeTarea;

public class TipoDeTareaDTO {
private Long idTipoTarea;
private String descripcion;
 

	public TipoDeTareaDTO() {
	
   }
	public TipoDeTareaDTO(TipoDeTarea tipoTarea) {
 
	this.idTipoTarea = tipoTarea.getIdTipoTarea();
	this.descripcion = tipoTarea.getDescripcion();
}
	public Long getIdTipoTarea() {
	return idTipoTarea;
	}
	public void setIdTipoTarea(Long idTipoTarea) {
	this.idTipoTarea = idTipoTarea;
	}
	public String getDescripcion() {
	return descripcion;
	}
	public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
	}

}
