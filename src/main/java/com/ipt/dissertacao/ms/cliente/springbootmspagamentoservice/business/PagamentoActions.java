package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.business;

import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades.OrdemPagamento;

public class PagamentoActions {

	public static void CriarPagamento(OrdemPagamento pgto) throws Exception {
		if (pgto.getTipoPagamento().compareToIgnoreCase("nao prioritario") != 0
				&& pgto.getTipoPagamento().compareToIgnoreCase("prioritario") != 0)
			throw new Exception("pagamento precisa ser do tipo prioritario ou nao prioritario");
	}

	public static void AlterarPagamento(OrdemPagamento pgto_from, OrdemPagamento pgto_to) {
		pgto_from.setTipoSituacaoPagamento(pgto_to.getTipoSituacaoPagamento());
	}

	public static void ExcluirPagamento(OrdemPagamento pgto) {
		pgto.setTipoSituacaoPagamento("Cancelado");
	}
}
