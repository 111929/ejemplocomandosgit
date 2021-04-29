package com.curso.proyecto.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.curso.proyecto.integrador.bo.Proyecto;
import com.curso.proyecto.service.ProyectoService;





@RestController
@RequestMapping(value="/proyectos")
public class ProyectoControllerRest {
	
      @Autowired
      private ProyectoService proyectoService;
      
	  @GetMapping (path="/{id}")
	  public ResponseEntity<ProyectoDTO> recuperarProyectosPorId(@PathVariable Long id){		  
		  Proyecto proyecto=  proyectoService.buscarProyectoPorId(id);		  
		  ProyectoDTO proyectoDTO = new ProyectoDTO(proyecto);
		  return ResponseEntity.ok(proyectoDTO);
	  }
	  
	  @GetMapping
		public ResponseEntity<List<ProyectoDTO>> recuperarProyecto()
		{
			List<Proyecto> proyecto= proyectoService.buscarProyectos();
			List<ProyectoDTO> proyectoDTO= new ArrayList<ProyectoDTO>();
			for(Proyecto p : proyecto) {
				proyectoDTO.add(new ProyectoDTO(p));
			}
			return ResponseEntity.ok(proyectoDTO);
		}
					
	  @GetMapping(path="/buscador")
		  public ResponseEntity<List<ProyectoDTO>> buscarProyectos(@RequestParam String nombre){
			List<Proyecto> proyectos=  proyectoService.buscarProyectos(nombre);
		    List <ProyectoDTO> proyectosDTO= new ArrayList<ProyectoDTO>();
		    for(Proyecto p : proyectos) {
		    	proyectosDTO.add(new ProyectoDTO(p));
		    }
		    return ResponseEntity.ok(proyectosDTO);
	  }
	  
	  @PostMapping
	  public ResponseEntity<ProyectoDTO> altaProyecto(@Valid @RequestBody ProyectoDTO proyectoDTO){
	   Proyecto proyecto= new Proyecto();
	   proyecto.setNombre(proyectoDTO.getNombre());
       proyectoService.altaProyecto(proyecto);
		  return ResponseEntity.status(HttpStatus.CREATED).body(proyectoDTO);
	  }
	  
	  @PutMapping(path = "/{id}")
	  public ResponseEntity actualizarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {
	  	Proyecto proyecto= proyectoService.buscarProyectoPorId(id);
	  	proyecto.setNombre(proyectoDTO.getNombre());
	  	proyecto.setTotalHorasProyecto(proyectoDTO.getTotalHorasProyecto());
	  	proyectoService.actualizarProyecto(proyecto);
	  	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	  }
	  @DeleteMapping(path = "/{id}")
	  public ResponseEntity borrarProyecto(@PathVariable Long id) {
	  	proyectoService.borrarProyecto(id);
	  	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	  }
	  
}
