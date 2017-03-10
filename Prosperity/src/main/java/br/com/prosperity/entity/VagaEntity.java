package br.com.prosperity.entity;

import java.util.Calendar;

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
@Table(name= "tbVaga")	
public class VagaEntity {
	/* Mapeamento dos Atributos */
	
	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idVaga", unique = true, nullable = false)
	private Integer id;
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
	private String tipoVaga;
	
	@Column(name = "hrEntrada")
	private Calendar horaEntrada;
	
	@Column(name = "hrSaida")
	private Calendar horaSaida;
		
	@Column(name = "flAumentoQuadro")
	private String aumentoQuadro;

	@Column(name = "numCandidatos")
	private int numeroCandidatos; //
	
	@Column(name = "nmSubstituido")
	private String nomeSubstituido; // 
	
	@Column(name = "dsFormacaoAcademica")
	private String descricaoFormacaoAcademica; //
	
	@Column(name = "dsPerfilComportamental")
	private String descricaoPerfilComportamental; //
	
	@Column(name = "dsPerfilTecnico")
	private String descricaoPerfilTecnico; //
	
	@Column(name = "dtAbertura")
	private Calendar dataAbertura; //
	
	@Column(name = "dtAprovacao")
	private Calendar dataAprovacao; //
	
	@Column(name = "dtFechamento")
	private Calendar dataFechamento; //
	
	
	
	
	
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
	
	// relacionamento avaliadores
			/* fim dos mapeamentos */
	public VagaEntity() {

	}
     
	
	public VagaEntity(Integer id, String nomeSolicitante, double valorPretensao, Calendar dataInicio,
			char localTrabalho, String tipoVaga, Calendar horaEntrada, Calendar horaSaida, String aumentoQuadro,
			int numeroCandidatos, String nomeSubstituido, String descricaoFormacaoAcademica,
			String descricaoPerfilComportamental, String descricaoPerfilTecnico, Calendar dataAbertura,
			Calendar dataAprovacao, Calendar dataFechamento, ProjetoEntity projetoEntity, CargoEntity cargoEntity,
			SenioridadeEntity senioridadeEntity, UsuarioEntity usuarioEntity, AvaliadorEntity avaliadorEntity) {
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
		this.numeroCandidatos = numeroCandidatos;
		this.nomeSubstituido = nomeSubstituido;
		this.descricaoFormacaoAcademica = descricaoFormacaoAcademica;
		this.descricaoPerfilComportamental = descricaoPerfilComportamental;
		this.descricaoPerfilTecnico = descricaoPerfilTecnico;
		this.dataAbertura = dataAbertura;
		this.dataAprovacao = dataAprovacao;
		this.dataFechamento = dataFechamento;
		this.projetoEntity = projetoEntity;
		this.cargoEntity = cargoEntity;
		this.senioridadeEntity = senioridadeEntity;
		this.usuarioEntity = usuarioEntity;
	}

	
	
	
	public int getNumeroCandidatos() {
		return numeroCandidatos;
	}



	public void setNumeroCandidatos(int numeroCandidatos) {
		this.numeroCandidatos = numeroCandidatos;
	}



	public String getNomeSubstituido() {
		return nomeSubstituido;
	}



	public void setNomeSubstituido(String nomeSubstituido) {
		this.nomeSubstituido = nomeSubstituido;
	}



	public String getDescricaoFormacaoAcademica() {
		return descricaoFormacaoAcademica;
	}



	public void setDescricaoFormacaoAcademica(String descricaoFormacaoAcademica) {
		this.descricaoFormacaoAcademica = descricaoFormacaoAcademica;
	}



	public String getDescricaoPerfilComportamental() {
		return descricaoPerfilComportamental;
	}



	public void setDescricaoPerfilComportamental(String descricaoPerfilComportamental) {
		this.descricaoPerfilComportamental = descricaoPerfilComportamental;
	}



	public String getDescricaoPerfilTecnico() {
		return descricaoPerfilTecnico;
	}



	public void setDescricaoPerfilTecnico(String descricaoPerfilTecnico) {
		this.descricaoPerfilTecnico = descricaoPerfilTecnico;
	}



	public Calendar getDataAbertura() {
		return dataAbertura;
	}



	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



	public Calendar getDataAprovacao() {
		return dataAprovacao;
	}



	public void setDataAprovacao(Calendar dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}



	public Calendar getDataFechamento() {
		return dataFechamento;
	}



	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getId() {
		return this.id;
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

	public String getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(String tipoVaga) {
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
}
