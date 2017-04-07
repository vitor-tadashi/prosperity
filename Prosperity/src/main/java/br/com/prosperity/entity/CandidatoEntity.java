package br.com.prosperity.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author andre.posman
 *
 */
@Entity
@Table(name = "tbCandidato")
@NamedQueries({
		@NamedQuery(name = "pesquisarNome", query = "SELECT u FROM CandidatoEntity u WHERE u.nome like ?1 AND u.valorPretensaoSalarial BETWEEN ?2 AND ?3 AND u.dataAbertura BETWEEN ?4 AND ?5"),
		@NamedQuery(name = "obterPorCPF", query = "SELECT u FROM CandidatoEntity u WHERE u.cpf = ?1"),
		@NamedQuery(name = "verificarCanidatura", query = "SELECT c FROM CandidatoEntity c JOIN c.statusCandidatos sc WHERE sc.status in(6,7,14)"
				+ "AND sc.idStatusCandidato = (SELECT MAX(sc.idStatusCandidato) FROM CandidatoEntity c JOIN c.statusCandidatos sc)"),
		@NamedQuery(name = "obterParaCombo", query = "SELECT v.id, v.nomeVaga FROM VagaEntity v"),
		@NamedQuery(name = "aprovacao", query = "SELECT c FROM CandidatoEntity c, AvaliadorCandidatoEntity ac INNER JOIN c.statusCandidatos sc "
				+ "WHERE ac.candidato.id = c.id AND sc.idStatusCandidato = (SELECT max(sc.idStatusCandidato)"
				+ "FROM CandidatoEntity c JOIN c.statusCandidatos sc WHERE sc.candidato.id = c.id AND sc.status.id IN (?1)) AND ac.status is NULL"
				+ " AND ac.avaliadorVaga.usuario.id = ?2") })

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

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idContato")
	private ContatoEntity contato;

	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "idEndereco")
	private EnderecoEntity endereco;

	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "idFormacao")
	private FormacaoEntity formacao;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@OneToMany()
	@JoinColumn(name = "idCandidato")
	private List<StatusCandidatoEntity> statusCandidatos;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "idCandidato")
	private List<CandidatoCompetenciaEntity> competencias;

	@OneToMany(cascade ={CascadeType.ALL})
	@JoinColumn(name="idCandidato")
	private Set<VagaCandidatoEntity> vagas;
	
	
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


	public Set<VagaCandidatoEntity> getVagas() {
		return vagas;
	}

	public void setVagas(Set<VagaCandidatoEntity> vagas) {
		this.vagas = vagas;
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

	public void setCurriculo(String file) {
		this.curriculo = file;
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

	/*
	 * public List<StatusCandidatoEntity> getStatusCandidatos() { return
	 * statusCandidatos; }
	 * 
	 * public void setStatusCandidatos(List<StatusCandidatoEntity>
	 * statusCandidatos) { this.statusCandidatos = statusCandidatos; }
	 * 
	 * public List<CandidatoCompetenciaEntity> getCompetencias() { return
	 * competencias; }
	 * 
	 * public void setCompetencias(List<CandidatoCompetenciaEntity>
	 * competencias) { this.competencias = competencias; } <<<<<<< HEAD
	 * 
	 * public Date getDataultimoContato() { return dataultimoContato; }
	 * 
	 * public void setDataultimoContato(Date dataultimoContato) {
	 * this.dataultimoContato = dataultimoContato; }
	 * 
	 * public Double getValorMin() { =======
	 */
	public Double getValorMin() {

		return valorMin;
	}

	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
	}

	public Double getValorMax() {

		return valorMax;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

}
