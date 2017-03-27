package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.entity.FuncionalidadeEntity;

@Component
public class FuncionalidadeConverter implements Converter<FuncionalidadeEntity, FuncionalidadeBean> {

	@Override
	public FuncionalidadeEntity convertBeanToEntity(FuncionalidadeBean bean) {
		FuncionalidadeEntity entity = new FuncionalidadeEntity();
		if (bean == null){
			entity = null;
		} else {
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setUrl(bean.getUrl());
		}
		return entity;
	}

	@Override
	public FuncionalidadeBean convertEntityToBean(FuncionalidadeEntity entity) {
		FuncionalidadeBean bean = new FuncionalidadeBean();
		if (entity == null){
			bean = null;
		} else {
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setUrl(entity.getUrl());
		}
		return bean;
	}
}
