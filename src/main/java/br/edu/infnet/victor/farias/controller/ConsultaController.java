package br.edu.infnet.victor.farias.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.victor.farias.Constantes;
import br.edu.infnet.victor.farias.dtos.AtualizarConsultaDto;
import br.edu.infnet.victor.farias.dtos.CriarConsultaDto;
import br.edu.infnet.victor.farias.model.domain.Consulta;
import br.edu.infnet.victor.farias.model.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@PostMapping
	public ResponseEntity<String> agendarConsulta(@Valid @RequestBody CriarConsultaDto requisicao){
		consultaService.adicionarConsulta(requisicao);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@PatchMapping
	public ResponseEntity<Consulta> modificarConsulta(@Valid @RequestBody AtualizarConsultaDto requisicao){
		
		Consulta consulta = consultaService.modificarConsulta(requisicao.getIdConsulta(), requisicao.getData());
		
		return ResponseEntity.ok(consulta);
	}
	
	@DeleteMapping("/{idConsulta}")
	public ResponseEntity<String> deleterConsulta(@PathVariable Integer idConsulta) {
		
		consultaService.removerConsulta(idConsulta);
		
		return ResponseEntity.ok().body(Constantes.MSG_EXCLUSAO_SUCESSO);
	}
}
