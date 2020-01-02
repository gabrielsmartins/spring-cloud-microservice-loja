package br.com.alura.microservices.loja.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservices.loja.dto.request.CompraRequestDto;
import br.com.alura.microservices.loja.entity.CompraEntity;
import br.com.alura.microservices.loja.enumeration.CompraStateEnum;
import br.com.alura.microservices.loja.repository.CompraRepository;
import br.com.alura.microservices.loja.webservice.fornecedor.api.FornecedorApi;
import br.com.alura.microservices.loja.webservice.fornecedor.dto.FornecedorResponseDto;
import br.com.alura.microservices.loja.webservice.fornecedor.dto.PedidoResponseDto;
import br.com.alura.microservices.loja.webservice.transportador.api.TransportadorApi;
import br.com.alura.microservices.loja.webservice.transportador.dto.EntregaRequestDto;
import br.com.alura.microservices.loja.webservice.transportador.dto.VoucherResponseDto;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorApi fornecedorClient;
	
	@Autowired
	private TransportadorApi transportadorClient;
	
	@Autowired
	private CompraRepository compraRepository;

	@HystrixCommand(fallbackMethod="realizaCompraFallback", threadPoolKey = "realizaCompraFallbackThreadPool")
	public CompraEntity realizaCompra(CompraRequestDto compraRequestDto) {
		
		CompraEntity compra = new CompraEntity();
		compra.setState(CompraStateEnum.RECEBIDO);
		compraRepository.save(compra);
		compra.setId(compra.getId());
		
		String estado = compraRequestDto.getEndereco().getEstado();
		FornecedorResponseDto fornecedor = fornecedorClient.getInformacoesPorEstado(estado);
		PedidoResponseDto pedidoResponse = fornecedorClient.realizaPedido(compraRequestDto.getItens());
		compra.setState(CompraStateEnum.PEDIDO_REALIZADO);
		compraRepository.save(compra);
		compra.setId(compra.getId());
		
		EntregaRequestDto entregaRequestDto = new EntregaRequestDto();
		entregaRequestDto.setDataParaEntrega(LocalDate.now().plusDays(pedidoResponse.getTempoDePreparo()));
		StringBuilder enderecoFornecedor = new StringBuilder();
				
		enderecoFornecedor.append(fornecedor.getLogradouro())
		                  .append(", ")
		                  .append(fornecedor.getNumero())
		                  .append(" - ")
		                  .append(fornecedor.getCidade())
		                  .append("-")
		                  .append(fornecedor.getEstado())
		                  .append(", ")
		                  .append(fornecedor.getBairro())
		                  .append(" - ")
		                  .append(fornecedor.getComplemento())
		                  .append(" - ")
		                  .append(fornecedor.getCEP());
				               
		
		entregaRequestDto.setEnderecoOrigem(enderecoFornecedor.toString());
		entregaRequestDto.setEnderecoDestino(compraRequestDto.getEndereco().toString());
		
		VoucherResponseDto voucher = transportadorClient.reservaEntrega(entregaRequestDto);
		 
		
		compra.setPedidoId(pedidoResponse.getId());
		compra.setTempoPreparo(pedidoResponse.getTempoDePreparo());
		compra.setEndereco(compraRequestDto.getEndereco().toString());
		compra.setDataEntrega(voucher.getPrevisaoParaEntrega());
		compra.setVoucher(voucher.getNumero());
		compra.setState(CompraStateEnum.RESERVA_ENTREGA_REALIZADA);
		compraRepository.save(compra);
		compra.setId(compra.getId());
		return compra;
		
	}
	
	
	private CompraEntity realizaCompraFallback(CompraRequestDto compraRequestDto) {
		CompraEntity compra = new CompraEntity();
		compra.setEndereco(compraRequestDto.getEndereco().toString());
		compra.setState(CompraStateEnum.CANCELADA);
		
		if(compraRequestDto.getCompraId() != null) {
			return compraRepository
					.findById(compra.getId())
			        .orElse(compra);
		}
		
		return compra;
	}

	@HystrixCommand(threadPoolKey = "consultaPorIdThreadPool")
	public CompraEntity consultaPorId(Long id) {
		return compraRepository.findById(id).orElse(new CompraEntity());
	}

}
