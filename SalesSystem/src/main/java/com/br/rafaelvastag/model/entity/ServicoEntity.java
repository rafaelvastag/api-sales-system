package com.br.rafaelvastag.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ServicoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@Column
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

}
