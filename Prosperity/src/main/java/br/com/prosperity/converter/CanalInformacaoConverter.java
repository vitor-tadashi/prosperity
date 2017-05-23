package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.entity.CanalInformacaoEntity;

@Component
public class CanalInformacaoConverter implements Converter<CanalInformacaoEntity, CanalInformacaoBean> {

	@Override
	public CanalInformacaoEntity convertBeanToEntity(CanalInformacaoBean bean) {
		if (bean == null) {
			return null;
		}
		CanalInformacaoEntity entity = new CanalInformacaoEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public CanalInformacaoBean convertEntityToBean(CanalInformacaoEntity entity) {
		if (entity == null) {
			return null;
		}
		CanalInformacaoBean bean = new CanalInformacaoBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());

		return bean;
	}
}