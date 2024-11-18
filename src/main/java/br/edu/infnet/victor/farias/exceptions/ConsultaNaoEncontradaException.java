package br.edu.infnet.victor.farias.exceptions;

public class ConsultaNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ConsultaNaoEncontradaException(String message) {
		super(message);
	}
}
