package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author andre.posman
 *
 */
@Entity
@Table(name = "tbDescricaoProva")
public class DescricaoProvaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDescricaoProva", unique = true, nullable = false)
	private Integer id;

	@Column(name = "dsProva")
	private String dsProva;

	public Integer getIdDescricaoProva() {
		return id;
	}

	public void setIdDescricaoProva(Integer idDescricaoProva) {
		this.id = idDescricaoProva;
	}

	public String getDsProva() {
		return dsProva;
	}

	public void setDsProva(String dsProva) {
		this.dsProva = dsProva;
	}

}
