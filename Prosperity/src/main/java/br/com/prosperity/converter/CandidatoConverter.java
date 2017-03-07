package br.com.prosperity.converter;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.entity.CandidatoEntity;


public class CandidatoConverter implements Converter<CandidatoEntity, CandidatoBean> {
	
	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.bean.CandidatoBean)
	 */
	@Override
	public CandidatoEntity convertBeanToEntity(CandidatoBean bean) {
		CandidatoEntity entity = new CandidatoEntity();
		
		entity.setId(bean.getIdCandidato());
		
		
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.entity.CandidatoEntity)
	 */
	@Override
	public CandidatoBean convertEntityToBean(CandidatoEntity entity) {
		CandidatoBean bean = new CandidatoBean();
		
		bean.setIdCandidato(entity.getId());
		
		
		return bean;
	}
}