package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class AvaliadorCandidatoBean {

	private Integer id;
	private Integer idAvaliador;
	private Integer idCandidato;
	private Integer idStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(Integer idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
}
