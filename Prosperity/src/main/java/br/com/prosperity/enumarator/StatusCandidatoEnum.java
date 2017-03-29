package br.com.prosperity.enumarator;

import java.util.HashMap;

public enum StatusCandidatoEnum {
	CANDIDATURA(3),
	CANDIDATOEMANALISE(4),
	CANDIDATOAPROVADO(5),
	CANDIDATOREPROVADO(6),
	CANDIDATOCANCELADO(7),
	RETOMADO(8),
	PROPOSTACANDIDATO(9),
	PROPOSTAACEITA(10),
	PROPOSTARECUSADA(11),
	REFAZERPROPOSTA(13),
	CONTRATADO(14),
	ACEITO(15),
	CANCELADO(21);

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
