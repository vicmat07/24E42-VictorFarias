package br.edu.infnet.victor.farias.model.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.victor.farias.Constantes;
import br.edu.infnet.victor.farias.dtos.GerarGuiaDto;
import br.edu.infnet.victor.farias.exceptions.GuiaDuplicadaException;
import br.edu.infnet.victor.farias.exceptions.GuiaNaoEncontradaException;
import br.edu.infnet.victor.farias.model.domain.Consulta;
import br.edu.infnet.victor.farias.model.domain.Guia;
import br.edu.infnet.victor.farias.model.domain.Paciente;
import br.edu.infnet.victor.farias.model.repository.GuiaRepository;

@Service
public class GuiaService {
	
	@Autowired
	private GuiaRepository guiaRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	public Guia GerarGuia(GerarGuiaDto requisicao) {
		
		Optional<Guia> guiaExistente = guiaRepository.findByPaciente_Id(requisicao.getIdPaciente());
		
		if(guiaExistente.isPresent()) {
			throw new GuiaDuplicadaException(Constantes.MSG_GUIA_DOUBLED);
		}
		Paciente paciente = pacienteService.obterPorId(requisicao.getIdPaciente());
		
		Guia guia = new Guia(paciente);
		
		return guiaRepository.save(guia);
	}
	
	public Guia obterGuiaPorIdPaciente(Integer idPaciente) {
		
		Guia guia = guiaRepository.findByPaciente_Id(idPaciente)
				.orElseThrow(() -> new GuiaNaoEncontradaException(Constantes.MSG_GUIA_NOT_FOUND));
		
		return guia;
	}
	
	@Transactional
	public Consulta adicionarConsulta(Integer idGuia, Consulta consulta) {
		Guia guia = guiaRepository.findById(idGuia)
				.orElseThrow(() -> new GuiaNaoEncontradaException(Constantes.MSG_GUIA_NOT_FOUND));
		
		guia.getConsultas().add(consulta);
		
		guiaRepository.save(guia);
		
		return consulta;
	}
}
