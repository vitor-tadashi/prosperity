package br.com.prosperity.enumarator;

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
	PROPOSTACANCELADA(12),
	REFAZERPROPOSTA(13),
	CONTRATADO(14),
	CANCELADO(17);

	private int value;

	StatusCandidatoEnum(int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

}
