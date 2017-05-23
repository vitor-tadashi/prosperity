package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.entity.FuncionalidadeEntity;

@Component
public class FuncionalidadeConverter implements Converter<FuncionalidadeEntity, FuncionalidadeBean> {

	@Override
	public FuncionalidadeEntity convertBeanToEntity(FuncionalidadeBean bean) {
		if (bean == null) {
			return null;
		}
		FuncionalidadeEntity entity = new FuncionalidadeEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setUrl(bean.getUrl());

		return entity;
	}

	@Override
	public FuncionalidadeBean convertEntityToBean(FuncionalidadeEntity entity) {
		if (entity == null) {
			return null;
		}
		FuncionalidadeBean bean = new FuncionalidadeBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setUrl(entity.getUrl());

		return bean;
	}
}