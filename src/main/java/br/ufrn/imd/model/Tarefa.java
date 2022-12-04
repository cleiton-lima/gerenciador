package br.ufrn.imd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String descricao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date data;
	private String prioridade;
	private String status;	

	@ManyToOne
	private Usuario responsavel;
	
	@ManyToOne
	private Usuario relator;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Projeto projeto;
	
	@OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Usuario getRelator() {
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
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public Tarefa() {};
	
	public String getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Tarefa(Long id, String titulo, String descricao, Date data, String prioridade, String status,
		Usuario responsavel, Usuario relator, Projeto projeto, List<Comentario> comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.prioridade = prioridade;
		this.status = status;
		this.responsavel = responsavel;
		this.relator = relator;
		this.projeto = projeto;
		this.comentarios = comentarios;
	}
	
}
