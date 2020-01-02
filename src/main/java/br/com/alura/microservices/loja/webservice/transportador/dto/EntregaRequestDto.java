package br.com.alura.microservices.loja.webservice.transportador.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntregaRequestDto {
	

	@JsonProperty("pedido_id")
	private Long pedidoId;
	
	@JsonProperty("data_entrega")
	private LocalDate dataParaEntrega;
	
	@JsonProperty("endereco_origem")
	private String enderecoOrigem;
	
	@JsonProperty("endereco_destino")
	private String enderecoDestino;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}
	
	

}
