package com.ipt.dissertacao.ms.cliente.springbootmspagamentoservice.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DICT {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	String telefone;
	@Column
	String email;
	@Column
	String cpfCnpj;
	@Column
	String uuid;
}
