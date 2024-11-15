package br.edu.infnet.victor.farias.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.victor.farias.model.domain.Endereco;


@FeignClient(url="https://viacep.com.br/ws", name="enderecoClient")
public interface EnderecoClient {
	
	@GetMapping(value="/{cep}/json/")
	Endereco findByCep(@PathVariable String cep);
}
