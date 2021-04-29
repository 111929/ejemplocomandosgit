package com.curso.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.proyecto.integrador.bo.Tarea;
import com.curso.proyecto.integrador.bo.TipoDeEstado;
import com.curso.proyecto.integrador.bo.TipoDeTarea;
import com.curso.proyecto.repository.TareaRepository;
import com.curso.proyecto.repository.TipoDeEstadoRepository;
import com.curso.proyecto.repository.TipoDeTareaRepository;

@Service
public class TareaServiceImp implements TareaService {

	@Autowired
	 TareaRepository tareaRepository;
	@Autowired
	TipoDeTareaRepository tipoDeTareaRepository;
	@Autowired
	TipoDeEstadoRepository tipoDeEstadoRepository;
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
		tareaRepository.save(tarea);
		return tarea.getIdTarea();
	}

	@Override
	public Long altaTarea(Tarea tarea, Long idTipoTarea, Long idEstado) {
		TipoDeTarea tipoDeTarea= tipoDeTareaRepository.findById(idTipoTarea).get();
		TipoDeEstado tipoDeEstado= tipoDeEstadoRepository.findById(idEstado).get();
		tarea.setTiposDeTareas(tipoDeTarea);
		tarea.setTiposDeEstados(tipoDeEstado);
		tareaRepository.save(tarea);
		return tarea.getIdTarea();
	}

	@Override
	public void borrarTarea(Long idTarea) {
		tareaRepository.deleteById(idTarea);
		
	}

	@Override
	public void actualizarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
		
	}

}
