package br.com.prosperity.bean;

import java.util.Date;

public class VagaBean {
	private Integer id;
	private String nomeSolicitante;
	private Double valorPretensao;
	private Date dataInicio;
	private String localTrabalho;
	private String idTipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private String aumentaQuadro;
	private ProjetoBean projetoBean;
	private CargoBean cargoBean;
	private SenioridadeBean senioridadeBean;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
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
