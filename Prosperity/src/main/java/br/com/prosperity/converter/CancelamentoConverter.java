package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CancelamentoBean;
import br.com.prosperity.entity.CancelamentoEntity;

@Component
public class CancelamentoConverter  implements Converter<CancelamentoEntity, CancelamentoBean> {

	@Override
	public CancelamentoEntity convertBeanToEntity(CancelamentoBean bean) {
		CancelamentoEntity entity = new CancelamentoEntity();
		entity.setId(bean.getId());
		entity.setDescricao(bean.getDescricao());
		
		return entity;
	}

	@Override
	public CancelamentoBean convertEntityToBean(CancelamentoEntity entity) {
		CancelamentoBean bean = new CancelamentoBean();
		bean.setId(entity.getId());
		bean.setDescricao(entity.getDescricao());
		return bean;
	}

}
