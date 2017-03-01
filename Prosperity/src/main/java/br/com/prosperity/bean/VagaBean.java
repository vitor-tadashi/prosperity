package br.com.prosperity.bean;

import java.util.Calendar;

public class VagaBean {
	private int id;
	private String nomeSolicitante;
	private Double valorSalarial;
	private Calendar dataInicio;
	private String localTrabalho;
	private String tipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private String aumentaQuadro;
	private ProjetoBean projetoBean;
	private CargoBean cargoBean;
	private SenioridadeBean senioridadeBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public Double getValorSalarial() {
		return valorSalarial;
	}

	public void setValorSalarial(Double valorSalarial) {
		this.valorSalarial = valorSalarial;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
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

	public ProjetoBean getProjetoBean() {
		return projetoBean;
	}

	public void setProjetoBean(ProjetoBean projetoBean) {
		this.projetoBean = projetoBean;
	}

	public CargoBean getCargoBean() {
		return cargoBean;
	}

	public void setCargoBean(CargoBean cargoBean) {
		this.cargoBean = cargoBean;
	}

	public SenioridadeBean getSenioridadeBean() {
		return senioridadeBean;
	}

	public void setSenioridadeBean(SenioridadeBean senioridadeBean) {
		this.senioridadeBean = senioridadeBean;
	}
}
