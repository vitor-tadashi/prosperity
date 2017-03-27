package br.com.prosperity.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import br.com.prosperity.bean.VagaBean;

@Entity
@Table(name = "tbVaga")
@NamedQueries({ @NamedQuery(name = "obterTodos", query = "SELECT u FROM VagaEntity u WHERE u.nomeVaga = ?1"),
	@NamedQuery(name="obterFiltro", query="SELECT u FROM VagaEntity u WHERE u.nomeVaga LIKE '?1'")
	
})
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
	private char localTrabalho;

	@Column(name = "idTpVaga")
	private Character tipoVaga;

	@Column(name = "hrEntrada")
	@Temporal(value = TemporalType.TIME)
	private Date horaEntrada;

	@Column(name = "hrSaida")
	@Temporal(value = TemporalType.TIME)
	private Date horaSaida;

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

	@ManyToOne
	@JoinColumn(name = "idProjeto")
	private ProjetoEntity projetoEntity;

	@ManyToOne
	@JoinColumn(name = "idCargo")
	private CargoEntity cargoEntity;

	@ManyToOne
	@JoinColumn(name = "idSenioridade")
	private SenioridadeEntity senioridadeEntity;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuarioEntity;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStatusVaga")
	private List<StatusVagaEntity> statusVagaEntity;

	// @ManyToOne(cascade = CascadeType.ALL)
	// private AvaliadorEntity avaliadorEntity;

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

	// public AvaliadorEntity getAvaliadorEntity() {
	// return avaliadorEntity;
	// }

	// public void setAvaliadorEntity(AvaliadorEntity avaliadorEntity) {
	// this.avaliadorEntity = avaliadorEntity;
	// }

}
