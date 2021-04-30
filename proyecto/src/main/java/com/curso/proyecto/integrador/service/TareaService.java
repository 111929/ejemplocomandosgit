package com.curso.proyecto.integrador.service;

import java.util.List;


import com.curso.proyecto.integrador.bo.Tarea;
import com.curso.proyecto.integrador.bo.TipoDeEstado;
import com.curso.proyecto.integrador.bo.TipoDeTarea;

public interface TareaService {

	public List<Tarea> buscarTarea();
	public Tarea buscarTareaPorId(Long idTarea);
	public Long altaTarea(Tarea tarea);
    public TipoDeTarea obtenerTipoTarea(Long id);
    public TipoDeEstado obtenerEstado(Long id);
    public void borrarTarea(Long idTarea);
	public void actualizarTarea(Tarea tarea);
	public void altaUsuarioTarea(Long id , Long idUsuario);
	
}
