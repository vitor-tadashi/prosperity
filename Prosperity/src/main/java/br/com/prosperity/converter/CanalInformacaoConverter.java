package br.com.prosperity.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.entity.CanalInformacaoEntity;
import br.com.prosperity.entity.ExampleEntity;
@Component
public class CanalInformacaoConverter implements Converter<CanalInformacaoEntity, CanalInformacaoBean> {

	@Override
	public CanalInformacaoEntity convertBeanToEntity(CanalInformacaoBean bean) {
		CanalInformacaoEntity entity = new CanalInformacaoEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		return entity;
	}

	@Override
	public CanalInformacaoBean convertEntityToBean(CanalInformacaoEntity entity) {
		CanalInformacaoBean bean = new CanalInformacaoBean();
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		return bean;
	}

	

}
