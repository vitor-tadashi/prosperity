package br.com.prosperity.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "CandidatoCompetenciaBean")
public class CandidatoCompetenciaBean {

	private Integer id;
	private List<CompetenciaBean> competencia;
	private List<AvaliacaoBean> avaliacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CompetenciaBean> getCompetencia() {
		return competencia;
	}

	public void setCompetencia(List<CompetenciaBean> competencia) {
		this.competencia = competencia;
	}

	public List<AvaliacaoBean> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<AvaliacaoBean> avaliacao) {
		this.avaliacao = avaliacao;
	}

}
