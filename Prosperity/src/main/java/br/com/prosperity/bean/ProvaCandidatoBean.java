package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class ProvaCandidatoBean {

	private Integer id;
	private CandidatoBean candidato;
	private ProvaBean provas;
	private String descricao;
	private String caminhoProva;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CandidatoBean getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}

	public ProvaBean getProvas() {
		return provas;
	}

	public void setProvas(ProvaBean provas) {
		this.provas = provas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminhoProva() {
		return caminhoProva;
	}

	public void setCaminhoProva(String caminhoProva) {
		this.caminhoProva = caminhoProva;
	}
}