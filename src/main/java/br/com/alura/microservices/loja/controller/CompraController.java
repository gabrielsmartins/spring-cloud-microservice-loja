package br.com.alura.microservices.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.loja.dto.request.CompraRequestDto;
import br.com.alura.microservices.loja.dto.response.CompraResponseDto;
import br.com.alura.microservices.loja.entity.CompraEntity;
import br.com.alura.microservices.loja.mapper.CompraMapper;
import br.com.alura.microservices.loja.service.CompraService;

@RestController
@RequestMapping("compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable("id") Long id){
		 CompraEntity compra = compraService.consultaPorId(id);
		 CompraResponseDto compraResponseDto = CompraMapper.mapToDto(compra);
		 return new ResponseEntity<>(compraResponseDto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> realizaCompra(@RequestBody CompraRequestDto compraRequestDto){
        CompraEntity compra = compraService.realizaCompra(compraRequestDto);
		CompraResponseDto compraResponseDto = CompraMapper.mapToDto(compra);
		return new ResponseEntity<>(compraResponseDto, HttpStatus.OK);
	}

}
