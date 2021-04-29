package com.curso.proyecto.repository;



import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.curso.proyecto.integrador.bo.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	
	
	@Query(value="from Proyecto p where p.nombre like :nombre")
	public List<Proyecto> buscarProyectos(@Param("nombre") String nombre);
	
	
}
