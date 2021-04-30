package com.curso.proyecto.integrador.rest;

import com.curso.proyecto.integrador.bo.Proyecto;

public class ProyectoDTO {
 private Long idProyecto;
 private String nombre;
 private int totalHorasProyecto;
 private String UsuarioResponsable;
 

 
 	public ProyectoDTO() {
		
	}
	public ProyectoDTO(Proyecto proyecto) {
		
		this.idProyecto = proyecto.getIdProyecto();
		this.nombre = proyecto.getNombre();
		this.totalHorasProyecto = proyecto.getTotalHorasProyecto();	
		if(proyecto.getResponsable()!= null) {
		this.UsuarioResponsable= proyecto.getResponsable().getNombre();
		}
	}
 
 	public String getUsuarioResponsable() {
	return UsuarioResponsable;
    }
    public void setUsuarioResponsable(String usuarioResponsable) {
	UsuarioResponsable = usuarioResponsable;
    }
	
 	public Long getId() {
		return idProyecto;
	}
	public void setId(Long id) {
		this.idProyecto = id;
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
 	
	
 
}
