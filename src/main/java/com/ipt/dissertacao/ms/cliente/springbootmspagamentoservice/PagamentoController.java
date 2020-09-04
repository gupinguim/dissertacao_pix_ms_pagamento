package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.repositorios.*;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.business.PagamentoActions;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades.*;

@RestController
public class PagamentoController {
	@Autowired
	OrdemPagamentoRepository ordem_repository;

	@GetMapping("/pagamentos/cliente/{id_cliente}")
	public List<OrdemPagamento> pagamentosRecuperarPorCliente(@PathVariable long id_cliente) {
		return ordem_repository.findAllByIdCliente(id_cliente);
	}

	@GetMapping("/pagamentos/{id_pagamento}")
	public OrdemPagamento pagamentosRecuperar(@PathVariable long id_pagamento) {
		return ordem_repository.findById(id_pagamento);
	}

	@PostMapping("/pagamentos")
	public ResponseEntity<?> pagamentoRegistrar(@RequestBody OrdemPagamento pgto) {
		if (pgto != null) {

			try {
				PagamentoActions.CriarPagamento(pgto);

				ordem_repository.save(pgto);

				return ResponseEntity.created(new URI(String.format("pagamentos/%d", pgto.getId())))
						.body("Ordem de pagamento criada");
			} catch (Exception e) {
				return new ResponseEntity<String>(String.format("Erro no processamento: %s", e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>(String.format("Favor informar uma ordem de pagamento"),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/pagamentos/{id_pagamento}")
	public ResponseEntity<?> pagamentoAtualizar(@PathVariable long id_pagamento, @RequestBody OrdemPagamento pgto) {
		if (id_pagamento == 0 || pgto == null)
			return new ResponseEntity<String>(String.format("Favor informar uma ordem de pagamento"),
					HttpStatus.BAD_REQUEST);

		try {
			OrdemPagamento myPgto = ordem_repository.findById(id_pagamento);

			if (myPgto == null)
				return new ResponseEntity<String>(String.format("Ordem de pagamento informada não existe"),
						HttpStatus.NOT_FOUND);

			PagamentoActions.AlterarPagamento(myPgto, pgto);

			ordem_repository.save(myPgto);

			return ResponseEntity.accepted().body("Ordem de pagamento atualizada");
		} catch (Exception e) {
			return new ResponseEntity<String>(String.format("Erro no processamento: %s", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/pagamentos/{id_pagamento}")
	public ResponseEntity<?> pagamentoDeletar(@PathVariable long id_pagamento) {
		if (id_pagamento == 0)
			return new ResponseEntity<String>(String.format("Favor informar uma ordem de pagamento"),
					HttpStatus.BAD_REQUEST);

		try {
			OrdemPagamento pgto = ordem_repository.findById(id_pagamento);

			PagamentoActions.ExcluirPagamento(pgto);

			ordem_repository.save(pgto);
			
			return ResponseEntity.accepted().body("Ordem de pagamento cancelada com sucesso");

		} catch (Exception e) {
			return new ResponseEntity<String>(String.format("Erro no processamento: %s", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
