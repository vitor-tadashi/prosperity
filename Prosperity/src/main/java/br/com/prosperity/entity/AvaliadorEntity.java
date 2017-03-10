package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbAvaliador")

public class AvaliadorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAvaliador", unique = true, nullable = false)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}
