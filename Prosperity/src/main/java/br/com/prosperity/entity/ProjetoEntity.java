package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tbProjeto")

public class ProjetoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idProjeto", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="nmProjeto")
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idFuncionario")
	private FuncionarioEntity funcionario;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
		
	public Integer getIdProjeto() {
		return id;
	}
	public void setIdProjeto(Integer idProjeto) {
		this.id = idProjeto;
	}
	public String getNmProjeto() {
		return nome;
	}
	public void setNmProjeto(String nmProjeto) {
		this.nome = nmProjeto;
	}
	public ClienteEntity getClienteProjeto() {
		return cliente;
	}
	public void setClienteProjeto(ClienteEntity clienteProjeto) {
		this.cliente = clienteProjeto;
	}
	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}

}
