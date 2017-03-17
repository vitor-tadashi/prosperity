package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.TipoStatusBean;
import br.com.prosperity.entity.TipoStatusEntity;

@Component
public class TipoStatusConverter implements Converter <TipoStatusEntity, TipoStatusBean> {

	@Override
	public TipoStatusEntity convertBeanToEntity(TipoStatusBean bean) {
		// TODO Auto-generated method stub
		TipoStatusEntity entity = new TipoStatusEntity();
		if (bean == null){
			entity = null;
		} else {
		entity.setId(bean.getId());
		entity.setNome(bean.getStatus());
		}
		return entity;
	}

	@Override
	public TipoStatusBean convertEntityToBean(TipoStatusEntity entity) {
		TipoStatusBean bean = new TipoStatusBean();
		if (entity == null){
			bean = null;
		} else {
		bean.setId(entity.getId());
		bean.setStatus(entity.getNome());
		}
		return bean;
	}
}
