package br.edu.infnet.victor.farias.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.victor.farias.model.domain.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
	
	Iterable<Paciente> findAll(Sort by);
	
	List<Paciente> findByNomeContaining(String nome, Sort by);
}
