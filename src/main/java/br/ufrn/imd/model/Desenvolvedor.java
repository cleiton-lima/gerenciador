package br.ufrn.imd.model;

import java.util.List;

import javax.persistence.Entity;

import br.ufrn.imd.repository.TarefaRepository;
import br.ufrn.imd.repository.UsuarioRepository;

@Entity
public class Desenvolvedor extends Usuario {

	public Desenvolvedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Desenvolvedor(Long id, String username, String senha, String tipo) {
		super(id, username, senha, tipo);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public Integer getPontos() {
		return 0;
	};
	public String relatorio() {
		return "";
	};
}
