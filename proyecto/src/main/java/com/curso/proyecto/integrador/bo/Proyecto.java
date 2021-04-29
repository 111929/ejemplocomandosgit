package com.curso.proyecto.integrador.bo;

import java.util.*;

import javax.persistence.*;

@Entity(name="Proyectos")

public class Proyecto {
  @Id
  @GeneratedValue 
  private Long idProyecto;
  private String nombre;
  private int totalHorasProyecto;
  
  @ManyToOne
  private Usuario responsable;
  
  @ManyToMany
  private List<Usuario> usuarios= new ArrayList<Usuario>();
  
  @OneToMany
  private List<Tarea> tareas= new ArrayList<Tarea>();
  
 
  public List<Tarea> getTareas() {
	return tareas;
  }

  public List<Usuario> getUsuarios() {
	return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
  }

  public void setTareas(List<Tarea> tareas) {
	this.tareas = tareas;
  }

  public Long getIdProyecto() {
	return idProyecto;
  }

  public void setIdProyecto(Long idProyecto) {
	this.idProyecto = idProyecto;
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

  public Usuario getResponsable() {
	return responsable;
  }

  public void setResponsable(Usuario responsable) {
	this.responsable = responsable;
  }
  @Override
  public int hashCode() {
  	final int prime = 31;
  	int result = 1;
  	result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
  	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
  	return result;
  }

  @Override
  public boolean equals(Object obj) {
  	if (this == obj)
  		return true;
  	if (obj == null)
  		return false;
  	if (getClass() != obj.getClass())
  		return false;
  	Proyecto other = (Proyecto) obj;
  	if (idProyecto == null) {
  		if (other.idProyecto != null)
  			return false;
  	} else if (!idProyecto.equals(other.idProyecto))
  		return false;
  	if (nombre == null) {
  		if (other.nombre != null)
  			return false;
  	} else if (!nombre.equals(other.nombre))
  		return false;
  	return true;
  }
  
}
