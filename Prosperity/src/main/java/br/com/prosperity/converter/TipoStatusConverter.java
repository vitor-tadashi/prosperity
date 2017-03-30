package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.TipoStatusBean;
import br.com.prosperity.entity.TipoStatusEntity;

@Component
public class TipoStatusConverter implements Converter<TipoStatusEntity, TipoStatusBean> {

	@Override
	public TipoStatusEntity convertBeanToEntity(TipoStatusBean bean) {
		if (bean == null) {
			return null;
		}
		TipoStatusEntity entity = new TipoStatusEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getStatus());

		return entity;
	}

	@Override
	public TipoStatusBean convertEntityToBean(TipoStatusEntity entity) {
		if (entity == null) {
			return null;
		}
		TipoStatusBean bean = new TipoStatusBean();

		bean.setId(entity.getId());
		bean.setStatus(entity.getNome());

		return bean;
	}
}
