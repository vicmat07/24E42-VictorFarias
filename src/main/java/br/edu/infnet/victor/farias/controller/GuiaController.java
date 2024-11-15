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

@RestController
@RequestMapping("/guias")
public class GuiaController {

	@Autowired
	private GuiaService guiaService;
	
	@GetMapping(value="/{idPaciente}")
	public ResponseEntity<Guia> obterGuiaPorIdPaciente(@PathVariable Integer idPaciente){
		Guia guia = guiaService.obterGuiaPorIdPaciente(idPaciente);
		
		if (guia == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(guia);
		}
		
		return ResponseEntity.ok(guia);
	}
	
	@PostMapping(value="/gerar")
	public ResponseEntity<Guia> gerarGuia(@Valid @RequestBody GerarGuiaDto dto) {
		
		Guia guia = guiaService.GerarGuia(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(guia);
	}
}
