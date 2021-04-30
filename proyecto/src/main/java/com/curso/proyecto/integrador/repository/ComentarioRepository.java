package com.curso.proyecto.integrador.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.proyecto.integrador.bo.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

}
