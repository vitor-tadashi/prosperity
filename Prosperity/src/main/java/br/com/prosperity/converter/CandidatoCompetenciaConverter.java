package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.entity.CandidatoCompetenciaEntity;

@Component
public class CandidatoCompetenciaConverter implements Converter<CandidatoCompetenciaEntity, CandidatoCompetenciaBean> {

	@Autowired
	AvaliacaoConverter avaliacaoConverter;

	@Override
	public CandidatoCompetenciaEntity convertBeanToEntity(CandidatoCompetenciaBean bean) {
		CandidatoCompetenciaEntity entity = new CandidatoCompetenciaEntity();

		entity.setIdCandidatoCompetencia(bean.getId());
		
		return entity;
	}

	@Override
	public CandidatoCompetenciaBean convertEntityToBean(CandidatoCompetenciaEntity entity) {
		CandidatoCompetenciaBean bean = new CandidatoCompetenciaBean();

		bean.setId(entity.getIdCandidatoCompetencia());

		return bean;
	}

}
