package br.edu.infnet.victor.farias.exceptions;

public abstract class ApplicationBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApplicationBaseException(String message) {
		super(message);
	}
}
