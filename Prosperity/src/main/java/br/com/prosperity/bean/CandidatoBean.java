package br.com.prosperity.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.util.FormatUtil;

@Component
public class CandidatoBean  extends FormatUtil {

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
	private VagaBean vaga;
	private List<StatusCandidatoBean> status;
	private VagaCandidatoBean vagaCandidatoBean;
	private List<CandidatoCompetenciaBean> competencias;
	private Date DataultimoContato;
	private Date entrevista;
	private String proposta;
	private Double valorMin;
	private Double valorMax;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
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

	public List<CandidatoCompetenciaBean> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CandidatoCompetenciaBean> competencias) {
		this.competencias = competencias;
	}

	public Date getDataultimoContato() {
		return DataultimoContato;
	}

	public void setDataultimoContato(Date dataultimoContato) {
		DataultimoContato = dataultimoContato;
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

	public List<StatusCandidatoBean> getStatus() {
		return status;
	}

	public void setStatus(List<StatusCandidatoBean> status) {
		this.status = status;
	}



	public Date getUltimoContato() {
		return DataultimoContato;
	}

	public void setUltimoContato(Date DataultimoContato) {
		this.DataultimoContato = DataultimoContato;
	}

	public Date getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Date entrevista) {
		this.entrevista = entrevista;
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

	public VagaCandidatoBean getVagaCandidatoBean() {
		return vagaCandidatoBean;
	}

	public void setVagaCandidatoBean(VagaCandidatoBean vagaCandidatoBean) {
		this.vagaCandidatoBean = vagaCandidatoBean;
	}

	public VagaBean getVaga() {
		return vaga;
	}

	public void setVaga(VagaBean vaga) {
		this.vaga = vaga;
	}

	public double getValorMin() {
		return valorMin;
	}

	public void setValorMin(double valorMin) {
		this.valorMin = valorMin;
	}

	public Double getValorMax() {
		return valorMax;
	}

	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}

	
}
