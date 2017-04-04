package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import br.com.prosperity.util.FormatUtil;

@Component
@XmlRootElement(name = "CandidatoBean")
public class CandidatoBean  extends FormatUtil {

	private Integer id;

	@NotEmpty(message = "O campo CPF deve ser preenchido")
	private String cpf;
	@NotEmpty(message = "O campo nome deve ser prenchido")
	private String nome;

	@NotEmpty(message = "O campo RG  deve ser prenchido")
	private String rg;

	@NotNull(message = "O campo data de nascimento deve ser preenchido")
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	private Date dataNascimento;
	private Double valorPretensao;
	private Date dataAbertura;
	private Date dataFechamento;
	private String email;
	private Date dataAlteracao;
	private String curriculo;
	@Valid
	private ContatoBean contato;
	@Valid
	private EnderecoBean endereco;
	private FormacaoBean formacao;
	private UsuarioBean usuario;
	private List<StatusCandidatoBean> status = new ArrayList<>();
	@Valid
	private Set<VagaCandidatoBean> vagas = new HashSet<>();
	private List<CandidatoCompetenciaBean> competencias = new ArrayList<>();
	private List<AvaliadorBean> avaliadores = new ArrayList<>(); 
	private Map<String, List<StatusCandidatoBean>> statusPorMesAno;
	private Date dataUltimoContato;
	private Date entrevista;
	private String proposta;
	private Double valorMin;
	private Double valorMax;
	private StatusCandidatoBean ultimoStatus;
	private VagaBean ultimaVaga;
	private VagaCandidatoBean vagaCandidato;
	private Double pretensaoDe;
	private Double pretensaoPara;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataAberturaDe;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataAberturaPara;
	



	public VagaCandidatoBean getVagaCandidato() {
		if (vagaCandidato == null) {
			getUltimaVaga();
		}
		
		return vagaCandidato;
	}

	public void setVagaCandidato(VagaCandidatoBean vagaCandidato) {
		this.vagaCandidato = vagaCandidato;
	}

	public void setPretensaoDe(Double pretensaoDe) {
		this.pretensaoDe = pretensaoDe;
	}

	public void setPretensaoPara(Double pretensaoPara) {
		this.pretensaoPara = pretensaoPara;
	}

	public Date getDataAberturaDe() {
		return dataAberturaDe;
	}

	public void setDataAberturaDe(Date dataAberturaDe) {
		this.dataAberturaDe = dataAberturaDe;
	}

	public Date getDataAberturaPara() {
		return dataAberturaPara;
	}

	public void setDataAberturaPara(Date dataAberturaPara) {
		this.dataAberturaPara = dataAberturaPara;
	}
	@XmlTransient
	public double getPretensaoDe() {
		return pretensaoDe;
	}

	public void setPretensaoDe(double pretensaoDe) {
		this.pretensaoDe = pretensaoDe;
	}
	@XmlTransient
	public double getPretensaoPara() {
		return pretensaoPara;
	}

	public void setPretensaoPara(double pretensaoPara) {
		this.pretensaoPara = pretensaoPara;
	}

	public StatusCandidatoBean getUltimoStatus() {
		if (status != null && status.size() > 0) {
			Integer idUltimoStatus = status.stream().map(StatusCandidatoBean::getId).max(Integer::compareTo).get();
			ultimoStatus = status.stream().filter(st -> st.getId().equals(idUltimoStatus)).findFirst().get();	
		} else {
			ultimoStatus = new StatusCandidatoBean("Não possui status");
		}

		return ultimoStatus;
	}
	
	public VagaBean getUltimaVaga() {
		if (vagas != null && vagas.size() > 0) {
			Integer idUltimaVaga = vagas.stream().map(VagaCandidatoBean::getId).max(Integer::compareTo).get();
			vagaCandidato = vagas.stream().filter(st -> st.getId().equals(idUltimaVaga)).findFirst().get();
			ultimaVaga = vagaCandidato.getVaga();
		} else {
			ultimaVaga = new VagaBean("Não possui vaga");
		}

		return ultimaVaga;
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

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
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

	public Set<VagaCandidatoBean> getVagas() {
		return vagas;
	}

	public void setVagas(Set<VagaCandidatoBean> vagas) {
		this.vagas = vagas;
	}

	public List<CandidatoCompetenciaBean> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CandidatoCompetenciaBean> competencias) {
		this.competencias = competencias;
	}

	@XmlTransient
	public Map<String, List<StatusCandidatoBean>> getStatusPorMesAno() {
		return statusPorMesAno;
	}

	public void setStatusPorMesAno(Map<String, List<StatusCandidatoBean>> statusPorMesAno) {
		this.statusPorMesAno = statusPorMesAno;
	}

	public Date getDataUltimoContato() {
		return dataUltimoContato;
	}

	public void setDataUltimoContato(Date dataUltimoContato) {
		this.dataUltimoContato = dataUltimoContato;
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

	public List<AvaliadorBean> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<AvaliadorBean> avaliadores) {
		this.avaliadores = avaliadores;
	}

}
