package br.com.prosperity.bean;

import java.util.List;

public class PerfilBean {

	private int id;
	private String nome;
	private List<FuncionalidadeBean> permissoes; //relacionamento entre Perfil e Permiss�es
	

	public List<FuncionalidadeBean> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<FuncionalidadeBean> permissoes) {
		this.permissoes = permissoes;
	}

	public PerfilBean(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public PerfilBean(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
