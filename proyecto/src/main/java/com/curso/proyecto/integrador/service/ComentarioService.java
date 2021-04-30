package com.curso.proyecto.integrador.service;

import com.curso.proyecto.integrador.bo.Comentario;

public interface ComentarioService {
 public Comentario altaComentario (Comentario comentario);
 public void borrarComentario(Long id);
}
