package com.curso.proyecto.integrador.rest;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.curso.proyecto.integrador.bo.Comentario;
import com.curso.proyecto.integrador.bo.Usuario;
import com.curso.proyecto.integrador.service.ComentarioService;
import com.curso.proyecto.integrador.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
	@Autowired
	private UsuarioService  usuarioService;
	@Autowired
	private ComentarioService comentarioService;
	
  @GetMapping
  public ResponseEntity<List<UsuarioDTO>> recuperarUsuario()
	{
	  try {
		  List<Usuario> usuarios= usuarioService.buscarUsuario();
			List<UsuarioDTO> usuarioDTO= new ArrayList<UsuarioDTO>();
			for(Usuario u : usuarios) {
				usuarioDTO.add(new UsuarioDTO(u));
			}
			return ResponseEntity.ok(usuarioDTO);		  
	  } catch(Exception e){	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
			}
		
	}
  @PostMapping
  public ResponseEntity<UsuarioDTO> nuevoUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO)
	{
	  try {
		  Usuario usuario= new Usuario();
			usuario.setNombre(usuarioDTO.getNombre());
			usuarioService.altaUsuario(usuario);
					
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);		  
	  }catch(Exception e){
	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
			}
		
	}
  
  @GetMapping(path="/{id}")
  public ResponseEntity<UsuarioDTO> recuperarUsuarioPorId(@PathVariable Long id)
	{
	  try {
		  
		  Usuario usuario= usuarioService.buscarPorUsuarioPorId(id);
			UsuarioDTO usuarioDTO= new UsuarioDTO(usuario);
		
			return ResponseEntity.ok(usuarioDTO);
	  } catch(Exception e){
	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
			}
		
	}
  
  @PostMapping(path="/{idUsuario}/altacomentario")
  public ResponseEntity <Comentario> ListarComentarios (@PathVariable Long idUsuario,@Valid @RequestBody ComentarioDTO comentarioDTO)
  {
	 try {
		 
		 Comentario comentario= new Comentario();
		 comentario.setIdComentario(comentarioDTO.getIdComentario());
		  comentario.setDescripcion(comentarioDTO.getDescripcion());
		  comentario.setFecha(comentarioDTO.getFecha());
		  comentario.setCreadoPor(usuarioService.buscarPorUsuarioPorId(idUsuario));
		  comentarioService.altaComentario(comentario);
		  return ResponseEntity.ok(comentario);
	 } catch(Exception e){
	    	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
			}
	  
	  	  
  }
   @DeleteMapping(path="/{id}/comentario")
  
	  public ResponseEntity borrarComentario(@PathVariable Long id) {
	  try {  comentarioService.borrarComentario(id);
 		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }  catch(Exception e){
  	
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
  
    }
}
