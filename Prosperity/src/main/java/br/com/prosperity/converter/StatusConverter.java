package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.entity.StatusEntity;

@Component
public class StatusConverter implements Converter<StatusEntity, StatusBean> {
	
	@Autowired
	private TipoStatusConverter tipoStatusConverter;
	
	@Override
	public StatusEntity convertBeanToEntity(StatusBean bean) {
		// TODO Auto-generated method stub
		StatusEntity entity = new StatusEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setTipoCss(bean.getCss());
		entity.setTipoStatus(tipoStatusConverter.convertBeanToEntity(bean.getTipo()));
		return entity;
	}

	@Override
	public StatusBean convertEntityToBean(StatusEntity entity) {
		StatusBean bean = new StatusBean();
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setCss(entity.getTipoCss());
		bean.setTipo(tipoStatusConverter.convertEntityToBean(entity.getTipoStatus()));
		return bean;
	}
}
