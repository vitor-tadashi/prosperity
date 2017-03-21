package br.com.prosperity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbFuncionario")
@NamedQuery(name="listarApenasNaoCadastrados", query="SELECT f FROM FuncionarioEntity f where f.id not in (SELECT u.funcionarioEntity.id from UsuarioEntity u)")
public class FuncionarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFuncionario", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="nmFuncionario")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="idCargo")
	private CargoEntity cargo;
	
	@ManyToOne
	@JoinColumn(name="idSenioridade")
	private SenioridadeEntity senioridade;

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
