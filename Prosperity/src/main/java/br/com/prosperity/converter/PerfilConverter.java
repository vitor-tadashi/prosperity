package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.entity.PerfilEntity;

@Component
public class PerfilConverter implements Converter<PerfilEntity, PerfilBean> {
	@Autowired
	private FuncionalidadeConverter funcionalidadeConverter;

	@Override
	public PerfilEntity convertBeanToEntity(PerfilBean bean) {
		PerfilEntity entity = new PerfilEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setFuncionalidades(funcionalidadeConverter.convertBeanToEntity(bean.getListaFuncionalidades()));

		return entity;
	}

	@Override
	public PerfilBean convertEntityToBean(PerfilEntity entity) {
		PerfilBean bean = new PerfilBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setListaFuncionalidades(funcionalidadeConverter.convertEntityToBean(entity.getFuncionalidades()));

		return bean;
	}
}
