package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class CandidatoCompetenciaBean {
	
	private Integer id;
	private Integer idCandidato;
	private Integer idAvaliacao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}
	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	

}
