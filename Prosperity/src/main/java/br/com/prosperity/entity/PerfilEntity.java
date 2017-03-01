package br.com.prosperity.entity;

import java.util.List;

public class PerfilEntity {

	private int id;
	private String nome;
	private List<FuncionalidadeEntity> permissoes; //relacionamento entre Perfil e Permissões
	

	public List<FuncionalidadeEntity> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<FuncionalidadeEntity> permissoes) {
		this.permissoes = permissoes;
	}

	public PerfilEntity(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public PerfilEntity(){
		
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
