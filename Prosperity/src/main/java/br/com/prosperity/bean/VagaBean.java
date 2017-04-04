package br.com.prosperity.bean;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "VagaBean")
public class VagaBean {

	public VagaBean() {

	}

	public VagaBean(String nome) {
		this.nomeVaga = nome;
	}
	@NotEmpty
	@Min(value = 1, message = "O campo de vaga a ser aplicado deve ser preenchido")
	private Integer id;
	private String nomeVaga;
	private String nomeSolicitante;
	private Double valorPretensao;
	//@Future(message = "Data para inicio inválido")
	private Date dataInicio;
	private Character localTrabalho;
	private Character idTipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private Character aumentaQuadro;
	@Valid
	private ProjetoBean projeto;
	@Valid
	private CargoBean cargoBean;
	@Valid
	private SenioridadeBean senioridadeBean;
	private String nomeSubstituido; //
	private String descricaoFormacaoAcademica; //
	private String descricaoPerfilComportamental; //
	private String descricaoPerfilTecnico; //
	private Date dataAbertura; //
	private Date dataAprovacao; //
	private Date dataFechamento; //
	private Integer numeroCandidatos; //
	@Valid
	private UsuarioBean usuarioBean;
	private List<StatusVagaBean> status;
	private String nmResponsavel;
	private String nmAreaResponsavel;
	private String emailResponsavel;
	private String telResponsavel;
	
	private StatusVagaBean ultimoStatus;

	public StatusVagaBean getUltimoStatus() {
		if (status != null && status.size() > 0) {
			Date dataUltimoStatus = status.stream().map(StatusVagaBean::getDataAlteracao).max(Date::compareTo).get();
			ultimoStatus = status.stream().filter(st -> st.getDataAlteracao().equals(dataUltimoStatus)).findFirst()
					.get();
		} else {
			ultimoStatus = new StatusVagaBean("Pendente");
		}

		return ultimoStatus;
	}
	
	
	
	



	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataAberturaDe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataAberturaPara;

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

	public Integer getId() {
		return id;
	}

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

	public char getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(char localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public char getIdTipoVaga() {
		return idTipoVaga;
	}

	public void setIdTipoVaga(char idTipoVaga) {
		this.idTipoVaga = idTipoVaga;
	}

	public String getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public char getAumentaQuadro() {
		return aumentaQuadro;
	}

	public void setAumentaQuadro(char aumentaQuadro) {
		this.aumentaQuadro = aumentaQuadro;
	}

	public ProjetoBean getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoBean projetoBean) {
		this.projeto = projetoBean;
	}

	public CargoBean getCargoBean() {
		return cargoBean;
	}

	public void setCargoBean(CargoBean cargoBean) {
		this.cargoBean = cargoBean;
	}

	public SenioridadeBean getSenioridadeBean() {
		return senioridadeBean;
	}

	public void setSenioridadeBean(SenioridadeBean senioridadeBean) {
		this.senioridadeBean = senioridadeBean;
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

	public Integer getNumeroCandidatos() {
		return numeroCandidatos;
	}

	public void setNumeroCandidatos(Integer numeroCandidatos) {
		this.numeroCandidatos = numeroCandidatos;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<StatusVagaBean> getStatus() {
		return status;
	}

	public void setStatus(List<StatusVagaBean> status) {
		this.status = status;
	}

	public void setLocalTrabalho(Character localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public void setIdTipoVaga(Character idTipoVaga) {
		this.idTipoVaga = idTipoVaga;
	}

	public void setAumentaQuadro(Character aumentaQuadro) {
		this.aumentaQuadro = aumentaQuadro;
	}
	
	public String getNmResponsavel() {
		return nmResponsavel;
	}

	public void setNmResponsavel(String nmResponsavel) {
		this.nmResponsavel = nmResponsavel;
	}

	public String getNmAreaResponsavel() {
		return nmAreaResponsavel;
	}

	public void setNmAreaResponsavel(String nmAreaResponsavel) {
		this.nmAreaResponsavel = nmAreaResponsavel;
	}

	public String getEmailResponsavel() {
		return emailResponsavel;
	}

	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}

	public String getTelResponsavel() {
		return telResponsavel;
	}

	public void setTelResponsavel(String telResponsavel) {
		this.telResponsavel = telResponsavel;
	}

}
