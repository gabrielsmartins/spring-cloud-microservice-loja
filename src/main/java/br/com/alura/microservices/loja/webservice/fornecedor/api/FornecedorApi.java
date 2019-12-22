package br.com.alura.microservices.loja.webservice.fornecedor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;

@Component
public class FornecedorApi {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	@Autowired
	private DiscoveryClient eurekaClient;

	public FornecedorResponseDto getInformacoesPorEstado(String estado) {
		ResponseEntity<FornecedorResponseDto> response = fornecedorClient.consultaPorEstado(estado);
		eurekaClient.getInstances("fornecedor").stream()
		.forEach(host -> System.out.println("Host: " +  host.getHost() + ":" + host.getPort()));
		return response.getBody();
	}

}
