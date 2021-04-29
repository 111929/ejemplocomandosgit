package com.curso.proyecto.service;
import java.util.List;

import com.curso.proyecto.integrador.bo.*;
public interface ProyectoService {

	public List<Proyecto> buscarProyectos();
	public Proyecto buscarProyectoPorId(Long id);
	public Long altaProyecto(Proyecto proyecto);
	public List<Proyecto> buscarProyectos(String nombre);
	public void borrarProyecto(Long id);
	public void actualizarProyecto(Proyecto proyecto);
	
}
