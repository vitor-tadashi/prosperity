package br.com.prosperity.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class EnderecoBean {
	private Integer id;
	@NotNull
	@NotEmpty(message="O campo CEP deve ser prenchido")
	private String cep;
	@NotNull
	@NotEmpty(message="O campo número deve ser prenchido")
	private Integer numero;
	
	private String complemento;
	@NotNull
	@NotEmpty(message="O campo cidade deve ser prenchido")
	private String cidade;
	@NotNull
	@NotEmpty(message="O campo estado deve ser prenchido")
	private String estado;
	@NotNull
	@NotEmpty(message="O campo rua deve ser prenchido")
	private String logradouro;
	
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
