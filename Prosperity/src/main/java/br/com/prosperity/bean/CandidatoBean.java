package br.com.prosperity.bean;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class CandidatoBean {
	private String cpf;
	private String nome;
	private String rg;
	private Calendar dtNascimento;
	private double valorPretensao;
	private Calendar dataAbertura;
	private Calendar dataFechamento;
	private String email;
	private Calendar dataAlteracao;
	private File curriculo;
	private ContatoBean contato;
	private EnderecoBean endereco;
	private FormacaoBean formacao;
	private UsuarioBean usuario;
	private List<StatusBean> status;
	private List<VagaBean> vagas;
	//TODO relacionamento avaliadores	
	
	public CandidatoBean(String cpf, String nome, String rg, Calendar dtNascimento, double valorPretensao,
			Calendar dataAbertura, Calendar dataFechamento, String email, Calendar dataAlteracao, File curriculo,
			ContatoBean contato, EnderecoBean endereco, FormacaoBean formacao, UsuarioBean usuario,
			List<StatusBean> status, List<VagaBean> vagas) {
		this.cpf = cpf;
		this.nome = nome;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.valorPretensao = valorPretensao;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.email = email;
		this.dataAlteracao = dataAlteracao;
		this.curriculo = curriculo;
		this.contato = contato;
		this.endereco = endereco;
		this.formacao = formacao;
		this.usuario = usuario;
		this.status = status;
		this.vagas = vagas;
	}
	
	public String getCpf() {
		return cpf;
	}
	public File getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(File curriculo) {
		this.curriculo = curriculo;
	}
	public List<StatusBean> getStatus() {
		return status;
	}
	public void setStatus(List<StatusBean> status) {
		this.status = status;
	}
	public List<VagaBean> getVagas() {
		return vagas;
	}
	public void setVagas(List<VagaBean> vagas) {
		this.vagas = vagas;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public double getValorPretensao() {
		return valorPretensao;
	}
	public void setValorPretensao(double valorPretensao) {
		this.valorPretensao = valorPretensao;
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
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public ContatoBean getContato() {
		return contato;
	}
	public void setContato(ContatoBean contato) {
		this.contato = contato;
	}
	public EnderecoBean getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoBean endereco) {
		this.endereco = endereco;
	}
	public FormacaoBean getFormacao() {
		return formacao;
	}
	public void setFormacao(FormacaoBean formacao) {
		this.formacao = formacao;
	}
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	
	
}
