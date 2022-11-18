package br.ufrn.imd.model;

import java.util.Date;
import java.util.List;

public class Tarefa {

	private String titulo;
	private String descricao;
	private Usuario responsavel;
	private Qa relator;
	private Date data;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	public Qa getRelator() {
		return relator;
	}
	public void setRelator(Qa relator) {
		this.relator = relator;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Comentario> getComentarios() {
		return null;
	}
	
	
}
