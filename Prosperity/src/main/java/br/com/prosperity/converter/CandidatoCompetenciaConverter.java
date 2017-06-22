package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.entity.CandidatoCompetenciaEntity;

@Component
public class CandidatoCompetenciaConverter implements Converter<CandidatoCompetenciaEntity, CandidatoCompetenciaBean> {

	@Autowired
	AvaliacaoConverter avaliacaoConverter;

	@Autowired
	CompetenciaConverter competenciaConverter;

	@Override
	public CandidatoCompetenciaEntity convertBeanToEntity(CandidatoCompetenciaBean bean) {
		if (bean == null) {
			return null;
		}
		CandidatoCompetenciaEntity entity = new CandidatoCompetenciaEntity();

		entity.setIdCandidatoCompetencia(bean.getId());
		entity.setCompetencia(competenciaConverter.convertBeanToEntity(bean.getCompetencia()));
		entity.setAvaliacao(avaliacaoConverter.convertBeanToEntity(bean.getAvaliacao()));
		entity.setNmAvaliador(bean.getNmAvaliador());
		entity.setIdCandidato(bean.getIdCandidato());
		entity.setIdVaga(bean.getIdVaga());

		return entity;
	}

	@Override
	public CandidatoCompetenciaBean convertEntityToBean(CandidatoCompetenciaEntity entity) {
		if (entity == null) {
			return null;
		}
		CandidatoCompetenciaBean bean = new CandidatoCompetenciaBean();

		bean.setId(entity.getIdCandidatoCompetencia());
		bean.setCompetencia(competenciaConverter.convertEntityToBean(entity.getCompetencia()));
		bean.setAvaliacao(avaliacaoConverter.convertEntityToBean(entity.getAvaliacao()));
		bean.setNmAvaliador(entity.getNmAvaliador());
		bean.setIdCandidato(entity.getIdCandidato());
		bean.setIdVaga(entity.getIdVaga());

		return bean;
	}
}