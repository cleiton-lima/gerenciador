package br.ufrn.imd.model;

import java.util.List;
import javax.persistence.Entity;

import br.ufrn.imd.repository.TarefaRepository;
import br.ufrn.imd.repository.UsuarioRepository;

@Entity
public class Qa extends Usuario {

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
