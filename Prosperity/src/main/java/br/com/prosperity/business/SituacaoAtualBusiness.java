package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.converter.SituacaoAtualConverter;
import br.com.prosperity.dao.SituacaoAtualDAO;

@Component
public class SituacaoAtualBusiness {
	@Autowired
	private SituacaoAtualDAO situacaoAtualDAO;
	@Autowired
	private SituacaoAtualConverter situacaoAtualConverter;

	@Transactional
	public List<SituacaoAtualBean> getSituacaoAtual() {
		List<SituacaoAtualBean> situacaoAtual = situacaoAtualConverter.convertEntityToBean(situacaoAtualDAO.listar());
		
		return situacaoAtual;
	}

}
