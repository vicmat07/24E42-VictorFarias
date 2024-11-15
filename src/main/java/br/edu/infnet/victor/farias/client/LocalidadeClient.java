package br.edu.infnet.victor.farias.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.victor.farias.model.domain.Estado;
import br.edu.infnet.victor.farias.model.domain.Municipio;

@FeignClient(url="https://servicodados.ibge.gov.br/api/v1/localidades", name="ibgeClient")
public interface LocalidadeClient {
	
	@GetMapping(value = "/estados")
	Collection<Estado> obterEstados();
	
	@GetMapping(value = "/estados/{uf}/municipios")
	Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}
