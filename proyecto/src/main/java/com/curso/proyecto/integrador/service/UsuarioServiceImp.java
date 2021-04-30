package com.curso.proyecto.integrador.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.proyecto.integrador.bo.Comentario;
import com.curso.proyecto.integrador.bo.Usuario;
import com.curso.proyecto.integrador.repository.ComentarioRepository;
import com.curso.proyecto.integrador.repository.UsuarioRepository;
@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	 UsuarioRepository usuarioRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Override
	public List<Usuario> buscarUsuario() {
		List<Usuario> usuarios= (List<Usuario>) usuarioRepository.findAll();
		return usuarios;
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

	@Override
	public void generarcomentario(Comentario comentario) {
		comentarioRepository.save(comentario);
		
	}

}
