package br.com.prosperity.bean;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class CandidatoBean {
	private String cpf;
	private String nome;
	private String rg;
	private Calendar dtNascimento;
	private double prtSalarial;
	private Calendar dtAbertura;
	private Calendar dtFechamento;
	private String email;
	private Calendar dtAlteracao;
	private File curriculo;
	private ContatoBean contato;
	private EnderecoBean endereco;
	private FormacaoBean formacao;
	private UsuarioBean usuario;
	private List<StatusBean> status;
	private List<VagaBean> vagas;
	//TODO relacionamento avaliadores
	
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
	public double getPrtSalarial() {
		return prtSalarial;
	}
	public void setPrtSalarial(double prtSalarial) {
		this.prtSalarial = prtSalarial;
	}
	public Calendar getDtAbertura() {
		return dtAbertura;
	}
	public void setDtAbertura(Calendar dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
	public Calendar getDtFechamento() {
		return dtFechamento;
	}
	public void setDtFechamento(Calendar dtFechamento) {
		this.dtFechamento = dtFechamento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDtAlteracao() {
		return dtAlteracao;
	}
	public void setDtAlteracao(Calendar dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
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
