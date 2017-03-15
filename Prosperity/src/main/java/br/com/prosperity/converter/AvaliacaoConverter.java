package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.entity.AvaliacaoEntity;

@Component
public class AvaliacaoConverter implements Converter<AvaliacaoEntity, AvaliacaoBean> {

	@Override
	public AvaliacaoEntity convertBeanToEntity(AvaliacaoBean bean) {
		AvaliacaoEntity entity = new AvaliacaoEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public AvaliacaoBean convertEntityToBean(AvaliacaoEntity entity) {
		AvaliacaoBean bean = new AvaliacaoBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());

		return bean;
	}

}
