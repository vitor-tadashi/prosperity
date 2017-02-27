package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class PerfilBean {

	private int id;
	private String nome;
	private List permissoes; //relacionamento entre Perfil e Permissões
	

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
