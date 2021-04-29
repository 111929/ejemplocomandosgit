package com.curso.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.proyecto.integrador.bo.Usuario;
import com.curso.proyecto.repository.UsuarioRepository;

public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	 UsuarioRepository usuarioRepository;
	@Override
	public List<Usuario> buscarUsuario() {
		
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorUsuarioPorId(Long id) {
		
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Long altaUsuario(Usuario usuario) {
	     usuarioRepository.save(usuario);
		return usuario.getIdUsuario();
	}

	@Override
	public void borrarUsuario(Long id) {
     usuarioRepository.deleteById(id);
		
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

}
