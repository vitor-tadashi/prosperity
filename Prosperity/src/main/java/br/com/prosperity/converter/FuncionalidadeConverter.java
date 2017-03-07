package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.entity.FuncionalidadeEntity;

public class FuncionalidadeConverter implements Converter<FuncionalidadeEntity, FuncionalidadeBean> {

	@Override
	public FuncionalidadeEntity convertBeanToEntity(FuncionalidadeBean bean) {
		FuncionalidadeEntity entity = new FuncionalidadeEntity();

		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public FuncionalidadeBean convertEntityToBean(FuncionalidadeEntity entity) {
		FuncionalidadeBean bean = new FuncionalidadeBean();

		bean.setId(entity.getId());

		return bean;
	}

	@Override
	public List<FuncionalidadeBean> convertEntityToBean(List<FuncionalidadeEntity> entities) {
		List<FuncionalidadeBean> beanList = new ArrayList<>();
		
		for (FuncionalidadeEntity e : entities) {
			beanList.add(convertEntityToBean(e));
		}

		return beanList;
	}
}
