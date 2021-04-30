package com.curso.proyecto.integrador.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.curso.proyecto.integrador.bo.Proyecto;
import com.curso.proyecto.integrador.bo.Usuario;
import com.curso.proyecto.integrador.repository.ProyectoRepository;
import com.curso.proyecto.integrador.repository.UsuarioRepository;

@Service
@Transactional
public class ProyectoServiceImp  implements ProyectoService{

	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public List<Proyecto> buscarProyectos() {
        List<Proyecto> proyectos= (List<Proyecto>)
		 proyectoRepository.findAll();
		return proyectos;
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
	public void AgregarUsuario(Long idProyecto, Long idUsuario) {
		Proyecto proyecto= proyectoRepository.findById(idProyecto).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		 proyecto.getUsuarios().add(usuario);
		 usuario.getProyectos().add(proyecto);
		proyectoRepository.save(proyecto);
		
	}

    

	
	
}
