package br.com.prosperity.entity;

import java.util.Calendar;

public class VagaEntity {
	private int id;
	private String nmSolicitante;
	private Double vlPretensao;
	private Calendar dtInicio;
	private String flLocalTrabalho;
	private String idTpVaga;
	private String hrEntrada;
	private String hrSaida;
	private String flAumentaQuadro;
	private ProjetoEntity projetoEntity;
	private CargoEntity cargoEntity;
	private SenioridadeEntity senioridadeEntity;

	public VagaEntity() {

	}

	public VagaEntity(int id, String nmSolicitante, Double vlPretensao, Calendar dtInicio, String flLocalTrabalho,
			String idTpVaga, String hrEntrada, String hrSaida, String flAumentaQuadro, ProjetoEntity projetoEntity,
			CargoEntity cargoEntity, SenioridadeEntity senioridadeEntity) {
		this.id = id;
		this.nmSolicitante = nmSolicitante;
		this.vlPretensao = vlPretensao;
		this.dtInicio = dtInicio;
		this.flLocalTrabalho = flLocalTrabalho;
		this.idTpVaga = idTpVaga;
		this.hrEntrada = hrEntrada;
		this.hrSaida = hrSaida;
		this.flAumentaQuadro = flAumentaQuadro;
		this.projetoEntity = projetoEntity;
		this.cargoEntity = cargoEntity;
		this.senioridadeEntity = senioridadeEntity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNmSolicitante() {
		return nmSolicitante;
	}

	public void setNmSolicitante(String nmSolicitante) {
		this.nmSolicitante = nmSolicitante;
	}

	public Double getVlPretensao() {
		return vlPretensao;
	}

	public void setVlPretensao(Double vlPretensao) {
		this.vlPretensao = vlPretensao;
	}

	public Calendar getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Calendar dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getFlLocalTrabalho() {
		return flLocalTrabalho;
	}

	public void setFlLocalTrabalho(String flLocalTrabalho) {
		this.flLocalTrabalho = flLocalTrabalho;
	}

	public String getIdTpVaga() {
		return idTpVaga;
	}

	public void setIdTpVaga(String idTpVaga) {
		this.idTpVaga = idTpVaga;
	}

	public String getHrEntrada() {
		return hrEntrada;
	}

	public void setHrEntrada(String hrEntrada) {
		this.hrEntrada = hrEntrada;
	}

	public String getHrSaida() {
		return hrSaida;
	}

	public void setHrSaida(String hrSaida) {
		this.hrSaida = hrSaida;
	}

	public String getFlAumentaQuadro() {
		return flAumentaQuadro;
	}

	public void setFlAumentaQuadro(String flAumentaQuadro) {
		this.flAumentaQuadro = flAumentaQuadro;
	}

	public ProjetoEntity getProjetoEntity() {
		return projetoEntity;
	}

	public void setProjetoEntity(ProjetoEntity projetoEntity) {
		this.projetoEntity = projetoEntity;
	}

	public CargoEntity getCargoEntity() {
		return cargoEntity;
	}

	public void setCargoEntity(CargoEntity cargoEntity) {
		this.cargoEntity = cargoEntity;
	}

	public SenioridadeEntity getSenioridadeEntity() {
		return senioridadeEntity;
	}

	public void setSenioridadeEntity(SenioridadeEntity senioridadeEntity) {
		this.senioridadeEntity = senioridadeEntity;
	}

}
