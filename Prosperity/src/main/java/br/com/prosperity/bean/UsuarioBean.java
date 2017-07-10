package br.com.prosperity.bean;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "UsuarioBean")
public class UsuarioBean {

	private final String SENHA_PADRAO = "verity@123";

	@Min(value = 1, message = "O campo Gestor imediato deve ser preenchido")
	private Integer id;
	private PerfilBean perfil;
	private String nomeFuncionario;
	private String nome;
	private String senha = SENHA_PADRAO;
	private Boolean autenticado = false;
	private Boolean primeiroAcesso = true;
	private String email;
	private Boolean ativo = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PerfilBean getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(Boolean autenticado) {
		this.autenticado = autenticado;
	}

	public Boolean getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSENHA_PADRAO() {
		return SENHA_PADRAO;
	}
}