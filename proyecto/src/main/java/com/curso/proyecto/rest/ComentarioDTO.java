package com.curso.proyecto.rest;

import java.time.LocalDate;
import java.util.Date;

import com.curso.proyecto.integrador.bo.Comentario;

import oracle.security.crypto.asn1.ASN1Date;

public class ComentarioDTO {

	private Long idComentario;
	private Long idUsuario;
    private String nombreUsuario;
    private String descripcion;
    private Date fecha;
    
	public ComentarioDTO() {
		
	}
	
	public ComentarioDTO(Comentario comentario) {
		
		this.idComentario = comentario.getIdComentario();		
		this.descripcion = comentario.getDescripcion();
		this.fecha = comentario.getFecha();
		if(comentario.getCreadoPor()!= null) {
			this.idUsuario = comentario.getCreadoPor().getIdUsuario();
			this.nombreUsuario = comentario.getCreadoPor().getNombre();
		}
	}

	public Long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
}
