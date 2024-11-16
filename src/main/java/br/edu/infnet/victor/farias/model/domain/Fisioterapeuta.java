package br.edu.infnet.victor.farias.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Fisioterapeutas")
public class Fisioterapeuta extends Pessoa {
	
	@Length(min = 3, max = 15, message="O numero do crefito deve possuir entre 3 e 5 caracteres")
	private String numeroCrefito;

	public String getNumeroCrefito() {
		return numeroCrefito;
	}
	
	public Fisioterapeuta(String nome, String email, String numeroCrefito) {
		super.setNome(nome);
		super.setEmail(email);
		this.numeroCrefito = numeroCrefito;
	}
	
	private Fisioterapeuta() {}
}
