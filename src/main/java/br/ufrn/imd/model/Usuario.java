package br.ufrn.imd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.ufrn.imd.repository.UsuarioRepository;

@Entity
public abstract class Usuario {

	@Id
	@GeneratedValue
	protected Long id;
	protected int username;
	protected String senha;
	protected String tipo;
	
	@OneToMany
	protected List<Tarefa> tarefas;
	
	@ManyToMany
	protected List<Projeto> projetos;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Long id, int username, String senha, String tipo) {
		super();
		this.username = username;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	};
	public abstract String relatorio();
	public abstract Integer getPontos();
	
}
