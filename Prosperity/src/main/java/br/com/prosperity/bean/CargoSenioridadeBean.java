package br.com.prosperity.bean;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component
public class CargoSenioridadeBean {

	private Integer id;
	
	private String dsPreTexto;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorMinSalario;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorMaxSalario;
	
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

	public BigDecimal getValorMinSalario() {
		return valorMinSalario;
	}

	public void setValorMinSalario(BigDecimal valorMinSalario) {
		this.valorMinSalario = valorMinSalario;
	}

	public BigDecimal getValorMaxSalario() {
		return valorMaxSalario;
	}

	public String getDsPreTexto() {
		return dsPreTexto;
	}

	public void setDsPreTexto(String dsPreTexto) {
		this.dsPreTexto = dsPreTexto;
	}

	public void setValorMaxSalario(BigDecimal valorMaxSalario) {
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
