package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.com.prosperity.bean.CancelamentoBean;
import br.com.prosperity.converter.CancelamentoConverter;
import br.com.prosperity.dao.CancelamentoDAO;
import br.com.prosperity.entity.CancelamentoEntity;

@Component
public class CancelamentoBusiness {
	
	@Autowired
	private CancelamentoDAO cancelamentoDAO;
	
	@Autowired
	private CancelamentoConverter cancelamentoConverter;

	@Transactional
	public List<CancelamentoBean> listar() {
		List<CancelamentoEntity> cancelamentoEntity = cancelamentoDAO.findAll();
		List<CancelamentoBean> cancelamentos = cancelamentoConverter.convertEntityToBean(cancelamentoEntity);
		return cancelamentos;
	}
}
