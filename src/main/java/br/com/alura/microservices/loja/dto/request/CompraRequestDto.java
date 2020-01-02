package br.com.alura.microservices.loja.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompraRequestDto {
	
	@JsonIgnore
	@JsonProperty("compra_id")
	private Long compraId;
	
	@JsonProperty("itens")
	private List<ItemRequestDto> itens;
	
	@JsonProperty("endereco")
	private EnderecoRequestDto endereco;

	public List<ItemRequestDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemRequestDto> itens) {
		this.itens = itens;
	}

	public EnderecoRequestDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequestDto endereco) {
		this.endereco = endereco;
	}

	public Long getCompraId() {
		return compraId;
	}

	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}
	


}
