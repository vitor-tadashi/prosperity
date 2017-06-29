package br.com.prosperity.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class QuantiaCandidatoPorStatusBean {
	private Integer candidaturas = 0;
	private Integer aprovados = 0;
	private Integer reprovados = 0;
	private Integer cancelados = 0;
	private Integer contratados = 0;
	private Integer emAnalise = 0;
	private BigDecimal candidaturasPercentual;
	private BigDecimal aprovadosPercentual;
	private BigDecimal reprovadosPercentual;
	private BigDecimal canceladosPercentual;
	private BigDecimal contratadosPercentual;
	private BigDecimal emAnalisePercentual;
	private Integer totalCandidatos = 0;
	
	public Integer getCandidaturas() {
		return candidaturas;
	}
	public void setCandidaturas() {
		this.candidaturas++;
	}
	public Integer getAprovados() {
		return aprovados;
	}
	public void setAprovados() {
		this.aprovados++;
	}
	public Integer getReprovados() {
		return reprovados;
	}
	public void setReprovados() {
		this.reprovados++;
	}
	public Integer getCancelados() {
		return cancelados;
	}
	public void setCancelados() {
		this.cancelados++;
	}
	public Integer getContratados() {
		return contratados;
	}
	public void setContratados() {
		this.contratados++;
	}
	public Integer getEmAnalise() {
		return emAnalise;
	}
	public void setEmAnalise() {
		this.emAnalise++;
	}
	public BigDecimal getCandidaturasPercentual() {
		try {
			candidaturasPercentual = BigDecimal.valueOf((100 / (double)getTotalCandidatos())* candidaturas);
			
			return candidaturasPercentual.setScale(2, RoundingMode.HALF_EVEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public BigDecimal getAprovadosPercentual() {
		try {
			aprovadosPercentual = BigDecimal.valueOf((100 / (double)getTotalCandidatos())* aprovados);
			
			return aprovadosPercentual.setScale(2, RoundingMode.HALF_EVEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public BigDecimal getReprovadosPercentual() {
		try {
			reprovadosPercentual = BigDecimal.valueOf((100 / (double)getTotalCandidatos())* reprovados);
			
			return reprovadosPercentual.setScale(2, RoundingMode.HALF_EVEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public BigDecimal getCanceladosPercentual() {
		try {
			canceladosPercentual = BigDecimal.valueOf((100 / (double)getTotalCandidatos())* cancelados);
			
			return canceladosPercentual.setScale(2, RoundingMode.HALF_EVEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public BigDecimal getContratadosPercentual() {
		try {
			contratadosPercentual = BigDecimal.valueOf((100 / (double)getTotalCandidatos())* contratados);
			
			return contratadosPercentual.setScale(2, RoundingMode.HALF_EVEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public BigDecimal getEmAnalisePercentual() {
		try {
			emAnalisePercentual = BigDecimal.valueOf((100 / (double)getTotalCandidatos())* emAnalise);
			
			return emAnalisePercentual.setScale(2, RoundingMode.HALF_EVEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Integer getTotalCandidatos() {
		this.totalCandidatos = candidaturas + reprovados + cancelados + aprovados + contratados + emAnalise;
		
		return totalCandidatos;
	}

}
