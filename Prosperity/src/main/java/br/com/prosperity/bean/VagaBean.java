package br.com.prosperity.bean;

import java.util.Calendar;

public class VagaBean {
	private int id;
	private String solicitante;
	private Double prtSalarial;
	private Calendar dtInicio;
	private String localTrabalho;
	private String tipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private String aumentaQuadro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public Double getPrtSalarial() {
		return prtSalarial;
	}
	public void setPrtSalarial(Double prtSalarial) {
		this.prtSalarial = prtSalarial;
	}
	public Calendar getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Calendar dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getLocalTrabalho() {
		return localTrabalho;
	}
	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}
	public String getTipoVaga() {
		return tipoVaga;
	}
	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}
	public String getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public String getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	public String getAumentaQuadro() {
		return aumentaQuadro;
	}
	public void setAumentaQuadro(String aumentaQuadro) {
		this.aumentaQuadro = aumentaQuadro;
	}
}
