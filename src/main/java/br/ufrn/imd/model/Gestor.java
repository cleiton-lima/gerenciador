package br.ufrn.imd.model;

import javax.persistence.Entity;

@Entity
public class Gestor extends Usuario {
	public String relatorioString() {
		return "";
	}
	public String relatorioGrupo() {
		return "";
	}
}
