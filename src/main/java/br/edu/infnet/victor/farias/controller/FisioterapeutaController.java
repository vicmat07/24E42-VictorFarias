package br.edu.infnet.victor.farias.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.victor.farias.model.domain.Fisioterapeuta;
import br.edu.infnet.victor.farias.model.service.FisioterapeutaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/fisioterapeutas")
public class FisioterapeutaController {

	@Autowired
	private FisioterapeutaService fisioterapeutaSerice;
	
	@Operation(summary="Recupera a lista de pacientes")
	@ApiResponse(responseCode = "200", description = "Sucesso")
	@GetMapping(value="/lista")
	public ResponseEntity<Collection<Fisioterapeuta>> obterLista(){
		return ResponseEntity.ok(fisioterapeutaSerice.obterLista());
	}
}
