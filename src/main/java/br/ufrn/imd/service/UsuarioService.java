package br.ufrn.imd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufrn.imd.model.Usuario;
import br.ufrn.imd.repository.UsuarioRepository;

@Component
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	public Usuario salvar(Usuario user) {
		return repository.save(user);
	}
	
	public List<Usuario> listar() {
		return repository.findAll();
	}

	public Usuario atualizar(Usuario user) {
		return repository.save(user);
	}

	public Usuario buscarPorId(Long id) {
		return repository.findById(id).get();
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	
}
