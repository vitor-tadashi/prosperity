package br.com.prosperity.converter;

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
		return null;
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

}
