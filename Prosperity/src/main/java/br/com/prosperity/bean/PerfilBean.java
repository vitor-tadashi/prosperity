package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class PerfilBean {

	private int id;
	private String nome;
	private List<FuncionalidadeBean> listaFuncionalidades = new ArrayList<>();

	public PerfilBean(int id, String nome, List<FuncionalidadeBean> listaFuncionalidades) {
		this.id = id;
		this.nome = nome;
		this.listaFuncionalidades = listaFuncionalidades;
	}

	public PerfilBean() {
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

	public List<FuncionalidadeBean> getListaFuncionalidades() {
		return listaFuncionalidades;
	}

	public void setListaFuncionalidades(List<FuncionalidadeBean> listaFuncionalidades) {
		this.listaFuncionalidades = listaFuncionalidades;
	}

}
