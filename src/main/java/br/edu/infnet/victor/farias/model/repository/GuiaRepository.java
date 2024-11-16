package br.edu.infnet.victor.farias.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.victor.farias.model.domain.Guia;

public interface GuiaRepository extends CrudRepository<Guia, Integer> {

	Optional<Guia> findByPaciente_Id(Integer idPaciente);
}
