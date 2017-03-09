package br.com.prosperity.entity;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbCandidato")
public class CandidatoEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	@Id
	@Column(name = "idCandidato", unique = true, nullable = false)
	private Integer id;
	/* fim Id */

	@Column(name = "nmCandidato")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "dtNascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "vlPretensao")
	private double valorPretensaoSalarial;

	@Column(name = "dtAbertura")
	@Temporal(TemporalType.DATE)
	private Calendar dataAbertura;

	@Column(name = "dtFechamento")
	@Temporal(TemporalType.DATE)
	private Calendar dataFechamento;

	@Column(name = "nmEmail")
	private String email;

	@Column(name = "dtAlteracao")
	@Temporal(TemporalType.DATE)
	private Calendar dataAlteracao;

	@Column(name = "cmCurriculo")
	private File curriculo;

	/* Mapeamento de Relacionamentos */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idContato")
	private List<ContatoEntity> contatos;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idEndereco")
	private EnderecoEntity endereco;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idCurso")
	private FormacaoEntity formacao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@OneToMany
	@JoinColumn(name = "idCandidato")
	private List<StatusCandidatoEntity> statusCandidato;

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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getValorPretensaoSalarial() {
		return valorPretensaoSalarial;
	}

	public void setValorPretensaoSalarial(double valorPretensaoSalarial) {
		this.valorPretensaoSalarial = valorPretensaoSalarial;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public File getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(File curriculo) {
		this.curriculo = curriculo;
	}

	public List<ContatoEntity> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoEntity> contatos) {
		this.contatos = contatos;
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

	public List<StatusCandidatoEntity> getStatusCandidato() {
		return statusCandidato;
	}

	public void setStatusCandidato(List<StatusCandidatoEntity> statusCandidato) {
		this.statusCandidato = statusCandidato;
	}


	/* fim dos mapeamentos */

	
}
