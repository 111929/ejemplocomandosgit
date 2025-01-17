package com.curso.proyecto.integrador.bo;

import java.util.*;

import javax.persistence.*;

@Entity(name="Tareas")
public class Tarea {
	@Id
	@GeneratedValue 
	private Long idTarea;
	private String nombre;
	private int totalHoras;
	private Long idEstado;
	private Long idTipoTarea;

	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public Long getIdTipoTarea() {
		return idTipoTarea;
	}
	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}
	@ManyToMany
	private List<Usuario> usuarios= new  ArrayList<Usuario>();
	
	@ManyToOne
	private TipoDeTarea tiposDeTareas;
	@ManyToOne
	private TipoDeEstado tiposDeEstados;
	@OneToMany
	private List<Comentario> comentarios= new ArrayList<Comentario>();
	@ManyToOne
	private Proyecto proyecto;
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Long idtarea) {
	this.idTarea=idtarea;
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public TipoDeTarea getTiposDeTareas() {
	return tiposDeTareas;
	}
	public void setTiposDeTareas(TipoDeTarea tiposDeTareas) {
	this.tiposDeTareas = tiposDeTareas;
	}
	public TipoDeEstado getTiposDeEstados() {
	return tiposDeEstados;
	}
	public void setTiposDeEstados(TipoDeEstado tiposDeEstados) {
	this.tiposDeEstados = tiposDeEstados;
	}
	public List<Comentario> getComentarios() {
	return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
	this.comentarios = comentarios;
	}



}
