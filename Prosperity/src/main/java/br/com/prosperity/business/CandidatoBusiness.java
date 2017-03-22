package br.com.prosperity.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.dao.StatusCandidatoDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusFuturoDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.entity.StatusCandidatoEntity;
import br.com.prosperity.entity.StatusFuturoEntity;
import br.com.prosperity.util.FormatUtil;

@Component
public class CandidatoBusiness extends FormatUtil {

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private CandidatoConverter candidatoConverter;

	@Autowired
	private StatusCandidatoDAO statusCandidatoDAO;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private StatusFuturoDAO statusFuturoDAO;

	@Transactional
	public CandidatoBean obter(Integer id) {
		CandidatoEntity candidatoEntity = candidatoDAO.obterPorId(id);
		CandidatoBean candidatoBean = new CandidatoBean();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM/yyyy");

		if (candidatoEntity != null) {
			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
			candidatoBean = formatCPF(candidatoBean);
			candidatoBean = formatRG(candidatoBean);
			candidatoBean.setContato(formatPhone(candidatoBean.getContato()));
		}

		Map<String, List<StatusCandidatoBean>> listaStatusOrdenada = groupByOrdered(candidatoBean.getStatus(),
				StatusCandidatoBean::getMesAno);
		
		candidatoBean.setStatusPorMesAno(listaStatusOrdenada);
		
		return candidatoBean;
	}

	private static <K, V> Map<K, List<V>> groupByOrdered(List<V> list, Function<V, K> keyFunction) {
		return list.stream().collect(Collectors.groupingBy(keyFunction, LinkedHashMap::new, Collectors.toList()));
	}

	@Transactional
	public List<CandidatoBean> listar() {
		List<CandidatoEntity> entities = candidatoDAO.listar();
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);
		return beans;
	}

	public void inserir(CandidatoBean candiatoBean) {
		CandidatoBean candidatoBean = new CandidatoBean();
		candidatoDAO.adicionar(candidatoConverter.convertBeanToEntity(candidatoBean));

	}

	@Transactional
	public void alterarStatus(SituacaoCandidatoBean situacaoCandidato, HttpSession session) {
		StatusCandidatoEntity statusCandidatoEntity = new StatusCandidatoEntity();

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");

		List<StatusFuturoEntity> statusFuturoEntity = statusFuturoDAO.findByNamedQuery("obterStatusFuturos",
				situacaoCandidato.getStatus().getValue());
		if (statusFuturoEntity != null) {
			if (statusFuturoEntity.size() > 1) {
				if (usuarioBean.getPerfil().getNome().equals("RH")){
						statusCandidatoEntity.setStatus(statusDAO.obterPorId(statusFuturoEntity.get(0).getIdStatusFuturo()));
				}else{
						statusCandidatoEntity.setStatus(statusDAO.obterPorId(statusFuturoEntity.get(1).getIdStatusFuturo()));
				}
			}else{
				for (StatusFuturoEntity sfe : statusFuturoEntity) {
					statusCandidatoEntity.setStatus(statusDAO.obterPorId(sfe.getIdStatusFuturo()));
				}
			}
		} else {
			statusCandidatoEntity.setStatus(statusDAO.obterPorId(situacaoCandidato.getStatus().getValue()));
		}

		statusCandidatoEntity.setIdCandidato(situacaoCandidato.getIdCandidato());
		statusCandidatoEntity.setDsParecer(situacaoCandidato.getParecer());
		statusCandidatoEntity.setDtAlteracao(new Date());
		statusCandidatoEntity.setUsuario(usuarioDAO.obterPorId(usuarioBean.getId()));

		statusCandidatoDAO.adicionar(statusCandidatoEntity);
		// PASSO 2 - PEGAR O STATUSFUTURO e SALVAR NO BANCO
	}
}
