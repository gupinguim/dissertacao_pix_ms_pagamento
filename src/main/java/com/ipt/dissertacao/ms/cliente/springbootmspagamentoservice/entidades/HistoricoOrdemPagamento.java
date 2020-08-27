
package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades;

import javax.persistence.*;
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
}
