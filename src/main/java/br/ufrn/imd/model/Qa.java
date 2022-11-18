package br.ufrn.imd.model;

import java.util.List;
import javax.persistence.Entity;

import br.ufrn.imd.repository.TarefaInterface;
import br.ufrn.imd.repository.UsuarioInterface;

@Entity
public class Qa extends Usuario implements UsuarioInterface, TarefaInterface {
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
