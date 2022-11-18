package br.ufrn.imd.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Gestor extends Usuario {

	public Gestor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gestor(Long id, String username, String senha, String tipo) {
		super(id, username, senha, tipo);
		// TODO Auto-generated constructor stub
	}
	public Integer getPontos() {
		return 0;
	};
	public String relatorio() {
		return "";
	};
	public String relatorioString() {
		return "";
	}
	public String relatorioGrupo() {
		return "";
	}
}
