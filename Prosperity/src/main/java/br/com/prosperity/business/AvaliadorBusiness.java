package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.prosperity.bean.AvaliadorBean;
import br.com.prosperity.converter.AvaliadorConverter;
import br.com.prosperity.dao.AvaliadorDAO;
import br.com.prosperity.entity.AvaliadorEntity;

public class AvaliadorBusiness {

	@Autowired
	private AvaliadorDAO avaliadorDAO;
	
	@Autowired
	private AvaliadorConverter avaliadorConverter;

	private AvaliadorBean obter(int idAvaliador) {
		
		AvaliadorEntity avaliadorEntity = avaliadorDAO.obterPorId(idAvaliador);
		
		AvaliadorBean avaliadorBean = avaliadorConverter.convertEntityToBean(avaliadorEntity);
		
		return avaliadorBean;		
	}
}
