package com.curso.proyecto.service;
import java.util.List;

import com.curso.proyecto.integrador.bo.*;
public interface ProyectoService {

	public List<Proyecto> buscarProyecto();
	public Proyecto buscarProyectoPorId(Long idProyecto);
	public Long altaProyecto(Proyecto proyecto);
	public void borrarProyecto(Long id);
	public void actualizarProyecto(Proyecto proyecto);
	
}
