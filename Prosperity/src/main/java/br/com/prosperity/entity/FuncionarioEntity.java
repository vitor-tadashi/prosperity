package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tbFuncionario")


public class FuncionarioEntity {
	
	public Integer getId() {
		return id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idFuncionario", unique = true, nullable = false)
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="nmFuncionario")
	private String nome;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="idCargo")
	private CargoEntity cargo;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="idSenioridade")
	private SenioridadeEntity senioridade;
	
	public int getIdFuncionario() {
		return id;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.id = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CargoEntity getCargo() {
		return cargo;
	}
	public void setCargo(CargoEntity cargo) {
		this.cargo = cargo;
	}
	public SenioridadeEntity getSenioridade() {
		return senioridade;
	}
	public void setSenioridade(SenioridadeEntity senioridade) {
		this.senioridade = senioridade;
	}
}
