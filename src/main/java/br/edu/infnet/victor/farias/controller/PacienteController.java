package br.edu.infnet.victor.farias.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.victor.farias.Constantes;
import br.edu.infnet.victor.farias.dtos.CriarPacienteDto;
import br.edu.infnet.victor.farias.model.domain.Paciente;
import br.edu.infnet.victor.farias.model.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Operation(summary="Recupera a lista de pacientes")
	@GetMapping(value="/lista")
	@ApiResponse(responseCode = "200", description = "Sucesso")
	public ResponseEntity<Collection<Paciente>> obterLista() {
		return ResponseEntity.ok(pacienteService.obterLista());
	}
	
	@Operation(summary="Cria um novo paciente")
	@PostMapping
	@ApiResponse(responseCode = "201", description = "Criado com Sucesso")
	public ResponseEntity<Paciente> criarPaciente(@Valid @RequestBody CriarPacienteDto pacienteDto) {
		
		Paciente paciente = pacienteService.inserir(pacienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
	}
	
	@Operation(summary="Recupera pacientes pelo nome")
	@GetMapping(value="/buscar/{nome}")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "204", description = "Sem pacientes para esse filtro")
	})
	public ResponseEntity<List<Paciente>> obterPacientePorNome(@PathVariable String nome){
		List<Paciente> pacientes = pacienteService.obterPorNome(nome);
		
		if (pacientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pacientes);
		}
		
		return ResponseEntity.ok(pacientes);
	}
	
	@Operation(summary="Remove um paciente")
	@DeleteMapping(value="/{idPaciente}")
	@ApiResponse(responseCode = "200", description = "Excluido com sucesso")
	public ResponseEntity<String> removerPaciente(@PathVariable Integer idPaciente){
		pacienteService.removerPaciente(idPaciente);
		
		return ResponseEntity.ok().body(Constantes.MSG_EXCLUSAO_SUCESSO);
	}
}
