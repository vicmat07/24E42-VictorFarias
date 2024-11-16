package br.edu.infnet.victor.farias.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.victor.farias.Constantes;
import br.edu.infnet.victor.farias.dtos.CriarFisioterapeutaDto;
import br.edu.infnet.victor.farias.exceptions.FisioterapeutaNaoEncontradoException;
import br.edu.infnet.victor.farias.model.domain.Fisioterapeuta;
import br.edu.infnet.victor.farias.model.repository.FisioterapeutaRepository;

@Service
public class FisioterapeutaService {

	@Autowired
	private FisioterapeutaRepository fisioterapeutaRepository;
	
	public Fisioterapeuta obterFisioterapeutaPorId(Integer id) {
		Fisioterapeuta fisioterapeuta = fisioterapeutaRepository.findById(id)
				.orElseThrow(() -> new FisioterapeutaNaoEncontradoException(Constantes.MSG_FISIOTERAPEUTA_NOT_FOUND));
		
		return fisioterapeuta;
	}
	
	public Fisioterapeuta criarFisioterapeuta(CriarFisioterapeutaDto requisicao) {
		
		Fisioterapeuta fisioterapeuta = new Fisioterapeuta(
				requisicao.getNome(), requisicao.getEmail(), requisicao.getNumeroCrefito());
		
		return fisioterapeutaRepository.save(fisioterapeuta);
		
	}
}
