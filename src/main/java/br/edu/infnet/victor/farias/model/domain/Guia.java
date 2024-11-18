package br.edu.infnet.victor.farias.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Guias")
public class Guia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="idConsulta")
	@JsonManagedReference
	private List<Consulta> consultas;
	
	private LocalDate dataDeExpiracao;
	
	public Integer getId() {
		return id;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public LocalDate getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public Guia(Paciente paciente) {
		this.consultas = new ArrayList<Consulta>();
		this.paciente = paciente;
        this.dataDeExpiracao = LocalDate.now().plusDays(10);
	}
	
	private Guia() {}
}
