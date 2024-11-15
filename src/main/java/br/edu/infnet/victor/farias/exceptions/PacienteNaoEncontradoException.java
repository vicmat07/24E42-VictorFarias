package br.edu.infnet.victor.farias.exceptions;

public class PacienteNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PacienteNaoEncontradoException(String message) {
		super(message);
	}
}
