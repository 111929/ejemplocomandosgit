package com.curso.proyecto.rest;

import com.curso.proyecto.integrador.bo.Proyecto;

public class ProyectoDTO {
 private Long id;
 private String nombre;
 private int totalHorasProyecto;
 private String UsuarioResponsable;

 
 
 	public String getUsuarioResponsable() {
	return UsuarioResponsable;
    }
    public void setUsuarioResponsable(String usuarioResponsable) {
	UsuarioResponsable = usuarioResponsable;
    }
	
 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
	return nombre;
 	}
 	public void setNombre(String nombre) {
	this.nombre = nombre;
 	}
 	public int getTotalHorasProyecto() {
	return totalHorasProyecto;
 	}
 	public void setTotalHorasProyecto(int totalHorasProyecto) {
	this.totalHorasProyecto = totalHorasProyecto;
 	}
 	
	public ProyectoDTO() {
	
	}
	public ProyectoDTO(Proyecto proyecto) {
		
		this.id = proyecto.getIdProyecto();
		this.nombre = proyecto.getNombre();
		this.totalHorasProyecto = proyecto.getTotalHorasProyecto();		
	
			this.UsuarioResponsable= proyecto.getResponsable().getNombre();
		
	}
    
 
}
