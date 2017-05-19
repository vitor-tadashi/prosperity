package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.converter.CandidatoCompetenciaConverter;
import br.com.prosperity.dao.CandidatoCompetenciaDAO;
import br.com.prosperity.entity.CandidatoCompetenciaEntity;

@Component
public class CandidatoCompetenciaBusiness {

	@Autowired
	CandidatoCompetenciaDAO ccDAO;

	@Autowired
	CandidatoCompetenciaConverter ccConverter;

	@Autowired
	List<CandidatoCompetenciaBean> ccBean;

	@Transactional
	public List<CandidatoCompetenciaBean> listarCompetencia() {
		List<CandidatoCompetenciaEntity> cce = ccDAO.findAll();
		ccBean = ccConverter.convertEntityToBean(cce);
		return ccBean;
	}

	@Transactional
	public void inserirCompetencias(List<CandidatoCompetenciaBean> competencias, Integer idCandidato) {
		for (CandidatoCompetenciaBean competencia : competencias) {
			competencia.setIdCandidato(idCandidato);
			ccDAO.insert(ccConverter.convertBeanToEntity(competencia));
		}
	}
}
