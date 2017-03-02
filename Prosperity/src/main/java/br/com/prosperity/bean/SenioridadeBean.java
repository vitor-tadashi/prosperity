package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class SenioridadeBean {

	private int id;
	private String nome;

	public SenioridadeBean(int id, String nome) {

		this.id = id;
		this.nome = nome;
	}

	public SenioridadeBean() {

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
