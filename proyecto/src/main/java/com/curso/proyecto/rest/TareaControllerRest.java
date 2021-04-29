package com.curso.proyecto.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.curso.proyecto.integrador.bo.Tarea;
import com.curso.proyecto.service.TareaService;

@RestController
@RequestMapping(value = "/tareas")
public class TareaControllerRest {
 
	@Autowired
	private TareaService  tareaService;
	
	@GetMapping (path = "/{id}")
		 public ResponseEntity<TareaDTO> recuperarTareasPorId(@PathVariable Long id){		  
			  Tarea tarea=  tareaService.buscarTareaPorId(id);		  
			  TareaDTO tareaDTO = new TareaDTO(tarea);
			  return ResponseEntity.ok(tareaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TareaDTO>> recuperarTarea()
	{
		List<Tarea> tarea= tareaService.buscarTarea();
		List<TareaDTO> tareaDTO= new ArrayList<TareaDTO>();
		for(Tarea t : tarea) {
	       tareaDTO.add(new TareaDTO(t));
		}
		return ResponseEntity.ok(tareaDTO);
	}
	
}
	

