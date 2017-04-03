package br.com.prosperity.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.AvaliadorDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusVagaDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliadorEntity;
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
	private UsuarioConverter usuarioConverter;

	@Autowired
	private SenioridadeBusiness senioridadeBusinness;

	@Autowired
	private CargoBusiness cargoBusinness;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private StatusVagaDAO statusVagaDAO;
	
	@Autowired
	private AvaliadorDAO avaliadorDAO;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private HttpSession session;

	@Transactional(readOnly = true)
	public List<VagaBean> listar() {

		List<VagaEntity> vagaEntity = vagaDAO.findAll(); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}
	
	@Transactional(readOnly = true)
	public List<VagaBean> listarVagasAtivas() {

		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagasAtivas"); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional
	public List<VagaBean> listarVagaAprovar() {

		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagaAprovar"); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}
	
	@Transactional(readOnly = true)
	public List<VagaBean> filtroVaga(VagaBean vagas) {
		Integer idStatus = 0;
		if (!vagas.getStatus().get(0).getStatus().getNome().equals("")) {
			idStatus = Integer.parseInt(vagas.getStatus().get(0).getStatus().getNome());
		}
		//List<Criterion>li = new ArrayList<>();
		//li.add(Restrictions.between("dataAbertura", null, null));
		List<VagaEntity> vaga = vagaDAO.findByCriteria("nomeVaga", false, Restrictions.like("nomeVaga", "%" + vagas.getNomeVaga() + "%"),
				Restrictions.between("dataAbertura", parseData(vagas.getDataAberturaDe()),  parseData(vagas.getDataAberturaPara()))
				
				);
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vaga);
		return vagaBean;
	}
	
	@Transactional(readOnly = true)
	public List<VagaBean> filtrarVagas(VagaBean vaga) {
		Integer idStatus = 0;
		if (!vaga.getStatus().get(0).getStatus().getNome().equals("")) {
			idStatus = Integer.parseInt(vaga.getStatus().get(0).getStatus().getNome());
		}
		// List<VagaEntity> vagas =
		// vagaDAO.findByNamedQuery("listarVagaFiltrado",
		// "%"+vagao.getNomeVaga()+"%", vagao.getDataAberturaDe(),
		// vagao.getDataAberturaPara(), idStatus);
		List<VagaEntity> vagas = vagaDAO.findByNamedQuery("listarVagaFiltrado", "%" + vaga.getNomeVaga() + "%",
				idStatus, parseData(vaga.getDataAberturaDe()), parseData(vaga.getDataAberturaPara()));

		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagas);
		return vagaBean;

		/*
		 * List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("pesquisar",
		 * vaga); List<VagaBean> vagaBean =
		 * vagaConverter.convertEntityToBean(vagaEntity); return vagaBean;
		 */
	}

	@Transactional(readOnly = true)

	public VagaBean obter(int idVaga) {

		VagaEntity vagaEntity = vagaDAO.findById(idVaga);

		VagaBean vagaBean = vagaConverter.convertEntityToBean(vagaEntity);

		return vagaBean;
	}

	@Transactional
	public void inserir(VagaBean vagaBean /* , HttpSession session */) {
		
		VagaEntity vagaEntity = vagaConverter.convertBeanToEntity(vagaBean);
		
		if (vagaEntity.getId() == null) {
			Date dateNow = new Date();
			/*SenioridadeEntity senioridadeEntity = senioridadeBusinness
					.obterPorId(vagaBean.getSenioridadeBean().getId());
			String senioridade = senioridadeEntity.getNome();
			CargoEntity cargoEntity = cargoBusinness.obterPorId(vagaBean.getCargoBean().getId());
			String cargo = cargoEntity.getNome();
			// String usuario = session.getAttribute("autenticado").getNome();
			vagaBean.setNomeVaga(cargo + " " + senioridade);*/
			vagaBean.setDataAbertura(dateNow);
			// vagaBean.setUsuarioBean(usuario);
			vagaDAO.insert(vagaEntity);
		} else {
			// Date dateNow = new Date();
			/*SenioridadeEntity senioridadeEntity = senioridadeBusinness
					.obterPorId(vagaBean.getSenioridadeBean().getId());
			String senioridade = senioridadeEntity.getNome();
			CargoEntity cargoEntity = cargoBusinness.obterPorId(vagaBean.getCargoBean().getId());
			String cargo = cargoEntity.getNome();
			// String usuario = session.getAttribute("autenticado").getNome();
			vagaBean.setNomeVaga(cargo + " " + senioridade);*/
			vagaBean.setDataAbertura(vagaBean.getDataAbertura()); // VERIFICAR SE DEVE SER DATA DE ALTERAÇÂO
			// vagaBean.setUsuarioBean(usuario);
			vagaDAO.update(vagaEntity);
		}
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

	private Date parseData(Date dataAntiga) {
		SimpleDateFormat novaData = new SimpleDateFormat("yyyy-MM-dd");

		String data = "";
		try {
			data = novaData.format(dataAntiga);
			return novaData.parse(data);
		} catch (ParseException e) {
			e.printStackTrace(); // imprimi a stack trace
		}
		return dataAntiga;
	}

	private void inserirAvaliadores(VagaEntity vaga, List<UsuarioBean> usuarios) {
		for (UsuarioBean usuario : usuarios) {
			AvaliadorEntity avaliadorEntity = new AvaliadorEntity();
			avaliadorEntity.setUsuario(usuarioConverter.convertBeanToEntity(usuario));
			avaliadorEntity.setVaga(vaga);
			avaliadorDAO.insert(avaliadorEntity);
		}
	}
}
