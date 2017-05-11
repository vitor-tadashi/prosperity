package br.com.prosperity.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CargoSenioridade
 *
 */

@Entity
@Table(name="tbCargoSenioridade")
@NamedQueries({ 
	@NamedQuery(name = "rangeSalarial", query = "SELECT u FROM CargoSenioridadeEntity u WHERE u.idCargo = ?1 AND u.idSenioridade = ?2"),
	@NamedQuery(name = "perfilPrePronto", query = "SELECT u FROM CargoSenioridadeEntity u WHERE u.idCargo = ?1 AND u.idSenioridade = ?2")
})
public class CargoSenioridadeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCargoSenioridade", unique = true)
	private Integer id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCargo")
	private CargoEntity idCargo;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idSenioridade")
	private SenioridadeEntity idSenioridade;
	
	@Column(name="dsPreFormacaoAcademica")
	private String dsPreFormacaoAcademica;
	
	@Column(name="dsPrePerfilComportamental")
	private String dsPrePerfilComportamental;
	
	@Column(name="dsPrePerfilTecnico")
	private String dsPrePerfilTecnico;
	
	@Column(name="vlMinSalario")
	private BigDecimal vlMinSalario;
	
	@Column(name="vlMaxSalario")
	private BigDecimal vlMaxSalario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public CargoEntity getCargo() {
		return idCargo;
	}
	public void setCargo(CargoEntity idCargo) {
		this.idCargo = idCargo;
	}
	public SenioridadeEntity getIdSenioridade() {
		return idSenioridade;
	}
	public void setIdSenioridade(SenioridadeEntity idSenioridade) {
		this.idSenioridade = idSenioridade;
	}
	public BigDecimal getVlMinSalario() {
		return vlMinSalario;
	}
	public void setVlMinSalario(BigDecimal vlMinSalario) {
		this.vlMinSalario = vlMinSalario;
	}
	public BigDecimal getVlMaxSalario() {
		return vlMaxSalario;
	}
	public void setVlMaxSalario(BigDecimal vlMaxSalario) {
		this.vlMaxSalario = vlMaxSalario;
	}
	public CargoEntity getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(CargoEntity idCargo) {
		this.idCargo = idCargo;
	}
	public String getDsPreFormacaoAcademica() {
		return dsPreFormacaoAcademica;
	}
	public void setDsPreFormacaoAcademica(String dsPreFormacaoAcademica) {
		this.dsPreFormacaoAcademica = dsPreFormacaoAcademica;
	}
	public String getDsPrePerfilComportamental() {
		return dsPrePerfilComportamental;
	}
	public void setDsPrePerfilComportamental(String dsPrePerfilComportamental) {
		this.dsPrePerfilComportamental = dsPrePerfilComportamental;
	}
	public String getDsPrePerfilTecnico() {
		return dsPrePerfilTecnico;
	}
	public void setDsPrePerfilTecnico(String dsPrePerfilTecnico) {
		this.dsPrePerfilTecnico = dsPrePerfilTecnico;
	}
	
	
	
}
