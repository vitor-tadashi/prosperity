package br.com.prosperity.entity;

import javax.persistence.*;

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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCargo")
	private CargoEntity cargo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
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
		return cargo;
	}
	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
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
