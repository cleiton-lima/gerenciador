package br.ufrn.imd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Projeto {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Tarefa> tarefas = new ArrayList<>();
	
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void adicionarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Projeto() {}
	
	public Projeto(long id, String nome, String descricao, List<Tarefa> tarefas, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tarefas = tarefas;
		this.usuarios = usuarios;
	}

}
