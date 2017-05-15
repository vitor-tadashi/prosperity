package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.converter.PropostaConverter;
import br.com.prosperity.dao.PropostaDAO;

@Component
public class PropostaBusiness {
	
	@Autowired
	private PropostaConverter propostaConverter;
	
	@Autowired
	private PropostaDAO propostaDAO;
	
	@Transactional
	public void salvarProposta(CandidatoBean bean){
		propostaDAO.insert(propostaConverter.convertBeanToEntity(bean.getUltimaProposta()));
	}
}