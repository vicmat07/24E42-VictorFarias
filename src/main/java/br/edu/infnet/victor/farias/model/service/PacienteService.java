package br.edu.infnet.victor.farias.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.victor.farias.Constantes;
import br.edu.infnet.victor.farias.exceptions.PacienteNaoEncontradoException;
import br.edu.infnet.victor.farias.model.domain.Endereco;
import br.edu.infnet.victor.farias.model.domain.Paciente;
import br.edu.infnet.victor.farias.model.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private LocalizacaoService localizacaoService;
	
	public void inserir(Paciente paciente) {
		
		String cep = paciente.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);
		
		paciente.setEndereco(endereco);
		
		pacienteRepository.save(paciente);
	}
	
	public Collection<Paciente> obterLista() {
		return (Collection<Paciente>)pacienteRepository.findAll();
	}
	
	public List<Paciente> obterPorNome(String nome){
		return  pacienteRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}
	
	public Paciente obterPorId(Integer id) {
		return pacienteRepository.findById(id).orElseThrow(() -> new PacienteNaoEncontradoException(Constantes.MSG_PACIENTE_NOT_FOUND));
	}
}
