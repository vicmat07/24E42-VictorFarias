package br.edu.infnet.victor.farias.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.victor.farias.dtos.GerarGuiaDto;
import br.edu.infnet.victor.farias.model.domain.Guia;
import br.edu.infnet.victor.farias.model.service.GuiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/guias")
public class GuiaController {

	@Autowired
	private GuiaService guiaService;
	
	@Operation(summary="Recupera a guia de um paciente")
	@GetMapping(value="/{idPaciente}")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Guia não encontrada")
	})
	public ResponseEntity<Guia> obterGuiaPorIdPaciente(@PathVariable Integer idPaciente){
		Guia guia = guiaService.obterGuiaPorIdPaciente(idPaciente);
		
		if (guia == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(guia);
		}
		
		return ResponseEntity.ok(guia);
	}
	
	@Operation(summary="Gera uma guia para um paciente")
	@PostMapping(value="/gerar")
	@ApiResponse(responseCode = "201", description = "Criado com sucesso")
	public ResponseEntity<Guia> gerarGuia(@Valid @RequestBody GerarGuiaDto dto) {
		
		Guia guia = guiaService.GerarGuia(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(guia);
	}
}
