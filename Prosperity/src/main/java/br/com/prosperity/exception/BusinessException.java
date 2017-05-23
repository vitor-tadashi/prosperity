package br.com.prosperity.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1157185811664602433L;

	public BusinessException(String message) {
		super(message);
	}
}