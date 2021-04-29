package com.curso.proyecto.rest;

import com.curso.proyecto.integrador.bo.TipoDeEstado;

public class TipoDeEstadoDTO {
 private Long idTipoEstado;
 private String descripcion;
 
 
  
 	public TipoDeEstadoDTO(TipoDeEstado tipoEstado) {

	this.idTipoEstado = tipoEstado.getIdEstado();
	this.descripcion = tipoEstado.getDescripcion();
}
	public Long getIdTipoEstado() {
	return idTipoEstado;	
 	}	
 	public void setIdTipoEstado(Long idTipoEstado) {
	this.idTipoEstado = idTipoEstado;
 	}
 	public String getDescripcion() {
	return descripcion;
 	}
 	public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
 	}
 
}
