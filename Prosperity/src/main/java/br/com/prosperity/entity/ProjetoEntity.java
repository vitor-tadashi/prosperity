package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tbProjeto")

public class ProjetoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idProjeto", unique = true, nullable = false)
	private int id;
	
	@Column(name="nmProjeto")
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private FuncionarioEntity funcionario;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private String cliente;
	
	
	public int getIdProjeto() {
		return id;
	}
	public void setIdProjeto(int idProjeto) {
		this.id = idProjeto;
	}
	public String getNmProjeto() {
		return nome;
	}
	public void setNmProjeto(String nmProjeto) {
		this.nome = nmProjeto;
	}
	public String getClienteProjeto() {
		return cliente;
	}
	public void setClienteProjeto(String clienteProjeto) {
		this.cliente = clienteProjeto;
	}
	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}

}
