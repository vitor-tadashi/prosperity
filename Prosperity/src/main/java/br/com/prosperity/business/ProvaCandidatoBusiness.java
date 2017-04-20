package br.com.prosperity.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProvaCandidatoBean;
import br.com.prosperity.converter.ProvaCandidatoConverter;
import br.com.prosperity.dao.ProvaCandidatoDAO;

@Component
public class ProvaCandidatoBusiness {
	@Autowired
	private ProvaCandidatoDAO provaCandidatoDAO;

	@Autowired
	private ProvaCandidatoConverter provaCandidatoConverter;

	@Transactional
	public void inserir(ProvaCandidatoBean provaCandidato) {
		provaCandidatoDAO.insert(provaCandidatoConverter.convertBeanToEntity(provaCandidato));
	}
}
