package com.poc.graphql.usuario;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	private UsuarioPublisher usuarioPublisher; 

	public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPublisher usuarioPublisher) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioPublisher = usuarioPublisher; 

	}

	public Usuario novoUsuario(String nome, String cpf) {

		Usuario usuario = new Usuario(nome, cpf);

		usuarioRepository.save(usuario);
		
		usuarioPublisher.publish(usuario);

		return usuario;
	}

	public Usuario alterarUsuario(Integer id, String nome, String cpf) {
		Optional<Usuario> optional = usuarioRepository.findById(id);

		if (optional.isPresent()) {
			Usuario usuario = optional.get();
			usuario.setNome(nome);
			usuario.setCpf(cpf);

			usuarioRepository.save(usuario);
			usuarioPublisher.publish(usuario);
			return usuario;
		}

		return null;
	}

	public Usuario apagarUsuario(Integer id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);

		if (optional.isPresent()) {
			Usuario usuario = optional.get();
			usuarioRepository.delete(usuario);
			return usuario;
		}

		return null;
	}

}
