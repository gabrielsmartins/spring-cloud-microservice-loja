package br.com.alura.microservices.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.loja.dto.request.CompraRequestDto;
import br.com.alura.microservices.loja.dto.response.CompraResponseDto;
import br.com.alura.microservices.loja.entity.CompraEntity;
import br.com.alura.microservices.loja.mapper.CompraMapper;
import br.com.alura.microservices.loja.service.CompraService;
import br.com.alura.microservices.loja.webservice.fornecedor.response.PedidoResponseDto;

@RestController
@RequestMapping("compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public ResponseEntity<?> realizaCompra(@RequestBody CompraRequestDto compraRequestDto){
		PedidoResponseDto pedidoResponse = compraService.realizaCompra(compraRequestDto);
		
		CompraEntity compra = new CompraEntity();
		compra.setId(pedidoResponse.getId());
		compra.setTempoPreparo(pedidoResponse.getTempoDePreparo());
		compra.setEndereco(compraRequestDto.getEndereco().toString());
		
		CompraResponseDto compraResponseDto = CompraMapper.mapToDto(compra);
		return new ResponseEntity<>(compraResponseDto, HttpStatus.OK);
	}

}
