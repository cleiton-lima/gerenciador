package br.ufrn.imd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.imd.model.Tarefa;
import br.ufrn.imd.repository.TarefaRepository;

@Component
public class TarefaService {

	@Autowired
	TarefaRepository repository;
	
	public Tarefa salvar(Tarefa task) {
		return repository.save(task);
	}
	
	public List<Tarefa> listar() {
		return repository.findAll();
	}

	public Tarefa atualizar(Tarefa task) {
		return repository.save(task);
	}

	public Tarefa buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
