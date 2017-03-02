package br.com.prosperity.bean;

import java.util.List;

public class FuncionarioBean {
	
	public FuncionarioBean() {
		
	}
	public FuncionarioBean(int id, String nome, CargoBean cargo,
			SenioridadeBean senioridade, List<ProjetoBean> projeto) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.senioridade = senioridade;
		this.projeto = projeto;
	}
	private int id;
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
	public int getId() {
		return id;
	}
	public void setIdFuncionario(int id) {
		this.id = id;
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
