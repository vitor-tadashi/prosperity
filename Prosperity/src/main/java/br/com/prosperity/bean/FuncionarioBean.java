package br.com.prosperity.bean;

import java.util.List;

public class FuncionarioBean {
	private int idFuncionario;
	private String nome;
	private CargoBean cargo;
	private SenioridadeBean senioridade;
	private List<ProjetoBean> projeto;
	
	public List<ProjetoBean> getProjeto() {
		return projeto;
	}
	public void setProjeto(List<ProjetoBean> projeto) {
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
	public CargoBean getCargo() {
		return cargo;
	}
	public void setCargo(CargoBean cargo) {
		this.cargo = cargo;
	}
	public SenioridadeBean getSenioridade() {
		return senioridade;
	}
	public void setSenioridade(SenioridadeBean senioridade) {
		this.senioridade = senioridade;
	}
}
