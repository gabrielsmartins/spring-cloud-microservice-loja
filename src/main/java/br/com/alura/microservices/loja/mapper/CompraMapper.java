package br.com.alura.microservices.loja.mapper;

import br.com.alura.microservices.loja.dto.response.CompraResponseDto;
import br.com.alura.microservices.loja.entity.CompraEntity;

public class CompraMapper {

	private CompraMapper() {
		
	}
	
	public static CompraResponseDto mapToDto(CompraEntity compra) {
		CompraResponseDto compraResponseDto = new CompraResponseDto();
		compraResponseDto.setEndereco(compra.getEndereco());
		compraResponseDto.setId(compra.getId());
		compraResponseDto.setTempoPreparo(compra.getTempoPreparo());
		return compraResponseDto;
		
	}

}
