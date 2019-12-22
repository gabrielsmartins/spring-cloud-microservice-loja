package br.com.alura.microservices.loja.webservice.fornecedor.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.alura.microservices.loja.dto.request.ItemRequestDto;
import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;
import br.com.alura.microservices.loja.webservice.fornecedor.response.PedidoResponseDto;

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

	public PedidoResponseDto realizaPedido(List<ItemRequestDto> itens) {
		ResponseEntity<PedidoResponseDto> response = fornecedorClient.realizaPedido(itens);
		return response.getBody();
		
	}

}
