package br.com.alura.microservices.loja.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.alura.microservices.loja.enumeration.CompraStateEnum;

@Table(name="compra")
@Entity
public class CompraEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="pedido_id")
	private Long pedidoId;
	
	@Column(name="tempo_preparo")
	private Integer tempoPreparo;
	
	@Column(name="endereco")
	private String endereco;

	@Column(name="data_entrega")
	private LocalDate dataEntrega;

	@Column(name="voucher")
	private Long voucher;
	
	@Column(name="status")
	@Enumerated
	private CompraStateEnum state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
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

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(LocalDate dataEntrega) {
	   this.dataEntrega = dataEntrega;
	}
	
	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
	   this.voucher = voucher;
	}

	public CompraStateEnum getState() {
		return state;
	}

	public void setState(CompraStateEnum state) {
		this.state = state;
	}
	
	
}
