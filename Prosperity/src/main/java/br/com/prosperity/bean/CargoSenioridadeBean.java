package br.com.prosperity.bean;

import java.util.List;

public class CargoSenioridadeBean {

	private int id;
	private double valorMinSalario;
	private double valorMaxSalario;
	private List<CargoBean> cargo;
	private List<SenioridadeBean> senioridade;

	public CargoSenioridadeBean(int id, double valorMinSalario, double valorMaxSalario, List<CargoBean> cargo,
			List<SenioridadeBean> senioridade) {
		this.id = id;
		this.valorMinSalario = valorMinSalario;
		this.valorMaxSalario = valorMaxSalario;
		this.cargo = cargo;
		this.senioridade = senioridade;
	}
	
	public CargoSenioridadeBean(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorMinSalario() {
		return valorMinSalario;
	}

	public void setValorMinSalario(double valorMinSalario) {
		this.valorMinSalario = valorMinSalario;
	}

	public double getValorMaxSalario() {
		return valorMaxSalario;
	}

	public void setValorMaxSalario(double valorMaxSalario) {
		this.valorMaxSalario = valorMaxSalario;
	}

	public List<CargoBean> getCargo() {
		return cargo;
	}

	public void setCargo(List<CargoBean> cargo) {
		this.cargo = cargo;
	}

	public List<SenioridadeBean> getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(List<SenioridadeBean> senioridade) {
		this.senioridade = senioridade;
	}
	
	

}
