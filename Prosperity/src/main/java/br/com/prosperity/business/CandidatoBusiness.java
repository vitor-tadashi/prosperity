package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.converter.CanalInformacaoConverter;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.dao.CanalInformacaoDAO;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.dao.FormacaoDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.CanalInformacaoEntity;
import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.entity.FormacaoEntity;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.util.FormatUtil;

@Component
public class CandidatoBusiness extends FormatUtil{

	@Autowired
	private FormacaoDAO formacaoDAO;
	@Autowired
	private CandidatoDAO candidatoDAO;
	@Autowired
	private CandidatoConverter candidatoConverter;
	@Autowired
	private CanalInformacaoDAO canalInformacaoDAO;
	@Autowired
	private VagaDAO vagaDAO;
	@Autowired
	private CanalInformacaoConverter canalInformacaoConverter;
	

	@Transactional
	public CandidatoBean obter(Integer id) {
		CandidatoEntity candidatoEntity = candidatoDAO.obterPorId(id);

		CandidatoBean candidatoBean = null;
		if (candidatoEntity != null) {
			ContatoBean contatoBean;
			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
			candidatoBean = formatCPF(candidatoBean);
			candidatoBean = formatRG(candidatoBean);
			candidatoBean.setContato(formatPhone(candidatoBean.getContato()));
		}

		return candidatoBean;
	}

	@Transactional
	public FormacaoEntity obterPorId(Integer id) {
		FormacaoEntity formacaoEntity = formacaoDAO.obterPorId(id);
		return formacaoEntity;

	}
	@Transactional
	public CanalInformacaoEntity obterCanal(Integer id){
		CanalInformacaoEntity canalInformacaoEntity = canalInformacaoDAO.obterPorId(id);
		return canalInformacaoEntity;
	}
	@Transactional
	public VagaEntity obterNomeVaga(Integer id){
		VagaEntity vagaEntity = vagaDAO.obterPorId(id);
		return vagaEntity;
	}

	@Transactional
	public List<CandidatoBean> obterTodos() {
		List<CandidatoEntity> entities = candidatoDAO.listar();
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);
		return beans;
	}

	@Transactional
	public void inserir(CandidatoBean candidatoBean) {
		candidatoDAO.adicionar(candidatoConverter.convertBeanToEntity(candidatoBean));

	}
	@Transactional
	public List<CanalInformacaoBean> obterLista(){

		List<CanalInformacaoBean> listaCanal = canalInformacaoConverter.convertEntityToBean(canalInformacaoDAO.listar());

		return listaCanal;
	}
}
