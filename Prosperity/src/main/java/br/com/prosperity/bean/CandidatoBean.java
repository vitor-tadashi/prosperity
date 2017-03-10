package br.com.prosperity.bean;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CandidatoBean {
	private Integer id;
	private String cpf;
	private String nome;
	private String rg;
	private Calendar dataNascimento;
	private double valorPretensao;
	private Calendar dataAbertura;
	private Calendar dataFechamento;
	private String email;
	private Calendar dataAlteracao;
	private File curriculo;
	private List<ContatoBean> contatos;
	private EnderecoBean endereco;
	private FormacaoBean formacao;
	private UsuarioBean usuario;
	private List<StatusBean> status;
	private List<VagaBean> vagas;
	
	public CandidatoBean(){
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public List<ContatoBean> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoBean> contatos) {
		this.contatos = contatos;
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

}
