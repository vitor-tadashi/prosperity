package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioBean {

	private Integer id;
	private String nome;
	private CargoBean cargo;
	private SenioridadeBean senioridade;
	private List<ProjetoBean> projeto = new ArrayList<>();

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

	public List<ProjetoBean> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<ProjetoBean> projeto) {
		this.projeto = projeto;
	}

}
