package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.entity.FuncionalidadeEntity;

@Component
public class FuncionalidadeConverter implements Converter<FuncionalidadeEntity, FuncionalidadeBean> {

	private PerfilConverter perfilConverter;

	@Override
	public FuncionalidadeEntity convertBeanToEntity(FuncionalidadeBean bean) {
		FuncionalidadeEntity entity = new FuncionalidadeEntity();
		if (bean == null){
			entity = null;
		} else {
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		// entity.setPerfil(perfilConverter.convertBeanToEntity(bean.getPerfil()));
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
		// bean.setPerfil(perfilConverter.convertEntityToBean(entity.getPerfil()));
		}
		return bean;
	}
}
