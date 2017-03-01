package br.com.prosperity.entity;

import java.util.Calendar;

public class VagaEntity {
	private int id;
	private String solicitante;
	private Double prtSalarial;
	private Calendar dtInicio;
	private String localTrabalho;
	private String tipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private String aumentaQuadro;
	private ProjetoEntity projetoBean;
	private CargoEntity cargoBean;
	private SenioridadeEntity senioridadeBean;

	public ProjetoEntity getProjetoBean() {
		return projetoBean;
	}

	public void setProjetoBean(ProjetoEntity projetoBean) {
		this.projetoBean = projetoBean;
	}

	public CargoEntity getCargoBean() {
		return cargoBean;
	}

	public void setCargoBean(CargoEntity cargoBean) {
		this.cargoBean = cargoBean;
	}

	public SenioridadeEntity getSenioridadeBean() {
		return senioridadeBean;
	}

	public void setSenioridadeBean(SenioridadeEntity senioridadeBean) {
		this.senioridadeBean = senioridadeBean;
	}

	public UsuarioEntity getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioEntity usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	private UsuarioEntity usuarioBean;

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
