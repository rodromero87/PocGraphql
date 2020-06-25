package com.poc.graphql.query.subscription;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.poc.graphql.usuario.Usuario;
import com.poc.graphql.usuario.UsuarioPublisher;

@Component
public class Subscription implements GraphQLSubscriptionResolver{
 
	private UsuarioPublisher usuarioPublisher; 
	
	@Autowired
	public Subscription(UsuarioPublisher usuarioPublisher) {
		this.usuarioPublisher = usuarioPublisher; 
	}
	
	
	Publisher<Usuario> usuarios(){
		return usuarioPublisher.getPublisher();
	}
	
	Publisher<Usuario> usuarioAlterado(Integer id){
		return usuarioPublisher.getPublisher(id);
	}
	
}
