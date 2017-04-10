package br.com.prosperity.bean;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
public class ProjetoBean {

	@Min(value = 1, message = "O campo Nome do projeto deve ser preenchido")
	private Integer id;

	private String nome;
	private FuncionarioBean funcionario;
	private ClienteBean cliente;
	private Boolean ativo;

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

	public FuncionarioBean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
