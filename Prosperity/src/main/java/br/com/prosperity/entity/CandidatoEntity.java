package br.com.prosperity.entity;

import java.io.File;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbCandidato")

@NamedQuery(name="pesquisarNome", query="SELECT u FROM CandidatoEntity u LEFT OUTER JOIN u.vagaEntity p WHERE p.nomeVaga like ?1")

public class CandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCandidato", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmCandidato")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "dtNascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "vlPretensao")
	private Double valorPretensaoSalarial;

	@Column(name = "dtAbertura")
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	@Column(name = "dtFechamento")
	@Temporal(TemporalType.DATE)
	private Date dataFechamento;

	@Column(name = "nmEmail")
	private String email;

	@Column(name = "dtAlteracao")
	@Temporal(TemporalType.DATE)
	private Date dataAlteracao;

	@Column(name = "cmCurriculo")
	private String curriculo;

	@Column(name = "dtUltimoContato")
	@Temporal(TemporalType.DATE)
	private Date dataultimoContato;

	@Column(name = "dtEntrevista")
	@Temporal(TemporalType.DATE)
	private Date dataEntrevista;

	@Column(name = "dsProposta")
	private String proposta;

	@Column(name = "vlPretencaoMin")
	private Double valorMin;

	@Column(name = "vlPretencaoMax")
	private Double valorMax;

	/* Mapeamento de Relacionamentos */

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idContato")
	private ContatoEntity contato;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idEndereco")
	private EnderecoEntity endereco;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idFormacao")
	private FormacaoEntity formacao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idCandidato")
	private List<StatusCandidatoEntity> statusCandidatos;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idCandidato")
	private List<CandidatoCompetenciaEntity> competencias;
	
//TODO 
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tbVagaCandidato", joinColumns = { @JoinColumn(name = "idCandidato") }, inverseJoinColumns = {
			@JoinColumn(name = "idVaga") })
	private List<VagaEntity> vagaEntity;

	public List<VagaEntity> getVagaEntity() {
		return vagaEntity;
	}

	public void setVagaEntity(List<VagaEntity> vagaEntity) {
		this.vagaEntity = vagaEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getValorPretensaoSalarial() {
		return valorPretensaoSalarial;
	}

	public void setValorPretensaoSalarial(Double valorPretensaoSalarial) {
		this.valorPretensaoSalarial = valorPretensaoSalarial;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}


	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public Date getDataUltimoContato() {
		return dataultimoContato;
	}

	public void setDataUltimoContato(Date contatoBean) {
		this.dataultimoContato = contatoBean;
	}

	public Date getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(Date dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

	public ContatoEntity getContato() {
		return contato;
	}

	public void setContato(ContatoEntity contato) {
		this.contato = contato;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public FormacaoEntity getFormacao() {
		return formacao;
	}

	public void setFormacao(FormacaoEntity formacao) {
		this.formacao = formacao;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<StatusCandidatoEntity> getStatusCandidatos() {
		return statusCandidatos;
	}

	public void setStatusCandidatos(List<StatusCandidatoEntity> statusCandidatos) {
		this.statusCandidatos = statusCandidatos;
	}

	public List<CandidatoCompetenciaEntity> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CandidatoCompetenciaEntity> competencias) {
		this.competencias = competencias;
	}

	public  double getValorMin() {
		return valorMin;
	}

	public void setValorMin(double valorMin) {
		this.valorMin = valorMin;
	}

	public  double getValorMax() {
		return valorMax;
	}

	public void setValorMax(double valorMax) {
		this.valorMax = valorMax;
	}
	
	public Date getDataultimoContato() {
		return dataultimoContato;
	}

	public void setDataultimoContato(Date dataultimoContato) {
		this.dataultimoContato = dataultimoContato;
	}

	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

}
