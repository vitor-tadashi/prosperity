package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbStatusFuturo")
@NamedQuery(name = "obterStatusFuturos", query = "SELECT u FROM StatusFuturoEntity u WHERE u.idStatus = ?1")
public class StatusFuturoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "idStatus")
	private Integer idStatus;

	@Column(name = "idStatusFuturo")
	private Integer idStatusFuturo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public Integer getIdStatusFuturo() {
		return idStatusFuturo;
	}

	public void setIdStatusFuturo(Integer idStatusFuturo) {
		this.idStatusFuturo = idStatusFuturo;
	}
}