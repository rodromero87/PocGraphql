package com.poc.graphql.usuario;

import org.springframework.stereotype.Component;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;


@Component
public class UsuarioPublisher {

	private final Flowable<Usuario> publisher;
	
	private ObservableEmitter<Usuario> emitter;
	
	public UsuarioPublisher() {
		
		Observable<Usuario> usuarioObservable = Observable.create(emitter -> {
			this.emitter = emitter; 
		});
		
		ConnectableObservable<Usuario> connectableObservable = usuarioObservable.share().publish();
		connectableObservable.connect();
		
		this.publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	}
	
	
	public void publish(final Usuario usuario) {
		emitter.onNext(usuario);
	}
	
	public Flowable<Usuario> getPublisher(){
		return publisher;
	}
}
