package br.ufrn.imd.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Gestor extends Usuario {

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
