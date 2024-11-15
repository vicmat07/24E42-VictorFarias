package br.edu.infnet.victor.farias.dtos;

import java.time.LocalDate;

public class AtualizarConsultaDto {
	
	private Integer idConsulta;
	private LocalDate data;

	
	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
