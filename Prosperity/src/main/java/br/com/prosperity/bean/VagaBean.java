package br.com.prosperity.bean;

import java.util.Calendar;

public class VagaBean {
	private int id;
	private String nomeSolicitante;
	private Double valorPretensao;
	private Calendar dataInicio;
	private String localTrabalho;
	private String idTipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private String aumentaQuadro;
	private ProjetoBean projetoBean;
	private CargoBean cargoBean;
	private SenioridadeBean senioridadeBean;

	public VagaBean() {

	}

	public VagaBean(int id, String nomeSolicitante, Double valorPretensao, Calendar dataInicio, String localTrabalho,
			String idTipoVaga, String horarioEntrada, String horarioSaida, String aumentaQuadro,
			ProjetoBean projetoBean, CargoBean cargoBean, SenioridadeBean senioridadeBean) {
		this.id = id;
		this.nomeSolicitante = nomeSolicitante;
		this.valorPretensao = valorPretensao;
		this.dataInicio = dataInicio;
		this.localTrabalho = localTrabalho;
		this.idTipoVaga = idTipoVaga;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.aumentaQuadro = aumentaQuadro;
		this.projetoBean = projetoBean;
		this.cargoBean = cargoBean;
		this.senioridadeBean = senioridadeBean;
	}

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

	public Double getValorPretensao() {
		return valorPretensao;
	}

	public void setValorPretensao(Double valorPretensao) {
		this.valorPretensao = valorPretensao;
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

	public String getIdTipoVaga() {
		return idTipoVaga;
	}

	public void setIdTipoVaga(String tipoVaga) {
		this.idTipoVaga = tipoVaga;
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
