package br.ufrn.imd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Tarefa tarefa;
	

	@ManyToOne
	private Usuario autor;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Usuario getAutor() {
		return autor;
	}
	public Comentario() {}
	
	public Comentario(String descricao, Usuario autor, Tarefa tarefa) {
		this.descricao = descricao;
		this.autor = autor;
		this.tarefa = tarefa;
	}	
}
