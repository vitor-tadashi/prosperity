package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tbFuncionario")


public class FuncionarioEntity {
	
	public int getId() {
		return id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idFuncionario", unique = true, nullable = false)
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="nmFuncionario")
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private CargoEntity cargo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private SenioridadeEntity senioridade;
	
	@OneToMany
	@JoinTable(name = "funcionarioProjeto", joinColumns = {
			@JoinColumn(name = "idProjeto", referencedColumnName = "idProjeto") }, inverseJoinColumns = {
					@JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario") })
	private List<ProjetoEntity> projeto;
	
	//GETTERS AND SETTERS
	public List<ProjetoEntity> getProjeto() {
		return projeto;
	}
	public void setProjeto(List<ProjetoEntity> projeto) {
		this.projeto = projeto;
	}
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
