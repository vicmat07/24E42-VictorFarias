package br.edu.infnet.victor.farias.model.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.victor.farias.Constantes;
import br.edu.infnet.victor.farias.dtos.CriarConsultaDto;
import br.edu.infnet.victor.farias.exceptions.ConsultaExpiradaException;
import br.edu.infnet.victor.farias.exceptions.DataConsultaInvalidaException;
import br.edu.infnet.victor.farias.model.domain.Consulta;
import br.edu.infnet.victor.farias.model.domain.Fisioterapeuta;
import br.edu.infnet.victor.farias.model.domain.Guia;
import br.edu.infnet.victor.farias.model.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private GuiaService guiaService;
	
	@Autowired
	private FisioterapeutaService fisioterapeutaService;
	
	private final float PRECO_CONSULTA = 5;
	
	public void removerConsulta(Integer id) {
		consultaRepository.deleteById(id);
	}
	
	public Consulta modificarConsulta(Integer idConsulta, LocalDate data) {
		Consulta consulta = consultaRepository.findById(idConsulta)
				.orElseThrow();
		
		if (consulta.getData().isAfter(data) || consulta.getData().isEqual(data)) {
			throw new DataConsultaInvalidaException(Constantes.MSG_CONSULTA_INVALID_DATE);
		}
		
		consulta.setData(data);
		
		return consultaRepository.save(consulta);
	}
	
	public Consulta adicionarConsulta(CriarConsultaDto requisicao) {
		Guia guia = guiaService.obterGuiaPorIdPaciente(requisicao.getIdPaciente());
		
		if(guia.getDataDeExpiracao().isBefore(LocalDate.now()) ) {
			throw new ConsultaExpiradaException(Constantes.MSG_GUIA_EXPIRED);
		}
		
		Fisioterapeuta fisioterapeuta = fisioterapeutaService.obterFisioterapeutaPorId(requisicao.getIdFisioterapeuta());
		
		Consulta consulta = new Consulta(requisicao.getData(), requisicao.isParticular(), PRECO_CONSULTA, fisioterapeuta);
		
		guiaService.adicionarConsulta(guia.getId(), consulta);
		
		return consulta;
	}
}
