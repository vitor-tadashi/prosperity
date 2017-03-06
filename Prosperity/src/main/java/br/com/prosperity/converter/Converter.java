package br.com.prosperity.converter;

public interface Converter<E, B> {

	E convertBeanToEntity(B bean);

	B convertEntityToBean(E entity);

}