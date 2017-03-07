package br.com.prosperity.converter;

import br.com.prosperity.bean.ClienteBean;
import br.com.prosperity.entity.ClienteEntity;

public class ClienteConverter implements Converter <ClienteEntity, ClienteBean> {

	@Override
	public ClienteEntity convertBeanToEntity(ClienteBean bean) {
		ClienteEntity entity = new ClienteEntity();
		
		entity.setId(bean.getId());
		
		return entity;
	}

	@Override
	public ClienteBean convertEntityToBean(ClienteEntity entity) {
		ClienteBean bean = new ClienteBean();
		
		bean.setId(entity.getId());
		
		return bean;
	}

}
