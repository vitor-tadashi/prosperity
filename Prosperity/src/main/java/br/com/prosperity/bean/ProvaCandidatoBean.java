package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class ProvaCandidatoBean {

	private Integer id;
	private String nome1;
	private String descricao1;
	private String nome2;
	private String descricao2;
	private String nome3;
	private String descricao3;
	private String parecerTecnico;
	private CandidatoBean candidato;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome1() {
		return nome1;
	}

	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}

	public String getDescricao1() {
		return descricao1;
	}

	public void setDescricao1(String descricao1) {
		this.descricao1 = descricao1;
	}

	public String getNome2() {
		return nome2;
	}

	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}

	public String getDescricao2() {
		return descricao2;
	}

	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}

	public String getNome3() {
		return nome3;
	}

	public void setNome3(String nome3) {
		this.nome3 = nome3;
	}

	public String getDescricao3() {
		return descricao3;
	}

	public void setDescricao3(String descricao3) {
		this.descricao3 = descricao3;
	}

	public String getParecerTecnico() {
		return parecerTecnico;
	}

	public void setParecerTecnico(String parecerTecnico) {
		this.parecerTecnico = parecerTecnico;
	}

	public CandidatoBean getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}

}
