package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.converter.PerfilConverter;
import br.com.prosperity.dao.PerfilDAO;
import br.com.prosperity.entity.PerfilEntity;
import br.com.prosperity.exception.BusinessException;

@Component
public class PerfilBusiness {

	@Autowired
	private PerfilDAO perfilDAO;

	@Autowired
	private PerfilConverter perfilConverter;

	private PerfilBean obter(Integer idPerfil) {

		PerfilEntity perfilEntity = perfilDAO.obterPorId(idPerfil);

		PerfilBean perfilBean = perfilConverter.convertEntityToBean(perfilEntity);

		return perfilBean;
	}

	@Transactional
	public void inserir(PerfilBean perfilBean) throws BusinessException {
		List<PerfilEntity> listaPerfil = perfilDAO.findByNamedQuery("obterNomePerfil", perfilBean.getNome());
		if (listaPerfil.isEmpty()) {
			PerfilEntity perfilEntity = perfilConverter.convertBeanToEntity(perfilBean);
			perfilDAO.adicionar(perfilEntity);
		} else {
			throw new BusinessException("Este perfil já existe");
		}
	}

	@Transactional
	public List<PerfilBean> getPerfis() {
		List<PerfilBean> perfis = perfilConverter.convertEntityToBean(perfilDAO.listar());
		return perfis;
	}
}
