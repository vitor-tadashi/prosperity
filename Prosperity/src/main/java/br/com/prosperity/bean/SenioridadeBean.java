package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class SenioridadeBean {

	private int id;
	private String descricao;
	private List<CargoBean> senioridade; //relacionamento entre Senioridade e CargoBeana

	public SenioridadeBean(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;
	}

	public SenioridadeBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
