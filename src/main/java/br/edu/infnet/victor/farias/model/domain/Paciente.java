package br.edu.infnet.victor.farias.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Pacientes")
public class Paciente extends Pessoa {
	
	@Size(min=3, max=100, message="O campo diagnóstico deve ter de 3 a 5 caracteres")
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
