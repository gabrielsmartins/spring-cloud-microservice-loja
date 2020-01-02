package br.com.alura.microservices.loja.webservice.fornecedor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ItemPedidoResponseDto {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("quantidade")
	private Integer quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
