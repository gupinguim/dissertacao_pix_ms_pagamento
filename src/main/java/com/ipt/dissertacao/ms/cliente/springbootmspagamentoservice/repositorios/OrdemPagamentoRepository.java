package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades.*;
import java.util.List;

public interface OrdemPagamentoRepository extends JpaRepository<OrdemPagamento, Long> {
	
	OrdemPagamento findById(long id);
	List<OrdemPagamento> findAllByIdCliente(long idCliente);
}
