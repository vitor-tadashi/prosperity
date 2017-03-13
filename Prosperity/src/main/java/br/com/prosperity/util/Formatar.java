package br.com.prosperity.util;

import br.com.prosperity.bean.CandidatoBean;

public abstract class Formatar {

	public CandidatoBean cpfFormat(CandidatoBean candidatoBean) {

		String bloco1 = candidatoBean.getCpf().substring(0, 3);
		String bloco2 = candidatoBean.getCpf().substring(3, 6);
		String bloco3 = candidatoBean.getCpf().substring(6, 9);
		String bloco4 = candidatoBean.getCpf().substring(9, 11);

		candidatoBean.setCpf(String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4));
		return candidatoBean;
	}
	
	public CandidatoBean rgFormat(CandidatoBean candidatoBean) {

		String bloco1 = candidatoBean.getRg().substring(0, 2);
		String bloco2 = candidatoBean.getRg().substring(2, 5);
		String bloco3 = candidatoBean.getRg().substring(5, 8);
		String bloco4 = candidatoBean.getRg().substring(8, 9);

		candidatoBean.setRg(String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4));
		return candidatoBean;
	}
}
