package com.curso.proyecto.integrador.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.proyecto.integrador.bo.Comentario;
import com.curso.proyecto.integrador.repository.ComentarioRepository;
@Service
@Transactional
public class ComentarioServiceImp implements  ComentarioService{

	@Autowired
	private ComentarioRepository comentarioRepository;
	@Override
	public Comentario altaComentario(Comentario comentario) {
	
		return comentarioRepository.save(comentario);
	}

	@Override
	public void borrarComentario(Long id) {
	 comentarioRepository.deleteById(id);
		
	}

}
