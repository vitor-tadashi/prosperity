package br.com.prosperity.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({

		@NamedQuery(name = "obterTodos", query = "SELECT u FROM VagaEntity u WHERE u.nomeVaga = ?1"),
		@NamedQuery(name = "listarVagaAprovar", query = "SELECT u FROM VagaEntity u LEFT OUTER JOIN u.statusVagaEntity p LEFT OUTER JOIN p.status s WHERE (s.id = ?1 OR s.id=?2) AND p.situacao = ?3"),

		@NamedQuery(name = "obterPorId", query = "SELECT u FROM VagaEntity u WHERE u.id = ?1"),

		// @NamedQuery(name="listarVagaFiltrado", query="SELECT u FROM
		// VagaEntity u LEFT JOIN u.statusVagaEntity p LEFT JOIN p.status e
		// WHERE u.dataAbertura BETWEEN ?1 AND ?2 AND u.nomeVaga like ?3 AND
		// p.status = ?4" )
		
		@NamedQuery(name = "listarVagasAtivas", query = "SELECT v FROM VagaEntity v LEFT JOIN v.statusVagaEntity sv where sv.status.id = ?1"),
		@NamedQuery(name = "listarVagaFiltrado", query = "SELECT u FROM VagaEntity u LEFT OUTER JOIN u.statusVagaEntity p left join p.status s "
				+ "WHERE u.nomeVaga like ?1 and s.id = ?2 and u.dataAbertura between ?3 and ?4"),
		@NamedQuery(name = "ultimoCadastro", query = "SELECT MAX(u.id) FROM VagaEntity u") })

@Entity
@Table(name = "tbVaga")
public class VagaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVaga", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmVaga")
	private String nomeVaga;

	@Column(name = "nmSolicitante")
	private String nomeSolicitante;

	@Column(name = "vlPretensao")
	private Double valorPretensao;

	@Column(name = "dtInicio")
	@Temporal(value = TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "flLocalTrabalho")
	private Character localTrabalho;

	@Column(name = "idTpVaga")
	private Character tipoVaga;

	@Column(name = "hrEntrada")
	private String horaEntrada;

	@Column(name = "hrSaida")
	private String horaSaida;

	@Column(name = "flAumentoQuadra")
	private Character aumentoQuadro;

	@Column(name = "numCandidatos")
	private Integer numeroCandidatos; //

	@Column(name = "nmSubstituido")
	private String nomeSubstituido; //

	@Column(name = "dsFormacaoAcademica")
	private String descricaoFormacaoAcademica; //

	@Column(name = "dsPerfilComportamental")
	private String descricaoPerfilComportamental; //

	@Column(name = "dsPerfilTecnico")
	private String descricaoPerfilTecnico; //

	@Column(name = "dtAbertura")
	@Temporal(value = TemporalType.DATE)
	private Date dataAbertura; //

	@Column(name = "dtAprovacao")
	@Temporal(value = TemporalType.DATE)
	private Date dataAprovacao; //

	@Column(name = "dtFechamento")
	@Temporal(value = TemporalType.DATE)
	private Date dataFechamento; //

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idProjeto")
	private ProjetoEntity projetoEntity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCargo")
	private CargoEntity cargoEntity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idSenioridade")
	private SenioridadeEntity senioridadeEntity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuarioEntity;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private List<StatusVagaEntity> statusVagaEntity;

	// @ManyToOne(cascade = CascadeType.ALL)
	// private AvaliadorEntity avaliadorEntity;

	@Column(name = "nmResponsavel")
	private String nmResponsavel;

	@Column(name = "nmAreaResponsavel")
	private String nmAreaResponsavel;

	@Column(name = "emailResponsavel")
	private String emailResponsavel;

	@Column(name = "telResponsavel")
	private String telResponsavel;

	public Integer getId() {
		return id;
	}
	/*
	 * =======
	 * 
	 * @OneToMany()
	 * 
	 * @JoinColumn(name = "idVaga") private List<StatusVagaEntity> statusEntity;
	 * 
	 * public Integer getId() { return id; }
	 * 
	 * public List<StatusVagaEntity> getStatusEntity() { return statusEntity; }
	 * 
	 * public void setStatusEntity(List<StatusVagaEntity> statusEntity) {
	 * this.statusEntity = statusEntity; >>>>>>>
	 * 6177abe9dacbea6ac3a7b401caace31a61a978f4 }
	 */

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

	public Character getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(Character localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public Character getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(Character tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Character getAumentoQuadro() {
		return aumentoQuadro;
	}

	public void setAumentoQuadro(Character aumentoQuadro) {
		this.aumentoQuadro = aumentoQuadro;
	}

	public Integer getNumeroCandidatos() {
		return numeroCandidatos;
	}

	public void setNumeroCandidatos(Integer numeroCandidatos) {
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

	public List<StatusVagaEntity> getStatusVagaEntity() {
		return statusVagaEntity;
	}

	public void setStatusVagaEntity(List<StatusVagaEntity> statusVagaEntity) {
		this.statusVagaEntity = statusVagaEntity;
	}

	public String getNmResponsavel() {
		return nmResponsavel;
	}

	public void setNmResponsavel(String nmResponsavel) {
		this.nmResponsavel = nmResponsavel;
	}

	public String getNmAreaResponsavel() {
		return nmAreaResponsavel;
	}

	public void setNmAreaResponsavel(String nmAreaResponsavel) {
		this.nmAreaResponsavel = nmAreaResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getTelResponsavel() {
		return telResponsavel;
	}

	public void setTelResponsavel(String telResponsavel) {
		this.telResponsavel = telResponsavel;
	}

	// public AvaliadorEntity getAvaliadorEntity() {
	// return avaliadorEntity;
	// }

	// public void setAvaliadorEntity(AvaliadorEntity avaliadorEntity) {
	// this.avaliadorEntity = avaliadorEntity;
	// }

}
