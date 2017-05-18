package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ComparativoPropostaBean;
import br.com.prosperity.entity.ComparativoPropostaEntity;

@Component
public class ComparativoPropostaConverter implements Converter<ComparativoPropostaEntity, ComparativoPropostaBean> {

	@Override
	public ComparativoPropostaEntity convertBeanToEntity(ComparativoPropostaBean bean) {
		// TODO Auto-generated method stub
		if (bean == null) {
			return null;
		}

		ComparativoPropostaEntity entity = new ComparativoPropostaEntity();

		entity.setId(bean.getId());
		entity.setNmFuncionario(bean.getNmFuncionario());
		entity.setNmCargo(bean.getNmCargo());
		entity.setNmSenioridade(bean.getNmSenioridade());
		entity.setDsConhecimento(bean.getDsConhecimento());
		entity.setDtAdmissao(bean.getDtAdmissao());
		entity.setVlrSalario(bean.getVlrSalario());
		entity.setVlrVr(bean.getVlrVr());
		entity.setVlrVa(bean.getVlrVa());
		entity.setVlrEstacionamento(bean.getVlrEstacionamento());
		entity.setVlrCombustivel(bean.getVlrCombustivel());
		entity.setVlrAssistenciaMedica(bean.getVlrAssistenciaMedica());
		entity.setVlrOutros(bean.getVlrOutros());
		entity.setVlrTaxa(bean.getVlrTaxa());
		entity.setFlSituacao(bean.getFlSituacao());

		return entity;
	}

	@Override
	public ComparativoPropostaBean convertEntityToBean(ComparativoPropostaEntity entity) {
		// TODO Auto-generated method stub
		if (entity == null) {
			return null;
		}

		ComparativoPropostaBean bean = new ComparativoPropostaBean();

		bean.setId(entity.getId());
		bean.setNmFuncionario(entity.getNmFuncionario());
		bean.setNmCargo(entity.getNmCargo());
		bean.setNmSenioridade(entity.getNmSenioridade());
		bean.setDsConhecimento(entity.getDsConhecimento());
		bean.setDtAdmissao(entity.getDtAdmissao());
		bean.setVlrSalario(entity.getVlrSalario());
		bean.setVlrVr(entity.getVlrVr());
		bean.setVlrVa(entity.getVlrVa());
		bean.setVlrEstacionamento(entity.getVlrEstacionamento());
		bean.setVlrCombustivel(entity.getVlrCombustivel());
		bean.setVlrAssistenciaMedica(entity.getVlrAssistenciaMedica());
		bean.setVlrOutros(entity.getVlrOutros());
		bean.setVlrTaxa(entity.getVlrTaxa());
		bean.setFlSituacao(entity.getFlSituacao());

		return bean;
	}

}
