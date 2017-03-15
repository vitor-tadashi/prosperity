package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.entity.CandidatoEntity;

@Component
public class CandidatoBusiness{

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private CandidatoBean candidatoBean;
	
	@Autowired
	private ContatoBean contatoBean;
	
	@Autowired
	private CandidatoConverter candidatoConverter;

	public CandidatoBean obter(Integer id) {
		CandidatoEntity candidatoEntity = candidatoDAO.obterPorId(id);
		
		
		if (candidatoEntity != null) {
			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
			candidatoBean.cpfFormat(candidatoBean);
			candidatoBean.rgFormat(candidatoBean);
			candidatoBean.telefoneFormat(contatoBean = candidatoBean.getContato());
		}
		
		return candidatoBean;
	}

	@Transactional
	public List<CandidatoBean> obterTodos() {
		List<CandidatoEntity> entities = candidatoDAO.listar();
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);
		return beans;
	}


	public void inserir(CandidatoBean candiatoBean) {
		
		candidatoDAO.adicionar(candidatoConverter.convertBeanToEntity(candidatoBean));
		
	}
}
