package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tbVaga")
public class VagaEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idVaga", unique = true, nullable = false)
	private Integer id;
	/* fim Id */

	@Column(name = "nmSolicitante")
	private String nomeSolicitante;

	@Column(name = "vlPretensao")
	private Double valorPretensao;

	@Column(name = "dtInicio")
	private Date dataInicio;

	@Column(name = "flLocalTrabalho")
	private char localTrabalho;

	@Column(name = "idTpVaga")
	private char tipoVaga;

	@Column(name = "hrEntrada")
	private Date horaEntrada;

	@Column(name = "hrSaida")
	private Date horaSaida;

	@Column(name = "flAumentoQuadro")
	private String aumentoQuadro;

	/*
	 * Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga
	 * 1-N
	 */

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private ProjetoEntity projetoEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private CargoEntity cargoEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private SenioridadeEntity senioridadeEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private UsuarioEntity usuarioEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private AvaliadorEntity avaliadorEntity;

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

	public char getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(char localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public char getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(char tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getAumentoQuadro() {
		return aumentoQuadro;
	}

	public void setAumentoQuadro(String aumentoQuadro) {
		this.aumentoQuadro = aumentoQuadro;
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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public AvaliadorEntity getAvaliadorEntity() {
		return avaliadorEntity;
	}

	public void setAvaliadorEntity(AvaliadorEntity avaliadorEntity) {
		this.avaliadorEntity = avaliadorEntity;
	}

}
