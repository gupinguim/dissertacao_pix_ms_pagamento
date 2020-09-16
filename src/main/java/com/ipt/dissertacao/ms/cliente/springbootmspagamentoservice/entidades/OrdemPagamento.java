package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades;

import javax.persistence.*;

import java.util.*;

@Entity
public class OrdemPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pgto_sequence")
	@SequenceGenerator(name = "pgto_sequence", sequenceName = "pgto_seq")
	long id;
	@Column(name = "data_pagamento")
	Date dataPagamento;
	@Column(name = "data_criacao")
	Date dataCriacao;
	@Column(name = "valor_ordem_pagamento")
	double valorOrdemPagamento;
	@Column(name = "tipo_situacao_pagamento")
	String tipoSituacaoPagamento;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_dict_origem", referencedColumnName = "id")
	DICT contaOrigem;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_dict_destino", referencedColumnName = "id")
	DICT contaDestino;
	@Column(name = "id_cliente")
	long idCliente;
	@Column(name="tipo_pagamento")
	String tipoPagamento;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getValorOrdemPagamento() {
		return valorOrdemPagamento;
	}

	public void setValorOrdemPagamento(double valorOrdemPagamento) {
		this.valorOrdemPagamento = valorOrdemPagamento;
	}

	public String getTipoSituacaoPagamento() {
		return tipoSituacaoPagamento;
	}

	public void setTipoSituacaoPagamento(String tipoSituacaoPagamento) {
		this.tipoSituacaoPagamento = tipoSituacaoPagamento;
	}

	public DICT getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(DICT contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public DICT getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(DICT contaDestino) {
		this.contaDestino = contaDestino;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public void copyFrom(OrdemPagamento outraOrdem) {
		this.dataPagamento = outraOrdem.getDataPagamento();
		this.tipoSituacaoPagamento = outraOrdem.getTipoSituacaoPagamento();
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
}
