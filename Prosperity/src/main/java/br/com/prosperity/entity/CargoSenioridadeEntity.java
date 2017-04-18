package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CargoSenioridade
 *
 */

@Entity
@Table(name="tbCargoSenioridade")

public class CargoSenioridadeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCargoSenioridade", unique = true)
	private Integer id;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCargo")
	private List<CargoEntity> idCargo;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "idSenioridade")
	private List<SenioridadeEntity> idSenioridade;
	
	@Column(name="vlMinSalario")
	private Double vlMinSalario;
	
	@Column(name="vlMaxSalario")
	private Double vlMaxSalario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<CargoEntity> getCargo() {
		return idCargo;
	}
	public void setCargo(List<CargoEntity> idCargo) {
		this.idCargo = idCargo;
	}
	public List<SenioridadeEntity> getIdSenioridade() {
		return idSenioridade;
	}
	public void setIdSenioridade(List<SenioridadeEntity> idSenioridade) {
		this.idSenioridade = idSenioridade;
	}
	public Double getVlMinSalario() {
		return vlMinSalario;
	}
	public void setVlMinSalario(Double vlMinSalario) {
		this.vlMinSalario = vlMinSalario;
	}
	public Double getVlMaxSalario() {
		return vlMaxSalario;
	}
	public void setVlMaxSalario(Double vlMaxSalario) {
		this.vlMaxSalario = vlMaxSalario;
	}
	
}
