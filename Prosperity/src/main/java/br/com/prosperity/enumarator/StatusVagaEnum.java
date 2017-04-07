package br.com.prosperity.enumarator;

import java.util.HashMap;

public enum StatusVagaEnum {
	ACEITO(1),
	RECUSADO(2),
	CANCELADO(3),
	PENDENTE(4);
	
	private Integer value;
	private static HashMap<Integer, StatusVagaEnum> map = new HashMap<Integer, StatusVagaEnum>();
	
	StatusVagaEnum(Integer newValue) {
		value = newValue;
	}
	
	static {
        for (StatusVagaEnum pageType : StatusVagaEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static StatusVagaEnum valueOf(Integer statusVagaEnum) {
        return map.get(statusVagaEnum);
    }

	public Integer getValue() {
		return value;
	}
}
