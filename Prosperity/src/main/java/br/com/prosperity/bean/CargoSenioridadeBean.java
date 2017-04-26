package br.com.prosperity.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CargoSenioridadeBean {

	private Integer id;
	private Double valorMinSalario;
	private Double valorMaxSalario;
	private CargoBean cargos;
	private SenioridadeBean senioridades;

	public CargoSenioridadeBean() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorMinSalario() {
		return valorMinSalario;
	}

	public void setValorMinSalario(Double valorMinSalario) {
		this.valorMinSalario = valorMinSalario;
	}

	public Double getValorMaxSalario() {
		return valorMaxSalario;
	}

	public void setValorMaxSalario(Double valorMaxSalario) {
		this.valorMaxSalario = valorMaxSalario;
	}

	public CargoBean getCargos() {
		return cargos;
	}

	public void setCargos(CargoBean cargos) {
		this.cargos = cargos;
	}

	public SenioridadeBean getSenioridades() {
		return senioridades;
	}

	public void setSenioridades(SenioridadeBean senioridades) {
		this.senioridades = senioridades;
	}

}
