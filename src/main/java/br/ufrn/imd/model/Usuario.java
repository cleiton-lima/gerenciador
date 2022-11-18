package br.ufrn.imd.model;


public class Usuario {

	private int username;
	private String senha;
	private String tipo;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int username, String senha, String tipo) {
		super();
		this.username = username;
		this.senha = senha;
		this.tipo = tipo;
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
	
	
}
