package br.ufrn.imd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.imd.model.Projeto;
import br.ufrn.imd.repository.ProjetoRepository;

@Component
public class ProjetoService {

	@Autowired
	ProjetoRepository repository;
	
	public Projeto salvar(Projeto proj) {
		return repository.save(proj);
	}
	
	public List<Projeto> listar() {
		return repository.findAll();
	}

	public Projeto atualizar(Projeto proj) {
		return repository.save(proj);
	}

	public void deletar(Projeto proj) {
		repository.delete(proj);
	}
	
}
