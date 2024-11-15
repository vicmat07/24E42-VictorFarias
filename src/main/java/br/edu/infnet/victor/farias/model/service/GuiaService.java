package br.edu.infnet.victor.farias.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.victor.farias.model.domain.Guia;
import br.edu.infnet.victor.farias.model.domain.Paciente;
import br.edu.infnet.victor.farias.model.repository.GuiaRepository;

@Service
public class GuiaService {
	
	@Autowired
	private GuiaRepository guiaRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	public Guia GerarGuia(Integer idPaciente) {
		Paciente paciente = pacienteService.obterPorId(idPaciente);
		
		Guia guia = new Guia(paciente);
		
		return guiaRepository.save(guia);
	}
	
	public Guia obterGuiaPorIdPaciente(Integer idPaciente) {
		return guiaRepository.findByPaciente_Id(idPaciente);
	}
}
