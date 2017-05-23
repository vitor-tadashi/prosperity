package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.VagaEntity;

@Component
public class RelatorioBusiness {

	@Autowired
	private VagaDAO vagaDAO;

	@Transactional(readOnly = true)
	public List<VagaEntity> listarVagas() {
		List<VagaEntity> vagas = vagaDAO.findAll();
		return vagas;
	}
}