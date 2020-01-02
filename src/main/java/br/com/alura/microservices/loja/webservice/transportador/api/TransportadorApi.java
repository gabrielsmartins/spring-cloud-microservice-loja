package br.com.alura.microservices.loja.webservice.transportador.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.microservices.loja.webservice.transportador.dto.EntregaRequestDto;
import br.com.alura.microservices.loja.webservice.transportador.dto.VoucherResponseDto;

@FeignClient("transportador")
public interface TransportadorApi {

	@PostMapping("/entrega")
	public VoucherResponseDto reservaEntrega(EntregaRequestDto pedidoDTO);
}
