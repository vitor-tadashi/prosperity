package br.com.prosperity.converter;


import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.entity.StatusEntity;

public class StatusCandidatoConverter implements Converter <StatusEntity, StatusBean> {

	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.bean.AvaliadorBean)
	 */
	@Override
	public StatusEntity convertBeanToEntity(StatusBean bean) {
		StatusEntity entity = new StatusEntity();

		entity.setId(bean.getId());
		return null;
	}
	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.entity.AvaliadorEntity)
	 */
	@Override
	public StatusBean convertEntityToBean(StatusEntity entity) {
		StatusBean bean = new StatusBean();
		 bean.setId(entity.getId());
		 
		return null;
	}

	@Override
	public List<StatusBean> convertEntityToBean(List<StatusEntity> entities) {
		List<StatusBean> beanList = new ArrayList<>();
		
		for (StatusEntity e : entities) {
			beanList.add(convertEntityToBean(e));
		}

		return beanList;
	}
	}
	
