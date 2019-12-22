package br.com.alura.microservices.loja.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoRequestDto {

	@JsonProperty("logradouro")
	private String logradouro;
	
	@JsonProperty("numero")
	private String numero;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("cidade")
	private String cidade;
	
	@JsonProperty("estado")
	private String estado;
	
	@JsonProperty("CEP")
	private String CEP;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	@Override
	public String toString() {
		return "EnderecoRequestDto [logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", CEP=" + CEP + "]";
	}
	
	

}
