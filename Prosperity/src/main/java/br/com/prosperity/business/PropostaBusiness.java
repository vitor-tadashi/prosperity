package br.com.prosperity.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.PropostaBean;
import br.com.prosperity.converter.PropostaConverter;
import br.com.prosperity.dao.PropostaDAO;

@Component
public class PropostaBusiness {

	@Autowired
	private PropostaDAO propostaDAO;
	
	@Autowired
	private PropostaConverter propostaConverter;
	
	@Transactional
	public void inserir(PropostaBean beans) {
			propostaDAO.insert(propostaConverter.convertBeanToEntity(beans));
	}
}
