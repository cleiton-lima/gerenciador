package br.ufrn.imd.model;

import java.util.List;

import br.ufrn.imd.repository.TarefaInterface;
import br.ufrn.imd.repository.UsuarioInterface;

public class Desenvolvedor extends Usuario implements UsuarioInterface, TarefaInterface {
	public List<Tarefa> getTarefas() {
		return null;
	}
	public Integer getPontos() {
		return null;
		
	};
	public String relatorio() {
		return null;
	};
}
