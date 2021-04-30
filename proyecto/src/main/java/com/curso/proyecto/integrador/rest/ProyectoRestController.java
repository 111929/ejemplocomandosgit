package com.curso.proyecto.integrador.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.loader.entity.CacheEntityLoaderHelper.EntityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.curso.proyecto.integrador.bo.Proyecto;
import com.curso.proyecto.integrador.service.ProyectoService;


@RestController
@RequestMapping(value ="/proyectos")
public class ProyectoRestController {
	
      @Autowired
      private ProyectoService proyectoService;
      
	  @GetMapping (path="/{id}")
	  public ResponseEntity<ProyectoDTO> recuperarProyectoPorId(@PathVariable Long id){		  
		  Proyecto proyecto=  proyectoService.buscarProyectoPorId(id);		  
		  ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
		  return ResponseEntity.ok(proyectoDTO);
	  }
	  
	  @GetMapping
		public ResponseEntity<List<ProyectoDTO>> recuperarProyectos()
		{
			List<Proyecto> proyecto= proyectoService.buscarProyectos();
			List<ProyectoDTO> proyectoDTO= new ArrayList<ProyectoDTO>();
			for(Proyecto p : proyecto) {
				proyectoDTO.add(new ProyectoDTO(p));
			}
			return ResponseEntity.ok(proyectoDTO);
		}
					

	  
	  @PostMapping
	  public ResponseEntity<ProyectoDTO> altaProyecto(@Valid @RequestBody ProyectoDTO parametros)
	  {
		  Proyecto nuevoProyecto= new Proyecto();
		try {
			nuevoProyecto.setNombre(parametros.getNombre());
			nuevoProyecto.setTotalHorasProyecto(parametros.getTotalHorasProyecto());	   
			  proyectoService.altaProyecto(nuevoProyecto);
			  return ResponseEntity.status(HttpStatus.CREATED).body(new ProyectoDTO(nuevoProyecto));
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		  
	  }
	  
	  @PutMapping(path = "/{id}")
	  public ResponseEntity actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {
	  try {
		    Proyecto proyecto= proyectoService.buscarProyectoPorId(id);
		    proyecto.setNombre(proyectoDTO.getNombre());
		  	proyecto.setTotalHorasProyecto(proyectoDTO.getTotalHorasProyecto());
		  	proyectoService.actualizarProyecto(proyecto);
		  	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }catch(Exception e){
	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		  
	  	
	  }
	  @DeleteMapping(path = "/{id}")
	  public ResponseEntity borrarProyecto(@PathVariable Long id) {
	  	proyectoService.borrarProyecto(id);
	  	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	  }
	  
}
