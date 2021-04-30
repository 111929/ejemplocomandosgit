package com.curso.proyecto.integrador.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.proyecto.integrador.bo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
