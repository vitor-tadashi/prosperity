package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.entity.FuncionalidadeEntity;
import br.com.prosperity.entity.PerfilEntity;

@Component
public class PerfilConverter implements Converter<PerfilEntity, PerfilBean> {
	
	private FuncionalidadeConverter funcionalidadeConverter;
	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.bean.AvaliadorBean)
	 */
	
	@Override
	public PerfilEntity convertBeanToEntity(PerfilBean bean) {
		PerfilEntity entity = new PerfilEntity();
		FuncionalidadeEntity funcionalidade = new FuncionalidadeEntity();
		
		for(FuncionalidadeBean e : bean.getListaFuncionalidades()){
			funcionalidade = funcionalidadeConverter.convertBeanToEntity(e);
		}
		
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setFuncionalidade(funcionalidade);

		return entity;
	}

	
	/* (non-Javadoc)
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.prosperity.entity.AvaliadorEntity)
	 */
	@Override
	public PerfilBean convertEntityToBean(PerfilEntity entity) {
		PerfilBean bean = new PerfilBean();
		
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		//bean.setListaFuncionalidades();
		//TODO realizar converts Funcionalidades e Perfil
		return null;
	}
}
