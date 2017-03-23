package br.com.prosperity.business;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.CanalInformacaoConverter;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.util.FormatUtil;

@Component
public class CandidatoBusiness extends FormatUtil {

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private CandidatoConverter candidatoConverter;

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
	@Transactional
	public void inserir(CandidatoBean candiatoBean) {
		CandidatoBean candidatoBean = new CandidatoBean();
		candidatoDAO.adicionar(candidatoConverter.convertBeanToEntity(candidatoBean));

	}
	
	@Transactional
	public CandidatoBean obterCandidatoPorId(Integer id) {
		CandidatoBean bean = candidatoConverter.convertEntityToBean(candidatoDAO.obterPorId(id));
		return bean;
}

}
