package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

import br.com.prosperity.enumarator.StatusCandidatoEnum;

@Component
public class SituacaoCandidatoBean {

	private Integer idCandidato;
	private StatusCandidatoEnum status;
	private String parecer;
	private String dsCancelamento;
	private Integer idCancelamento;
	private String nomeVaga;

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public StatusCandidatoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusCandidatoEnum status) {
		this.status = status;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public void setIdStatus(Integer idStatus) {
		status = StatusCandidatoEnum.valueOf(idStatus);
	}

	public String getDsCancelamento() {
		return dsCancelamento;
	}

	public void setDsCancelamento(String dsCancelamento) {
		this.dsCancelamento = dsCancelamento;
	}

	public Integer getIdCancelamento() {
		return idCancelamento;
	}

	public void setIdCancelamento(Integer idCancelamento) {
		this.idCancelamento = idCancelamento;
	}

	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}
}