package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: PerfilFuncionalidadeEntity
 *
 */
@Entity
@Table(name="tbEndereco")

public class EnderecoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCliente", unique = true)
	private int id;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="vlNumero")
	private int numero;
	
	@Column(name="dsComplemento")
	private String complemento;
	
	@Column(name="nmEstado")
	private String estado;
	
	@Column(name="nmLogradouro")
	private String logradouro;
	
	@Column(name="nmCidade")
	private String cidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
