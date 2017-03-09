package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.converter.PerfilConverter;
import br.com.prosperity.dao.PerfilDAO;
import br.com.prosperity.entity.PerfilEntity;
@Component
public class PerfilBusiness {

	@Autowired
	private PerfilDAO perfilDAO;
	
	@Autowired
	private PerfilConverter perfilConverter;
	
	private PerfilBean obter(int idPerfil){
		
		PerfilEntity perfilEntity = perfilDAO.obterPorId(idPerfil);
		
		PerfilBean perfilBean = perfilConverter.convertEntityToBean(perfilEntity);
		
		return perfilBean;
	}

	public void inserir(PerfilBean perfilBean) {
		PerfilEntity perfilEntity = perfilConverter.convertBeanToEntity(perfilBean);
		perfilDAO.adicionar(perfilEntity);
	}
}
