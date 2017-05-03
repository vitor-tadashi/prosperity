package br.com.prosperity.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProvaCandidatoBean;
import br.com.prosperity.converter.ProvaCandidatoConverter;
import br.com.prosperity.dao.ProvaCandidatoDAO;
import br.com.prosperity.entity.ProvaCandidatoEntity;

@Component
public class ProvaCandidatoBusiness {
	@Autowired
	private ProvaCandidatoDAO provaCandidatoDAO;

	@Autowired
	private ProvaCandidatoConverter provaCandidatoConverter;

	@Transactional
	public void inserir(List<ProvaCandidatoBean> provas) {
		List<ProvaCandidatoEntity> provasCandidatoEntity = provaCandidatoConverter.convertBeanToEntity(provas);
		for (ProvaCandidatoEntity provaCandidato : provasCandidatoEntity) {
			provaCandidatoDAO.insert(provaCandidato);
		}
	}

	@Transactional
	public List<ProvaCandidatoBean> obterProva(Integer id) {
		List<ProvaCandidatoEntity> provasCandidatoEntity = provaCandidatoDAO.findByNamedQuery("queryProva", id);
		// ProvaCandidatoEntity provaCandidatoEntity = new
		// ProvaCandidatoEntity();

		// provaCandidatoEntity.setProvas(provasCandidatoEntity.get(0).getProvas());
		// provaCandidatoEntity.setDescricaoProva(provasCandidatoEntity.get(0).getDescricaoProva());
		// ProvaCandidatoBean provaCandidatoBean =
		// provaCandidatoConverter.convertEntityToBean(provaCandidatoEntity);
		List<ProvaCandidatoBean> provasCandidatoBean = provaCandidatoConverter
				.convertEntityToBean(provasCandidatoEntity);
		// provasCandidatoBean.add(provaCandidatoBean);
		return provasCandidatoBean;
	}
}
