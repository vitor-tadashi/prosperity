package br.com.prosperity.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.CanalInformacaoConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.CanalInformacaoDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.CanalInformacaoEntity;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaBusiness {

	@Autowired
	private VagaDAO vagaDAO;
	
	@Autowired
	private VagaConverter vagaConverter;

	@Transactional
	public List<VagaBean> listar() {
		List<VagaEntity> vagaEntity = vagaDAO.listar();
        List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}
	
	@Transactional
	public VagaBean obter(int idVaga) {

		VagaEntity vagaEntity = vagaDAO.obterPorId(idVaga);

		VagaBean vagaBean = vagaConverter.convertEntityToBean(vagaEntity);

		return vagaBean;
	}

	public void inserir(VagaBean vagaBean) {
		vagaDAO.adicionar(vagaConverter.convertBeanToEntity(vagaBean));
	}
	@Transactional
	public VagaBean obterVagaPorId(Integer id) {
		VagaBean bean = vagaConverter.convertEntityToBean(vagaDAO.obterPorId(id));
		return bean;
}}

// criar método consultarVagasAprovacao
// chamar o dao e acionar o método findByNamedQuery
// pegar todas as vagas que estão disponíves por perfil para aprovação (ou por
// enquanto pegue todas as vagas disponíveis)
// retornar uma lista de VagaBean
