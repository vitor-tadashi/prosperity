package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.entity.PerfilEntity;

public class PerfilConverter implements Converter<PerfilEntity, PerfilBean> {

	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.bean.AvaliadorBean)
	 */
	
	@Override
	public PerfilEntity convertBeanToEntity(PerfilBean bean) {
		PerfilEntity entity = new PerfilEntity();

		entity.setId(bean.getId());

		return entity;
	}

	
	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.entity.AvaliadorEntity)
	 */
	@Override
	public PerfilBean convertEntityToBean(PerfilEntity entity) {
		PerfilBean bean = new PerfilBean();
		
		bean.setId(entity.getId());
		return null;
	}

	@Override
	public List<PerfilBean> convertEntityToBean(List<PerfilEntity> entities) {
		List<PerfilBean> beanList = new ArrayList<>();
		
		for (PerfilEntity e : entities) {
			beanList.add(convertEntityToBean(e));
		}

		return beanList;
	}

}
