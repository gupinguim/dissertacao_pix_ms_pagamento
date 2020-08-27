package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades;

import javax.persistence.*;
import java.util.*;

@Entity
public class OrdemPagamento {

	@Id
	long id;
	@Column(name="data_pagamento")
	Date dataPagamento;
	@Column(name = "data_criacao")
	Date dataCriacao;
	@Column(name = "valor_ordem_pagamento")
	double valorOrdemPagamento;
	@Column(name="tipo_situacao_pagamento")
	String tipoSituacaoPagamento;
	@OneToOne()
	@JoinColumn(name="fk_dict_origem")
	DICT contaOrigem;
	@OneToOne()
	@JoinColumn(name="fk_dict_destino")
	DICT contaDestino;
	@Column(name = "id_cliente")
	long idCliente;
}
