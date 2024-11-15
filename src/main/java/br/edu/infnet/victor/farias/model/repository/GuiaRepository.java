package br.edu.infnet.victor.farias.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.victor.farias.model.domain.Guia;

public interface GuiaRepository extends CrudRepository<Guia, Integer> {

	Guia findByPaciente_Id(Integer idPaciente);
}
