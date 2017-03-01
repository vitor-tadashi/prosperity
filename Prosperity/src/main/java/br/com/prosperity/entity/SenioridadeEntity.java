package br.com.prosperity.entity;

import java.util.List;

public class SenioridadeEntity {

	private int id;
	private String descricao;
	private List<CargoEntity> senioridade; //relacionamento entre Senioridade e CargoBeana

	public List<CargoEntity> getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(List<CargoEntity> senioridade) {
		this.senioridade = senioridade;
	}

	public SenioridadeEntity(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;
	}

	public SenioridadeEntity() {

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
