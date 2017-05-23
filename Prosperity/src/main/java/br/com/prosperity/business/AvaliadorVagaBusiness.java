package br.com.prosperity.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.AvaliadorVagaBean;
import br.com.prosperity.converter.AvaliadorVagaConverter;
import br.com.prosperity.dao.AvaliadorVagaDAO;
import br.com.prosperity.entity.AvaliadorVagaEntity;

@Component
public class AvaliadorVagaBusiness {

	@Autowired
	public AvaliadorVagaConverter avaliadorVagaConverter;

	@Autowired
	public AvaliadorVagaDAO avaliadorVagaDAO;

	@Transactional
	public List<AvaliadorVagaBean> obterAvaliador(Integer id) {
		List<AvaliadorVagaEntity> avaliadorVagaEntity = avaliadorVagaDAO.findByNamedQuery("queryAvaliador", id);
		List<AvaliadorVagaBean> avaliadorVagaBean = avaliadorVagaConverter.convertEntityToBean(avaliadorVagaEntity);

		return avaliadorVagaBean;
	}
}