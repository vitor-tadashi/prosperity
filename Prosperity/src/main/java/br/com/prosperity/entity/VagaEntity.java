package br.com.prosperity.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name= "tbVaga")	
@NamedQuery (name = "obterAprovacao", query = "SELECT u FROM UsuarioEntity u WHERE u.nome = ?1")
public class VagaEntity {
	/* Mapeamento dos Atributos */
	
	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idVaga", unique = true, nullable = false)
	private int id;
	/* fim Id */
	
	@Column(name = "nmSolicitante")
	private String nomeSolicitante;
	
	@Column(name = "vlPretensao")
	private double valorPretensao;
	
	@Column(name = "dtInicio")
	private Calendar dataInicio;
	
	@Column(name = "flLocalTrabalho")
	private char localTrabalho;
	
	@Column(name = "idTpVaga")
	private char tipoVaga;
	
	@Column(name = "hrEntrada")
	private Calendar horaEntrada;
	
	@Column(name = "hrSaida")
	private Calendar horaSaida;
		
	@Column(name = "flAumentoQuadro")
	private String aumentoQuadro;
	
	/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private ProjetoEntity projetoEntity;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private CargoEntity cargoEntity;
	
	@ManyToOne (cascade = CascadeType.ALL)	
	private SenioridadeEntity senioridadeEntity;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private UsuarioEntity usuarioEntity;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private AvaliadorEntity avaliadorEntity;
	
	// relacionamento avaliadores
			/* fim dos mapeamentos */
	public VagaEntity() {

	}
     
	public VagaEntity(int id, String nomeSolicitante, double valorPretensao, Calendar dataInicio, char localTrabalho,
			char tipoVaga, Calendar horaEntrada, Calendar horaSaida, String aumentoQuadro, ProjetoEntity projetoEntity,
			CargoEntity cargoEntity, SenioridadeEntity senioridadeEntity, UsuarioEntity usuarioEntity,
			AvaliadorEntity avaliadorEntity) {
		super();
		this.id = id;
		this.nomeSolicitante = nomeSolicitante;
		this.valorPretensao = valorPretensao;
		this.dataInicio = dataInicio;
		this.localTrabalho = localTrabalho;
		this.tipoVaga = tipoVaga;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.aumentoQuadro = aumentoQuadro;
		this.projetoEntity = projetoEntity;
		this.cargoEntity = cargoEntity;
		this.senioridadeEntity = senioridadeEntity;
		this.usuarioEntity = usuarioEntity;
		this.avaliadorEntity = avaliadorEntity;
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

	public double getValorPretensao() {
		return valorPretensao;
	}

	public void setValorPretensao(double valorPretensao) {
		this.valorPretensao = valorPretensao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
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

	public Calendar getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Calendar horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Calendar getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Calendar horaSaida) {
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
