package br.edu.infnet.victor.farias.model.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Consultas")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@FutureOrPresent
	private LocalDate data;
	
	private boolean particular;
	
	@DecimalMin(value="10.0", message = "o preço deve ser maior que 10.0")
	private float preco;
	
	@OneToOne
	@JoinColumn(name="idFisioterapeuta")
	private Fisioterapeuta fisioterapeuta;
	
	@ManyToOne
	@JoinColumn(name = "idGuia")
	@JsonBackReference
	private Guia guia;
	
	public Fisioterapeuta getFisioterapeuta() {
		return fisioterapeuta;
	}
	
	public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
		this.fisioterapeuta = fisioterapeuta;
	}
	
	public Integer getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public boolean isParticular() {
		return particular;
	}

	public float getPreco() {
		return preco;
	}
	
	public Consulta(LocalDate data, boolean particular, float preco, Fisioterapeuta fisioterapeuta) {
		
		if (data.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("A data da consulta não pode ser no passado");
		}
		
		this.data = data;
		this.particular = particular;
		this.preco = preco;
		this.fisioterapeuta = fisioterapeuta;
	}
	
	private Consulta() {}
}
