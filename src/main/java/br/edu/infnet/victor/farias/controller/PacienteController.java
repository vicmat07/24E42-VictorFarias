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

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping(value="/lista")
	public ResponseEntity<Collection<Paciente>> obterLista() {
		return ResponseEntity.ok(pacienteService.obterLista());
	}
	
	@PostMapping
	public ResponseEntity<Paciente> criarPaciente(@Valid @RequestBody CriarPacienteDto pacienteDto) {
		
		Paciente paciente = pacienteService.inserir(pacienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
	}
	
	@GetMapping(value="/buscar/{nome}")
	public ResponseEntity<List<Paciente>> obterPacientePorNome(@PathVariable String nome){
		List<Paciente> pacientes = pacienteService.obterPorNome(nome);
		
		if (pacientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pacientes);
		}
		
		return ResponseEntity.ok(pacientes);
	}
	
	@DeleteMapping(value="/{idPaciente}")
	public ResponseEntity<String> removerPaciente(@PathVariable Integer idPaciente){
		pacienteService.removerPaciente(idPaciente);
		
		return ResponseEntity.ok().body(Constantes.MSG_EXCLUSAO_SUCESSO);
	}
}
