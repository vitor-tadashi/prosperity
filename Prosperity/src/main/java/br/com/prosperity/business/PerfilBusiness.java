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
		if (perfilBean.getId() == null) {
			List<PerfilEntity> listaPerfil = perfilDAO.findByNamedQuery("obterNomePerfil", perfilBean.getNome());
			if (listaPerfil.isEmpty()) {
				PerfilEntity perfilEntity = perfilConverter.convertBeanToEntity(perfilBean);

				List<Integer> idFuncionalidades = new ArrayList<>();
				for (FuncionalidadeBean f : perfilBean.getListaFuncionalidades()) {
					idFuncionalidades.add(f.getId());
				}
				perfilEntity.setFuncionalidades(
						funcionalidadeDAO.findByNamedQuery("obterPerfilFuncionalidade", idFuncionalidades));
				perfilDAO.adicionar(perfilEntity);
			} else {
				throw new BusinessException("Este perfil já existe");
			}
		} else {
			PerfilEntity perfilEntity = perfilDAO.obterPorId(perfilBean.getId());

			List<Integer> idFuncionalidades = new ArrayList<>();
			for (FuncionalidadeBean f : perfilBean.getListaFuncionalidades()) {
				idFuncionalidades.add(f.getId());
			}
			perfilEntity.setFuncionalidades(
					funcionalidadeDAO.findByNamedQuery("obterPerfilFuncionalidade", idFuncionalidades));

			perfilDAO.alterar(perfilEntity);
		}
	}

	@Transactional
	public List<PerfilBean> obterTodos() {
		List<PerfilEntity> perfisEntity = perfilDAO.listar();
		List<PerfilBean> perfisBean = perfilConverter.convertEntityToBean(perfisEntity);

		return perfisBean;
	}
}
