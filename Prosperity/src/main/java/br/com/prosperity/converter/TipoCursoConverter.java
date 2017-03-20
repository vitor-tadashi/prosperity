package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.entity.TipoCursoEntity;

@Component
public class TipoCursoConverter implements Converter<TipoCursoEntity, TipoCursoBean> {

	@Override
	public TipoCursoEntity convertBeanToEntity(TipoCursoBean bean) {
		if (bean == null) {
			return null;
		}
		TipoCursoEntity entity = new TipoCursoEntity();
		entity.setId(bean.getId());
		entity.setDescricao(bean.getNome());
		return entity;
	}

	@Override
	public TipoCursoBean convertEntityToBean(TipoCursoEntity entity) {
		
		if (entity == null) {
			return null;
		}
		TipoCursoBean bean = new TipoCursoBean();
		bean.setId(entity.getId());
		bean.setNome(entity.getDescricao());
		return bean;
	}
}
