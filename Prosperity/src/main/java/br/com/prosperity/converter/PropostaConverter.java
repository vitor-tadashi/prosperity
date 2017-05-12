package br.com.prosperity.converter;

import br.com.prosperity.bean.PropostaBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.prosperity.entity.PropostaEntity;

@Component
public class PropostaConverter implements Converter<PropostaEntity, PropostaBean> {

	@Autowired
	private CandidatoConverter candidatoConveter;

	@Override
	public PropostaEntity convertBeanToEntity(PropostaBean bean) {
		if (bean == null) {
			return null;
		}

		PropostaEntity entity = new PropostaEntity();

		entity.setId(bean.getId());
		entity.setCandidato(candidatoConveter.convertBeanToEntity(bean.getCandidato()));
		entity.setNovaEmpresa(bean.getNovaEmpresa());
		entity.setAnteriorEmpresa(bean.getAnteriorEmpresa());
		entity.setNovoCargo(bean.getNovoCargo());
		entity.setAnteriorCargo(bean.getAnteriorCargo());
		entity.setNovoSalarioFixoBruto(bean.getNovoSalarioFixoBruto());
		entity.setAnteriorSalarioFixoBruto(bean.getAnteriorSalarioFixoBruto());
		entity.setNovoSalarioLiquidoMensal(bean.getNovoSalarioLiquidoMensal());
		entity.setAnteriorSalarioLiquidoMensal(bean.getAnteriorSalarioLiquidoMensal());
		entity.setNovoVrMensal(bean.getNovoVrMensal());
		entity.setAnteriorVrMensal(bean.getAnteriorVrMensal());
		entity.setNovoVaMensal(bean.getNovoVaMensal());
		entity.setAnteriorVaMensal(bean.getAnteriorVaMensal());
		entity.setNovoSeguroSaudeMensal(bean.getNovoSeguroSaudeMensal());
		entity.setAnteriorSeguroSaudeMensal(bean.getAnteriorSeguroSaudeMensal());
		entity.setNovoValeAuto(bean.getNovoValeAuto());
		entity.setAnteriorValeAuto(bean.getAnteriorValeAuto());
		entity.setNovoEstacionamento(bean.getNovoEstacionamento());
		entity.setAnteriorEstacionamento(bean.getAnteriorEstacionamento());
		entity.setNovoValeTransporte(bean.getAnteriorValeTransporte());
		entity.setAnteriorValeTransporte(bean.getAnteriorValeTransporte());
		entity.setNovoLiquidoComBeneficios(bean.getNovoLiquidoComBeneficios());
		entity.setAnteriorLiquidoComBeneficios(bean.getAnteriorLiquidoComBeneficios());
		entity.setNovoAnualLiquido(bean.getNovoAnualLiquido());
		entity.setAnteriorAnualLiquido(bean.getAnteriorAnualLiquido());
		entity.setNovaParticipacaoLucrosOuBonus(bean.getNovaParticipacaoLucrosOuBonus());
		entity.setAnteriorParticipacaoLucrosOuBonus(bean.getAnteriorParticipacaoLucrosOuBonus());
		entity.setNovoTotalAnualLiquidoComBeneficios(bean.getNovoTotalAnualLiquidoComBeneficios());
		entity.setAnteriorTotalAnualLiquidoComBeneficios(bean.getAnteriorTotalAnualLiquidoComBeneficios());
		return entity;

	}

	@Override
	public PropostaBean convertEntityToBean(PropostaEntity entity) {
		if (entity == null) {
			return null;
		}
		PropostaBean bean = new PropostaBean();

		bean.setId(entity.getId());
		bean.setCandidato(candidatoConveter.convertEntityToBean(entity.getCandidato()));
		bean.setNovaEmpresa(entity.getNovaEmpresa());
		bean.setAnteriorEmpresa(entity.getAnteriorEmpresa());
		bean.setNovoCargo(entity.getNovoCargo());
		bean.setAnteriorCargo(entity.getAnteriorCargo());
		bean.setNovoSalarioFixoBruto(entity.getNovoSalarioFixoBruto());
		bean.setAnteriorSalarioFixoBruto(entity.getAnteriorSalarioFixoBruto());
		bean.setNovoSalarioLiquidoMensal(entity.getNovoSalarioLiquidoMensal());
		bean.setAnteriorSalarioLiquidoMensal(entity.getAnteriorSalarioLiquidoMensal());
		bean.setNovoVrMensal(entity.getNovoVrMensal());
		bean.setAnteriorVrMensal(entity.getAnteriorVrMensal());
		bean.setNovoVaMensal(entity.getNovoVaMensal());
		bean.setAnteriorVaMensal(entity.getAnteriorVaMensal());
		bean.setNovoSeguroSaudeMensal(entity.getNovoSeguroSaudeMensal());
		bean.setAnteriorSeguroSaudeMensal(entity.getAnteriorSeguroSaudeMensal());
		bean.setNovoValeAuto(entity.getNovoValeAuto());
		bean.setAnteriorValeAuto(entity.getAnteriorValeAuto());
		bean.setNovoEstacionamento(entity.getNovoEstacionamento());
		bean.setAnteriorEstacionamento(entity.getAnteriorEstacionamento());
		bean.setNovoValeTransporte(entity.getAnteriorValeTransporte());
		bean.setAnteriorValeTransporte(entity.getAnteriorValeTransporte());
		bean.setNovoLiquidoComBeneficios(entity.getNovoLiquidoComBeneficios());
		bean.setAnteriorLiquidoComBeneficios(entity.getAnteriorLiquidoComBeneficios());
		bean.setNovoAnualLiquido(entity.getNovoAnualLiquido());
		bean.setAnteriorAnualLiquido(entity.getAnteriorAnualLiquido());
		bean.setNovaParticipacaoLucrosOuBonus(entity.getNovaParticipacaoLucrosOuBonus());
		bean.setAnteriorParticipacaoLucrosOuBonus(entity.getAnteriorParticipacaoLucrosOuBonus());
		bean.setNovoTotalAnualLiquidoComBeneficios(entity.getNovoTotalAnualLiquidoComBeneficios());
		bean.setAnteriorTotalAnualLiquidoComBeneficios(entity.getAnteriorTotalAnualLiquidoComBeneficios());
		return bean;
	}

}