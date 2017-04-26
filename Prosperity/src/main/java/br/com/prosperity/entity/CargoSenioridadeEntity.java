package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CargoSenioridade
 *
 */

@Entity
@Table(name="tbCargoSenioridade")
@NamedQueries({ 
	@NamedQuery(name = "rangeSalarial", query = "SELECT u FROM CargoSenioridadeEntity u WHERE u.idCargo = ?1 AND u.idSenioridade = ?2")
})
public class CargoSenioridadeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCargoSenioridade", unique = true)
	private Integer id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCargo")
	private CargoEntity idCargo;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idSenioridade")
	private SenioridadeEntity idSenioridade;
	
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

	public CargoEntity getCargo() {
		return idCargo;
	}
	public void setCargo(CargoEntity idCargo) {
		this.idCargo = idCargo;
	}
	public SenioridadeEntity getIdSenioridade() {
		return idSenioridade;
	}
	public void setIdSenioridade(SenioridadeEntity idSenioridade) {
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
