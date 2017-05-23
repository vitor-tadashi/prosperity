package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PerfilBean {

	private Integer id;
	private String nome;
	private List<FuncionalidadeBean> listaFuncionalidades = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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