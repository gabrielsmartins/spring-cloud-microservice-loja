package br.com.alura.microservices.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservices.loja.dto.request.CompraRequestDto;
import br.com.alura.microservices.loja.webservice.fornecedor.api.FornecedorApi;
import br.com.alura.microservices.loja.webservice.fornecedor.response.FornecedorResponseDto;
import br.com.alura.microservices.loja.webservice.fornecedor.response.PedidoResponseDto;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorApi fornecedorClient;

	public PedidoResponseDto realizaCompra(CompraRequestDto compraRequestDto) {
		String estado = compraRequestDto.getEndereco().getEstado();
		FornecedorResponseDto fornecedor = fornecedorClient.getInformacoesPorEstado(estado);
		System.out.println(fornecedor.getLogradouro() + " - " + fornecedor.getCidade() + " - " + fornecedor.getEstado());
		return fornecedorClient.realizaPedido(compraRequestDto.getItens());
	}

}
