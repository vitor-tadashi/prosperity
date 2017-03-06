package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class TipoCursoBean {

	private int id;
	private String nome;

	public TipoCursoBean(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public TipoCursoBean() {
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
