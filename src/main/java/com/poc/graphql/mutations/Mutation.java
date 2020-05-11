package com.poc.graphql.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.poc.graphql.usuario.Usuario;
import com.poc.graphql.usuario.UsuarioRepository;
import com.poc.graphql.usuario.UsuarioService;

@Component
public class Mutation implements GraphQLMutationResolver{
	
	private UsuarioService usuarioService; 
	
	@Autowired
	public Mutation(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public Usuario novoUsuario(String nome, String cpf) {
		return usuarioService.novoUsuario(nome, cpf); 
	}

	public Usuario alterarUsuario(Integer id, String nome, String cpf) {
		return usuarioService.alterarUsuario(id, nome, cpf);
	}
	
	public Usuario apagarUsuario(Integer id) {
		return usuarioService.apagarUsuario(id);
	}
}
