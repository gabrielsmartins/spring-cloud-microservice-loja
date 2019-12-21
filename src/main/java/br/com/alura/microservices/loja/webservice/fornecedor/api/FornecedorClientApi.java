package br.com.alura.microservices.loja.webservice.fornecedor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;

@Component
public class FornecedorClientApi {
	
	@Autowired
	private RestTemplate restTemplate;
	
    private String fornecedorEndpoint = "http://fornecedor";

	public FornecedorResponseDto getInformacoesPorEstado(String estado) {
		ResponseEntity<FornecedorResponseDto> response = restTemplate.getForEntity(fornecedorEndpoint + "/info/" + estado, FornecedorResponseDto.class);
		return response.getBody();
	}

}
