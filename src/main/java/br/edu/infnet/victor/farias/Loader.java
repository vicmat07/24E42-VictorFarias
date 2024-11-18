package br.edu.infnet.victor.farias;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.victor.farias.dtos.CriarConsultaDto;
import br.edu.infnet.victor.farias.dtos.CriarFisioterapeutaDto;
import br.edu.infnet.victor.farias.dtos.CriarPacienteDto;
import br.edu.infnet.victor.farias.dtos.GerarGuiaDto;
import br.edu.infnet.victor.farias.model.domain.Fisioterapeuta;
import br.edu.infnet.victor.farias.model.domain.Paciente;
import br.edu.infnet.victor.farias.model.service.ConsultaService;
import br.edu.infnet.victor.farias.model.service.FisioterapeutaService;
import br.edu.infnet.victor.farias.model.service.GuiaService;
import br.edu.infnet.victor.farias.model.service.PacienteService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private FisioterapeutaService fisioterapeutaService;
	
	@Autowired
	private GuiaService guiaService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		CriarPacienteDto requisicao = new CriarPacienteDto();
		requisicao.setCep("50800220");
		requisicao.setNome("Victor Farias");
		requisicao.setEmail("victor.farias@test.com");
		requisicao.setDiagnostico("Lesão no joelho");
		Paciente paciente = pacienteService.inserir(requisicao);
		
		CriarFisioterapeutaDto requisicaoFisioterapeuta = new CriarFisioterapeutaDto();
		requisicaoFisioterapeuta.setCep("50800220");
		requisicaoFisioterapeuta.setEmail("victor.fisio@profissional.com");
		requisicaoFisioterapeuta.setNome("Victor Fisioterapeuta");
		requisicaoFisioterapeuta.setNumeroCrefito("123456");
		Fisioterapeuta fisioterapeuta = fisioterapeutaService.criarFisioterapeuta(requisicaoFisioterapeuta);
	}
}
