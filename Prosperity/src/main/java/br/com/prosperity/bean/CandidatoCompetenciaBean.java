package br.com.prosperity.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "CandidatoCompetenciaBean")
public class CandidatoCompetenciaBean {

	private Integer id;
	private CompetenciaBean competencia;
	private AvaliacaoBean avaliacao;
	private String nmAvaliador;
	private Integer idCandidato;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompetenciaBean getCompetencia() {
		return competencia;
	}

	public void setCompetencia(CompetenciaBean competencia) {
		this.competencia = competencia;
	}

	public AvaliacaoBean getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoBean avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getNmAvaliador() {
		return nmAvaliador;
	}

	public void setNmAvaliador(String nmAvaliador) {
		this.nmAvaliador = nmAvaliador;
	}

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}
}