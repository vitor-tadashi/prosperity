package br.com.prosperity.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProvaCandidatoBean {

	private Integer id;
	private String parecerTecnico;
	private CandidatoBean candidato;
	private List<ProvaBean> provas;
	private List<DescricaoProvaBean> descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<ProvaBean> getProvas() {
		return provas;
	}

	public void setProvas(List<ProvaBean> provas) {
		this.provas = provas;
	}

	public List<DescricaoProvaBean> getDescricao() {
		return descricao;
	}

	public void setDescricao(List<DescricaoProvaBean> descricao) {
		this.descricao = descricao;
	}

}
