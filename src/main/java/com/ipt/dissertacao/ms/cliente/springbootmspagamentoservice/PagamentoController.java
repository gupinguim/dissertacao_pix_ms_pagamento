package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.repositorios.*;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades.*;

@RestController
public class PagamentoController {
	@Autowired
	OrdemPagamentoRepository rep_ordem;

	@GetMapping("/pagamentos/cliente/{id_cliente}")
	public List<OrdemPagamento> getPagamentosByCliente(@PathVariable long id_cliente) {
		return rep_ordem.findAllByIdCliente(id_cliente);
	}

	@GetMapping("/pagamentos/{id_pagamento}")
	public OrdemPagamento getPagamentoById(@PathVariable long id_pagamento) {
		return rep_ordem.findById(id_pagamento);
	}
}
