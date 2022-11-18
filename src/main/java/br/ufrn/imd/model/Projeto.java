package br.ufrn.imd.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Projeto {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@OneToMany
	protected List<Tarefa> tarefas;
	
	@ManyToMany
	private List<Usuario> usuarios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
}
