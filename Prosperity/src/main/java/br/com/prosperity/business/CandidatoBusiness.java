package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.entity.CandidatoEntity;

@Component
public class CandidatoBusiness {

	@Autowired
	private CandidatoDAO candidatoDAO;
	
	public CandidatoBean obter(int id) {
		CandidatoEntity candidatoEntity = candidatoDAO.obterPorId(id);
		return null;
	}



}
