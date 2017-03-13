package br.com.prosperity.entity;

import java.util.Date;
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
@NamedQuery (name = "obterAprovacao", query = "SELECT u FROM VagaEntity u WHERE u.nomeVaga = ?1")
public class VagaEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idVaga", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "nmVaga")
	private String nomeVaga;
	
	@Column(name = "nmSolicitante")
	private String nomeSolicitante;

	@Column(name = "vlPretensao")
	private Double valorPretensao;

	@Column(name = "dtInicio")
	private Date dataInicio;

	@Column(name = "flLocalTrabalho")
	private String localTrabalho;

	@Column(name = "idTpVaga")
	private String tipoVaga;

	@Column(name = "hrEntrada")
	private Date horaEntrada;

	@Column(name = "hrSaida")
	private Date horaSaida;

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
	private Date dataAbertura; //
	
	@Column(name = "dtAprovacao")
	private Date dataAprovacao; //
	
	@Column(name = "dtFechamento")
	private Date dataFechamento; //

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private ProjetoEntity projetoEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private CargoEntity cargoEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private SenioridadeEntity senioridadeEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private UsuarioEntity usuarioEntity;

	//@ManyToOne(cascade = CascadeType.ALL)
	//private AvaliadorEntity avaliadorEntity;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
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

	public String getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(String tipoVaga) {
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

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
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

	//public AvaliadorEntity getAvaliadorEntity() {
		//return avaliadorEntity;
	//}

	//public void setAvaliadorEntity(AvaliadorEntity avaliadorEntity) {
		//this.avaliadorEntity = avaliadorEntity;
	//}

	
	

}
