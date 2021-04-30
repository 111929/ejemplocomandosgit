package com.curso.proyecto.integrador.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.curso.proyecto.integrador.bo.Tarea;
import com.curso.proyecto.integrador.bo.TipoDeEstado;
import com.curso.proyecto.integrador.bo.TipoDeTarea;
import com.curso.proyecto.integrador.bo.Usuario;

import com.curso.proyecto.integrador.repository.TareaRepository;
import com.curso.proyecto.integrador.repository.TipoDeEstadoRepository;
import com.curso.proyecto.integrador.repository.TipoDeTareaRepository;
import com.curso.proyecto.integrador.repository.UsuarioRepository;

@Service
@Transactional
public class TareaServiceImp implements TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	@Autowired
	private TipoDeTareaRepository tipoDeTareaRepository;
	@Autowired
	private TipoDeEstadoRepository tipoDeEstadoRepository;
	@Autowired
	
	private UsuarioRepository usuarioRepository;
	@Override
	
	public List<Tarea> buscarTarea() {
		
		return (List<Tarea>) tareaRepository.findAll();
	}

	@Override
	public Tarea buscarTareaPorId(Long idTarea) {
		
		return tareaRepository.findById(idTarea).get();
	}

	@Override
	public Long altaTarea(Tarea tarea) {
			
		return tareaRepository.save(tarea).getIdTarea();	
	}

	

	@Override
	public void borrarTarea(Long idTarea) {
		tareaRepository.deleteById(idTarea);
		
	}

	@Override
	public void actualizarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
		
	}

	@Override
	public TipoDeTarea obtenerTipoTarea(Long id) {
		
		return tipoDeTareaRepository.findById(id).get();
	}

	@Override
	public TipoDeEstado obtenerEstado(Long id) {
		
		return tipoDeEstadoRepository.findById(id).get();
	}

	@Override
	public void altaUsuarioTarea(Long id, Long idUsuario) {
		Tarea tarea = tareaRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		
		for(Usuario g : tarea.getUsuarios()) {
			if(g.getIdUsuario()== idUsuario) {
				return;
			}
		}
		tarea.getUsuarios().add(usuario);
	    tareaRepository.save(tarea).getIdTarea();
		
	}

}
