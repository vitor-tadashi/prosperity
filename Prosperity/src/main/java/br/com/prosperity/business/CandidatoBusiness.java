package br.com.prosperity.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.entity.CandidatoEntity;

@Component
public class CandidatoBusiness {

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private CandidatoBean candidatoBean;
	
	@Autowired
	private CandidatoConverter candidatoConverter;

	public CandidatoBean obter(Integer id) {
		CandidatoEntity candidatoEntity = candidatoDAO.obterPorId(id);
		
		if (candidatoEntity != null) {
			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
		}
		
		return candidatoBean;
	}

	public void obterTodos() {
		List<CandidatoEntity> entities = new ArrayList<>();
		entities = candidatoDAO.listar();
	}
}
