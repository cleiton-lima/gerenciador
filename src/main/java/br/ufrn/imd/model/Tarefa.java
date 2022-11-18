package br.ufrn.imd.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String descricao;
	private Date data;

	@ManyToOne
	private Usuario responsavel;
	
	@ManyToOne
	private Usuario relator;
	
	@OneToMany
	private List<Comentario> comentarios;
	
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
	public List<Comentario> getComentarios() {
		return null;
	}
	
	
}
