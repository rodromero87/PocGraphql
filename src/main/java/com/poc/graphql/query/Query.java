package com.poc.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.poc.graphql.usuario.Usuario;
import com.poc.graphql.usuario.UsuarioRepository;

@Component
public class Query implements GraphQLQueryResolver{
	
	private UsuarioRepository usuarioRepository;

	@Autowired
	public Query(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		
	}
	
	public Usuario buscarUsuarioPeloId(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(null);
	}
	
	public List<Usuario> listarTodosUsuarios(){
		return usuarioRepository.findAll(); 
	}

}
