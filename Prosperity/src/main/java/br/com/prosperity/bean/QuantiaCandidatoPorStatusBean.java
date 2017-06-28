package br.com.prosperity.bean;

public class QuantiaCandidatoPorStatusBean {
	private Integer candidaturas = 0;
	private Integer aprovados = 0;
	private Integer reprovados = 0;
	private Integer cancelados = 0;
	private Integer contratados = 0;
	private Integer emAnalise = 0;
	
	public Integer getCandidaturas() {
		return candidaturas;
	}
	public void setCandidaturas() {
		this.candidaturas++;
	}
	public Integer getAprovados() {
		return aprovados;
	}
	public void setAprovados() {
		this.aprovados++;
	}
	public Integer getReprovados() {
		return reprovados;
	}
	public void setReprovados() {
		this.reprovados++;
	}
	public Integer getCancelados() {
		return cancelados;
	}
	public void setCancelados() {
		this.cancelados++;
	}
	public Integer getContratados() {
		return contratados;
	}
	public void setContratados() {
		this.contratados++;
	}
	public Integer getEmAnalise() {
		return emAnalise;
	}
	public void setEmAnalise() {
		this.emAnalise++;
	}

}
