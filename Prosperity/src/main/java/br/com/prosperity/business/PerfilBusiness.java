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

	@Transactional
	public void inserir(PerfilBean perfilBean) throws BusinessException {
		if (perfilBean.getListaFuncionalidades().isEmpty()) {
			throw new BusinessException("Selecione uma funcionalidade para o perfil");
		}
		if (perfilBean.getId() == null) {
			if (perfilBean.getNome().isEmpty() || perfilBean.getNome() == null) {
				throw new BusinessException("Preencha um nome para o perfil");
			}
			List<PerfilEntity> listaPerfil = perfilDAO.findByNamedQuery("obterNomePerfil", perfilBean.getNome());
			if (listaPerfil.isEmpty()) {
				PerfilEntity perfilEntity = perfilConverter.convertBeanToEntity(perfilBean);
				perfilEntity.setFuncionalidades(obterPerfilFuncionalidadeEntity(perfilBean.getListaFuncionalidades()));

				perfilDAO.insert(perfilEntity);
			} else {
				throw new BusinessException("Um perfil com este nome ja esta cadastrado");
			}
		} else {
			PerfilEntity perfilEntity = perfilDAO.findById(perfilBean.getId());
			perfilEntity.setFuncionalidades(obterPerfilFuncionalidadeEntity(perfilBean.getListaFuncionalidades()));

			perfilDAO.update(perfilEntity);
		}
	}

	@Transactional(readOnly = true)
	private List<FuncionalidadeEntity> obterPerfilFuncionalidadeEntity(List<FuncionalidadeBean> lista) {
		List<Integer> idFuncionalidades = new ArrayList<>();
		for (FuncionalidadeBean f : lista) {
			if (f.getId() != null) {
				idFuncionalidades.add(f.getId());
			}
		}
		return funcionalidadeDAO.findByNamedQuery("obterPerfilFuncionalidade", idFuncionalidades);
	}

	@Transactional(readOnly = true)
	public List<PerfilBean> listar() {
		List<PerfilEntity> perfisEntity = perfilDAO.findByNamedQuery("obterPerfis");
		List<PerfilBean> perfisBean = perfilConverter.convertEntityToBean(perfisEntity);

		return perfisBean;
	}

	@Transactional(readOnly = true)
	public List<FuncionalidadeBean> obterPerfilFuncionalidades(Integer id) {
		PerfilEntity entity = perfilDAO.findById(id);
		PerfilBean bean = perfilConverter.convertEntityToBean(entity);
		List<FuncionalidadeBean> listaFunc = bean.getListaFuncionalidades();

		return listaFunc;
	}
}
