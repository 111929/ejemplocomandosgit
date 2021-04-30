package com.curso.proyecto.integrador.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.curso.proyecto.integrador.bo.Proyecto;
import com.curso.proyecto.integrador.bo.Tarea;
import com.curso.proyecto.integrador.bo.TipoDeEstado;
import com.curso.proyecto.integrador.bo.TipoDeTarea;
import com.curso.proyecto.integrador.service.ProyectoService;
import com.curso.proyecto.integrador.service.TareaService;



@RestController
@RequestMapping(value = "/tareas")
public class TareaRestController {
 
	@Autowired
	private TareaService  tareaService;
	@Autowired
	private ProyectoService proyectoService;
	@GetMapping (path = "/{id}")
		 public ResponseEntity<TareaDTO> recuperarTareasPorId(@PathVariable Long id){		  
			  Tarea tarea=  tareaService.buscarTareaPorId(id);		  
			  TareaDTO tareaDTO = new TareaDTO(tarea);
			  return ResponseEntity.ok(tareaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TareaDTO>> recuperarTarea()
	{
		try {
			List<Tarea> tarea= tareaService.buscarTarea();
			List<TareaDTO> tareaDTO= new ArrayList<TareaDTO>();
			for(Tarea t : tarea) {
		       tareaDTO.add(new TareaDTO(t));
			}
			return ResponseEntity.ok(tareaDTO);
		 } catch(Exception e){
	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
			}			
	}
	@PostMapping("/{id}/tareaproyecto")
	public ResponseEntity<TareaDTO> altaNuevaTarea(@Valid @RequestBody TareaDTO tareaDTO) {
	try {
		Tarea tarea= new Tarea();		
		Proyecto proyecto= proyectoService.buscarProyectoPorId(tareaDTO.getIdProyecto());
		TipoDeTarea tipoTarea = tareaService.obtenerTipoTarea(tareaDTO.getIdTipoTarea());
		TipoDeEstado tipoEstado= tareaService.obtenerEstado(tareaDTO.getIdEstado());		
		tarea.setNombre(tareaDTO.getNombre());
		tarea.setTotalHoras(tareaDTO.getTotalHoras());
		tarea.setProyecto(proyecto);
		tarea.setTiposDeTareas(tipoTarea);
		tarea.setTiposDeEstados(tipoEstado);
		tareaService.altaTarea(tarea);
		return ResponseEntity.status(HttpStatus.CREATED).body(new TareaDTO(tarea));
	 }catch(Exception e){
    	
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
				
	}
	
	@PostMapping("/{id}/tareausuario")
	public BodyBuilder asignarUsuarioTarea(@Valid @RequestBody AsignarUsuarioTareaDTO asignarDTO){
		tareaService.altaUsuarioTarea(asignarDTO.getIdTarea(), asignarDTO.getIdUsuario());
		return ResponseEntity.ok();
	}
	
	  @PutMapping(path = "/{id}/tarea")
	  public ResponseEntity actualizarTarea(@PathVariable Long id, @RequestBody TareaDTO tareaDTO) {
	  try {
		    Tarea tarea= tareaService.buscarTareaPorId(id);
		    tarea.setTotalHoras(tareaDTO.getTotalHoras());
		    tarea.setIdTipoTarea(tareaDTO.getIdTipoTarea());
		    tarea.setIdEstado(tareaDTO.getIdEstado());
		    tareaService.actualizarTarea(tarea);
		    
		  	
		  	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }catch(Exception e){
	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		  	  	
	  }
	
}
	

