package br.ufrn.imd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.imd.model.Comentario;
import br.ufrn.imd.repository.ComentarioRepository;

@Component
public class ComentarioService {

	@Autowired
	ComentarioRepository repository;
	
	public Comentario salvar(Comentario comment) {
		return repository.save(comment);
	}
	
	public List<Comentario> listar() {
		return repository.findAll();
	}

	public Comentario atualizar(Comentario comment) {
		return repository.save(comment);
	}
	
	public void deletar(Comentario comment) {
		repository.delete(comment);
	}
	
}
