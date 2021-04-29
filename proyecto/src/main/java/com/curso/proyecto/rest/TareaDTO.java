package com.curso.proyecto.rest;

import com.curso.proyecto.integrador.bo.Tarea;
import com.curso.proyecto.integrador.bo.TipoDeEstado;
import com.curso.proyecto.integrador.bo.TipoDeTarea;

public class TareaDTO {
	private Long idTarea;
	private String nombre;
	private int totalHoras;
	private Long idEstado;
	private String tipoEstado;
	
	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(int totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(String tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	private Long idTipoTarea;
	private String tipoTarea;
	
 	public TareaDTO() {
	
 	}

	public TareaDTO(Tarea tarea) {
		
		this.idTarea = tarea.getIdTarea();
		this.nombre = tarea.getNombre();
		this.totalHoras = tarea.getTotalHoras();
		TipoDeEstado tipoDeEstado = tarea.getTiposDeEstados();
		TipoDeTarea tipoDeTarea= tarea.getTiposDeTareas();
		if(tipoDeEstado != null && tipoDeTarea!= null) {
			this.idEstado= tipoDeEstado.getIdEstado();
			this.tipoEstado= tipoDeEstado.getDescripcion();
			this.idTipoTarea= tipoDeTarea.getIdTipoTarea();
			this.tipoTarea=tipoDeTarea.getDescripcion();
		}
		
	}
 
 
}
