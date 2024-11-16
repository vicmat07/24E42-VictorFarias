package br.edu.infnet.victor.farias.dtos;

public class CriarFisioterapeutaDto {
	
	private String nome;
	private String cep;
	private String email;
	private String numeroCrefito;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumeroCrefito() {
		return numeroCrefito;
	}
	
	public void setNumeroCrefito(String numeroCrefito) {
		this.numeroCrefito = numeroCrefito;
	}
	
}
