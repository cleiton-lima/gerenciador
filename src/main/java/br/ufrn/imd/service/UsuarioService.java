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
		System.out.println("Executando regra de negócio complicadas");
		return repository.save(user);
	}
	
	public List<Usuario> listar() {
		return repository.findAll();
	}
}
