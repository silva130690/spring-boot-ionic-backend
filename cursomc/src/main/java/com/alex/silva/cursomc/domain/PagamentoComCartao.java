package com.alex.silva.cursomc.domain;

import java.io.Serializable;

import com.alex.silva.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer numDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido ,Integer numDeParcelas) {
		super(id, estado, pedido);
		this.setNumDeParcelas(numDeParcelas);
	}

	public Integer getNumDeParcelas() {
		return numDeParcelas;
	}

	public void setNumDeParcelas(Integer numDeParcelas) {
		this.numDeParcelas = numDeParcelas;
	}

}
