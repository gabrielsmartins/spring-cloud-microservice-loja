package br.com.alura.microservices.loja.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompraResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("tempo_preparo")
	private Integer tempoPreparo;
	
	@JsonProperty("endereco")
	private String endereco;
	
	@JsonProperty("status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
