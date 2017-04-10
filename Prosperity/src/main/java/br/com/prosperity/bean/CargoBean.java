package br.com.prosperity.bean;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
public class CargoBean {

	@Min(value = 1, message = "O campo Cargo deve ser preenchido")
	private Integer id;

	private String nome;

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

}
