package br.com.prosperity.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CargoSenioridadeBean {

	private Integer id;
	private Double valorMinSalario;
	private Double valorMaxSalario;
	private List<CargoBean> cargos;
	private List<SenioridadeBean> senioridades;

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
