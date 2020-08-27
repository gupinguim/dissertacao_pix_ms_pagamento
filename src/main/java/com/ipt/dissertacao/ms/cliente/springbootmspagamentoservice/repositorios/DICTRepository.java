package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades.*;

public interface DICTRepository extends JpaRepository<DICT, Long> {
	DICT findById(long id);
	
}
