package br.com.alura.microservices.loja.webservice.fornecedor.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservices.loja.dto.request.ItemRequestDto;
import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;
import br.com.alura.microservices.loja.webservice.fornecedor.response.PedidoResponseDto;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	
	@GetMapping("/info/{estado}")
	public ResponseEntity<FornecedorResponseDto> consultaPorEstado(@PathVariable("estado") String estado);
	
	@PostMapping("/pedido")
	public ResponseEntity<PedidoResponseDto>  realizaPedido(@RequestBody List<ItemRequestDto> itensRequestDto);

	
}
