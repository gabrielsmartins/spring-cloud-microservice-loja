package br.com.alura.microservices.loja.dto.response;

import java.io.Serializable;

public class CompraResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Integer tempoPreparo;
	
	private String endereco;

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
	
	
}
