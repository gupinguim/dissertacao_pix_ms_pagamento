
package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.*;

@Entity
public class HistoricoOrdemPagamento {

	@Id
	long id;
	@Column(name="tipo_situacao_pagamento")
	String tipoSituacaoPagamento;
	@Column(name="data_situacao_pagamento")
	Date dataSituacaoPagamento;
	@Column(name="observacoes")
	String observacoes;
	@ManyToOne
	@JoinColumn(name = "fk_ordem")
	OrdemPagamento ordem;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipoSituacaoPagamento() {
		return tipoSituacaoPagamento;
	}
	public void setTipoSituacaoPagamento(String tipoSituacaoPagamento) {
		this.tipoSituacaoPagamento = tipoSituacaoPagamento;
	}
	public Date getDataSituacaoPagamento() {
		return dataSituacaoPagamento;
	}
	public void setDataSituacaoPagamento(Date dataSituacaoPagamento) {
		this.dataSituacaoPagamento = dataSituacaoPagamento;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public OrdemPagamento getOrdem() {
		return ordem;
	}
	public void setOrdem(OrdemPagamento ordem) {
		this.ordem = ordem;
	}
	public HistoricoOrdemPagamento(long id, String tipoSituacaoPagamento, Date dataSituacaoPagamento,
			String observacoes, OrdemPagamento ordem) {
		super();
		this.id = id;
		this.tipoSituacaoPagamento = tipoSituacaoPagamento;
		this.dataSituacaoPagamento = dataSituacaoPagamento;
		this.observacoes = observacoes;
		this.ordem = ordem;
	}
	public HistoricoOrdemPagamento() {
		super();
	}
}
