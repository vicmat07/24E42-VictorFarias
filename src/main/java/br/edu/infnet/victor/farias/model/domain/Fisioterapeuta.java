package br.edu.infnet.victor.farias.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Fisioterapeutas")
public class Fisioterapeuta extends Pessoa {
	
	private String numeroCrefito;

	public String getNumeroCrefito() {
		return numeroCrefito;
	}

	public void setNumeroCrefito(String numeroCrefito) {
		this.numeroCrefito = numeroCrefito;
	}
}
