package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.entity.AvaliacaoEntity;

@Component
public class AvaliacaoConverter implements Converter<AvaliacaoEntity, AvaliacaoBean> {

	@Override
	public AvaliacaoEntity convertBeanToEntity(AvaliacaoBean bean) {
		if (bean == null) {
			return null;
		}
		AvaliacaoEntity entity = new AvaliacaoEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setTipoCss(bean.getTipoCss());
		return entity;
	}

	@Override
	public AvaliacaoBean convertEntityToBean(AvaliacaoEntity entity) {
		if (entity == null) {
			return null;
		}
		AvaliacaoBean bean = new AvaliacaoBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setTipoCss(entity.getTipoCss());
		return bean;
	}

}
