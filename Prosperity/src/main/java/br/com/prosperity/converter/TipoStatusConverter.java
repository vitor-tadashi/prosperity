package br.com.prosperity.converter;

import java.util.List;

import br.com.prosperity.bean.TipoStatusBean;
import br.com.prosperity.entity.TipoStatusEntity;

public class TipoStatusConverter implements Converter <TipoStatusEntity, TipoStatusBean> {

	@Override
	public TipoStatusEntity convertBeanToEntity(TipoStatusBean bean) {
		// TODO Auto-generated method stub
		TipoStatusEntity entity = new TipoStatusEntity();
		entity.setId(bean.getId());
		entity.setStatus(bean.getStatus());
		return null;
	}

	@Override
	public TipoStatusBean convertEntityToBean(TipoStatusEntity entity) {
		TipoStatusBean bean = new TipoStatusBean();
		bean.setId(entity.getId());
		bean.setStatus(entity.getStatus());
		return null;
	}

	@Override
	public List<TipoStatusBean> convertEntityToBean(List<TipoStatusEntity> entities) {
		return null;
	}

}
