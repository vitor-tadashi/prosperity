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
		entity.setId(bean.getId());
		return null;
	}

	@Override
	public TipoStatusBean convertEntityToBean(TipoStatusEntity entity) {
		TipoStatusBean bean = new TipoStatusBean();
		bean.setId(entity.getId());
		return null;
	}
}
