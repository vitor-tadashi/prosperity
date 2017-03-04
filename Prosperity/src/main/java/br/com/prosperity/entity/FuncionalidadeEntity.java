package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tbFuncionalidade")

public class FuncionalidadeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFuncionalidade", unique = true, nullable = false)
	private int id;
	@Column(name = "nmFuncionalidade")
	private String nome;
	
	 @ManyToMany
	 @JoinTable(name="tbPerfilFuncionalidade", joinColumns={@JoinColumn(name="idPerfil")}, inverseJoinColumns={@JoinColumn(name="idFuncionalidade")})
	private List<PerfilEntity> perfil;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<PerfilEntity> getPerfil() {
		return perfil;
	}
	public void setPerfil(List<PerfilEntity> perfil) {
		this.perfil = perfil;
	}
}
