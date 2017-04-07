package br.com.prosperity.enumarator;

import java.util.HashMap;

public enum StatusCandidatoEnum {
	CANDIDATURA(5),
	CANDIDATOEMANALISE(6),
	CANDIDATOAPROVADO(7),
	CANDIDATOREPROVADO(8),
	GERARPROPOSTA(9),
	PROPOSTACANDIDATO(10),
	PROPOSTAACEITA(11),
	PROPOSTARECUSADA(13),
	REFAZERPROPOSTA(14),
	CONTRATADO(15),
	CANCELADO(17),
	RETOMADO(18);

	private Integer value;
	private static HashMap<Integer, StatusCandidatoEnum> map = new HashMap<Integer, StatusCandidatoEnum>();
	
	StatusCandidatoEnum(Integer newValue) {
		value = newValue;
	}
	
	static {
        for (StatusCandidatoEnum pageType : StatusCandidatoEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static StatusCandidatoEnum valueOf(Integer statusCandidatoEnum) {
        return map.get(statusCandidatoEnum);
    }

	public Integer getValue() {
		return value;
	}

}
