package br.com.prosperity.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusVagaDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.CargoEntity;
import br.com.prosperity.entity.SenioridadeEntity;
import br.com.prosperity.entity.StatusVagaEntity;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaBusiness {

	@Autowired
	private VagaDAO vagaDAO;

	@Autowired
	private VagaConverter vagaConverter;

	@Autowired
	private SenioridadeBusiness senioridadeBusinness;

	@Autowired
	private CargoBusiness cargoBusinness;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private StatusVagaDAO statusVagaDAO;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private HttpSession session;

	@Transactional
	public List<VagaBean> listar() {

		List<VagaEntity> vagaEntity = vagaDAO.findAll(); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional
	public List<VagaBean> filtrarVagas(VagaBean vagao) {
		List<VagaEntity> vagas = vagaDAO.findByNamedQuery("listarVagaFiltrado", "%" + vagao.getNomeVaga() + "%",
				vagao.getDataAberturaDe(), vagao.getDataAberturaPara());
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagas);
		return vagaBean;

		/*
		 * List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("pesquisar",
		 * vaga); List<VagaBean> vagaBean =
		 * vagaConverter.convertEntityToBean(vagaEntity); return vagaBean;
		 */
	}

	@Transactional

	public VagaBean obter(int idVaga) {

		VagaEntity vagaEntity = vagaDAO.findById(idVaga);

		VagaBean vagaBean = vagaConverter.convertEntityToBean(vagaEntity);

		return vagaBean;
	}

	@Transactional
	public void inserir(VagaBean vagaBean /* , HttpSession session */) {

		Date dateNow = new Date();

		SenioridadeEntity senioridadeEntity = senioridadeBusinness.obterPorId(vagaBean.getSenioridadeBean().getId());
		String senioridade = senioridadeEntity.getNome();

		CargoEntity cargoEntity = cargoBusinness.obterPorId(vagaBean.getCargoBean().getId());
		String cargo = cargoEntity.getNome();

		// String usuario = session.getAttribute("autenticado").getNome();
		vagaBean.setNomeVaga(cargo + " " + senioridade);

		vagaBean.setDataAbertura(dateNow);

		// vagaBean.setUsuarioBean(usuario);
		vagaDAO.insert(vagaConverter.convertBeanToEntity(vagaBean));
	}

	@Transactional
	public VagaBean obterVagaPorId(Integer id) {
		VagaBean bean = vagaConverter.convertEntityToBean(vagaDAO.findById(id));
		return bean;
	}

	public Date formatarHora(String hora) throws ParseException {
		String myDateString = hora;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = sdf.parse(myDateString);
		return date;
	}

	@Transactional
	public void alterarStatus(SituacaoVagaBean situacaoVaga) {
		StatusVagaEntity statusVagaEntity = new StatusVagaEntity();

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		statusVagaEntity.setStatus(statusDAO.findById(situacaoVaga.getStatus().getValue()));
		statusVagaEntity.setVaga(situacaoVaga.getIdVaga());
		statusVagaEntity.setDataAlteracao(new Date());
		statusVagaEntity.setUsuario(usuarioDAO.findById(usuarioBean.getId()));

		statusVagaDAO.insert(statusVagaEntity);
	}
}

// criar método consultarVagasAprovacao
// chamar o dao e acionar o método findByNamedQuery
// pegar todas as vagas que estão disponíves por perfil para aprovação (ou por
// enquanto pegue todas as vagas disponíveis)
// retornar uma lista de VagaBean
