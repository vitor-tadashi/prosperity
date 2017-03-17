package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.entity.CandidatoEntity;

@Component
public class CandidatoBusiness extends FormatUtil{

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private CandidatoBean candidatoBean;

	@Autowired
	private CandidatoConverter candidatoConverter;

	@Transactional 
	public CandidatoBean obter(Integer id) {
		CandidatoEntity candidatoEntity = candidatoDAO.obterPorId(id);

		if (candidatoEntity != null) {
			ContatoBean contatoBean;
			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
			candidatoBean = formatCPF(candidatoBean);
			candidatoBean = formatRG(candidatoBean);
			candidatoBean.setContato(formatPhone(candidatoBean.getContato()));
		}

		return candidatoBean;
	}

	@Transactional
	public List<CandidatoBean> obterTodos() {
		List<CandidatoEntity> entities = candidatoDAO.listar();
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);
		return beans;
	}

	@Transactional
	public void inserir(CandidatoBean candidatoBean) {
		
		candidatoDAO.adicionar(candidatoConverter.convertBeanToEntity(candidatoBean));
		
	}
}
