package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.business.CandidatoBusiness;

@Controller
@RequestMapping(value="candidato")
public class CandidatoController {
	
	@Autowired
	private CandidatoBusiness candidatoBusiness;

	private String teste;
	
	@RequestMapping(value ="cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato() {
		return "candidato/cadastrar-candidato";
	}
	
	@RequestMapping(value ="consultar-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH(Model model) {
		
		List<CandidatoBean> candidatos = new ArrayList<>();
		candidatoBusiness.obterTodos();
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
		candidatoBean = candidatoBusiness.obter(1);
		model.addAttribute("candidato", candidatoBean);
		
		return "candidato/historico-candidato";
	}
}
