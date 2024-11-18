package br.edu.infnet.victor.farias.exceptions;

public class PacienteNaoEncontradoException extends ApplicationBaseException {
	
	private static final long serialVersionUID = 1L;
	
	public PacienteNaoEncontradoException(String message) {
		super(message);
	}
}
