package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.AvaliadorBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.AvaliadorConverter;
import br.com.prosperity.dao.AvaliadorDAO;
import br.com.prosperity.entity.AvaliadorEntity;

@Component
public class AvaliadorBusiness {

	@Autowired
	private AvaliadorDAO avaliadorDAO;
	
	@Autowired
	private AvaliadorConverter avaliadorConverter;

	private AvaliadorBean obter(Integer idAvaliador) {
		
		AvaliadorEntity avaliadorEntity = avaliadorDAO.obterPorId(idAvaliador);
		
		AvaliadorBean avaliadorBean = avaliadorConverter.convertEntityToBean(avaliadorEntity);
		
		return avaliadorBean;		
	}

	@Transactional
	public List<AvaliadorBean> listar() {
		List<AvaliadorBean> avaliadores = avaliadorConverter.convertEntityToBean(avaliadorDAO.listar());
		return avaliadores;
	}
}
