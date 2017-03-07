package br.com.prosperity.converter;

import java.util.List;

import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.entity.StatusEntity;

public class StatusConverter implements Converter<StatusEntity, StatusBean> {

	@Override
	public StatusEntity convertBeanToEntity(StatusBean bean) {
		// TODO Auto-generated method stub
		StatusEntity entity = new StatusEntity();
		entity.setId(bean.getId());
		entity.setStatus(bean.getStatus());
		return null;
	}

	@Override
	public StatusBean convertEntityToBean(StatusEntity entity) {
		StatusBean bean = new StatusBean();
		bean.setId(entity.getId());
		bean.setStatus(entity.getStatus());
		return null;
	}

	@Override
	public List<StatusBean> convertEntityToBean(List<StatusEntity> entities) {
		return null;
	}

}
