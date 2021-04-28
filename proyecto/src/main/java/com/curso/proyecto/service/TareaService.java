package com.curso.proyecto.service;

import java.util.List;


import com.curso.proyecto.integrador.bo.Tarea;

public interface TareaService {

	public List<Tarea> buscarTarea();
	public Tarea buscarTareaPorId(Long idTarea);
	public Long altaTarea(Tarea tarea);
    public Long altaTarea(Tarea tarea, Long idTipoTarea,Long idEstado);
    public void borrarTarea(Long idTarea);
	public void actualizarTarea(Tarea tarea);
		
	
}
