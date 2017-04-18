package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name="tbProjeto")
@NamedQueries({
	@NamedQuery(name = "obterProjetosAtivos", query = "SELECT u FROM ProjetoEntity u WHERE u.ativo = true"),
	@NamedQuery(name = "obterCliente", query = "SELECT u FROM ProjetoEntity u WHERE u.ativo = true AND u.id=?1")
})
public class ProjetoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProjeto", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="nmProjeto")
	private String nome;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idFuncionario")
	private FuncionarioEntity funcionario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	
	@Column(name = "ativo")
	private Boolean ativo;
		
	
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
	
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
