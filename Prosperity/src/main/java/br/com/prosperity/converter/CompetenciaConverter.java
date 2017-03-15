package br.com.prosperity.converter;

import br.com.prosperity.bean.CompetenciaBean;
import br.com.prosperity.entity.CompetenciaEntity;

public class CompetenciaConverter implements Converter<CompetenciaEntity, CompetenciaBean> {

	@Override
	public CompetenciaEntity convertBeanToEntity(CompetenciaBean bean) {
		CompetenciaEntity entity = new CompetenciaEntity();
		
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		
		return entity;
	}

	@Override
	public CompetenciaBean convertEntityToBean(CompetenciaEntity entity) {
		CompetenciaBean bean = new CompetenciaBean();
		
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		
		return bean;
	}
	
	

}
