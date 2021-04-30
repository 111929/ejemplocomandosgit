package com.curso.proyecto.integrador.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.curso.proyecto.integrador.bo.Tarea;

public interface TareaRepository  extends CrudRepository<Tarea, Long>{

	/*@Query(value="select sum(t.totalHoras)from Tarea t where t.proyecto.id = :idProyecto")
	
	public Double buscarHorasAsignadas(@Param(value = "idProyecto") Long idProyecto);*/
}
