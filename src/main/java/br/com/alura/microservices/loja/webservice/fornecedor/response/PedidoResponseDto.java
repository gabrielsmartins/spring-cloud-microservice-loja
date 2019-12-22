package br.com.alura.microservices.loja.webservice.fornecedor.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PedidoResponseDto {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("tempo_preparo")
	private Integer tempoDePreparo;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("itens")
	private List<ItemPedidoResponseDto> itens;



	public List<ItemPedidoResponseDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoResponseDto> itens) {
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}
}
