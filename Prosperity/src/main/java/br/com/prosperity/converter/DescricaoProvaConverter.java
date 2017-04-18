package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.DescricaoProvaBean;
import br.com.prosperity.entity.DescricaoProvaEntity;

@Component
public class DescricaoProvaConverter implements Converter<DescricaoProvaEntity, DescricaoProvaBean> {

	@Override
	public DescricaoProvaEntity convertBeanToEntity(DescricaoProvaBean bean) {
		if (bean == null) {
			return null;
		}

		DescricaoProvaEntity entity = new DescricaoProvaEntity();

		entity.setIdDescricaoProva(bean.getId());
		entity.setDsProva(bean.getNome());

		return entity;
	}

	@Override
	public DescricaoProvaBean convertEntityToBean(DescricaoProvaEntity entity) {
		if (entity == null) {
			return null;
		}

		DescricaoProvaBean bean = new DescricaoProvaBean();

		bean.setId(entity.getIdDescricaoProva());
		bean.setNome(entity.getDsProva());

		return bean;
	}

}
