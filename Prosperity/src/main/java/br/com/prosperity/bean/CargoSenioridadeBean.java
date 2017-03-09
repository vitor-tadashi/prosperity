package br.com.prosperity.bean;

import java.util.List;

public class CargoSenioridadeBean {

	private int id;
	private double valorMinSalario;
	private double valorMaxSalario;
	private List<CargoBean> cargos;
	private List<SenioridadeBean> senioridades;

	public CargoSenioridadeBean(int id, double valorMinSalario, double valorMaxSalario, List<CargoBean> cargos,
			List<SenioridadeBean> senioridades) {
		this.id = id;
		this.valorMinSalario = valorMinSalario;
		this.valorMaxSalario = valorMaxSalario;
		this.cargos = cargos;
		this.senioridades = senioridades;
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

	public List<CargoBean> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoBean> cargos) {
		this.cargos = cargos;
	}

	public List<SenioridadeBean> getSenioridades() {
		return senioridades;
	}

	public void setSenioridades(List<SenioridadeBean> senioridades) {
		this.senioridades = senioridades;
	}
	
	

}
