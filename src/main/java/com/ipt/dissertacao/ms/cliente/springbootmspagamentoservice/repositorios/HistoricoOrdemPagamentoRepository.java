package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades.*;

public interface HistoricoOrdemPagamentoRepository extends JpaRepository<HistoricoOrdemPagamento, Long> {
	
	HistoricoOrdemPagamento findById(long id);
}
