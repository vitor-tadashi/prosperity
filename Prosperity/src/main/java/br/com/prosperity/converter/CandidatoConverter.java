package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.entity.CandidatoEntity;


public class CandidatoConverter implements Converter<CandidatoEntity, CandidatoBean> {

	@Override
	public CandidatoEntity convertBeanToEntity(CandidatoBean bean) {
		CandidatoEntity entity = new CandidatoEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public CandidatoBean convertEntityToBean(CandidatoEntity entity) {
		CandidatoBean bean = new CandidatoBean();
		bean.setId(entity.getId());
		return bean;
	}


	@Override
 public List<CandidatoBean> convertEntityToBean(List<CandidatoEntity> entities) {
		List<CandidatoBean> beanList = new ArrayList<>();
		
		for (CandidatoEntity e : entities) {
			beanList.add(convertEntityToBean(e));
		}
		
		return beanList;
	
	}
}