package br.com.alura.microservices.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservices.loja.dto.request.CompraRequestDto;
import br.com.alura.microservices.loja.entity.CompraEntity;
import br.com.alura.microservices.loja.repository.CompraRepository;
import br.com.alura.microservices.loja.webservice.fornecedor.api.FornecedorApi;
import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;
import br.com.alura.microservices.loja.webservice.fornecedor.response.PedidoResponseDto;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorApi fornecedorClient;
	
	@Autowired
	private CompraRepository compraRepository;

	@HystrixCommand(fallbackMethod="realizaCompraFallback", threadPoolKey = "realizaCompraFallbackThreadPool")
	public CompraEntity realizaCompra(CompraRequestDto compraRequestDto) {
		
		
		String estado = compraRequestDto.getEndereco().getEstado();
		FornecedorResponseDto fornecedor = fornecedorClient.getInformacoesPorEstado(estado);
		PedidoResponseDto pedidoResponse = fornecedorClient.realizaPedido(compraRequestDto.getItens());
		 
		CompraEntity compra = new CompraEntity();
		compra.setId(pedidoResponse.getId());
		compra.setTempoPreparo(pedidoResponse.getTempoDePreparo());
		compra.setEndereco(compraRequestDto.getEndereco().toString());
		
		System.out.println(fornecedor.getLogradouro() + " - " + fornecedor.getCidade() + " - " + fornecedor.getEstado());
		compraRepository.saveAndFlush(compra);
		return compra;
		
	}
	
	
	private CompraEntity realizaCompraFallback(CompraRequestDto compraRequestDto) {
		return new CompraEntity();
		
	}

	@HystrixCommand(threadPoolKey = "consultaPorIdThreadPool")
	public CompraEntity consultaPorId(Long id) {
		return compraRepository.findById(id).orElse(new CompraEntity());
	}

}
