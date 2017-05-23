package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CompetenciaBean;
import br.com.prosperity.entity.CompetenciaEntity;

@Component
public class CompetenciaConverter implements Converter<CompetenciaEntity, CompetenciaBean> {

	@Override
	public CompetenciaEntity convertBeanToEntity(CompetenciaBean bean) {
		if (bean == null) {
			return null;
		}
		CompetenciaEntity entity = new CompetenciaEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public CompetenciaBean convertEntityToBean(CompetenciaEntity entity) {
		if (entity == null) {
			return null;
		}
		CompetenciaBean bean = new CompetenciaBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());

		return bean;
	}
}