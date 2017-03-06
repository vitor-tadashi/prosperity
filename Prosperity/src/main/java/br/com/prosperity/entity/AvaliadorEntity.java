package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbAvaliador")

public class AvaliadorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAvaliador", unique = true, nullable = false)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
