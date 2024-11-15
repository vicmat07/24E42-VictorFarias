package br.edu.infnet.victor.farias.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Pacientes")
public class Paciente extends Pessoa {
	
	private String diagnostico;

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public Paciente(String nome, String email) {
		this.setNome(nome);
		this.setEmail(email);
	}
	
	private Paciente() {}
}
