package com.br.rafaelvastag.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.rafaelvastag.model.dto.ServicoPrestadoDTO;
import com.br.rafaelvastag.model.entity.ClienteEntity;
import com.br.rafaelvastag.model.entity.ServicoEntity;
import com.br.rafaelvastag.model.repository.ClienteRepository;
import com.br.rafaelvastag.model.repository.ServicoRepository;
import com.br.rafaelvastag.util.ConverterUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoRepository repository;
	private final ConverterUtil converterUtil;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoEntity salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {
		
		LocalDate dataFormatada = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		ClienteEntity cliente = clienteRepository
									.findById(Long.valueOf(idCliente))
										.orElseThrow(()-> new ResponseStatusException(
												HttpStatus.BAD_REQUEST, "Cliente inexistente"));
		
		ServicoEntity servicoEntity = new ServicoEntity();
		servicoEntity.setDescricao(dto.getDescricao());
		servicoEntity.setData(dataFormatada);
		servicoEntity.setCliente(cliente);
		servicoEntity.setValor(converterUtil.stringToBigDecimal(dto.getPreco()));
		
		return repository.save(servicoEntity);
	}
	
	@GetMapping
	public List<ServicoEntity> find(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
													@RequestParam(value = "mes", required = false) Integer mes) {

		return repository.findByCustomerNameAndMonth( "%" + nome + "%",  mes);
	}
}
