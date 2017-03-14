package br.com.prosperity.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.converter.PerfilConverter;
import br.com.prosperity.dao.FuncionalidadeDAO;
import br.com.prosperity.dao.PerfilDAO;
import br.com.prosperity.entity.FuncionalidadeEntity;
import br.com.prosperity.entity.PerfilEntity;
import br.com.prosperity.exception.BusinessException;

@Component
public class PerfilBusiness {

	@Autowired
	private PerfilDAO perfilDAO;

	@Autowired
	private PerfilConverter perfilConverter;

	@Autowired
	private FuncionalidadeDAO funcionalidadeDAO;

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

			List<FuncionalidadeEntity> listaFuncionalidade = new ArrayList<>();
			for (FuncionalidadeBean f : perfilBean.getListaFuncionalidades()) {
				listaFuncionalidade.add(funcionalidadeDAO.obterPorId(f.getId()));
			}
			perfilEntity.setFuncionalidades(listaFuncionalidade);
			perfilDAO.adicionar(perfilEntity);
		} else {
			throw new BusinessException("Este perfil já existe");
		}
	}

	@Transactional
	public List<PerfilEntity> getPerfis() {
		List<PerfilEntity> perfis = perfilDAO.listar();
		return perfis;
	}

	@Transactional
	public List<PerfilBean> obterTodos() {
		List<PerfilEntity> perfisEntity = perfilDAO.listar();
		List<PerfilBean> perfisBean = perfilConverter.convertEntityToBean(perfisEntity);

		return perfisBean;
	}
}
