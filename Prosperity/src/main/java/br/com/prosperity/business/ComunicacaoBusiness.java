package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.ComunicacaoBean;
import br.com.prosperity.converter.ComunicacaoConverter;
import br.com.prosperity.dao.ComunicacaoDAO;
import br.com.prosperity.entity.ComunicacaoEntity;

@Component
public class ComunicacaoBusiness {

	@Autowired
	ComunicacaoDAO comunicacaoDAO;

	@Autowired
	ComunicacaoConverter comunicacaoConverter;

	@Transactional
	public List<ComunicacaoBean> listarDataComunicacao(Integer idCandidato) {
		List<ComunicacaoEntity> comunicacaoEntity = comunicacaoDAO.findByNamedQuery("obterComunicacao", idCandidato);
		List<ComunicacaoBean> comunicacaoBean = comunicacaoConverter.convertEntityToBean(comunicacaoEntity);

		return comunicacaoBean;
	}
}