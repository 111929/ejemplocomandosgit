package com.curso.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.proyecto.integrador.bo.Tarea;

public interface TareaRepository  extends CrudRepository<Tarea, Long>{

	
}
