package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.converter.CanalInformacaoConverter;
import br.com.prosperity.dao.CanalInformacaoDAO;

@Component
public class CanalInformacaoBusiness {
	
	@Autowired
	private CanalInformacaoConverter canalInformacaoConverter;
	
	@Autowired
	private CanalInformacaoDAO canalInformacaoDAO;

	@Transactional
	public List<CanalInformacaoBean> obterTodos() {
		List<CanalInformacaoBean> listaCanal = canalInformacaoConverter
				.convertEntityToBean(canalInformacaoDAO.findAll());

		return listaCanal;
	}
}