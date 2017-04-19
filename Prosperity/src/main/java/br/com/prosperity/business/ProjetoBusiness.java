package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.converter.ProjetoConverter;
import br.com.prosperity.dao.ProjetoDAO;
import br.com.prosperity.entity.ProjetoEntity;

@Component
public class ProjetoBusiness {
	
	@Autowired
	private ProjetoDAO projetoDAO;
			
	@Autowired
	private ProjetoConverter projetoConverter;
	
	@Transactional(readOnly=true)
	public List<ProjetoBean> obterTodos(){
		List<ProjetoEntity> projetoEntity = projetoDAO.findAll();
		List<ProjetoBean> projetoBean = projetoConverter.convertEntityToBean(projetoEntity);
		return projetoBean;
	}
	
	@Transactional
	public List<ProjetoBean> buscarProjetoAtivo(){
		List<ProjetoEntity> projetoEntity = projetoDAO.findByNamedQuery("obterProjetosAtivos");
		List<ProjetoBean> projetoBean = projetoConverter.convertEntityToBean(projetoEntity);
		return projetoBean;
	}
	
	@Transactional
	public List<ProjetoBean> obterCliente(Integer id){
		List<ProjetoEntity> projetoEntity = projetoDAO.findByNamedQuery("obterCliente", id);
		List<ProjetoBean> projetoBean = projetoConverter.convertEntityToBean(projetoEntity);
		return projetoBean;
	}

}
