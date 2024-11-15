package br.edu.infnet.victor.farias.exceptions;

public class GuiaExpiradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public GuiaExpiradaException(String message) {
		super(message);
	}
}
