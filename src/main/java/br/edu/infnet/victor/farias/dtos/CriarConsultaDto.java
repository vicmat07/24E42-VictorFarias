package br.edu.infnet.victor.farias.dtos;

import java.time.LocalDate;

public class CriarConsultaDto {
	
	private Integer idPaciente;
	private LocalDate data;
	private boolean particular;
	

	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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
	public void setParticular(boolean particular) {
		this.particular = particular;
	}
}
