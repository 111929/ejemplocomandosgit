package com.curso.proyecto.integrador.bo;

import javax.persistence.*;

@Entity (name= "TiposDeEstado")
public class TipoDeEstado {
	@Id
	@GeneratedValue
	private Long idEstado;
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
private String descripcion;

}
