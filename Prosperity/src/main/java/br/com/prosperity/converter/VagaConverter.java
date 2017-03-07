package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.entity.VagaEntity;

public class VagaConverter implements Converter<VagaEntity, VagaBean> {

	@Override
	public VagaEntity convertBeanToEntity(VagaBean bean) {
		VagaEntity entity = new VagaEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public VagaBean convertEntityToBean(VagaEntity entity) {
		VagaBean bean = new VagaBean();
		bean.setId(entity.getId());
		
		return bean;
	}

	@Override
	public List<VagaBean> convertEntityToBean(List<VagaEntity> entities) {
	List<VagaBean> beanList =  new ArrayList<>();
	 for(VagaEntity e: entities){
		 beanList.add(convertEntityToBean(e));
	 }
		return beanList;
	}

}
