package com.curso.proyecto.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.curso.proyecto.integrador.bo.Proyecto;
import com.curso.proyecto.repository.ProyectoRepository;

@Service
@Transactional
public class ProyectoServiceImp  implements ProyectoService{

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	public List<Proyecto> buscarProyectos() {

		return (List<Proyecto>) proyectoRepository.findAll();
		
	}

	@Override
	public Proyecto buscarProyectoPorId(Long id) {
		
		return  proyectoRepository.findById(id).get();
	}

	@Override
	public Long altaProyecto(Proyecto proyecto) {
		
		proyectoRepository.save(proyecto);
		return proyecto.getIdProyecto();
	}

	@Override
	public void borrarProyecto(Long id) {
		proyectoRepository.deleteById(id);
		
	}

	@Override
	public void actualizarProyecto(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
		
	}

	@Override
	public List<Proyecto> buscarProyectos(String nombre) {
		
		return proyectoRepository.buscarProyectos("%" + nombre);
	}

	
	
}
