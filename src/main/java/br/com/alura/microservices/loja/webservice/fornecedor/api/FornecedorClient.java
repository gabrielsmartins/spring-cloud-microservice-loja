package br.com.alura.microservices.loja.webservice.fornecedor.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	
	@GetMapping("/info/{estado}")
	public ResponseEntity<FornecedorResponseDto> consultaPorEstado(@PathVariable("estado") String estado);

	
}