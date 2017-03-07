package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.entity.SenioridadeEntity;

public class SenioridadeConverter implements Converter<SenioridadeEntity, SenioridadeBean> {

	@Override
	public SenioridadeEntity convertBeanToEntity(SenioridadeBean bean) {
		SenioridadeEntity entity = new SenioridadeEntity();
		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public SenioridadeBean convertEntityToBean(SenioridadeEntity entity) {
		SenioridadeBean bean = new SenioridadeBean();
		bean.setId(entity.getId());
		return bean;
	}

	@Override
	public List<SenioridadeBean> convertEntityToBean(List<SenioridadeEntity> entities) {
		List<SenioridadeBean> beanList = new ArrayList<>();
		 for(SenioridadeEntity e: entities){
			 beanList.add(convertEntityToBean(e));
			 
		 }
		return null;
	}

}
