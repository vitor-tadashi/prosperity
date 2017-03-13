package br.com.prosperity.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.util.Formatar;

@Component
public class CandidatoBean extends Formatar {
	private Integer id;
	private String cpf;
	private String nome;
	private String rg;
	private Date dataNascimento;
	private Double valorPretensao;
	private Date dataAbertura;
	private Date dataFechamento;
	private String email;
	private Date dataAlteracao;
	private File curriculo;

   private ContatoBean contato;
	private EnderecoBean endereco;
	private FormacaoBean formacao;
	private UsuarioBean usuario;
	private List<StatusBean> status = new ArrayList<>();;
	private List<VagaBean> vagas = new ArrayList<>();;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getValorPretensao() {
		return valorPretensao;
	}

	public void setValorPretensao(Double valorPretensao) {
		this.valorPretensao = valorPretensao;
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

	public File getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(File curriculo) {
		this.curriculo = curriculo;
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
