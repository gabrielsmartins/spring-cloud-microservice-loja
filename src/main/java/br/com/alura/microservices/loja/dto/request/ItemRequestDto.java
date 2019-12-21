package br.com.alura.microservices.loja.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemRequestDto {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("quantidade")
	private Double quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
