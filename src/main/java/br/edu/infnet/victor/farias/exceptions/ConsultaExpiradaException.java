package br.edu.infnet.victor.farias.exceptions;

public class ConsultaExpiradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ConsultaExpiradaException(String message) {
		super(message);
	}
}
