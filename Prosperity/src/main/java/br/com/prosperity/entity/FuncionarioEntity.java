package br.com.prosperity.entity;

import java.util.List;

public class FuncionarioEntity {
	private int idFuncionario;
	private String nome;
	private CargoEntity cargo;
	private SenioridadeEntity senioridade;
	private List<ProjetoEntity> projeto;
	
	public List<ProjetoEntity> getProjeto() {
		return projeto;
	}
	public void setProjeto(List<ProjetoEntity> projeto) {
		this.projeto = projeto;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CargoEntity getCargo() {
		return cargo;
	}
	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
	}
	public SenioridadeEntity getSenioridade() {
		return senioridade;
	}
	public void setSenioridade(SenioridadeEntity senioridade) {
		this.senioridade = senioridade;
	}
}
