package com.curso.proyecto.service;

import java.util.List;


import com.curso.proyecto.integrador.bo.Usuario;

public interface UsuarioService {
	
 public List<Usuario>buscarUsuario();
 public Usuario buscarPorUsuarioPorId(Long id);
 public Long altaUsuario(Usuario usuario);
 public void borrarUsuario(Long id);
 public void actualizarUsuario (Usuario usuario);
}
