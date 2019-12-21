package br.com.alura.microservices.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservices.loja.dto.request.CompraRequestDto;
import br.com.alura.microservices.loja.service.CompraService;

@RestController
@RequestMapping("compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public ResponseEntity<?> realizaCompra(@RequestBody CompraRequestDto compraRequestDto){
		compraService.realizaCompra(compraRequestDto);
		return null;
	}

}
