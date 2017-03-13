package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.business.TipoCursoBusiness;

@Controller
@RequestMapping(value="candidato")
public class CandidatoController {
	
	@Autowired
	private CandidatoBusiness candidatoBusiness;
	
	@Autowired
	private EnderecoBean enderecoBean;

	@Autowired
	private TipoCursoBusiness tipoCursoBusiness;
	

	private String teste;
	
	@RequestMapping(value ="cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato(Model model) {
		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.getTipoCurso();
		model.addAttribute("tiposCurso", tiposCurso);
		return "candidato/cadastrar-candidato";
	}
	
	@RequestMapping(value ="consultar-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH(Model model) {

		List<CandidatoBean> candidatos = candidatoBusiness.obterTodos();
		model.addAttribute("candidatos", candidatos);
		return "candidato/consulta-rh";
	}
	
	@RequestMapping(value ="consultar-gestor", method = RequestMethod.GET)
	public String consultarCandidatoGestor() {
		return "candidato/consulta-gestor";
	}
	
	@RequestMapping(value ="historico", method = RequestMethod.GET)
	public String historicoCandidato(Model model) {
		CandidatoBean candidatoBean = new CandidatoBean();
		candidatoBean = candidatoBusiness.obter(2);
		
		enderecoBean = candidatoBean.getEndereco();
		
		model.addAttribute("candidato", candidatoBean);
		model.addAttribute("endereco", enderecoBean);
		
		return "candidato/historico-candidato";
	}



	
	
	
	
}
